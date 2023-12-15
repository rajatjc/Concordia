// Copies.java
//
// an example that demomstrates how a polymorphic reference refers directly
// to the child object. Copies are not made during assignment.

public class Copies {

	public static void main(String[] args) {
		
		// declare a mutt object (the child class)
		Mutt myMutt = new Mutt();
		
		System.out.println("Declaring an object of type mutt...");
		System.out.println("The mutt's name is: " + myMutt.getName() );
		
		// now assign the mutt object to a reference of the parent type
		System.out.println("\nAssigning the mutt object to the dog reference...");
		Dog myDog = myMutt;
		
		// set the name from the dog reference
		System.out.println("Setting the name to Fernando using the dog reference...");
		myDog.setName("Fernando");
		System.out.println("The dog's name is " + myDog.getName() );
		System.out.println("The mutt's name is " + myMutt.getName() );
		
		// set the name from the mutt reference
		System.out.println("\nSetting the name to Bernard using the mutt reference...");
		myMutt.setName("Bernard");
		System.out.println("The mutt's name is " + myMutt.getName() );
		System.out.println("The dog's name is " + myDog.getName() );
		
		
		// let's try to use the child methods from the parent reference
		// this won't work even though myDog actually contains a mutt object
		//myDog.getAge();
		
	}
}


class Dog {
	
	private String name = "Barney";
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName( ){
		return name;
	}
	
}


class Mutt extends Dog {
	
	int age = 14;
	
	int getAge(){
		return age;
	}
}
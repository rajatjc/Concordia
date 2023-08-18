// Farm.java
//
// A powerful OOP tool is the use of abstract classes/methods to
// create "templates" for classes. We can add one of more abstract
// methods and then provide the method bodies in the subclasses.
// subclasses are then free to create completely different implementations.

// our farm test class. We create two animals and have them say Hello.

public class Farm {

	public static void main(String[] args) {
		
		Pig myPig = new Pig(6, 120, "Porky");
		myPig.sayHello();
		System.out.println("It will cost " + myPig.cost() + " to feed me!");
		
		Cow myCow = new Cow(21, 1200, "Elmer");
		myCow.sayHello();
		System.out.println("It will cost " + myCow.cost() + " to feed me!");
	}
}


// the base animal class. It has a few methods including an abstract
// sayHello method
abstract class Animal{
	
	int age;
	int weight;
	String name;
	
	public Animal(int age, int weight, String name){
		this.age = age;
		this.weight = weight;
		this.name = name;
	}
	
	double cost(){
		return (weight * age) / 2;
		
	}
	
	abstract void sayHello();
	
}


// the pig class provides its version of sayHello
class Pig extends Animal{
	
	public Pig(int age, int weight, String name){
		super(age, weight, name);
	}
	
	public void sayHello(){
		System.out.println("Oink, Oink!");
	}
}


//the cow class provides its version of sayHello
class Cow extends Animal{
	
	public Cow(int age, int weight, String name){
		super(age, weight, name);
	}
	
	public void sayHello(){
		System.out.println("Moo, Moo!");
	}
}



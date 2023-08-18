// Farmpoly.java
//
// This examples shows polymorphism in action. Specifically, we can assign different
// sub-types to a parent type variable and have each one produce unique behaviour
// at run-time



// the main farm test class
public class Farmpoly {

	// my fake animal database. Polymorphism is useful when we don't know what
	// kinds of objects will be created. In our example, we will pretend to have 
	// a database that will be read at run-time. The database contains information
	// about five animals.
	
	public static final int databaseSize = 5;
	String[] animalType = {"pig", "cow", "pig", "chicken", "sheep"}; 
	String[] animalName = {"Billy", "Lucy", "Othello", "Arnold", "Precious"}; 
	int[] animalWeight = {43, 1789, 899, 468, 138}; 
	int[] animalAge = {12, 3, 107, 91, 14}; 
	
	// the main array that will hold our animal objects
    Animal3[] animalList = new Animal3[databaseSize];
	
	
	// the constructor - it will be used to "read" the database and populate the 
	// animal array
    public Farmpoly(){
		String type;
		
		for(int i = 0; i < databaseSize; i++){
			
				// read the anaimal type for our "database". Create the appropriate animal
				// object and assign it to the animal list
				type = animalType[i];
				if(type.equals("pig")){
					animalList[i] = new Pig3(animalAge[i], animalWeight[i], animalName[i]);
				}
                else if(type.equals("cow")){
					animalList[i] = new Cow3(animalAge[i], animalWeight[i], animalName[i]);
				}
                else if(type.equals("chicken")){
					animalList[i] = new Chicken(animalAge[i], animalWeight[i], animalName[i]);
				}
                else if(type.equals("sheep")){
					animalList[i] = new Sheep(animalAge[i], animalWeight[i], animalName[i]);
				}
			}
	}
	
	
	public static void main(String[] args) {
		
		
		// create the animals directly. This is just regular object instantiation
		System.out.println("Let's create the animals explicitly...\n");
			
        Pig3 myPig = new Pig3(6, 120, "Porky");
		System.out.println(myPig);
		
		Cow3 myCow = new Cow3(21, 1200, "Elmer");
		System.out.println(myCow);
		
		
		// now, let's use polymorphism. The farm constructor loads the database
		// and then each animal type will speak in its own "voice". Very simple
		// and very powerful.
		
		System.out.println("\nNow let's do the loop...\n");
		
        Farmpoly myFarm = new Farmpoly(); 
		for(int i = 0; i < databaseSize; i++){
			System.out.println(myFarm.animalList[i]);
		}
	}
}


// our base animal class. It has a toString method and an abstract sayHello
// method.

abstract class Animal3{
	
	private int age;
    private int weight;
    private String name;
	
    public Animal3(int age, int weight, String name){
		this.age = age;
		this.weight = weight;
		this.name = name;
	}
	
	double cost(){
		return (weight * age) / 2;
		
	}
	
	
	public String toString(){
		
		// just a little fancier
		Class classObject = this.getClass();
	    String classPath = classObject.getName();
	    String[] pathParts = classPath.split("\\."); 
	    String className = pathParts[pathParts.length - 1];
		
		String s = "";
        s += "Hi, my name is " + name + "\n";
        s += "I'm " + age + " years old and I weight " + weight + " pounds\n";
        s += "Apparently, I'm a " + className + "\n";
        s += "I'm very friendly. If you talk to me, I will say " + sayHello() + "\n";
        return s;
		
	}
	
	abstract public String sayHello();
	
}



// the pig subclass - it provides its own sayHello method
class Pig3 extends Animal3{
	
    public Pig3(int age, int weight, String name){
		super(age, weight, name);
	}
	
    public String sayHello(){
		return "Oink, Oink!";
	}
	
}


//the cow subclass - it provides its own sayHello method
class Cow3 extends Animal3{
	
    public Cow3(int age, int weight, String name){
		super(age, weight, name);
	}
	
    public String sayHello(){
		return "Moo, Moo!";
	}
}


//the chicken subclass - it provides its own sayHello method
class Chicken extends Animal3{
	
	public Chicken(int age, int weight, String name){
		super(age, weight, name);
	}
	
    public String sayHello(){
		return "Cluck, Cluck!";
	}
}


//the sheep subclass - it provides its own sayHello method
class Sheep extends Animal3{
	
    public Sheep(int age, int weight, String name){
		super(age, weight, name);
	}
	
    public String sayHello(){
		return "Baa, Baa!";
	}
}



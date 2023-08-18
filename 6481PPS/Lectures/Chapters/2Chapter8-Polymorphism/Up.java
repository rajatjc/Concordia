// Up.java
//
// upcasting refers to the ability to assign a child object to a variable
// that has been declared as the parent type. It forms the foundation
// of polymorphism. This example shows how upcasting works.



public class Up {

	// a method that takes a creature object (the parent type) as an argument
    static void show_animal_cost(Creature myCreature){
		System.out.println("I'm " + myCreature.getName() + " and my feeding cost is " + myCreature.getCost() + "\n\n");
	}


	public static void main(String[] args) {

		// we start by creating the parent class

        Creature myCreature1 = new Creature(4, 60, "Jellybean");
		show_animal_cost(myCreature1);


		// we now create an object of the subclass and assign it to
		// a variable of the parent type. This works because of upcasting

        Creature myCreature2 = new Platypus(44, 17, "Natasha");
		show_animal_cost(myCreature2);


		// we now try to create an object and assign it to a variable
		// of the child type. This will not even compile because it is never
		// allowed in Java. Try it and see.

//        Platypus myCreature3 = new Creature(44, 17, "Wally");
//		show_animal_cost(myCreature3);


		// we will now try to do the same thing but we will use an explicit
		// cast operation to tell the compiler to allow the downcast. This
		// compiles but it will produce a class cast exception. This
		// exception is generated at run-time because Java will check the types
		// before it does an assignment. Try it.

        //Platypus myCreature4 = (Platypus)new Creature(44, 17, "Wally");
		//show_animal_cost(myCreature4);


		// in this example, we first do and upcast and then a downcast. Because
		// the final type of the object on the right side of the assignment
		// actually matches the type of the variables on the left side, the
		// "downcast" will be allowed. This is a very peculiar example but
		// it does show that downcasts are actually possible. Give it a try.

        Platypus myPlatypus1 = new Platypus(4, 60, "Peeps");
        Creature myCreature5 = myPlatypus1;
        Platypus myPlatypus2 = (Platypus)myCreature5;
		myPlatypus2.print_foo();
		show_animal_cost(myPlatypus2);

	}
}


// the parent class
class Creature{

	private int age;
	private int weight;
	private String name;


    public Creature(int age, int weight, String name){
		this.age = age;
		this.weight = weight;
		this.name = name;
	}

	public String getName(){
		return (name);
	}
	public double getCost(){
		return (weight * age) / 2;
	}
}


// the child class - it adds its own print_foo method
class Platypus extends Creature{

    public Platypus(int age, int weight, String name){
			super(age, weight, name);
	}

	public void print_foo(){
		System.out.println("foo");
	}
}

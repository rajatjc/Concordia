// Stop.java
//
// The final keyword puts an end to inheritance. It can be used
// at the class level (not so common) or at the method level
// to ensure that some kind of functionality is never
// over-ridden


public class Stop {

	// final is often used with pmitive values to create constants
	public static final int STUFF = 20; // the proper way - one value in the class itself
	public final int fuzz = 5; // also a constant, but a copy exists in every object
	public final int mush;  //blank final - will be set at a later point
	
	public Stop(int mush){
		this.mush = mush; // initialize the blank final at run-time. It cannot be changed after this.
	}
	
	
	// cannot over-ride this method in any sub-class. calculate_foo() will 
	// always do exactly what it does here 
	public final int calculate_foo(){
		return fuzz + STUFF + mush;
	}
	
	public static void main(String[] args) {
		
		Stop test = new Stop(100);
		System.out.println("The magic mush = " + test.calculate_foo() );
		
	}
}

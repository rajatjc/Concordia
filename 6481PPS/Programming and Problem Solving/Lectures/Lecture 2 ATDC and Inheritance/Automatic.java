// Automatic.java
//
// When you create an object without the "extends" keyword,
// you are implicitly inheriting from Java's Object class.
// This is the root class for all objects.


public class Automatic { // extends Java's Object class

	public String apples = "Granny Smith";
	public String oranges = "Florida";


	public static void main(String[] args) {
		
		Automatic auto = new Automatic();
		
		// if we print the object now, it will use the
		// toString method from the Object class. The output
		// is really simple - and ugly.
		System.out.println(auto);
		System.out.println();
		
		// create the "extra" object that has its own toString method
		Extra ex = new Extra();
		System.out.println(ex);
	}
}




class Extra extends Automatic{
	
	//	 the toString() method over-rides the toString method
	//	 found in Java's Object class. Note that it does not use
	//	 println statements. Instead, you must create a string
	//	 that gets retunred at the end of the method.
	
	public String toString(){
		
		String S = "";
		S += "** Extra Listing: ** \n";
		S += "apples = " + apples + "\n";
		S += "oranges = " + oranges + "\n";
		S += "...and that's it!";
		
		return S; 
	}

}

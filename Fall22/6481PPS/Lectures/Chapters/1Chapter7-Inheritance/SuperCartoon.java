// superCartoon.java
//
// Java will add a default constructor for you if you provide none.
// If you do provide a constructor, however, Java does not provide
// a default (i.e., a constructor with no arguments). Because Java
// automatically calls the parent constructor before it runs the code
// for the child constructor, you must now tell it how to call the 
// parent constructor (since there is no default).

class SuperArt {
	SuperArt(int x) {
		System.out.println("Art constructor");
	  }
}

class SuperDrawing extends SuperArt {
	SuperDrawing(int x) {
		// the parent constructor has an argument so
		// you must invoke the parent properly
		super(x);
		System.out.println("Drawing constructor");
	  }
}


public class SuperCartoon extends SuperDrawing {
	
	SuperCartoon() {
		// the parent constructor has an argument so
		// you must invoke the parent properly
		super(55); 
		System.out.println("Cartoon constructor");
	}
	 

	public static void main(String[] args) {
		
		SuperCartoon sc = new SuperCartoon(); 
		// no constructor arguments required
	}
	
}
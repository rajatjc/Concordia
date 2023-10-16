// Cartoon.java
//
// An example showing the order in which default constructors
// are invoked. 

class Art {
	Art() {
		System.out.println("Art constructor");
	  }
}

class Drawing extends Art {
	Drawing() {
		System.out.println("Drawing constructor");
	  }
}


public class Cartoon extends Drawing {
    public Cartoon() {
		System.out.println("Cartoon constructor");
	}
	 
	// We create a cartoon object, thereby automatically invoking
	// a chain of parent constructors
	public static void main(String[] args) {
        Cartoon x = new Cartoon();
	}
	
}

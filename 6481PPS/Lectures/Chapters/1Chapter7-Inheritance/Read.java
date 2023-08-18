// read.java
//
// Java does not allow multiple inheritance of classes. However,
// it does allow a class to implement multiple interfaces. Because
// interfaces contain no method bodies, there can be no conflict
// when two interfaces contain a method with the same signature.

// the book interface - requires methodA()
interface IntBook {
	public void methodA();
}

// child interface - the Dictionary "is-a" book, it just adds to the
// functionality of the Book interface
interface IntDictionary {
	public void methodB();
}


// the class implements both interfaces by defining the 
// methods methodA() and methodB()
public class Read implements IntBook, IntDictionary {
	
	public void methodA(){
		System.out.println("I am method A");	
	}
	
	public void methodB(){
			System.out.println("I am method B");	
		}
	
	public static void main(String[] args) {
		Read myBook = new Read();
		myBook.methodA();
		myBook.methodB();
	}
}

// basic.java 
//
// Our "HelloWorld" exception example. In the bar() method we see the basic
// try/catch mechanism. In the try block, we call the method foo(). The method foo()
// "throws" an exception which is leter "caught" of trapped by the catch block in 
// bar(). Note that the exception type in the catch block matches the exception type thrown
// by foo.


class myException extends Exception{ }

class Test{
	
	// throw an exception in this method
	public void foo() throws myException{
		throw new myException();	
	}
	
	
	public void bar(){
		System.out.println("Calling the foo method...");
		
		try{
			foo();
		}
		catch (myException e) { // catch the exception generated in the try block
			System.out.println("I caught myException");
		}
	}
}



public class Basic {

	public static void main(String[] args) {
		
		// create a test object and run its bar() method
		Test myTest = new Test();
		myTest.bar();
		
	}
}

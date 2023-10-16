// MultipleI.java
//
// Java does not allow multiple inheritance of classes. In this example,
// we create two parent classes - book and dictionary. The main method in
// multipleI, however, can only inherit from one. If you try to extend both
// at the same time, you will get a compiler error. 

// base/parent class
class MultiBook {
    public MultiBook (){
	   System.out.println("I am a book");
	}
}

// child class - the Dictionary "is-a" book, it just adds or refines its
// functionality

class MultiDictionary {

   public MultiDictionary (){
	  System.out.println("I am a dictionary");
   }
}

//if you use the following line to define the class, you will
// get a compiler error
//public class MultipleI extends MultiBook, MultiDictionary {
public class MultipleI extends MultiBook {
	public static void main(String[] args) {
        MultipleI myObject = new MultipleI();
	}
}
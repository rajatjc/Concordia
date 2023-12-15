// Visibility2.java
//
//The series of three "visibility" source files demonstrates why
//we should not allow direct public access to our class data. This is true
//even if we want to allow outside objects to be able to modify these
//internal fields. 
//
//This file shows the "bad" way of doing this.

// the main test method. Run this and you will see that we have 
// produced an unexpected side effect.

public class Visibility2 {

	public static void main(String[] args) {
		
        BadCalc calculator = new BadCalc();
		System.out.println("Count = " + calculator.count);
		System.out.println("Cost for A = " + calculator.calculateCost());
		System.out.println("Count = " + calculator.count);
	}
}

// this time the base class provides full public access to its data. Bad.
class BadCalc2{
	
	public int count = 10;
	public double price = 9.99;
	
}


// the subclass executes a loop but uses the count variable but
// "accidentally" decrements it during each iteration. This is what we call
// a "side effect" and it is definitely not what we wanted. 
// This may seems like a stupid mistake but it is very easy
// to do on a big system.

class BadCalc extends BadCalc2{
	
	public double calculateCost(){
		double cost = 0.0;
		while (count-- > 0){
			cost += price;
		}
		return cost;
	}
}















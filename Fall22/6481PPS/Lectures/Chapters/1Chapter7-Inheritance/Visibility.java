// Visibility.java
//
// The series of three "visibility" source files demonstrates why
// we should not allow direct public access to our class data. This is true
// even if we want to allow outside objects to be able to modify these
// internal fields. 
//
// This file shows the "proper" way of doing this.

// a simple test class that creates a "calculator" object and runs its
// calculateCost method

public class Visibility {

	public static void main(String[] args) {
		
        GoodCalc calculatorA = new GoodCalc();
		System.out.println("Cost for A = " + calculatorA.calculateCost());
	}
}


// the parent class uses the private modifier on its count and 
// price fields but provides public get and set methods
class BasicCalc{
	
	private int count = 10;
	private double price = 9.99;
	
	public int getCount(){
		return count;
	}
	
	public void setCount(int count){
		this.count = count;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
}


// the subclass uses the public get and set methods in its
// calculateCost method

class GoodCalc extends BasicCalc{
	
	public double calculateCost(){
		double cost = 0.0;
		for(int i = getCount(); i > 0; i--){
			cost += getPrice();
		}
		return cost;
	}
}
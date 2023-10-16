// Visibility3.java
//
// The series of three "visibility" source files demonstrates why
// we should not allow direct public access to our class data. This is true
// even if we want to allow outside objects to be able to modify these
// internal fields. 
//
// This file shows that, while it would be possible to produce side effects
// with public get and set methods, it would be much more unlikely since the
// programmer would have to intentionally do it.

// main test class
public class Visibility3 {

	public static void main(String[] args) {	
		
		WeirdCalc calculator = new WeirdCalc();
		System.out.println("Cost for A = " + calculator.calculateCost());
	}
}

// original base class
class BasicCalc3{
	
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

// the sub class creates a side effect but does so by 
// explicity calling setCount( getCount() - 1). It would 
// be hard to do this without knowing that you are changing
// the value of the count variable

class WeirdCalc extends BasicCalc3{
	
	public double calculateCost(){
		double cost = 0.0;
		while (getCount() > 0){
			cost += getPrice();
			setCount( getCount() - 1);
		}
		return cost;
	}
}

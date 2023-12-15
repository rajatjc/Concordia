/////////////////////////////////
// YOU CANNOT CHANGE THIS CODE //
/////////////////////////////////
import java.util.ArrayList;
import java.util.InputMismatchException;

public class KeyboardIntegerReader {
	public ArrayList<Integer> read_int_kbd() {
	    Integer integer = Integer.valueOf(0);
	    ArrayList<Integer> myintegers = new ArrayList<Integer>();
	    System.out.println("Enter integers separated by <enter>."); 
	    System.out.println("Enter \"0\" to stop."); 
	    do {
	    	try{
	    		integer = ReaderDriver.kbd.nextInt(); 
	    	}catch(InputMismatchException e) {
	    		throw new WrongIntegers(myintegers); 
	    	}
	    	myintegers.add(integer);
	    } while (!integer.equals(0));
		return myintegers;
	}
}

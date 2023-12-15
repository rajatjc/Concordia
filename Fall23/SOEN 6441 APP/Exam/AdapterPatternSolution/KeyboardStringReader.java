/////////////////////////////////
// YOU CANNOT CHANGE THIS CODE //
/////////////////////////////////
import java.util.ArrayList;

public class KeyboardStringReader {
	public ArrayList<String> read_kbd() {
	    String string = new String();
	    ArrayList<String> mystrings = new ArrayList<String>();
	    System.out.println("Enter words separated by <enter>."); 
	    System.out.println("Enter \"stop\" to stop."); 
	    do {
	    	string = ReaderDriver.kbd.next(); 
	    	mystrings.add(string);
	    } while (!string.equals("stop"));
		return mystrings;
	}
}

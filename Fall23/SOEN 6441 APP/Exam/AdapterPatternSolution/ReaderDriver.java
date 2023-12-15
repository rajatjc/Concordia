/////////////////////////////////
// YOU CANNOT CHANGE THIS CODE //
/////////////////////////////////
import java.util.ArrayList;
import java.util.Scanner;

public class ReaderDriver {
	public static Scanner kbd = new Scanner(System.in);
	public static void main(String[] args) {
		ReaderAndWriter rdr = new ReaderAndWriter();
		ArrayList<String> strings = new ArrayList<String>();
		rdr.chooseReader();
		strings = rdr.readStrings(); 
		rdr.writeStrings(strings);
	}
	
}

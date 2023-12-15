/////////////////////////////////
// YOU CANNOT CHANGE THIS CODE //
/////////////////////////////////
import java.util.ArrayList;
import java.util.InputMismatchException;

public class WrongIntegers extends InputMismatchException{
	private static final long serialVersionUID = 1423093016149647500L;
	ArrayList<Integer> a; 
	WrongIntegers(ArrayList<Integer> a){
		this.a = a;
	}
	public ArrayList<Integer> getIntegers(){
		return a; 
	}
}

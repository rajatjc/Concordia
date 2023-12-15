import java.util.Scanner;
public class DFARunner {
	public static Scanner kbd = new Scanner(System.in);
	DFAState state = new StateEnter();
	
	public int getInput() {
		int value = kbd.nextInt();
		return value; 
	}
	
	public void run() {
		while(state.getClass().getName() != "StateExit") {
			state.transition(this);
		}
	}
}

import java.util.Scanner;

public class StateEnter extends DFAState {

    static Scanner kbd = new Scanner(System.in);

    public void transition(DFARunner p_DFARunner)
    {
        p_DFARunner.state = new State1();
    }

}

import java.util.Scanner;

public class StateExit extends State4 {

    static Scanner kbd = new Scanner(System.in);

    public void transition(DFARunner p_DFARunner)
    {
        System.out.println("Unreachable");
    }

}

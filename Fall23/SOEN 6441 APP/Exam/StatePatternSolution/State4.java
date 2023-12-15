import java.util.Scanner;

public class State4 extends State3 {


    public void transition(DFARunner p_DFARunner)
    {
        System.out.println("Now in State 4. Final State");
        p_DFARunner.state = new StateExit();
    }

}

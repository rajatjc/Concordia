import java.util.Scanner;

public class State2 extends State1 {

    static Scanner kbd = new Scanner(System.in);

    public void transition(DFARunner p_DFARunner)
    {
        System.out.println("Now in State 2 : \nAvailable options : [3]\nEnter Choice");
        int l_input = kbd.nextInt();

        if (l_input == 3)
        {
            p_DFARunner.state = new State3();
        }
        else
        {
            System.out.println("Invalid Transition");
        }
    }
}

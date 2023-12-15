import java.util.Scanner;

public class State3 extends State1 {

    static Scanner kbd = new Scanner(System.in);

    public void transition(DFARunner p_DFARunner)
    {
        System.out.println("Now in State 3 : \nAvailable options : [1, 4]\nEnter Choice");
        int l_input = kbd.nextInt();

        if (l_input == 4)
        {
            p_DFARunner.state = new State4();
        }
        else  if (l_input == 1)
        {
            p_DFARunner.state = new State1();
        }else
        {
            System.out.println("Invalid Transition");
        }
    }

}

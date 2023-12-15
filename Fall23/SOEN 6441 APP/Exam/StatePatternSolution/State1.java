import java.util.Scanner;

public class State1 extends StateEnter {

    static Scanner kbd = new Scanner(System.in);

    public void transition(DFARunner p_DFARunner)
    {
        System.out.println("Now in State 1 : \nAvailable options : [2, 3]\nEnter Choice");
        int l_input = kbd.nextInt();

        switch (l_input){

            case 2:
                p_DFARunner.state = new State2();
                break;
            case 3:
                p_DFARunner.state = new State3();
                break;
            default:
                System.out.println("Invalid Transition");
                break;
        }
    }

}

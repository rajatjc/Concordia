import java.util.*;
public class Knapsack {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] inputs = str.split(" ");

        int total_prizes = Integer.parseInt(inputs[0]);
        int W = Integer.parseInt(inputs[1]);			//W

        String p = sc.nextLine();
        String[] pr = p.split(" ");

        int [] val = new int[pr.length]; 				//val
        int [] wt = new int[pr.length];

        for(int i=0; i<pr.length; i++) {
            wt[i] = (Integer.parseInt(pr[i]));
        }

        for(int i = 0; i<wt.length;i++) {
            val[i] = 1;
        }
        int n = val.length;

        System.out.println(calc(W, wt, val, n));

    }

    static int calc(int W, int wt[], int val[], int n){
        if (n == 0 || W == 0)
            return 0;

        if (wt[n - 1] > W)
            return calc(W, wt, val, n - 1);
        else
            return max(val[n - 1]
                            + calc(W - wt[n - 1], wt,
                            val, n - 1),
                    calc(W, wt, val, n - 1));
    }
    static int max(int a, int b)
    {return (a > b) ? a : b;}

}

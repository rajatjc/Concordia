package pod;

import java.util.Scanner;

public class pod13 {
    public static void answer(int[] A)
    {
      
        int[] inc = new int[A.length];
        inc[0] = 1;
        for (int i = 1; i < A.length; i++)
        {
            inc[i] = 1;
            if (A[i - 1] < A[i]) {
                inc[i] = inc[i - 1] + 1;
            }
        }

//        for(int i:I)
//            System.out.print(i);
//        System.out.println();

        int[] dec = new int[A.length];
        dec[A.length - 1] = 1;
        for (int i = A.length - 2; i >= 0; i--)
        {
            dec[i] = 1;
            if (A[i] > A[i + 1]) {
                dec[i] = dec[i + 1] + 1;
            }
        }

//        for(int i:D)
//            System.out.print(i);
//        System.out.println();

        int m = 1;

        for (int i = 0; i < A.length; i++)
            if (m < inc[i] + dec[i] - 1)
                m = inc[i] + dec[i] - 1;


        System.out.println( m);

    }
    public static void main(String[] args) {
        String s1, s2;
        Scanner sc = new Scanner(System.in);
        s1 = sc.nextLine();
        s2 = sc.nextLine();
       // s2=s2.substring(1,s2.length()-1);
        sc.close();

        int n = Integer.parseInt(s1);


        String[] s22;
        s22 = s2.split(",");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s22[i]);
        }

        answer(arr);

    }
}

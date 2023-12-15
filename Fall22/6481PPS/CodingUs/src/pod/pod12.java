package pod;

import java.util.Arrays;
import java.util.Scanner;

public class pod12 {

    public static void main(String[] args) {
        String s1, s2;
        Scanner sc = new Scanner(System.in);
        s1 = sc.nextLine();
        s2 = sc.nextLine();
        s2=s2.substring(1,s2.length()-1);

        String[] s11;
        s11 = s1.split(" ");

        int n = Integer.parseInt(s11[0]);
        int money = Integer.parseInt(s11[1]);

        String[] s22;
        s22 = s2.split(",");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s22[i]);
        }


        Arrays.sort(arr);
        int score=0,m=0;

        int i=0,j=n-1;
        while(i<=j)
        {
            if(arr[i]<=money)
            {
                money-=arr[i++];
                score++;
            }
            else
            {
                money+=arr[j--];
                score--;
            }
            m=Math.max(score,m);
        }
        System.out.println(m);
    }
}

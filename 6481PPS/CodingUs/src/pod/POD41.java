package pod;

import java.util.Scanner;

public class POD41 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String s1=sc.nextLine();
        String[] s11=s1.substring(1,s1.length()-1).split(",");

        String s2=sc.nextLine();
        String[] s22=s2.substring(1,s2.length()-1).split(",");

        int[] prog=new int[s11.length];
        int[] speed=new int[s22.length];

        for(int i=0;i<s11.length;i++)
        {
            prog[i]=Integer.parseInt(s11[i]);
            speed[i]=Integer.parseInt(s22[i]);
        }
        int day=0,prod=0;
        int i=0;
        while(i<s22.length) {

            while (prog[i] < 100) {
                for (int j = i; j < s22.length; j++) {
                    prog[j] += speed[j];
                }
                day++;
            }

            while (i < s22.length && prog[i] >= 100) {
                prod++;
                i++;
            }
            if (i == s22.length)
            {
                System.out.print("(" + day + "," + prod + ")");
                return;
            }
            System.out.print("("+day+","+prod+"),");
            prod=0;
        }
    }
}

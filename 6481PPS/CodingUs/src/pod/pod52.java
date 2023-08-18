package pod;

import java.util.Scanner;

public class pod52 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();

        int n1;
        if(s1.length()>1)
        {

            String[] s=s1.split(" ");

            int n=s.length;
            int[] a=new int[n];
            for(int i=0;i<n;i++) {
                a[i]=Integer.parseInt(s[i]);
                // System.out.println(a[i]);
            }




            int ans = 0, ce = 0, cf = 0;
            for (int i = 0; i < a.length - 1; i++) {
                cf = Math.max(cf, i + a[i]);
                if (i == ce) {
                    ans++;
                    ce = cf;
                }
            }
            System.out.println(ans);

        }
        else
        {
            n1=Integer.parseInt(s1);

            String s2=sc.nextLine();
            String[] s=s2.split(" ");

            int n=s.length;
            int[] a=new int[n];
            for(int i=0;i<n;i++) {
                a[i]=Integer.parseInt(s[i]);
                // System.out.println(a[i]);
            }




            int ans = 0, ce = 0, cf = 0;
            for (int i = 0; i < a.length - 1; i++) {
                cf = Math.max(cf, i + a[i]);
                if (i == ce) {
                    ans++;
                    ce = cf;
                }
            }
            System.out.println(ans);

        }

    }
}

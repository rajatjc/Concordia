package pod;

import java.util.Scanner;

public class lab8b {
    public static int rec(int [] a,int n,int k)
    {
        if (k==0)
            return 1;
        if(k<0)
            return 0;
        if (n <= 0)
            return 0;

        return rec(a, n - 1, k)
                + rec(a, n, k - a[n - 1]);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        int[] a={1,4,9,16,25,36,49,64,81,100,121,144,169,196,225,256,289};

        System.out.println(rec(a,a.length,n));
    }
}

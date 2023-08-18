package pod;

import java.util.Scanner;

public class pod42 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] s=sc.nextLine().split(",");
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(s[i]);
        int c=0;
        for(int i=0;i<n;i++)
        {
            if(c==0&&i==n-1)
            {
                System.out.print(arr[i]);
            }
            else
            if(arr[i]!=-1)
                System.out.print(arr[i]+",");
            else c++;
        }
        for(int i=0;i<c;i++)
            if(i!=c-1)
            System.out.print(-1+",");
        else
                System.out.print(-1);

    }
}

package pod;

import java.util.Scanner;

public class pod53 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] s=sc.nextLine().split(",");
        int[] arr=new int[n];
        int k=0;
        for(String s1:s)
            arr[k++]=Integer.parseInt(s1);
        int diff=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(arr[j]-arr[i]>diff)
                    diff=arr[j]-arr[i];
            }
        }
        System.out.println(diff);
    }
}

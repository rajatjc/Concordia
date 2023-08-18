import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ass1q3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String l1,l2;
        l2=sc.nextLine();

        String[] s1,s2;
        s2=l2.split(",");


        int n=s2.length;
        int [] arr=new int[n];


        int diff=0;
        for(int i=0;i<n;i++) {
            arr[i]=Integer.parseInt(s2[i]);
            int abs = Math.abs(arr[i] - arr[i + 1]);
            if(abs >diff)
                diff= abs;
        }

        int[] a=new int[12];
        Arrays.fill(a,-1);
        
        for(int i=0;i<n;i++)
        {
            if(arr[i]==1) {
                if(a[0]==-1)
                {
                    a[0]=i;
                }
                a[1]=i;

            } else if (arr[i]==11) {
                if(a[2]==-1)
                {
                    a[2]=i;
                }
                a[3]=i;
                
            } else if (arr[i]==101) {
                if(a[4]==-1)
                {
                    a[4]=i;
                }
                a[5]=i;
                
            } else if (arr[i]==111) {
                if(a[6]==-1)
                {
                    a[6]=i;
                }
                a[7]=i;
                
            } else if (arr[i]==808) {
                if(a[8]==-1)
                {
                    a[8]=i;
                }
                a[9]=i;
                
            } else if (arr[i]==818) {
                if(a[10]==-1)
                {
                    a[10]=i;
                }
                a[11]=i;
            }
        }



        
        

    }
}

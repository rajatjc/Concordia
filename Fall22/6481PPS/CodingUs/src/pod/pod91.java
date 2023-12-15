package pod;

import java.util.Scanner;

public class pod91 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        int[] a=new int[s.length];
        for(int i=0;i<s.length;i++)
            a[i]=Integer.parseInt(s[i]);
        int[] prefix=new int[s.length];int n=s.length;int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=a[i];
            prefix[i]=sum;
        }
        int max=0;
        for(int k=0;k<n;k++)
        {
            for(int i=k;i<n-1;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    if(prefix[i]*2==prefix[j])
                    {
                        if(prefix[i]>max)
                            max=prefix[i];
                    }
                    else if(prefix[i]*2<prefix[j])
                        break;
                }
            }
            for(int l=0;l<n;l++)
                prefix[l]=prefix[l]-a[k];
        }
        System.out.println(max);
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class lab4b {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        int[] arr=new int[n];
        String[] s=sc.nextLine().split(" ");
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(s[i]);


        Arrays.sort(arr);
        int temp=1;
        int found=0;
        int finAns=-1;
        while(found!=1)
        {
            int ans=temp;
            int[] vis=new int[n];
            while(ans!=0)
            {
                int index=-1;
                for(int i=0;i<n;i++)
                {
                    if(arr[i]>ans)
                        break;
                    else
                        if(vis[i]==0)
                            index=i;
                }
                if(index==-1)
                {
                    found=1;
                    finAns=temp;
                    break;
                }
                vis[index]=1;
                ans-=arr[index];
            }
            temp++;
        }
        System.out.println(finAns);
    }
}

package pod;

import java.util.Scanner;

public class pod102 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int [] arr=new int[52];
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt((i));
            if(c>='a'&&c<='z')
            {
                arr[c-'a']++;
            }
            else
            {
                arr[c-'A'+26]++;
            }
        }
        int ans=0;
        int flag=0;
        for(int i=0;i<52;i++)
        {
            if(arr[i]%2==0)
                ans+=arr[i];
            else {
                ans+=(arr[i]-1);
                flag=1;
            }
        }
        System.out.println(ans+flag);
    }
}

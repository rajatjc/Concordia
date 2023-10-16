package pod;

import java.util.Scanner;

public class pod21 {
    public int findLCP(String s,String p)
    {
        int sl=s.length();
        int pl=p.length();
        int len=sl<pl?sl:pl;
        int g=0;
        for(int i=0;i<len;i++)
        {
            if(s.charAt(i)==p.charAt(i))
            {
                g++;
            }
            else break;
        }

        return g;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1;
        s1=sc.nextLine();
        String[] s11=s1.split(",");
        int c=0;
        for(String str:s11)
            c++;
        int ans=0;
        pod21 obj=new pod21();
        for(int i=0;i<c;i++)
        {
            int m=0;
            for(int j=0;j<c;j++)
            {
                if(i!=j)
                {
                    int n=obj.findLCP(s11[i],s11[j]);
                    m=Math.max(m,n);
                }
            }
            if(s11[i].length()==m)
                ans=ans+m;
            else
                ans=ans+m+1;
        }
        System.out.println(ans);
    }
}

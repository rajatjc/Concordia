package pod;

import java.util.*;

public class pod31 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        s1=s1.substring(1,s1.length()-1);
        String[] s11=s1.split(" ");
        String s2=sc.nextLine();
        s2=s2.substring(1,s2.length()-1);
        String[] s22=s2.split(" ");
        int n=s11.length;
        int m=s22.length;
        int m2=1;
        for(int i=0;i<m;i++)
        {
            int m1=0;

            for(int j=0;j<n;j++)
            {
                String s=s22[i];
                String t=s11[j];
                if(s.length()!=t.length())
                {
                    continue;
                }
                else
                {
                    int flag=1;
                    for(int k=0;k<s.length();k++)
                    {
                        if(s.charAt(k)=='*')
                            continue;
                        else if(s.charAt(k)==t.charAt(k))

                            continue;

                        else
                        {
                            flag=0;
                            break;
                        }
                    }
                    if(flag==1)
                        m1 += 1;
                }
            }
            //if(m1!=0)
            m2*=m1;
        }
        System.out.println(m2);
    }
}

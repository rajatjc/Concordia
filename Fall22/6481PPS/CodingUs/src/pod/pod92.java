package pod;

import java.util.HashMap;
import java.util.Scanner;

public class pod92 {
    static int numberOfWays(String s,String ans)
    {
        if(s.isEmpty())
        {
            System.out.println(ans);
//            StringBuilder s1=new StringBuilder();
//            ans=s1;
            return 1;
        }
        HashMap<String,Character> hm=new HashMap<>();
        for(int i=1;i<=26;i++)
        {
            String temp=String.valueOf(i);
            char c= (char) (i+'A'-1);
            hm.put(temp,Character.valueOf(c));
        }
        int ans1=0,ans2=0;
        if(hm.containsKey(s.substring(0,1)))
        {
            ans1=numberOfWays(s.substring(1,s.length()),ans+(hm.get(s.substring(0,1))));
        }
        if(s.length()>=2&&hm.containsKey(s.substring(0,2)))
        {
            ans2=numberOfWays(s.substring(2,s.length()),ans+(hm.get(s.substring(0,2))));
        }
        return ans1+ans2;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(numberOfWays(s, ""));
//        System.out.println(s.substring(1,s.length())+" "+
//        s.substring(2,s.length())+" "+
//        s.substring(0,2)+" "+s.indexOf(0));
//        System.out.println(s.isEmpty());
    }
}

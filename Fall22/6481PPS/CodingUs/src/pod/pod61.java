package pod;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class pod61 {
    public static<T> T[] subArray(T[] array, int beg, int end) {
        return Arrays.copyOfRange(array, beg, end );
    }
    public static int findAns(String[] s1,String word,String kol)
    {
        if(word.length()==0)
            return 0;

        for(int i=0;i<s1.length;i++)
        {
            if(word.length()<s1[i].length())
                continue;

            if(s1[i].equals(word.substring(0,s1[i].length())))
            {

                String[] temp=new String[s1.length-1];
                int k=0;
                for(int j=0;j<i;j++)
                {
                    temp[k++]=s1[j];
                }
                for(int j=i+1;j<s1.length;j++)
                {
                    temp[k++]=s1[j];
                }
                int newans=findAns(temp,kol,kol);
                int ans= findAns(s1,word.substring(s1[i].length(),word.length()),kol)+1;

                if(ans==0)
                    continue;
                else
                    return Math.min(ans,newans);
            }
            else
                continue;
        }

        return 1000000;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s1=sc.nextLine().split(" ");
        String s=sc.nextLine();
        Arrays.sort(s1, (a, b)->Integer.compare(a.length(), b.length()));
        Collections.reverse(Arrays.asList(s1));

//        for(String k:s1)
//            System.out.println(k);

        int ma=findAns(s1,s,s);



        if(ma>=1000000)
            System.out.println(-1);
        else
            System.out.println(ma);
    }
}

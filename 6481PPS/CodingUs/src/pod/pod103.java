package pod;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class pod103 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] s=sc.nextLine().split(" ");
        int [] arr=new int[n];

        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++) {
            arr[i]=Integer.parseInt(s[i]);
            if(hm.containsKey(arr[i]))
            {
                int temp=hm.get(arr[i]);
                hm.put(arr[i],temp+1);

            }
            else
                hm.put(arr[i],1);
        }
        for(Map.Entry<Integer, Integer> g:hm.entrySet())
        {
         int temp=g.getValue();
         if(temp>n/2)
         {
             System.out.print(g.getKey()+" ");
         }
        }

    }
}

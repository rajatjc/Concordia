package pod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class pod62 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String[] s1=sc.nextLine().split(",");
        String[] s2=sc.nextLine().split(",");
        int [] a1=new int[s1.length];
        int [] a2=new int[s2.length];
        HashMap<Integer, ArrayList<Integer>> mm=new HashMap<>();
        for(int i=0;i<s1.length;i++)
        {
            a1[i]=Integer.parseInt(s1[i]);
            a2[i]=Integer.parseInt(s2[i]);
            if(mm.containsKey(a1[i]))
            {

                ArrayList<Integer> temp=mm.get(a1[i]);
                if(temp.contains(a2[i]))
                    continue;
                temp.add(a2[i]);
                mm.put(a1[i],temp);
            }
            else
            {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(a2[i]);
                mm.put(a1[i],temp);
            }
            if(mm.containsKey(a2[i]))
            {
                ArrayList<Integer> temp=mm.get(a2[i]);
                if(temp.contains(a1[i]))
                    continue;
                temp.add(a1[i]);
                mm.put(a2[i],temp);
            }
            else
            {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(a1[i]);
                mm.put(a2[i],temp);
            }
        }
        HashMap<Integer, ArrayList<Integer>> newMap=new HashMap<Integer,ArrayList<Integer>>();

        int flag=0;
        int c=0;
        int ans=0;
        while(flag!=1)
        {
            flag=1;
            if(mm.size()==0)
                break;
            //traverse map
            newMap= (HashMap<Integer, ArrayList<Integer>>) mm.clone();
            int k=0;
//            for(HashMap.Entry<Integer, ArrayList<Integer>> m : newMap.entrySet())
//            {
//                ArrayList<Integer> temp=m.getValue();
//                if(temp.size()==1)
//                {
//                    k++;
//                }
//            }
            for(HashMap.Entry<Integer, ArrayList<Integer>> m : newMap.entrySet())
            {
                ArrayList<Integer> temp=m.getValue();
                if(temp.size()==1)
                {
                    flag=0;
                    Integer rEle=m.getKey();
                    Integer val=mm.remove(rEle).get(0);
                    ArrayList<Integer> upd=mm.get(val);
                    upd.remove(rEle);
                    mm.put(val,upd);

                }
                if(temp.size()==0)
                {
                    mm.remove(m.getKey());
                }

            }
            if(flag==1&&c==0)
            {
                System.out.println(0);
                return;
            }
            c++;
//            if(k==newMap.size())
//                ans=-1;
        }
        System.out.println(c+ans);
    }
}

package pod;

import java.util.*;

public class lab7b {
    static Set<ArrayList<Integer>> s1=new HashSet<>();
    public static void findPowerSet(int []s, Deque<Integer> res,int n,int tar){
        if (n == 0){
            ArrayList<Integer> list = new ArrayList(res);
            Collections.sort(list);
            int sum=0;
            for(int l:list) {
                sum+=l;
            }

            if(sum==tar) {
//                for(int l:list) {
//                    System.out.print(l+" ");
//                }
//                System.out.println();
                s1.add(list);
            }
            return;
        }
        res.addLast(s[n - 1]);
        findPowerSet(s, res, n - 1,tar);
        res.removeLast();
        findPowerSet(s, res, n - 1,tar);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tar=Integer.parseInt(sc.nextLine());
        int n=Integer.parseInt(sc.nextLine());
        String []s=sc.nextLine().split(" " );
        int[] a =new int[n];
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(s[i]);
        Deque<Integer> res = new ArrayDeque<>();
        findPowerSet(a, res, n,tar);
        System.out.println(s1.size());
    }
}

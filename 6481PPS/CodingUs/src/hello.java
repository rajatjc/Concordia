import org.w3c.dom.ls.LSOutput;

public class hello {
    public static int[] solve(String A, int[] B) {

        int [] ans=new int [A.length()];
        for(int i=1;i<A.length()-1;i++)
        {
            if(A.charAt(i-1)!=A.charAt(i+1))
                ans[i]=1;
        }
        ans[0]=1;
        ans[A.length()-1]=1;
        for(int j:ans)
            System.out.print(j+" ");
        System.out.println();
        for(int i=0;i<ans.length;i++)
        {
            if(ans[i]==0)
            {
                int a=i-1;
                int b=i+1;
                while(a>=0&&b<=A.length()-1&&A.charAt(a)==A.charAt(b))
                {
                    a--;
                    b++;
                }
                ans[i]=b-a-1;
            }
        }
        int l=0;
       int [] fans=new int[B.length];
        for(int k:B)
        {
            fans[l++]=ans[k-1];
        }
        return ans;
    }
    public static void main(String[] args) {
        String a="aaaaaaaaaa";
        int []B={1,2,3,4,5,6,7,8,9,10};
        int [] ans=solve(a,B);
        for(int j:ans)
            System.out.print(j+" ");

    }
}

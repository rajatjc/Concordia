import java.util.Scanner;

public class pod22 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String[] s11=s1.split(" ");
        int n,k;
        n=Integer.parseInt(s11[0]);
        k=Integer.parseInt(s11[1]);
        long ans=0;
        ans=n*(n+1)/2;
        ans-=k;
        ans*=8;
        ans+=1;
        //System.out.println(ans);
        if(ans<0)
        {
            System.out.println(-1);
            return;
        }
        double ans1= Math.sqrt(ans);
        ans1-=1;
        ans1/=2.0;
        ans1=Math.floor(ans1);
        System.out.println(n-(int)ans1);

    }
}

import java.util.Scanner;

public class pod32 {
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        String n=sc.nextLine();
        String s1=sc.nextLine();

        String [] s=s1.split(",");
        int[] a=new int[s.length];
        for(int i=0;i<s.length;i++)
            a[i]=Integer.parseInt(s[i]);

        int m=0;
        int index=0;
        for(int i=1;i<s.length-1;i++)
        {
            if((a[i])>(a[i-1])&&(a[i])>(a[i+1]))
            {
                int temp=Math.max(Math.abs(a[i]-a[i-1]),Math.abs(a[i]-a[i+1]));
                if(temp>m)
                {
                    m=temp;
                    index=i;
                }
            }
            else
                continue;
        }
        if(m!=0)
            System.out.println(index);
        else
            System.out.println(-1);
    }
}

import java.util.Scanner;

public class ass1q1 {
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            String l1,l2;
            l1=sc.nextLine();
            l2=sc.nextLine();

            String[] s1,s2;
            s1=l1.split(" ");
            s2=l2.split(",");

            int n,k;
            n=Integer.parseInt(s1[0]);
            k=Integer.parseInt(s1[1]);
            int [] arr=new int[n];

            for(int i=0;i<n;i++)
                arr[i]=Integer.parseInt(s2[i]);


            for(int i=0;i<n;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    if(arr[j]-arr[i]==10)
                        System.out.println(arr[i]+" "+arr[j]);
                }
            }

    }
}

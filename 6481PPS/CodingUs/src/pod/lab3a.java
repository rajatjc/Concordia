import java.util.Scanner;

public class lab3a {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++)
        {
            String s1,s2;
            s1=sc.nextLine();
            s2=sc.nextLine();
            int len=s1.length()<s2.length()?s1.length():s2.length();
            int c=0;
            for(int j=0;j<len;j++)
            {
                if(s1.charAt(j)==s2.charAt(j))
                    c++;
                else break;
            }
            System.out.println(c);
        }
    }
}

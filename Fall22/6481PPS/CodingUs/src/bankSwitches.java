import java.util.*;

public class bankSwitches {

    public static void main(String[] args) {
        int n;
        Scanner s=new Scanner(System.in);
        n=s.nextInt();

        StringBuilder str=new StringBuilder();

        for(int i=1;i<=n;i++)
        {
            if(Math.sqrt(i)-Math.floor(Math.sqrt(i))==0)
                str.append('1');
            else
                str.append('0');
        }
        System.out.println(str);
    }
}

package pod;

import java.util.Date;

public class pracpod7a {
    static int minOperations(int x, int y)
    {
     //.   System.out.println(x+" "+y);

        // If both are equal then return 0
        if (x == y)
            return 0;

        // Check if conversion is possible or not
        if (x <= 0 && y > 0)
            return -1;

        // If x > y then we can just increase y by 1
        // Therefore return the number of increments
        // required
        if (x > y)
            return x - y;

        // If last bit is odd
        // then increment y so that we can make it even
        if (y % 2 != 0)
            return 1 + minOperations(x, y + 1);

            // If y is even then divide it by 2 to make it
            // closer to x
        else
            return 1 + minOperations(x, y / 2);
    }

    public static void main(String[] args)
    {
        Date curr=new Date();
        double time1=  System.nanoTime();
        System.out.println(minOperations(103,999999999));
        double time2=  System.nanoTime();
        System.out.println((time2 - time1)/1000000);
    }
}

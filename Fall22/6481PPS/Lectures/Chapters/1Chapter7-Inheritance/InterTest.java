import java.util.*;

public class InterTest implements i1, i2 {
   //public String m1 () {return "hi";};
   //public double m1 () {return 10};
   public LinkedList m2 () { return new LinkedList(); }

   public static void main(String[] args) {
    // System.out.print(X);
    System.out.print(i1.X);
   }    
}


interface i1 {
   final int X = 9;
   //public String m1 ();
   public Object m2 ();
}

interface i2 {
   final int X = 5;
   //public double m1 ();
   public Collection m2 ();
} 
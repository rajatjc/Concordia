package recursion;

public class Class1 {
    public static void main(String[] args) {

        printIncreasing(5,9);
        System.out.println();
        printDecreasing(5,9);
        System.out.println();
        printDecreasing1(5,9);
        System.out.println();
        printIncreasingDecreasing(5,9);
        System.out.println();
        printOddEven(6,10);
        System.out.println();
        System.out.println(fact(5));
    }
    public static void printIncreasing(int a ,int b)
    {
        if(a>b)
            return;
        System.out.print(a+" ");
        printIncreasing(a+1,b);
    }

    public static void printDecreasing(int a ,int b)
    {
        if(a>b)
            return;
        System.out.print(b+" ");
        printDecreasing(a,b-1);
    }

    public static void printDecreasing1(int a ,int b)
    {
        if(a>b)
            return;
        printDecreasing1(a+1,b);
        System.out.print(a+" ");

    }

    public static void printIncreasingDecreasing(int a ,int b)
    {
        if(a>b)
            return;
        System.out.print(a+" ");
        printIncreasingDecreasing(a+1,b);
        System.out.print(a+" ");

    }

    public static void printOddEven(int a ,int b)
    {
        if(a>b)
            return;
        if(a%2!=0)
            System.out.print(a+ " ");
        printOddEven(a+1,b);
        if(a%2==0)
            System.out.print(a+ " ");

    }
    public static int fact(int n)
    {
        if(n==0)
            return 1;
        return fact(n-1)*n;

      //  return n==0 ? 1 : fact(n-1)*n;
    }
}

/*

59
5 7 9 8 6

69
7 9 8 6

6 10
7 9 10 8 6

5 10
5 7 9 10 8 6

 */
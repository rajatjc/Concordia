//import java.util.Scanner;
//import java.util.Stack;
//
//public class eg1 {
//    public static void main(String[] args) {
//        System.out.println("hello");
////        Object[] arr = new Object[6];
////
////        arr[0] = new String("First Pair");
////        arr[1] = new Integer(1);
////        arr[2] = new String("Second Pair");
////        arr[3] = new Integer(2);
////        arr[4] = new String("Third Pair");
////        arr[5] = new Integer(3);
////        int x = (Integer)arr[3];
////        System.out.println(x);
////
////
////        Object[] a = new Object[]{1,2,3,"srk"};
////        for(Object o: a){
////            System.out.println();
////        }
////        double [] codes = new double[100];
////        int count = 100;
////        System.out.println(codes[count]);
//
////        int[] scores = new int [10];
////        System.out.print(scores.length);
//
//
//        Scanner sc=new Scanner(System.in);
//
//
//        int[][] hel=new int[4][4];
//        for(int i=0;i<4;i++)
//        {
//            String s1=sc.nextLine();
//            String[] s11;
//            s11=s1.split(" ");
//            for(int j=0;j<4;j++)
//            {
//                hel[i][j]=Integer.parseInt(s11[j]);
//            }
//        }
//
//        for(int i=0;i<4;i++)
//        {
//            for(int j=0;j<4;j++)
//            {
//                System.out.println(hel[i][j]);
//            }
//        }
//
//        import java.util.Scanner;
//
//        public class pod.POD41 {
//            public static void main(String[] args) {
//                Scanner sc=new Scanner(System.in);
//                String s1=sc.nextLine();
//                s1=s1.substring(1,s1.length()-1);
//                String[] s11=s1.split(",");
//
//                String s2=sc.nextLine();
//                s2=s2.substring(1,s2.length()-1);
//                String[] s22=s2.split(",");
//
//                int[] prog=new int[s11.length];
//                int[] speed=new int[s22.length];
//
//                for(int i=0;i<s11.length;i++)
//                {
//                    prog[i]=Integer.parseInt(s11[i]);
//                    speed[i]=Integer.parseInt(s22[i]);
//                }
//                int day=0,prod=0;
//                int i=0;
//                while(i<s22.length) {
//
//                    while (prog[i] < 100) {
//                        for (int j = i; j < s22.length; j++) {
//                            prog[j] += speed[j];
//                        }
//                        day++;
//                    }
//
//                    while (i < s22.length && prog[i] >= 100) {
//                        prod++;
//                        i++;
//                    }
//                    if (i == s22.length)
//                    {
//                        System.out.print("(" + day + "," + prod + ")");
//                        return;
//                    }
//                    System.out.print("("+day+","+prod+"),");
//                    prod=0;
//                }
//            }
//        }
//
//
//        import java.util.Scanner;
//
//        public class pod.pod42 {
//            public static void main(String[] args) {
//                Scanner sc=new Scanner(System.in);
//                int n=Integer.parseInt(sc.nextLine());
//                String[] s=sc.nextLine().split(",");
//                int[] arr=new int[n];
//                for(int i=0;i<n;i++)
//                    arr[i]=Integer.parseInt(s[i]);
//                int c=0;
//                for(int i=0;i<n;i++)
//                {
//                    if(c==0&&i==n-1)
//                    {
//                        System.out.print(arr[i]);
//                    }
//                    else
//                    if(arr[i]!=-1)
//                        System.out.print(arr[i]+",");
//                    else c++;
//                }
//                for(int i=0;i<c;i++)
//                    if(i!=c-1)
//                        System.out.print(-1+",");
//                    else
//                        System.out.print(-1);
//
//            }
//        }
//
//        import java.util.Scanner;
//import java.util.Stack;
//
//        public class pod.pod43 {
//            public static void main(String[] args) {
//                Scanner sc=new Scanner(System.in);
//                String s=sc.nextLine();
//                int n=s.length();
//                Stack<Character> s1=new Stack<Character>();
//                for(int i=0;i<n;i++)
//                {
//                    if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
//                        s1.push(s.charAt(i));
//                    else
//                    {
//                        if (s1.size()!=0&&s.charAt(i) == ')' && s1.peek() == '(') {
//                            s1.pop();
//                        } else if (s1.size()!=0&&s.charAt(i) == '}' && s1.peek() == '{') {
//                            s1.pop();
//                        } else if (s1.size()!=0&&s.charAt(i) == ']' && s1.peek() == '[') {
//                            s1.pop();
//                        }
//                        else
//                        {
//                            s1.push(s.charAt(i));
//                        }
//                    }
//
//                }
////        while(s1.size()!=0)
////        {
////            System.out.println(s1.pop());
////        }
//                if(s1.size()==0)
//                    System.out.println("true");
//                else
//                    System.out.println("false");
//            }
//        }
//
//
//        import java.util.Scanner;
//
//        public class rotateBy90 {
//            public static void main(String[] args) {
//                int r,c;
//                Scanner s=new Scanner(System.in);
//                r=s.nextInt();
//                c=s.nextInt();
//                System.out.println(r+" "+c);
//                int[][] a=new int[r][c];
//                int[][] b=new int[c][r];
//
//                for(int i=0;i<r;i++)
//                    for(int j=0;j<c;j++)
//                    {
//                        a[i][j]=s.nextInt();
//                        b[j][r-i-1]=a[i][j];
//                    }
//
//                for(int i=0;i<c;i++)
//                {
//                    for(int j=0;j<r;j++)
//                    {
//                        System.out.print(b[i][j]+ " ");
//                    }
//                    System.out.println();
//                }
//
//            }
//        }
//
//
//        package com.company;
//
//import java.util.Scanner;
//
//        public class triange {
//            public static void main(String args[]){
//                Scanner s = new Scanner(System.in);
//                String n = s.nextLine();
//                String input = s.nextLine();
//                String[] arr = input.split(",");
//                int count=1;
//                int max = 0;
//                int first = 0;
//                if(arr.length==0)
//                    System.out.println(0);
//                else if(arr.length==1)
//                    System.out.println(1);
//                else {
//                    for (int i = 1; i < arr.length; i++) {
//                        if (Integer.parseInt(arr[i - 1]) < Integer.parseInt(arr[i]) && Integer.parseInt(arr[i])!= Integer.parseInt(arr[first]) ) {
//                            count++;
//
//                        }
//                        else if(Integer.parseInt(arr[i - 1]) > Integer.parseInt(arr[i]) && Integer.parseInt(arr[i])!= Integer.parseInt(arr[first])) {
//                            count++;
//                        }
//                        else if(i+1< Integer.parseInt(n) && ((Integer.parseInt(arr[i - 1]) < Integer.parseInt(arr[i]) && Integer.parseInt(arr[i+1]) > Integer.parseInt(arr[i]) && Integer.parseInt(arr[i])!= Integer.parseInt(arr[first])) || (Integer.parseInt(arr[i - 1]) > Integer.parseInt(arr[i]) && Integer.parseInt(arr[i+1]) < Integer.parseInt(arr[i]) && Integer.parseInt(arr[i])!= Integer.parseInt(arr[first])))  ) {
//                            count++;
//                        }
//                        else{
//
//
//                            if(max<=count){
//                                if(Integer.parseInt(arr[i])== Integer.parseInt(arr[first]))
//                                    max = count+1;
//                                else max = count;
//                            }
//                            count = 1;
//                            first = i;
//                        }
//
//
//                    }
//
//                }
//                if(max<=count)
//                    max = count;
//                System.out.println(max);
//            }
//        }
///*
//10
//0,1,2,3,2,1,0,4,7,6
//
//9
//0,1,2,3,3,4,5,7,6
//
//5
//0,1,2,3,3
//
// */
//
//
//        import java.util.Scanner;
//
//        public class ass1q1 {
//            public static void main(String[] args) {
//                Scanner sc=new Scanner(System.in);
//                String l1,l2;
//                l1=sc.nextLine();
//                l2=sc.nextLine();
//
//                String[] s1,s2;
//                s1=l1.split(" ");
//                s2=l2.split(",");
//
//                int n,k;
//                n=Integer.parseInt(s1[0]);
//                k=Integer.parseInt(s1[1]);
//                int [] arr=new int[n];
//
//                for(int i=0;i<n;i++)
//                    arr[i]=Integer.parseInt(s2[i]);
//
//
//                for(int i=0;i<n;i++)
//                {
//                    for(int j=i+1;j<n;j++)
//                    {
//                        if(arr[j]-arr[i]==10)
//                            System.out.println(arr[i]+" "+arr[j]);
//                    }
//                }
//
//            }
//        }
//
//
//
//    }
//}
//
//

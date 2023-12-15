package pod;

import java.util.Scanner;
import java.util.Stack;

public class pod43 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        Stack<Character> s1=new Stack<Character>();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
                s1.push(s.charAt(i));
            else
            {
                if (s1.size()!=0&&s.charAt(i) == ')' && s1.peek() == '(') {
                    s1.pop();
                } else if (s1.size()!=0&&s.charAt(i) == '}' && s1.peek() == '{') {
                    s1.pop();
                } else if (s1.size()!=0&&s.charAt(i) == ']' && s1.peek() == '[') {
                    s1.pop();
                }
                else
                {
                    s1.push(s.charAt(i));
                }
            }

        }
//        while(s1.size()!=0)
//        {
//            System.out.println(s1.pop());
//        }
        if(s1.size()==0)
            System.out.println("true");
        else
            System.out.println("false");
    }
}

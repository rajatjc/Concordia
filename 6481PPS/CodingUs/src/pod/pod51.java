package pod;


import java.util.HashMap;
import java.util.Scanner;


public class pod51 {
    private static String preprocess(String s) {
        s = s.replaceAll("\\!|\\?|\\,|\\;|\\.|\\(|\\[|\\{|\\)|\\}|\\]", " ");
        s = s.trim();  // should be put after all those replace()
        s = s.toLowerCase();
        return s;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        HashMap<String,String> hm=new HashMap<String,String>();
        for(int i=0;i<n;i++)
        {
            String s=sc.nextLine();
//            System.out.println();
//            Pattern reg = Pattern.compile("\\w+");
//            Matcher m = reg.matcher(s);
            String[] s1=preprocess(s).split(" ");
            int temp=0;
            String key = null;
            for(int k=0;k<s1.length;k++){


                String word = s1[k];
              //  System.out.println(word+" "+word.length());
                if(temp==0)
                {
                    key=word;
                }
                else
                {
                    hm.put(word,key);
                }
                temp++;
            }
        }


        while(sc.hasNextLine())
        {
            String s=sc.nextLine();
            //System.out.println(s+" "+s.length());
            if(s.length()==0)
                continue;

            String[] s1=preprocess(s).split(" ");
            String ans="";
            for(int k=0;k<s1.length;k++){


                String word = s1[k];
                //System.out.println(word+" "+word.length());
                if(hm.containsKey(word))
                {
                    ans=hm.get(word);
                    break;
                }
            }
            System.out.println(ans);
        }

    }
}
//commas, exclamation, points,
//        periods, semicolons, question marks, and parentheses) and space





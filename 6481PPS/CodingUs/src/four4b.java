import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class four4b {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        HashMap<String, Integer> mm=new HashMap<String, Integer>();
        for(int i=0;i<n;i++)
        {
            String s=sc.nextLine();
//            System.out.println(s);


            Pattern reg = Pattern.compile("\\w+");
            Matcher m = reg.matcher(s);




            while (m.find()) {
                String word=m.group();
                if(word.length()==1)
                {
                    if(!mm.containsKey(word)) {
                        mm.put(word,1);
                    }
                    else
                    {
                        int temp=mm.get(word);
                        mm.put(word,temp+1);
                    }

                }
                else if(word.length()==2)
                {
                    for(int k=0;k<2;k++)
                    {
                        String s1=String.valueOf(word.charAt(k));
                        if(!mm.containsKey(s1)) {
                            mm.put(s1,1);
                        }
                        else
                        {
                            int temp=mm.get(s1);
                            mm.put(s1,temp+1);
                        }
                    }
                    if(!mm.containsKey(word)) {
                        mm.put(word,1);
                    }
                    else
                    {
                        int temp=mm.get(word);
                        mm.put(word,temp+1);
                    }
                }
                else if(word.length()==3)
                {
                    for(int k=0;k<3;k++)
                    {
                        String s1=String.valueOf(word.charAt(k));
                        if(!mm.containsKey(s1)) {
                            mm.put(s1,1);
                        }
                        else
                        {
                            int temp=mm.get(s1);
                            mm.put(s1,temp+1);
                        }
                    }
                    for(int k=0;k<2;k++)
                    {
                        String s1=String.valueOf(word.charAt(k))+String.valueOf(word.charAt(k+1));
                        if(!mm.containsKey(s1)) {
                            mm.put(s1,1);
                        }
                        else
                        {
                            int temp=mm.get(s1);
                            mm.put(s1,temp+1);
                        }
                    }
                    if(!mm.containsKey(word)) {
                        mm.put(word,1);
                    }
                    else
                    {
                        int temp=mm.get(word);
                        mm.put(word,temp+1);
                    }
                }
                else {
                    for(int k=0;k<word.length();k++)
                    {
                        String s1=String.valueOf(word.charAt(k));
                        if(!mm.containsKey(s1)) {
                            mm.put(s1,1);
                        }
                        else
                        {
                            int temp=mm.get(s1);
                            mm.put(s1,temp+1);
                        }
                    }
                    for(int k=0;k<word.length()-1;k++)
                    {
                        String s1=String.valueOf(word.charAt(k))+String.valueOf(word.charAt(k+1));
                        if(!mm.containsKey(s1)) {
                            mm.put(s1,1);
                        }
                        else
                        {
                            int temp=mm.get(s1);
                            mm.put(s1,temp+1);
                        }
                    }
                    for(int k=0;k<word.length()-2;k++)
                    {
                        String s1=String.valueOf(word.charAt(k))+String.valueOf(word.charAt(k+1))+String.valueOf(word.charAt(k+2));
                        if(!mm.containsKey(s1)) {
                            mm.put(s1,1);
                        }
                        else
                        {
                            int temp=mm.get(s1);
                            mm.put(s1,temp+1);
                        }
                    }
                }

            }

        }
        int k=Integer.parseInt(sc.nextLine());
        for (HashMap.Entry<String, Integer> e : mm.entrySet())
            if(e.getKey().length()==k) {
                System.out.println(e.getKey()+" "+e.getValue());
            }

    }

}


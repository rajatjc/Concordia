public class quessss {

    public static boolean findAns(String s, String q)
    {
        if(s.length()==0&&q.length()==0)
            return true;
        if(s.length()!=0&&q.length()==0)
            return false;

        if(q.charAt(0)=='*')
        {
            boolean ans=false;
            for(int i=0;i<=s.length();i++)
            {
                ans=ans|findAns(s.substring(i,s.length()),
                        q.substring(1,q.length()));
            }
            return ans;
        }
       else if(q.charAt(0)=='?')
        {
            if(s.length()==0)
                return false;
            return findAns(s.substring(1,s.length()),q.substring(1,q.length()));
        }

        else
        {

            if(s.length()==0)
                return false;

            if(s.charAt(0)==q.charAt(0))
                return findAns(s.substring(1,s.length()),q.substring(1,q.length()));
            else
                return false;
        }
    }
    public static boolean isMatch(String s, String p) {
        return findAns("mississippi",
                "m??*ss*?i*pi");
    }

    public static void main(String[] args) {
        System.out.println(isMatch("a","C"));
    }
}

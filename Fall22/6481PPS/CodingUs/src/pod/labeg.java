package pod;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class labeg {
    public void leadingCharacterSame()
    {
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
    public void minWindow(String s, String t) {
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        int[] map = new int[256];
        int end = 0;
        int start = 0;
        int min_length = Integer.MAX_VALUE;
        for(int i = 0; i < t_array.length; i++) // store t character and its count ----< means the lack number
            map[t_array[i]] ++;
        int count = t_array.length;
        int min_start = 0;

        // for those Characters t doesn't have, map[thisCharacter] are at most 0
        while(end < s_array.length)
        {
            if(map[s_array[end]] > 0)   // t has this character
            {
                count--;
            }
            map[s_array[end]] --;
            while(count == 0)   //window matches
            {
                if((end - start + 1) < min_length)
                {
                    min_length = end - start + 1;
                    min_start = start;
                }
                map[s_array[start]] ++;     // start go left
                if(map[s_array[start]] > 0){    // remove a character which t has
                    count ++;           //Cause for those Characters t doesn't have, map[thisCharacter] are at most 0
                }
                start++;
            }
            end ++;

        }
        if( min_start+min_length > s_array.length)
            System.out.println("");
        System.out.println(s.substring(min_start, min_start+min_length));
    }
    public void pairedIsogram1()
    {
        Scanner s=new Scanner(System.in);
        int n=Integer.parseInt(s.nextLine());
        for(int i=0;i<n;i++)
        {
            String s1=s.nextLine();
            int[] a=new int[123];
            for(int j=0;j<s1.length();j++)
            {
                char ch=s1.charAt(j);
                int a1=ch;
                a[a1]++;

            }
            StringBuilder s2=new StringBuilder();
            StringBuilder s3=new StringBuilder();
            int flag=1;
            for(int j=0;j<123;j++)
            {
                String ch= String.valueOf((char) j);
                if(a[j]==1)
                {
                    s2.append(ch+" ");
                    flag=0;
                }
                else
                {
                    if(a[j]==2)
                        s3.append(ch+" ");
                }
            }
            if(flag==0)
            {
                System.out.println(s2+"no");
            }
            else
            {
                System.out.println(s3+"yes");
            }

        }
    }
    public void nGram()
    {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        int p = Integer.parseInt(sc.nextLine());
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            inputs.add(sc.nextLine());
        }
        int ngram = Integer.parseInt(sc.nextLine());
        System.out.println(inputs);
        for (String str : inputs) {
            if (ngram == 1 && str.length() >= 1) {
                for (int i = 0; i < str.length(); i++) {
                    if (!Character.toString(str.charAt(i)).equals(".") && !Character.toString(str.charAt(i)).equals(",")
                            && !Character.toString(str.charAt(i)).equals(" ")) {
                        if (map.containsKey(Character.toString(str.charAt(i)))) {
                            int a = map.get(Character.toString(str.charAt(i)));
                            map.put(Character.toString(str.charAt(i)), a + 1);
                        } else {
                            map.put(Character.toString(str.charAt(i)), 1);
                        }
                    }
                }
            } else if (ngram == 2 && str.length() >= 2) {
                for (int i = 0; i < str.length() - 1; i++) {
                    if (!Character.toString(str.charAt(i)).equals(".") && !Character.toString(str.charAt(i)).equals(",")
                            && !Character.toString(str.charAt(i)).equals(" ")) {
                        String s = Character.toString(str.charAt(i)) + Character.toString(str.charAt(i + 1));
                        if (map.containsKey(s)) {
                            int a = map.get(s);
                            map.put(s, a + 1);
                        } else {
                            map.put(s, 1);
                        }
                    }
                }
            } else if (ngram == 3 && str.length() >= 3) {
                for (int i = 0; i < str.length() - 2; i++) {
                    if (!Character.toString(str.charAt(i)).equals(".") && !Character.toString(str.charAt(i)).equals(",")
                            && !Character.toString(str.charAt(i)).equals(" ")) {
                        String s = Character.toString(str.charAt(i)) + Character.toString(str.charAt(i + 1))
                                + Character.toString(str.charAt(i + 2));
                        if (map.containsKey(s)) {
                            int a = map.get(s);
                            map.put(s, a + 1);
                        } else {
                            map.put(s, 1);
                        }
                    }
                }
            }
        }
        Map.Entry<String, Integer> maxEntry = null;
        //maxEntry = map.entrySet().iterator().next();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        String answerString = maxEntry.getKey();
        System.out.println(maxEntry);
        System.out.println(answerString);
        if (ngram == 1) {
            System.out.println("Unigram" + " " + answerString);
        } else if (ngram == 2) {
            System.out.println("Bigram" + " " + answerString);
        } else if (ngram == 3) {
            System.out.println("Trigram" + " " + answerString);
        }
        sc.close();
    }
    public static void main(String[] args) {

    }
    public String sortSentence(String s) {
        String[] s1=s.split(" ");
        String[] s2=new String[s1.length];
        for(int i=0;i<s1.length;i++)
        {
            int index=Integer.parseInt(String.valueOf(s1[i].charAt(s1[i].length()-1)));
            String t=s1[i].substring(0,s1[i].length()-1);
            s2[index]=t;
        }
        return String.join(" ",s2);
    }

    public String[] sortPeople(String[] strings, int[] ints) {

        String[] sorted=new String[100001];
        String[] ans=new String[strings.length];

        for(int i=0;i<strings.length;i++)
            sorted[ints[i]]=strings[i];

        int j=0;

        for(int i=0;i<100000;i++)
            if(sorted[i]!=null)
                ans[j++]=sorted[i];
        Collections.reverse(Arrays.asList(ans));

        return ans;
    }
    public String replaceDigits(String s) {
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(i%2!=0)
            {
                char ch= (char) (s.charAt(i-1)+Integer.parseInt(String.valueOf(s.charAt(i))));
            }
            else
                ans.append(s.charAt(i));
        }
        return ans.toString();
    }
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) break; // Since arr[i] <= arr[l] <= arr[r], if a[i] > 0 then sum=arr[i]+arr[l]+arr[r] > 0
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum < 0) l++;
                else if (sum > 0) r--;
                else {
                    ans.add(Arrays.asList(arr[i], arr[l], arr[r]));
                    while (l+1 <= r && arr[l] == arr[l+1]) l++; // Skip duplicate nums[l]
                    l++;
                    r--;
                }
            }
            while (i+1 < n && arr[i+1] == arr[i]) i++; // Skip duplicate nums[i]
        }
        return ans;
    }
    public void trangle()
    {
        /*
        int n, f;
        int a[10], b[10], c[10];
        cin» a[0]» a[1]» a[2];
        cin» b[0]» b[1]» b[2];
        sort(a, a + 3);
        sort(b, b + 3);
        int k = 0;
        for (int i = 0; i < 3; i++) {
          if (a[i] == b[i]) k++;
        }
        if (a[0] * a[0] + a[1] * a[1] == a[2] * a[2] && k == 3) cout« "YES"«
        endl;
        else cout << "NO" << endl;
        return 0;
         */
    }
    public class pod42 {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=Integer.parseInt(sc.nextLine());
            String[] s=sc.nextLine().split(",");
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=Integer.parseInt(s[i]);
            int c=0;
            for(int i=0;i<n;i++)
            {
                if(c==0&&i==n-1)
                {
                    System.out.print(arr[i]);
                }
                else
                if(arr[i]!=-1)
                    System.out.print(arr[i]+",");
                else c++;
            }
            for(int i=0;i<c;i++)
                if(i!=c-1)
                    System.out.print(-1+",");
                else
                    System.out.print(-1);

        }
    }
    public class POD41 {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);

            String s1=sc.nextLine();
            String[] s11=s1.substring(1,s1.length()-1).split(",");

            String s2=sc.nextLine();
            String[] s22=s2.substring(1,s2.length()-1).split(",");

            int[] prog=new int[s11.length];
            int[] speed=new int[s22.length];

            for(int i=0;i<s11.length;i++)
            {
                prog[i]=Integer.parseInt(s11[i]);
                speed[i]=Integer.parseInt(s22[i]);
            }
            int day=0,prod=0;
            int i=0;
            while(i<s22.length) {

                while (prog[i] < 100) {
                    for (int j = i; j < s22.length; j++) {
                        prog[j] += speed[j];
                    }
                    day++;
                }

                while (i < s22.length && prog[i] >= 100) {
                    prod++;
                    i++;
                }
                if (i == s22.length)
                {
                    System.out.print("(" + day + "," + prod + ")");
                    return;
                }
                System.out.print("("+day+","+prod+"),");
                prod=0;
            }
        }
    }

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

    public class pod52 {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            String s1=sc.nextLine();

            int n1;
            if(s1.length()>1)
            {

                String[] s=s1.split(" ");

                int n=s.length;
                int[] a=new int[n];
                for(int i=0;i<n;i++) {
                    a[i]=Integer.parseInt(s[i]);
                    // System.out.println(a[i]);
                }




                int ans = 0, ce = 0, cf = 0;
                for (int i = 0; i < a.length - 1; i++) {
                    cf = Math.max(cf, i + a[i]);
                    if (i == ce) {
                        ans++;
                        ce = cf;
                    }
                }
                System.out.println(ans);

            }
            else
            {
                n1=Integer.parseInt(s1);

                String s2=sc.nextLine();
                String[] s=s2.split(" ");

                int n=s.length;
                int[] a=new int[n];
                for(int i=0;i<n;i++) {
                    a[i]=Integer.parseInt(s[i]);
                    // System.out.println(a[i]);
                }




                int ans = 0, ce = 0, cf = 0;
                for (int i = 0; i < a.length - 1; i++) {
                    cf = Math.max(cf, i + a[i]);
                    if (i == ce) {
                        ans++;
                        ce = cf;
                    }
                }
                System.out.println(ans);

            }

        }
    }

    public class pod53 {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=Integer.parseInt(sc.nextLine());
            String[] s=sc.nextLine().split(",");
            int[] arr=new int[n];
            int k=0;
            for(String s1:s)
                arr[k++]=Integer.parseInt(s1);
            int diff=0;
            for(int i=0;i<n;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    if(arr[j]-arr[i]>diff)
                        diff=arr[j]-arr[i];
                }
            }
            System.out.println(diff);
        }
    }
    public class pod61 {
        public static<T> T[] subArray(T[] array, int beg, int end) {
            return Arrays.copyOfRange(array, beg, end );
        }
        public static int findAns(String[] s1,String word,String kol)
        {
            if(word.length()==0)
                return 0;

            for(int i=0;i<s1.length;i++)
            {
                if(word.length()<s1[i].length())
                    continue;

                if(s1[i].equals(word.substring(0,s1[i].length())))
                {

                    String[] temp=new String[s1.length-1];
                    int k=0;
                    for(int j=0;j<i;j++)
                    {
                        temp[k++]=s1[j];
                    }
                    for(int j=i+1;j<s1.length;j++)
                    {
                        temp[k++]=s1[j];
                    }
                    int newans=findAns(temp,kol,kol);
                    int ans= findAns(s1,word.substring(s1[i].length(),word.length()),kol)+1;

                    if(ans==0)
                        continue;
                    else
                        return Math.min(ans,newans);
                }
                else
                    continue;
            }

            return 1000000;
        }
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            String[] s1=sc.nextLine().split(" ");
            String s=sc.nextLine();
            Arrays.sort(s1, (a, b)->Integer.compare(a.length(), b.length()));
            Collections.reverse(Arrays.asList(s1));

//        for(String k:s1)
//            System.out.println(k);

            int ma=findAns(s1,s,s);



            if(ma>=1000000)
                System.out.println(-1);
            else
                System.out.println(ma);
        }
    }
    public class pod62 {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            sc.nextLine();
            String[] s1=sc.nextLine().split(",");
            String[] s2=sc.nextLine().split(",");
            int [] a1=new int[s1.length];
            int [] a2=new int[s2.length];
            HashMap<Integer, ArrayList<Integer>> mm=new HashMap<>();
            for(int i=0;i<s1.length;i++)
            {
                a1[i]=Integer.parseInt(s1[i]);
                a2[i]=Integer.parseInt(s2[i]);
                if(mm.containsKey(a1[i]))
                {

                    ArrayList<Integer> temp=mm.get(a1[i]);
                    if(temp.contains(a2[i]))
                        continue;
                    temp.add(a2[i]);
                    mm.put(a1[i],temp);
                }
                else
                {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(a2[i]);
                    mm.put(a1[i],temp);
                }
                if(mm.containsKey(a2[i]))
                {
                    ArrayList<Integer> temp=mm.get(a2[i]);
                    if(temp.contains(a1[i]))
                        continue;
                    temp.add(a1[i]);
                    mm.put(a2[i],temp);
                }
                else
                {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(a1[i]);
                    mm.put(a2[i],temp);
                }
            }
            HashMap<Integer, ArrayList<Integer>> newMap=new HashMap<Integer,ArrayList<Integer>>();

            int flag=0;
            int c=0;
            int ans=0;
            while(flag!=1)
            {
                flag=1;
                if(mm.size()==0)
                    break;
                //traverse map
                newMap= (HashMap<Integer, ArrayList<Integer>>) mm.clone();
                int k=0;
//            for(HashMap.Entry<Integer, ArrayList<Integer>> m : newMap.entrySet())
//            {
//                ArrayList<Integer> temp=m.getValue();
//                if(temp.size()==1)
//                {
//                    k++;
//                }
//            }
                for(HashMap.Entry<Integer, ArrayList<Integer>> m : newMap.entrySet())
                {
                    ArrayList<Integer> temp=m.getValue();
                    if(temp.size()==1)
                    {
                        flag=0;
                        Integer rEle=m.getKey();
                        Integer val=mm.remove(rEle).get(0);
                        ArrayList<Integer> upd=mm.get(val);
                        upd.remove(rEle);
                        mm.put(val,upd);

                    }
                    if(temp.size()==0)
                    {
                        mm.remove(m.getKey());
                    }

                }
                if(flag==1&&c==0)
                {
                    System.out.println(0);
                    return;
                }
                c++;
//            if(k==newMap.size())
//                ans=-1;
            }
            System.out.println(c+ans);
        }
    }
    public class pod63 {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int num=sc.nextInt();
            String ans = "";

            while (num >= 1000) {
                ans += "M";
                num -= 1000;
            }

            while (num >= 900) {
                ans += "CM";
                num -= 900;
            }

            while (num >= 500) {
                ans += "D";
                num -= 500;
            }

            while (num >= 400) {
                ans += "CD";
                num -= 400;
            }

            while (num >= 100) {
                ans += "C";
                num -= 100;
            }

            while (num >= 90) {
                ans += "XC";
                num -= 90;
            }

            while (num >= 50) {
                ans += "L";
                num -= 50;
            }

            while (num >= 40) {
                ans += "XL";
                num -= 40;
            }

            while (num >= 10) {
                ans += "X";
                num -= 10;
            }

            while (num >= 9) {
                ans += "IX";
                num -= 9;
            }

            while (num >= 5) {
                ans += "V";
                num -= 5;
            }

            while (num >= 4) {
                ans += "IV";
                num -= 4;
            }

            while (num >= 1) {
                ans += "I";
                num -= 1;
            }

            System.out.println(ans);
        }
    }
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

    public void pairedIsogram()
    {
        Scanner s=new Scanner(System.in);
        int n=Integer.parseInt(s.nextLine());
        for(int i=0;i<n;i++)
        {
            String s1=s.nextLine();
            int[] a=new int[123];
            for(int j=0;j<s1.length();j++)
            {
                char ch=s1.charAt(j);
                int a1=ch;
                a[a1]++;

            }
            StringBuilder s2=new StringBuilder();
            StringBuilder s3=new StringBuilder();
            int flag=1;
            for(int j=0;j<123;j++)
            {
                String ch= String.valueOf((char) j);
                if(a[j]==1)
                {
                    s2.append(ch+" ");
                    flag=0;
                }
                else
                {
                    if(a[j]==2)
                        s3.append(ch+" ");
                }
            }
            if(flag==0)
            {
                System.out.println(s2+"no");
            }
            else
            {
                System.out.println(s3+"yes");
            }

        }
    }



}

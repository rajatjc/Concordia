import java.util.Scanner;

public class pod23 {
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
    public static void main(String[] args) {
     pod23 obj=new pod23();
     Scanner sc=new Scanner(System.in);
     String s1,s2;
     s1=sc.nextLine();
     s2=sc.nextLine();
     obj.minWindow(s1,s2);
    }
}

package pod;

import java.util.*;

public class pod62_1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        sc.nextLine();
        String[] s1=sc.nextLine().split(",");
        String[] s2=sc.nextLine().split(",");
        int [] a1=new int[s1.length];
        int [] a2=new int[s2.length];
        int[][] mat=new int[n][n+1];
        for(int i=0;i<s1.length;i++) {
            a1[i] = Integer.parseInt(s1[i]);
            a2[i] = Integer.parseInt(s2[i]);
        }
        for(int i=0;i<s1.length;i++)
        {
            for(int j=0;j<s1.length;j++)
            {
                mat[a1[i]][a2[j]]=1;
                mat[a2[j]][a1[i]]=1;
            }
        }
        for(int i=0;i<n;i++)
        {

            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==1)
                    mat[i][n]++;
            }
            if(mat[i][n]==0)
                mat[i][n]=-1;
        }
        int c=0;
        for(int i=0;i<n;i++)
        {
            //checker funtion
            int flag=1;
            int temp=0;
            for(int j=0;j<n;j++)
            {
                if(mat[i][n]==1||mat[i][n]==0)
                    flag=0;
            }
            if(flag==1)
                break;

            c++;

            //condiiton
            if(mat[i][n]==1||mat[i][n]==0)
            {
                for(int j=0;j<n;j++)
                {
                    if(mat[i][j]==1)
                    {
                        mat[i][j]=0;
                        mat[j][i]=0;
                        if(mat[j][n]==1)
                            mat[j][n]-=2;
                        else
                            mat[j][n]--;
                        mat[i][n]-=2;
                    }
                }
            }
        }
        System.out.println(c);

    }
}

import java.util.Scanner;

public class rotateBy90 {
    public static void main(String[] args) {
        int r,c;
        Scanner s=new Scanner(System.in);
        r=s.nextInt();
        c=s.nextInt();
        System.out.println(r+" "+c);
        int[][] a=new int[r][c];
        int[][] b=new int[c][r];

        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
            {
                a[i][j]=s.nextInt();
                b[j][r-i-1]=a[i][j];
            }

        for(int i=0;i<c;i++)
        {
            for(int j=0;j<r;j++)
            {
                System.out.print(b[i][j]+ " ");
            }
            System.out.println();
        }

    }
}

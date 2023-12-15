// Java code to implement the
// matrix chain multiplication using recursion
import java.io.*;
import java.util.*;
class mcm {
	static int MatrixChainOrder(int p[], int i, int j)
	{
		if (i+2 == j)
			return p[i]*p[i+1]*p[i+2];
		if(i+1==j)return 0;
		int mini = Integer.MAX_VALUE;
		int mk=-1;
		for (int k = i+1; k < j; k++)
		{
			if(p[k]<mini)
			{
				mini=p[k];
				mk=k;
			}
		}
		return MatrixChainOrder(p,i,mk)+MatrixChainOrder(p,mk,j)+p[i]*p[mk]*p[j];
	}

	// Driver code
	public static void main(String args[])
	{
		int arr[] = new int[] {38, 2919, 8847, 8674, 1445, 8819, 3027, 1892, 5740, 3557};
		int N = arr.length;

		// Function call
		System.out.println(
				"Minimum number of multiplications is "
						+ MatrixChainOrder(arr, 0, N-1 ));
	}
}

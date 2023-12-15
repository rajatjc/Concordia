import java.util.Scanner;

public class Question1 {
	

	
	public static void product(long[] arr, int startIndex, int endIndex, long res, int lastIndex) {
		if(startIndex >= endIndex) {
			if(startIndex == endIndex) {
				res *= arr[startIndex];
			}
			arr[lastIndex] = res;
		}
		else {
			res *= (arr[startIndex] * arr[endIndex]);
			product(arr, startIndex+1, endIndex-1, res, lastIndex);
		}
	}
	
	public static void sum(long[] arr, int startIndex, int endIndex, long res, int lastIndex) {
		if (startIndex >= endIndex) {
			if(startIndex == endIndex) {
				res += arr[startIndex];
			}
			arr[lastIndex] = res;
		}
		else {
			res += (arr[startIndex] + arr[endIndex]);
			sum(arr, startIndex+1, endIndex-1, res, lastIndex);
		}
	}
	
	public static void print(long[] arr, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return;
		}
		else {
			System.out.print(arr[startIndex]);
			if(startIndex != endIndex) {
				System.out.print(", ");
			}
			print(arr, startIndex+1, endIndex);
		}
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int arrSize = sc.nextInt();
		long[] arr = new long[arrSize];
		
		for(int i=0; i<arrSize; i++) {
			arr[i] = sc.nextInt();
		}
		
		int p1 = (int) Math.ceil(arrSize*1.0/3);
		int p2 = p1 + (int)Math.floor(arrSize*1.0/3);
		
		System.out.println("p1 = " + p1 + ", p2 = " + p2);
		
		reverse(arr, 0, p1);
		product(arr, p1+1, p2, 1, p2);
		sum(arr, p2+1, arrSize-1 ,0, arrSize-1);
		
		print(arr, 0, arrSize-1);
		
		sc.close();
	}

}

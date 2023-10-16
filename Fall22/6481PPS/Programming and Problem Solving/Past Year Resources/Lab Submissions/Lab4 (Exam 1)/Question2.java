import java.util.Scanner;

public class Question2 {
	
	public static void leftRightSum(int[] arr) {
		int[] totalTillIndex = new int[arr.length];
		int total = 0;
		for(int i=0; i<arr.length; i++) {
			total += arr[i];
			totalTillIndex[i] = total;
		}
		int resultIndexValue = -1;
		for(int i=1; i<arr.length; i++) {
			int leftSum = totalTillIndex[i-1];
			int rightSum = totalTillIndex[arr.length-1] - totalTillIndex[i];
			if(leftSum == rightSum) {
				resultIndexValue = i;
				break;
			}
		}
		
		if(resultIndexValue == -1) {
			System.out.println("No Solution Exists; returning -1");
		}
		else {
			System.out.println("Solution Exists at Index " + resultIndexValue);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sizeOfArr = sc.nextInt();
		int[] arr = new int[sizeOfArr];
		
		for(int i=0; i<sizeOfArr; i++) {
			arr[i] = sc.nextInt();
		}
		
		leftRightSum(arr);
		
		sc.close();
	}

}

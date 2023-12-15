import java.util.Scanner;

public class Lab5_Question2 {

	public static void isStrictlyAscending(int[] arr) {
		int count = 0;
		int indexToBeRemoved = 0;
		int prevIndex = 0;
		int currIndex = 1;
		
		while(currIndex < arr.length) {
			if (arr[prevIndex] < arr[currIndex]) {
				currIndex++;
				prevIndex = currIndex - 1;
			} 
			else {
//				System.out.println("==> " + arr[prevIndex] + " " + arr[currIndex]);
				count++;
				if( (currIndex+1 < arr.length && arr[prevIndex] <= arr[currIndex+1])
						||
					(prevIndex-1 >= 0 && arr[prevIndex-1] <= arr[prevIndex] && arr[prevIndex] > arr[currIndex])	) {
					indexToBeRemoved = currIndex;
					currIndex++;	
				}
				else {
					indexToBeRemoved = prevIndex;
					prevIndex++;
					currIndex++;
				}
				
				if(count > 1) {
					break;
				}
			}
		}
		if (count == 0) {
			System.out.println("Array is OK. No removed value");
		}
		else if (count == 1) {
			System.out.println("Array is OK. Removed value " + arr[indexToBeRemoved] + " at index " + indexToBeRemoved);
		}
		else {
			System.out.println("No Solution Exists!");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int arrSize = sc.nextInt();
		int[] arr = new int[arrSize];
		
		for(int i=0; i<arrSize; i++) {
			arr[i] = sc.nextInt();
		}
		
		isStrictlyAscending(arr);
		
		sc.close();
	}

}

// 5
// 1 2 3 4 3

// 5 
// 1 2 5 3 4 

// 5
// 1 3 2 4 5 

// 1
// 4
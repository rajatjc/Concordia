package Assignment2;

import java.util.Scanner;

public class Part1Que1A {
	
	public static void findAllConsecutiveSimilarElements(int[] arr) {
		int repeatingEle = arr[0]; 
		int repeatingEleStartIndex = 0; 
		int repeatingEleCount = 1;
		for(int i=1; i<arr.length; i++) {
			if(arr[i] == repeatingEle) {
				repeatingEleCount++;
			}
			else {
				if(repeatingEleCount > 1) {
					System.out.println("Value " + repeatingEle + " is repeated " + repeatingEleCount + " times starting at index " + repeatingEleStartIndex);
				}
				repeatingEle = arr[i];
				repeatingEleStartIndex = i;
				repeatingEleCount = 1;
			}
		}
		if(repeatingEleCount > 1) {
			System.out.println("Value " + repeatingEle + " is repeated " + repeatingEleCount + " times starting at index " + repeatingEleStartIndex);
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
		
		findAllConsecutiveSimilarElements(arr);
		
		sc.close();
	}

}

// Space Complexity - O(1)
// Time Complexity - O(n)


/*
17

22 
9
61
61
61
21
0
9
9
9
9
35
81
81
9
5
5
 */

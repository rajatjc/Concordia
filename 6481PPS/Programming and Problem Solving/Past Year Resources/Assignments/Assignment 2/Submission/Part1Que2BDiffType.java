package Assignment2;

import java.util.Arrays;

public class Part1Que2BDiffType {
	private static int topOfStack1, topOfStack2;
	private static int[] arr;
	
	public static void pushToStack1(int val) {
			if(topOfStack1+1 < topOfStack2) {
				topOfStack1 += 1;
				arr[topOfStack1] = val;
			}
			else {
				System.out.println("Stack1 is full !");
			}
	}
	
	public static void pushToStack2(int val) {
		if(topOfStack2-1 > topOfStack1) {
			topOfStack2 -= 1;
			arr[topOfStack2] = val;
		}
		else {
			System.out.println("Stack2 is full !");
		}
	}
	
	public static int popFromStack1() {
		if(topOfStack1 > -1) {
			int poppedVal = arr[topOfStack1];
			arr[topOfStack1] = -1;
			topOfStack1 -= 1;
			return poppedVal;
		}
		else {
			return -1;
		}
	}
	
	public static int popFromStack2() {
		if(topOfStack2 < 6) {
			int poppedVal = arr[topOfStack2];
			arr[topOfStack2] = -1;
			topOfStack2 += 1;
			return poppedVal;
		}
		else {
			return -1;
		}
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int size = 6;
		arr = new int[size];
		
		topOfStack1 = -1;
		topOfStack2 = 6;
		
		pushToStack1(1);
		pushToStack1(2);
		pushToStack1(3);
		
		pushToStack2(4);
		pushToStack2(5);
		pushToStack2(6);
		
		System.out.println(Arrays.toString(arr));
		
		popFromStack1();
		popFromStack1();
		pushToStack2(31);
		pushToStack2(51);
		
		System.out.println(Arrays.toString(arr));
		
		popFromStack2();
		popFromStack2();
		pushToStack1(71);
		pushToStack1(91);
		
		System.out.println(Arrays.toString(arr));
		
		popFromStack1();
		popFromStack1();
		popFromStack1();
		
		popFromStack2();
		popFromStack2();
		popFromStack2();
		
		System.out.println(Arrays.toString(arr));
		
	}

}

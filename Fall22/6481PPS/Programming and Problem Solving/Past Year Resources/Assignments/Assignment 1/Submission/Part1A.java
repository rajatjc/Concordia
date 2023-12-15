// -----------------------------------------------------
// Assignment 1 - Question 1
// © Manan Paruthi
// Written by: Manan Paruthi (Concordia University Student ID: 40192620) 
// -----------------------------------------------------

package Assignment1;

import java.util.Scanner;

public class Part1A {
	
	public static int[] ModifyLeftHalfArr(int[] arr, int middleIndex) {
		System.out.println(arr.length + " " + middleIndex);
		for(int i=0; i<middleIndex; i+=2) {
			int temp;
			temp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = temp;
		}
		return arr;
	}
	
	public static int[] ModifyRightHalfArr(int[] arr, int middleIndex) {
		System.out.println(arr.length + " " + middleIndex);
		for(int i=middleIndex; i<arr.length; i+=2) {
			int temp = arr[i] + arr[i+1];
			arr[i+1] = temp;
		}
		return arr;
	}

	
	public static void PrintArray(int[] arr) {
		String result = "";
		for(int i=0; i<arr.length; i++) {
			if(i == arr.length-1) {
				result +=  Integer.toString(arr[i]);  
			}
			else {
				result +=  Integer.toString(arr[i]);
				result += " ";
			}
		}
		System.out.println(result);
	}
	
	public static int[] GetSpaceSeparatedArrayAsInput() {
		Scanner sc = new Scanner(System.in);
		int sizeOfArr = sc.nextInt();
		int[] arr = new int[sizeOfArr];
		
		sc.nextLine();
		String[] temp = sc.nextLine().split(" ");
		
		for(int i=0; i<sizeOfArr; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		sc.close();
		
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = GetSpaceSeparatedArrayAsInput();
		int sizeOfArr = arr.length;
		int middleIndex = sizeOfArr/2;
		if(sizeOfArr%2 != 0) {
			if(middleIndex%2 != 0) {
				ModifyLeftHalfArr(arr, middleIndex);
				ModifyRightHalfArr(arr, middleIndex+2);
			}
			else {
				ModifyLeftHalfArr(arr, middleIndex);
				ModifyRightHalfArr(arr, middleIndex+1);
			}
		}
		else {
			if(middleIndex%2 != 0) {
				ModifyLeftHalfArr(arr, middleIndex);
				ModifyRightHalfArr(arr, middleIndex+1);
			}
			else {
				ModifyLeftHalfArr(arr, middleIndex);
				ModifyRightHalfArr(arr, middleIndex);
			}
		}
		PrintArray(arr);
	}

}
//Input : 22    0 1 2 3 4 5 6 7 8 9 10 11 12 0 1 2 3 4 5 6 7 8 9 10
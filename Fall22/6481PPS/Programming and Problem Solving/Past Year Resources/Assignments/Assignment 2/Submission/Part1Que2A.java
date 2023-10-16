package Assignment2;

import java.util.Arrays;
import java.util.Scanner;

public class Part1Que2A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int size = 6;
		
		int[] arr = new int[size];
		
		Stack s1 = new Stack(arr, 0, size/2-1);
		Stack s2 = new Stack(arr, size/2, size-1);
		
		s1.push(1);
		s1.push(2);
		s1.push(3);
		
		s2.push(4);
		s2.push(5);
		s2.push(6);
		
		System.out.println("arr ==> "+ Arrays.toString(arr));
		
		s1.pop();
		s1.pop();
		s1.pop();
		
		s2.pop();
		s2.pop();
		s2.pop();
		
		System.out.println("arr ==> "+ Arrays.toString(arr));
		
		sc.close();
	}

}

class Stack {
	
	private int startIndex, endIndex, top;
	private int[] stack;
	
	Stack(int[] arr, int startIndex, int endIndex) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.top = startIndex-1;
		stack = arr;
	}
	
	public void push(int val) {
		if(isFull()) {
			System.out.println("Stack is full");
		}
		else {
			top += 1;
			stack[top] = val;
		}
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			return -1;
		}
		else {
			int removedVal = stack[top];
			stack[top] = -1;
			top -= 1;
			return removedVal;
		}
	}
	
	public boolean isEmpty() {
		if(this.top == this.startIndex-1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isFull() {
		if(this.top == this.endIndex) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int size() {
		return top+1;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.stack);
	}
}

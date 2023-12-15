package Assignment2;

import java.util.Arrays;
import java.util.Scanner;

public class Part1Que2B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int size = 6;
		
		int[] arr = new int[size];
		
		StackForward s1 = new StackForward(arr, 0); // start from 0 one side end
		ReverseStack s2 = new ReverseStack(arr, size-1); // start from n other side end
		
		s1.push(1);
		s1.push(2);
		s1.push(3);
		s1.push(4);
		
		s2.push(5);
		s2.push(6);
		
		System.out.println("arr ==> "+ Arrays.toString(arr) );
		
		s1.pop();
		s1.pop();
		s2.push(11);
		s2.push(21);
		
		System.out.println("arr ==> "+ Arrays.toString(arr));
		
		s2.pop();
		s2.pop();
		s1.push(71);
		s1.push(81);
		
		System.out.println("arr ==> "+ Arrays.toString(arr));
		
		s1.pop();
		s1.pop();
		s1.pop();
		s1.pop();
		
		s2.pop();
		s2.pop();
		
		System.out.println("arr ==> "+ Arrays.toString(arr));
		
		sc.close();
	}

}

class StackForward {
	
	private int startIndex, top;
	private int[] stack;
	
	StackForward(int[] arr, int startIndex) {
		this.startIndex = startIndex;
		this.top = startIndex-1;
		stack = arr;
	}
	
	public void push(int val) {
		if(isFull()) {
			System.out.println("Stack 1 is full");
		}
		else {
			top += 1;
			stack[top] = val;
		}
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack 1 is Empty");
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
		if(stack[this.top+1] == -1 || stack[this.top+1] == 0) {
			return false;
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

class ReverseStack {
	private int startIndex, top;
	private int[] stack;
	
	ReverseStack(int[] arr, int startIndex) {
		this.startIndex = startIndex;
		this.top = startIndex+1;
		stack = arr;
	}
	
	public void push(int val) {
		if(isFull()) {
			System.out.println("Stack 2 is full");
		}
		else {
			top -= 1;
			stack[top] = val;
		}
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack 2 is Empty");
			return -1;
		}
		else {
			int removedVal = stack[top];
			stack[top] = -1;
			top += 1;
			return removedVal;
		}
	}
	
	public boolean isEmpty() {
		if(this.top == this.startIndex+1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isFull() {
		if(stack[this.top-1] == -1 || stack[this.top-1] == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	public int size() {
		return startIndex-top+1;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.stack);
	}
}
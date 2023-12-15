package Assignment2;

import java.util.Arrays;

public class Part1Que3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sttaack s = new Sttaack(6);
		
		s.push(5);
		System.out.println(s.max());
		s.push(3);
		System.out.println(s.max());
		s.push(1);
		System.out.println(s.max());
		s.push(6);
		System.out.println(s.max());
		s.push(2);
		System.out.println(s.max());
		s.push(9);
		System.out.println(s.max());
		
		s.pop();
		System.out.println(s.max());
		s.pop();
		System.out.println(s.max());
		s.pop();
		System.out.println(s.max());
		s.pop();
		System.out.println(s.max());
		s.pop();
		System.out.println(s.max());
		s.pop();
		
	}

}

class Sttaack {
	
	private int size, top;
	private int[] stack;
	private int[] maxTrackStack;
	
	Sttaack(int size) {
		this.size = size;
		this.top = -1;
		stack = new int[size];
		maxTrackStack = new int[size];
	}
	
	public void push(int val) {
		if(isFull()) {
			System.out.println("Stack is full");
		}
		else {
			top += 1;
			stack[top] = val;
			int prevMaxVal;
			if(top == 0) {
				prevMaxVal = val;
			}
			else {
				prevMaxVal = maxTrackStack[top-1];
			}
			if(val > prevMaxVal) {
				maxTrackStack[top] = val;
			}
			else {
				maxTrackStack[top] = prevMaxVal;
			}
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
	
	public int max() {
		if(top > -1) {
			return maxTrackStack[top];
		}
		else {
			return -1;
		}
	}
	
	public boolean isEmpty() {
		if(this.top == -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isFull() {
		if(this.top == this.size-1) {
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
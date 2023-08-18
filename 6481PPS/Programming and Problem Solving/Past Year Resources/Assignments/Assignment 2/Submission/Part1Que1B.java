package Assignment2;

import java.util.Scanner;

public class Part1Que1B {
	
	public static void findAllConsecutiveSimilarElements(Queue q) {
		int repeatingEle = q.dequeue(); 
		int repeatingEleStartIndex = 0; 
		int repeatingEleCount = 1;
		
		for(int i=1; i<q.getCapacity(); i++) {
			int currEle = q.dequeue();
			if(currEle == repeatingEle) {
				repeatingEleCount++;
			}
			else {
				if(repeatingEleCount > 1) {
					System.out.println("Value " + repeatingEle + " is repeated " + repeatingEleCount + " times starting at index " + repeatingEleStartIndex);
				}
				repeatingEle = currEle;
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
		int capacity = sc.nextInt();
		Queue q = new Queue(capacity+1); // 1 extra bcoz circular queue - one space is wasted as rear is always one after front
		
		for(int i=0; i<capacity; i++) {
			q.enqueue(sc.nextInt());
		}
		
		findAllConsecutiveSimilarElements(q);
		
		sc.close();
	}

}


class Queue {
	
	private int front, rear, capacity;
	private int[] queue;
	
	Queue(int maxCapacity) {
		front = rear = 0;
		queue = new int[maxCapacity];
		capacity = maxCapacity;
	}
	
	public void enqueue(int val) {
		if(isFull()) {
			System.out.println("Queue is Full");
		}
		else {
			queue[rear] = val;
			rear = (rear + 1) % capacity;
		}
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
		else {
			int removedVal = queue[front];
			front = (front+1) % capacity;
			return removedVal;	
		}
	}
	
	public boolean isEmpty() {
		if(front == rear) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isFull() {
		if(front  == (rear+1) % capacity) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int size() {
		return (capacity - front + rear) % capacity;
	}
	
	public int getCapacity() {
		return capacity-1;
	}
}
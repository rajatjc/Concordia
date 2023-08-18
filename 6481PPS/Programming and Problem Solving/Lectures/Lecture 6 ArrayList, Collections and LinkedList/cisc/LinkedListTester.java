// LinkedListTester.java
//
// The tester program compares our two linked list implementation on a number of common tasks.
// Note the performance advantages and disadvantages of each.

import java.io.*;
import java.util.Random;

public class LinkedListTester {

	public static void main(String[] args) throws IOException{

		final int BUILD_SIZE = 100000;
		final int INSERT_SIZE = 1000;
		final int DELETE_SIZE = 1000;
		final int LOOKUP_SIZE = 1000;

		SimpleArrayList saList = new SimpleArrayList();
		SimpleLinkedList slList = new SimpleLinkedList();
		StopWatch stopwatch = new StopWatch();
		Random randGen = new Random();

		// Build Testing
		System.out.println("*** Build time ***\n");
		System.out.println("Testing ArrayList creation speed using append() on " + BUILD_SIZE + " objects...");
		stopwatch.start();
		for (int i = 0; i < BUILD_SIZE; i++) {
			saList.append( new Integer(1) );
		}
		stopwatch.stop();
		System.out.println("Test time: " + stopwatch + "\n");


		System.out.println("Testing LinkedList creation speed using append() on " + BUILD_SIZE + " objects...");
		stopwatch.start();
		for (int i = 0; i < BUILD_SIZE; i++) {
			slList.append(new Integer(1));
		}
		stopwatch.stop();
		System.out.println("Test time: " + stopwatch + "\n");

		// Insert Testing
		System.out.println("\n\n\n** Insert time ***\n");
		System.out.println("Testing ArrayList insert speed using insertObjectAt() on " + INSERT_SIZE + " objects...");
		stopwatch.start();
		for (int i = 0; i < INSERT_SIZE; i++){
			saList.insertObjectAt(1, new Integer(1) );
		}
		stopwatch.stop();
		System.out.println("Test time: " + stopwatch + "\n");

		System.out.println("Testing LinkedList insert speed using insertObjectAt() on " + INSERT_SIZE + " objects...");
		stopwatch.start();
		for (int i = 0; i < INSERT_SIZE; i++){
			slList.insertObjectAt(1, new Integer(1));
		}
		stopwatch.stop();
		System.out.println("Test time: " + stopwatch + "\n");

		// Delete Testing
		System.out.println("\n\n\n*** Delete time ***\n");
		System.out.println("Testing ArrayList insert speed using deleteObjectAt() on " + DELETE_SIZE + " objects...");
		stopwatch.start();
		for (int i = 0; i < DELETE_SIZE; i++) {
			saList.deleteObjectAt(saList.getSize() - 1);
		}
		stopwatch.stop();
		System.out.println("Test time: " + stopwatch + "\n");

		System.out.println("Testing LinkedList insert speed using deleteObjectAt() on " + DELETE_SIZE + " objects...");
		stopwatch.start();
		for (int i = 0; i < DELETE_SIZE; i++) {
			slList.deleteObjectAt(slList.getSize() -1);
		}
		stopwatch.stop();
		System.out.println("Test time: " + stopwatch + "\n");

		//	Lookup Testing
		 System.out.println("\n\n\n*** Lookup time ***\n");
		 System.out.println("Testing ArrayList lookup speed using getObjectAt() on " + LOOKUP_SIZE + " objects...");
		 stopwatch.start();
		 for (int i = 0; i < LOOKUP_SIZE; i++) {
			 saList.getObjectAt(randGen.nextInt(saList.getSize() - 1));
		 }
		 stopwatch.stop();
		 System.out.println("Test time: " + stopwatch + "\n");

		 System.out.println("Testing LinkedList lookup speed using getObjectAt() on " + LOOKUP_SIZE + " objects...");
		 stopwatch.start();
		 for (int i = 0; i < LOOKUP_SIZE; i++) {
			 slList.getObjectAt(randGen.nextInt(slList.getSize() - 1));
		 }
		 stopwatch.stop();
		 System.out.println("Test time: " + stopwatch + "\n");
	}
}

// Sets.java
//
// A test program for Java's two implementations of sets: HashSet and TreeList.
// At the end of the main method, you can see the simple code for sorting sets.


import java.util.*;


public class Sets {

	public static void main(String[] args) {

		final int LOOP_SIZE = 100000;
		final int DELETE_SIZE = 5000;
		StopWatch stopwatch = new StopWatch();


		// Set construction comparison
		TreeSet<Integer> tSet = new TreeSet<Integer>();
		stopwatch.start();
		for (int i = 0; i < LOOP_SIZE; i++){
			tSet.add(new Integer(i));
		}
		stopwatch.stop();
		System.out.println("TreeSet Construction: " + stopwatch);


		HashSet<Integer> hSet = new HashSet<Integer>();
		stopwatch.start();
		for (int i = 0; i < LOOP_SIZE; i++){
			hSet.add(new Integer(i));
		}
		stopwatch.stop();
		System.out.println("HashSet Construction: " + stopwatch);


		//	Set search comparison
		stopwatch.start();
		for(int i = 0; i < LOOP_SIZE; i++){
			tSet.contains(new Integer(i));
		}
		stopwatch.stop();
		System.out.println("\nTreeSet Search: " + stopwatch);

		stopwatch.start();
		for (int i = 0; i < LOOP_SIZE; i++){
			hSet.contains(new Integer(i));
		}
		stopwatch.stop();
		System.out.println("HashSet Search: " + stopwatch);


		//	Set deletion comparison
		stopwatch.start();
		for(int i = 0; i < DELETE_SIZE; i++){
			tSet.remove(new Integer(i));
		}
		stopwatch.stop();
		System.out.println("\nTreeSet Remove: " + stopwatch);

		stopwatch.start();
		for (int i = 0; i < DELETE_SIZE; i++){
			hSet.remove(new Integer(i));
		}
		stopwatch.stop();
		System.out.println("HashSet Remove: " + stopwatch);


		// Binary trees are implicitly sorted. To traverse the tree
		// in sorted order, you simply get an interator object from the
		// the TreeSet. You then call the next() method of the iterator
		// to move through the tree.
		System.out.println("\nFirst 10 elements of sorted TreeSet");
		Iterator<Integer> myIter = tSet.iterator();
		for (int i = 0; i < 10; i++){
			Integer myInt = (Integer)myIter.next();
			System.out.println(myInt.intValue());
		}



		// To sort the hashset, you first need to extract the values of
		// the set into an array. Use the toArray() method of the HashSet for
		// this purpose
		System.out.println("\nFirst 10 elements of unsorted HashSet");
		Object[] hArray = hSet.toArray();
		for (int i = 0; i < 10; i++){
			Integer myInt = (Integer)hArray[i];
			System.out.println(myInt.intValue());
		}


		// You must then pass the array to the Arrays.sort() utility
		// function in the java.util package.
		System.out.println("\nFirst 10 elements of sorted HashSet");
		Arrays.sort(hArray);
		for (int i = 0; i < 10; i++){
			Integer myInt = (Integer)hArray[i];
			System.out.println(myInt.intValue());
		}
	}
}

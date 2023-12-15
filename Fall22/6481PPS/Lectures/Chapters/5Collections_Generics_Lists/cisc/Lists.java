// Lists.java
//
// A test program for Java's two implementations of lists: ArrayList and LinkedList.
// At the end of the main method, you can see the simple code for sorting lists


import java.util.*;



public class Lists {

	public static void main(String[] args) {

		final int LOOP_SIZE = 100000;
		final int SEARCH_SIZE = 1000;
		StopWatch stopwatch = new StopWatch();


		// List construction comparison
		ArrayList<Integer> aList = new ArrayList<Integer>();
		stopwatch.start();
		for (int i = 0; i < LOOP_SIZE; i++){
			aList.add(new Integer(i));
		}
		stopwatch.stop();
		System.out.println("ArrayList Construction of " + LOOP_SIZE + " elements: " + stopwatch);


		LinkedList<Integer> lList = new LinkedList<Integer>();
		stopwatch.start();
		for (int i = 0; i < LOOP_SIZE; i++){
			lList.add(new Integer(i));
		}
		stopwatch.stop();
		System.out.println("LinkedList Construction of " + LOOP_SIZE + " elements: "  + stopwatch);



		//	List search comparison
		stopwatch.start();
		for (int i = (LOOP_SIZE/2); i < ((LOOP_SIZE/2) + SEARCH_SIZE); i++){
			aList.contains(new Integer(i));
		}
		stopwatch.stop();
		System.out.println("\nArrayList Search of " + SEARCH_SIZE + " elements: "  + stopwatch);

		stopwatch.start();
		for (int i = (LOOP_SIZE/2); i < ((LOOP_SIZE/2) + SEARCH_SIZE); i++){
			lList.contains(new Integer(i));
		}
		stopwatch.stop();
		System.out.println("LinkedList Search of " + SEARCH_SIZE + " elements: " + stopwatch);


		// List Insertion comparison
		stopwatch.start();
		for (int i = (LOOP_SIZE/2); i < ((LOOP_SIZE/2) + SEARCH_SIZE); i++){
			aList.add(i, new Integer(i));
		}
		stopwatch.stop();
		System.out.println("\nArrayList Insertion of " + SEARCH_SIZE + " elements: " + stopwatch);

		stopwatch.start();
		for (int i = (LOOP_SIZE/2); i < ((LOOP_SIZE/2) + SEARCH_SIZE); i++){
			lList.add(i, new Integer(i));
		}
		stopwatch.stop();
		System.out.println("LinkedList Insertion of " + SEARCH_SIZE + " elements: " + stopwatch);



		//	Set deletion comparison
		stopwatch.start();
		int start = aList.size() - 1;
		int stop = aList.size() - SEARCH_SIZE;

		for (int i = start; i > stop; i--){
			aList.remove(i);
		}
		stopwatch.stop();
		System.out.println("\nArrayList Deletion of " + SEARCH_SIZE + " elements (END): " + stopwatch);


		stopwatch.start();
		for (int i = start; i > stop; i--){
			lList.remove(i);
		}
		stopwatch.stop();
		System.out.println("LinkedList Deletion of " + SEARCH_SIZE + " elements (END): " + stopwatch);




		//	Set deletion comparison
		stopwatch.start();
		for (int i = (LOOP_SIZE/2); i < ((LOOP_SIZE/2) + SEARCH_SIZE); i++){
			aList.remove(i);
		}
		stopwatch.stop();
		System.out.println("\nArrayList Deletion of " + SEARCH_SIZE + " elements (Middle: " + stopwatch);

		stopwatch.start();
		for (int i = (LOOP_SIZE/2); i < ((LOOP_SIZE/2) + SEARCH_SIZE); i++){
			lList.remove(i);
		}
		stopwatch.stop();
		System.out.println("LinkedList Deletion of " + SEARCH_SIZE + " elements (Middle): " + stopwatch);


		//	Set deletion comparison
		stopwatch.start();
		for (int i = 0; i < SEARCH_SIZE; i++){
			aList.remove(i);
		}
		stopwatch.stop();
		System.out.println("\nArrayList Deletion of " + SEARCH_SIZE + " elements (START): " + stopwatch);

		stopwatch.start();
		for (int i = 0; i < SEARCH_SIZE; i++){
			lList.remove(i);
		}
		stopwatch.stop();
		System.out.println("LinkedList Deletion of " + SEARCH_SIZE + " elements (START): " + stopwatch);



		// sorting lists. Both lists are sorted simply by passing them to Collections.sort
		// in the java.util package

		stopwatch.start();
		Collections.sort(aList);
		stopwatch.stop();
		System.out.println("\nArrayList sort: " + stopwatch);

		stopwatch.start();
		Collections.sort(lList);
		stopwatch.stop();
		System.out.println("LinkedList sort: " + stopwatch);


		System.out.println("\nFirst 10 elements of sorted Array");
		for (int i = 0; i < 10; i++){
			Integer myInt = (Integer)aList.get(i);
			System.out.println(myInt.intValue());
		}
	}
}

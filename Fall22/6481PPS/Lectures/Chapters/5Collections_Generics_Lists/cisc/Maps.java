// Maps.java
//
// A test program for Java's two implementations of sets: HashMap and TreeMap.
// At the end of the main method, you can see the simple code for sorting sets.


import java.util.*;

public class Maps {

	public static void main(String[] args) {

		Integer myInt;
		final int LOOP_SIZE = 100000;
		final int INSERT_SIZE = 10000;
		final int DELETE_SIZE = 5000;
		StopWatch stopwatch = new StopWatch();


		// Set construction comparison
		HashMap<String,Integer> hMap = new HashMap<String,Integer>();
		stopwatch.start();
		for (int i=0; i < LOOP_SIZE; i++){
			myInt = new Integer(i);
			hMap.put(myInt.toString(), myInt);
		}
		stopwatch.stop();
		System.out.println("HashMap Construction: " + stopwatch);


		TreeMap<String,Integer> tMap = new TreeMap<String,Integer>();
		stopwatch.start();
		for (int i=0; i < LOOP_SIZE; i++) {
			myInt = new Integer(i);
			tMap.put(myInt.toString(), myInt);
		}
		stopwatch.stop();
		System.out.println("TreeMap Construction: " + stopwatch);


		//	Set search comparison
		stopwatch.start();
		for (int i=0; i < LOOP_SIZE; i++) {
			hMap.get("Moose Jaw");
		}
		stopwatch.stop();
		System.out.println("\nHash Map Search: " + stopwatch);

		stopwatch.start();
		for (int i=0; i < LOOP_SIZE; i++) {
			tMap.get("Moose Jaw");
		}
		stopwatch.stop();
		System.out.println("Tree Map Search: " + stopwatch);

		System.out.println("\nSearch for '1': " + hMap.get("1"));
		System.out.println("Search for '111111111': " + tMap.get("111111111"));



		//	Set insertion comparison
		stopwatch.start();
		for (int i=0; i < INSERT_SIZE; i++) {
			myInt = new Integer(i);
			hMap.put(myInt.toString(), myInt);
		}
		stopwatch.stop();
		System.out.println("\nHashMap Insert: " + stopwatch);

		stopwatch.start();
		for (int i=0; i < INSERT_SIZE; i++) {
			myInt = new Integer(i);
			tMap.put(myInt.toString(), myInt);
		}
		stopwatch.stop();
		System.out.println("TreeMap Insert: " + stopwatch);




		// since binary trees are implicitly sorted, we can use an iterator
		// to move through the tree in sorted order. However, remember that
		// we are iterator through the keys of the map, not its value. Use the keySet()
		// method to get the keys and then retrieve its iterator.
		System.out.println("\nFirst 10 keys of sorted TreeMap");
		Set<String> kSet = tMap.keySet();
		Iterator<String> myIter = kSet.iterator();
		for (int i=0; i < 10; i++) {
			System.out.println(tMap.get(myIter.next()));
		}

		// if you want a sorted list of the values themselves, then you
		// should extract the values in a list with the TreeMap's values()
		// method. Then you can just call Collections.sort() on the list
		System.out.println("\nFirst 10 values of sorted TreeMap");
		List<Integer> valueList = new ArrayList<Integer>(tMap.values());
		Collections.sort(valueList);
		for (int i=0; i < 10; i++) {
			System.out.println(valueList.get(i));
		}


		// To sort the values of the HashMap, you must again load its values
		// into a list and sort them with Collections.sort. You can also sort
		// the key just as we did with the TreeMap
		System.out.println("\nFirst 10 elements of sorted Hash Map");
		List<Integer> hashList = new ArrayList<Integer>(hMap.values());
		Collections.sort(hashList);
		for (int i=0; i < 10; i++) {
			myInt = (Integer)hashList.get(i);
			System.out.println(myInt.intValue());
		}
	}
}
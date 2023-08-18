import java.util.Scanner;

public class UseOAHash {

	public static void main(String[] args) {
		System.out.println("Enter a positive value that you want to insert in the hash table; or -1 to terminate:");
		Scanner sc = new Scanner(System.in);
		
		OAHash oAHash = new OAHash();
		
		int userInput = sc.nextInt();
		while(true) {
			oAHash.insert(userInput);
			if(userInput == -1) {
				break;
			}
			userInput = sc.nextInt();
		}
		
		sc.close();
	}

}

class OAHash {
	
	int[] arr;
	int size;
	int noOfEleInTable;
	boolean tableExpandedOnce;
	
	public OAHash() {
		arr = new int[19];
		size = 19;
		noOfEleInTable = 0;
		tableExpandedOnce = false;
	}
	
	public int findHashvalue(int k, boolean rehashing) {
		int hashIndex1= k % size;
		int noOfCollisions = 0;
		if(arr[hashIndex1] == 0) {
			if(!rehashing) {
				System.out.println("Key " + k + " is inserted at index " + hashIndex1);
				System.out.println("Insertion of " + k + " resulted in " + noOfCollisions + " Collisions");
				System.out.println();
			}
			return hashIndex1;
		}
		else {
			if(!rehashing) { System.out.println("Key " + k + " caused collision at index " + hashIndex1); }
			noOfCollisions++;
			int hashIndexIncrement = 13 - (k%13);
			int noOfIncrements = 1;
			int hashIndex2 = (hashIndex1 + (noOfIncrements * hashIndexIncrement))%size;
			while(arr[hashIndex2] != 0) {
				if(!rehashing) { System.out.println("Key " + k + " caused collision at index " + hashIndex2); }
				noOfCollisions++;
				noOfIncrements++;
				hashIndex2 = (hashIndex1 + (noOfIncrements * hashIndexIncrement))%size;
			}
			if(!rehashing) {
				System.out.println("Key " + k + " is inserted at index " + hashIndex2);
				System.out.println("Insertion of " + k + " resulted in " + noOfCollisions + " Collisions");
				System.out.println();
			}
			return hashIndex2;
		}

	}
	
	public void expandTable() {
		int[] tempArr = arr;
		arr = new int[41];
		size = 41;
		for(int i=0; i<tempArr.length; i++) {
			if(tempArr[i] != 0) {
				int k = tempArr[i];
				int hashIndex = findHashvalue(k, true);
				arr[hashIndex] = k;
			}
		}
	}
	
	public void displayAllEle() {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 0) { System.out.print("-1"); }
			else { System.out.print(arr[i]); }
			
			if(i < arr.length-1) { System.out.print(", "); }
			else { System.out.print("."); }
		}
	}
	
	public void insert(int k) {
		if(k == -1) {
			displayAllEle();
		
		}
		else {
			noOfEleInTable++;
			
			if(!tableExpandedOnce && noOfEleInTable >= 0.75 * size) {
				System.out.println();
				System.out.println("Load factor is about to exceed 75%. Expanding table. ");
				System.out.println();
				System.out.println("Contents of table before expansion is as follows: ");
				displayAllEle();
				System.out.println();
				tableExpandedOnce = true;
				expandTable();
			}
			
			int hashIndex = findHashvalue(k, false);
			arr[hashIndex] = k;
		}
		
	}
}

// 102 23 4 55 68 87 42 61 65 3 12 92 125 82 211 33 94 158 35 48 63 -1
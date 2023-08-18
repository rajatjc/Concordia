import java.util.ArrayList;
import java.util.Scanner;

public class Question2 {
	
	// Time Complexity - O(n logn) - looping over the ArrayList starting with index 0 and checking if the corresponding element 
	//				is available or not and if available then inserting it at index+1 and incrementing the index by 2 otherwise by 1
	// Space Complexity - O(1) - only 4 variables are used

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		int userInput = sc.nextInt();
		while(userInput != -1) {
			arr.add(userInput);
			userInput = sc.nextInt();
		}
		int targetVal = sc.nextInt();
		
		int i=0;
		while(i < arr.size()) {
			int reqVal = targetVal - arr.get(i);
			int indexOfReqVal = arr.indexOf(reqVal);
			if(indexOfReqVal != -1 && i+1<arr.size()) {
				arr.remove(indexOfReqVal);
				arr.add(i+1, reqVal);
				i += 2;
			}
			else {
				i += 1;
			}
		}
		
		for(int j=0; j<arr.size(); j++) {
			System.out.println(arr.get(j));
		}
		
		sc.close();
	}

}


/*
163
2
125
7
14
10
18
25
30
40
140
157
-1
150
 */

/*
100
99
97
0
-2
3
102
25
-1
100
*/

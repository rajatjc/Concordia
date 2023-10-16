import java.util.Scanner;

public class FirstEatsSecond {
	
	public static void FirstSecond(int[] arr) {
		int[][] count = new int[arr.length][2];
		int lastIndexOfCount = 0;
		for(int i=0; i<arr.length; i++) {
			
			//find index of element if already exists
			int indexOfExistingEle = 99999;
			for(int j=0; j<count.length; j++) {
				if(count[j][0] == arr[i]) {
					indexOfExistingEle = j;
				}
			}
			
			// if already exists increase count or add new entry
			if(indexOfExistingEle == 99999) {
				count[lastIndexOfCount][0] = arr[i];
				count[lastIndexOfCount][1] = 1;
				lastIndexOfCount++;
			}
			else {
				count[indexOfExistingEle][1] += 1;
			}
		}
		
		//find no of unique values and highest and secondHighest number
		int noOfUniqueVal = 0;
		int highestOccurenceCount = 0;
		int highestOccurenceNumber = 0;
		int secondHighestOccurenceCount = 0;
		int secondHighestoccurenceNumber = 0;
		for(int j=0; j<count.length; j++) {
			if(count[j][1] == 1) {
				noOfUniqueVal += 1;
			}

			if(count[j][1] > highestOccurenceCount) {
				highestOccurenceCount = count[j][1];
				highestOccurenceNumber = count[j][0];
			}
			
		}
		
		for(int j=0; j<count.length; j++) {
			if(count[j][1] < highestOccurenceCount && count[j][1] > secondHighestOccurenceCount) {
				secondHighestOccurenceCount = count[j][1];
				secondHighestoccurenceNumber = count[j][0];
			}
		}
		
		//check if modification is required
		if(noOfUniqueVal == arr.length || noOfUniqueVal == arr.length-1) {
			//No modification required
		}
		else {
			for(int i=0; i<arr.length; i++) {
				if(arr[i] == secondHighestoccurenceNumber) {
					arr[i] = highestOccurenceNumber;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sizeOfArr = sc.nextInt();
		int[] arr = new int[sizeOfArr];
		
		sc.nextLine();
		String[] temp = new String[sizeOfArr];
		temp = sc.nextLine().split(" ");
		for(int i=0; i<sizeOfArr; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		FirstSecond(arr);
		
		String result = "";
		for(int i=0; i<sizeOfArr; i++) {
			
			if(i == sizeOfArr-1) {
				result += Integer.toString(arr[i]);
			}
			else {
				result += Integer.toString(arr[i]);
				result += " ";
			}
		}
		System.out.print(result);
		
		sc.close();
	}

}

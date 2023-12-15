import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(new FileInputStream("Pairs.txt"));
			
			int[] arr = new int[200];
			int targetVal = 231;
			
			int i=0;
			while(sc.hasNextInt()) {
				arr[i] = sc.nextInt();
				i++;
			}
			sc.close();
			
			int leftIndex = 0;
			int rightIndex = i-1;
			
			while(arr[rightIndex] > targetVal) {
				rightIndex -= 1;
			}

			while(leftIndex < rightIndex) {
				int sumVal = arr[leftIndex] + arr[rightIndex];
				if(sumVal > targetVal) {
					rightIndex -= 1;
				}
				else if(sumVal < targetVal) {
					leftIndex +=1;
				}
				else { //found match
					int j=leftIndex;
					int currEle = arr[j];
					int nextEle = arr[j+1];
					while(j<rightIndex) {
						arr[j] = currEle;
						currEle = nextEle;
						nextEle = arr[j+1]; 
						j++;
					}
					arr[j] = currEle;
					arr[leftIndex+1] = targetVal - arr[leftIndex];
					
					leftIndex +=2;
				}
				
			}
			PrintWriter pw = new PrintWriter(new FileOutputStream("Pairs.txt"));
			for(int k=0; k<i; k++) {
				pw.println(arr[k]);
			}
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

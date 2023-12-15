import java.util.Scanner;

public class Question1 {
	
	public static void findLargestSkyway(int[][] arr) {
		int startIndexI = 0;
		int startIndexJ = 0;
		int maxValue = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(i+2<arr.length && j+3<arr.length) {
					int tempMax = arr[i][j] + arr[i+1][j] + arr[i+2][j] 
							+ arr[i+1][j+1] + arr[i+1][j+2] 
							+ arr[i][j+3] + arr[i+1][j+3] + arr[i+2][j+3];
					
					if(tempMax > maxValue) {
						maxValue = tempMax;
						startIndexI = i;
						startIndexJ = j;
					}
					
				}
			}
		}
		
		System.out.println("The largest skyway is " + maxValue + " starting at [" + startIndexI + "][" + startIndexJ + "]");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int sizeOfArr = sc.nextInt();
		int[][] arr = new int[sizeOfArr][sizeOfArr];
		
		for(int i=0; i<sizeOfArr; i++) {
			for(int j=0; j<sizeOfArr; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		findLargestSkyway(arr);
		
		sc.close();
	}

}

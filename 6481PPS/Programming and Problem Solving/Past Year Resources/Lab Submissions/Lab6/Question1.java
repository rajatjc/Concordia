import java.util.Scanner;

public class Question1 {
	
	// Time Complexity - O(n^2)
	// Space Complexity - O(1)

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int noOfRows = sc.nextInt();
		int noOfCols = sc.nextInt();
		int[][] matrix = new int[noOfRows][noOfCols];
		
		for(int i=0; i<noOfRows; i++) {
			for(int j=0; j<noOfCols; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		int maxPossibleTotalIncome = 0;
		for(int i=0; i<noOfRows; i++) {
			for(int j=0; j<noOfCols; j++) {
				if(matrix[i][j] == 0 && (i+1)<noOfRows) {
					maxPossibleTotalIncome -= matrix[i+1][j];
				}
				else {
					maxPossibleTotalIncome += matrix[i][j];
				}
			}
		}
		
		System.out.println("Total Income is: " + maxPossibleTotalIncome);
		
		sc.close();
	}

}

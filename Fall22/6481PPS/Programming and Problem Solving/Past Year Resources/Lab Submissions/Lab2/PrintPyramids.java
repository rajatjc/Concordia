import java.util.Scanner;

public class PrintPyramids {
	
	public static String getNoOfSpChar(int no, String character) {
		String s = "";
		for(int i=0; i<no; i++) {
			s += character;
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int userInput = sc.nextInt();
		
		for(int i=1; i<=userInput; i++) {
			int noOfSpace = 2*(userInput - i);
			int noOfStars = 2*(i-1) + 1;
			System.out.print(getNoOfSpChar(noOfSpace, "-"));
			System.out.print(getNoOfSpChar(noOfStars, "* "));
			System.out.println();
		}
		
		sc.close();
	}

}

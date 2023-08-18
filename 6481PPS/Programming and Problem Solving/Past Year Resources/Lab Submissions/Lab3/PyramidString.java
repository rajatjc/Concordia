import java.util.Scanner;

public class PyramidString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] list = new String[10]; 
		
		boolean isPyramid = true;
		int prevLen = 11;
		for(int i=0; i<n; i++) {
			list[i] = sc.next();
			int currentLen = list[i].length();
			if(isPyramid && currentLen > prevLen) {
				isPyramid = false;
			}
			prevLen = list[i].length();
		}
		
		if(isPyramid) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		sc.close();
	}

}

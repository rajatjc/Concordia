import java.util.Scanner;

public class BackwardCrossOver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int jokerNo = sc.nextInt();
		int sizeOfArr = sc.nextInt();
		int[] arr = new int[sizeOfArr];
		int[] resArr = new int[sizeOfArr];
		
		for(int i=0; i<sizeOfArr; i++) {
			arr[i] = sc.nextInt();
		}
		
		resArr[0] = 0;
		
		for(int i=1; i<sizeOfArr; i++) {
			int sum = 0;
			for(int j=i-1; j>=0; j--) {
				if(arr[i] > arr[j]) {
					sum += (arr[i] - arr[j]);
					if(sum == jokerNo) {
						resArr[i] = 0;
						break;
					}
				}
				else {
					break;
				}
			}
			if(sum == jokerNo) {
				resArr[i]= 0;
			}
			else {
				resArr[i] = sum;
			}
		}
		
		for(int i=0; i<sizeOfArr; i++) {
			System.out.println(resArr[i]);
		}
		
		sc.close();
	}

}

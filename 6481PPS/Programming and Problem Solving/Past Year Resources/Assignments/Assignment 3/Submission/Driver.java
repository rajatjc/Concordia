package Assignment3_Final;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Driver {
	
	private static String getRandomStudentData() {
		String[] data = new String[] {
				"John Henry - 40198765",
				"Sam Philip - 40194387",
				"Ema Mill - 40196963",
				"Catherine Johnathon - 40194837",
				"Andrea Jhonny - 40198274"
		};
		Random rnd = new Random();
		int randomIndex = rnd.nextInt(9)%5;
		return data[randomIndex];
	}
	
	
	public static void main(String[] args) {
		try {
			String filePath = "NASTAFiles/custom_test_file5.txt";
			Scanner sc = new Scanner(new FileInputStream(filePath));
			Path file = Paths.get(filePath);
			int noOfEntries = (int) Files.lines(file).count();
			
			CleverSIDC cleverSIDC = new CleverSIDC(noOfEntries+1);
			while(sc.hasNextLong()) {
				cleverSIDC.add(sc.nextLong(), getRandomStudentData());
			}
			
			System.out.println("\n==========================================================================\n");
			
			int newKey = cleverSIDC.generate();
			cleverSIDC.add(newKey, getRandomStudentData());
			System.out.println("After adding getVal for "+ newKey + " ==> " +cleverSIDC.getValues(newKey)); 
			System.out.println("Prev Key of "+ newKey + " ==> " +cleverSIDC.prevKey(newKey));
			System.out.println("Next Key of "+ newKey + " ==> " +cleverSIDC.nextKey(newKey));
			long[] allKeys = cleverSIDC.allKeys();
			System.out.println("get first 10 keys from " + allKeys.length + " keys ==> ");
			for(int i=0; i<10; i++) {
				System.out.println(String.format("%08d", allKeys[i]));
			}
			cleverSIDC.remove(newKey);
			System.out.println("After removing getVal for "+ newKey + " ==> " +cleverSIDC.getValues(newKey)); 
			
			System.out.println("Enter two keys to find the keys between that range :");
			Scanner scan = new Scanner(System.in);
			int key1 = scan.nextInt();
			int key2 = scan.nextInt();
			long[] rangeKeys = cleverSIDC.rangeKey(key1, key2);	
			System.out.println("rangeKey "+key1+" to "+key2);
			if(rangeKeys!=null) {
				int endIndex;
				if(rangeKeys.length > 10) { endIndex = 10; }
				else { endIndex = rangeKeys.length; }
				System.out.println("Showing first "+endIndex+" keys from " + rangeKeys.length + " keys ==> ");

				for(int i=0; i<endIndex; i++) {
					System.out.println(String.format("%08d", rangeKeys[i]));
				}
			}
			else {
				System.out.println("No keys are present in this range");
			}
			
			scan.close();
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

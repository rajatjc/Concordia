package pod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class POD51 {

	private static String preprocess(String s) {
		s = s.replaceAll("\\!|\\?|\\,|\\;|\\.|\\(|\\[|\\{|\\)|\\}|\\]", " ");
		s = s.trim();  // should be put after all those replace()
		s = s.toLowerCase();
		return s;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num_lang = sc.nextInt();
		sc.nextLine();
		String[] languages = new String[num_lang];
		HashMap<String, String> language = new HashMap<String, String>();
		for(int i=0; i<num_lang; i++) {
			languages = sc.nextLine().split(" ");
			for(int j=1; j<languages.length; j++) {
				language.put(languages[j].toLowerCase() , languages[0]);
			}
		}
		System.out.println();
		while(sc.hasNextLine()) {
			String temp = sc.nextLine();
			if(temp.equals(""))
				continue;
			String[] book = preprocess(temp).split(" ");
			for(int i=0; i<book.length; i++) {
//				book[i] = book[i].toLowerCase();
				if(language.containsKey(book[i])) {
					System.out.println(language.get(book[i]));
					break;
				}
			}
		}
	}

}

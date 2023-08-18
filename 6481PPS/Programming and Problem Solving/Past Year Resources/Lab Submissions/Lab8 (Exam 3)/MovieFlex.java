import java.util.Scanner;

public class MovieFlex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MovieHT mht1 = new MovieHT();
		System.out.println("Add movies to MovieFlex, enter \"DONE!\" to terminate");
		String userInput = sc.nextLine();
		while(!userInput.equals("DONE!")) {
			mht1.insertMovie(userInput);
			userInput = sc.nextLine();
		}
		
		System.out.println("==========");
		mht1.showHashTableContents();
		
		sc.close();
	}

}

class MovieHT {
	
	class MovieList {
		
		class MovieNode {
			String movieName;
			MovieNode next;
			
			public MovieNode(String value, MovieNode next) {
				this.movieName = value;
				this.next = next;
			}
		}
		
		MovieNode head, tail;
		int size;
		
		public MovieList() {
			this.head = null;
			this.tail = null;
			this.size = 0;
		}
		
		public void AddToStart(String value) {
			if(this.head == null) {
				this.head = new MovieNode(value, null);
				this.tail = this.head;
			}
			else {
				this.head = new MovieNode(value, this.head);
			}
			this.size++;
		}
		
		public void AddAtEnd(String value) {
			if(head == null) {
				this.head = new MovieNode(value, this.head);
				this.tail = this.head;
			}
			else {
				this.tail.next = new MovieNode(value, null);
				this.tail = this.tail.next;
			}
			this.size++;
		}
		
		public void displayContents() {
			MovieNode temp = this.head;
			while(temp != null) {
				System.out.print(temp.movieName);
				if(temp.next != null) { System.out.print(","); }
				temp = temp.next;
			}
			System.out.println();
		}
		
		public int size() {
			return this.size;
		}
		
		public boolean contains(String value) {
			MovieNode temp = this.head;
			while(temp != null) {
				if(temp.movieName.equals(value)) {
					return true;
				}
				temp = temp.next;
			}
			return false;
		}
		
	}
	
	MovieList[] movieArr;
	
	public MovieHT() {
		movieArr = new MovieList[13];
	}
	
	public int computeHashValue(String value) {
		int hashVal = 0;
		for(int i=0; i<6; i++) {
			if(i < value.length()) {
				hashVal += ((int) value.charAt(i)) * Math.pow(3, i);
			}
		}
		return hashVal % 13;
	}
	
	public void insertMovie(String value) {
		int hashIndex = computeHashValue(value);
		if(movieArr[hashIndex] == null) {
			MovieList listObj = new MovieList(); 
			listObj.AddToStart(value);
			movieArr[hashIndex] = listObj;
		}
		else {
			MovieList listObj = movieArr[hashIndex];
			if(!listObj.contains(value)) {
				listObj.AddToStart(value);
			}
			else {
				System.out.println("movie already exists");
			}
		}
	}
	
	public void showHashTableContents() {
		System.out.println();
		for(int i=0; i<movieArr.length; i++) {
			System.out.println("index " + i + " has");
			if(movieArr[i] != null && movieArr[i].size() > 0) { 
				movieArr[i].displayContents(); 
				if(movieArr[i].size() == 1) {
					System.out.println("0 collisions");
				}
				else {
					System.out.println(movieArr[i].size() + " collisions");
				}
			}
			else { 
				System.out.println("empty"); 
				System.out.println("0 collisions");
			}
			System.out.println();
		}
	}
}

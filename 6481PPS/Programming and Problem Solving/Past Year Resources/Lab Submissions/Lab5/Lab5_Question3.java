import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Lab5_Question3 {

	public static void display(ObjectInputStream ois) throws IOException {
		try{		
			int s1;
			char s2;
			char s3;
			char s4;
			String s5 = ois.readUTF();

			while(s5 != null) {
				System.out.println(s5);
				s1 = ois.readInt();
				s2 = ois.readChar();
				s3 = ois.readChar();
				s4 = ois.readChar();
				System.out.print(Integer.toString(s1) + Character.toString(s2) + Character.toString(s3) + Character.toString(s4));
				s5 = ois.readUTF();
				
			}
		} catch (EOFException e) {
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mystery.dat"));
			
			display(ois);

		}
		catch (FileNotFoundException e) {
			System.out.println("File Not Found !");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}

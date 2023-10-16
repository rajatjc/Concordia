import java.io.*;
import java.util.Scanner;

public class LineNumberer {
    public static void main(String[] args) {
        Scanner myKeyboard = new Scanner(System.in);

        System.out.print("Enter Input file: ");
        String inputFileName = myKeyboard.next();

        System.out.print("Enter Output file: ");
        String outputFileName = myKeyboard.next();
 
 		FileReader myReader = null;
 		PrintWriter outFile = null;
 		
        try { 
            myReader = new FileReader(inputFileName);
            Scanner inFile = new Scanner(myReader);
     
	        outFile = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName)));
          
            int lineNb = 1;
          
        	while (inFile.hasNextLine()) {
                String line = inFile.nextLine();
                outFile.println("/* "+lineNb+" */ " + line);
                lineNb++;
            }
        	inFile.close();
        } // end try

        catch (IOException exception) { 
            System.out.println("Error with file:" + exception);
        }
        finally {
      		try {
      			if (myReader != null)
      				myReader.close( );
      			if (outFile != null)
      				outFile.close( );      				
      			myKeyboard.close();
      		}
      		catch(IOException e) {
           		System.out.println("Can't seem to close a file...");
        	}
		}
    }
}

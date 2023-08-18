
import java.io.*;

public class BinaryInputDemo
{
  public static void main(String[] args)
  {
  	 ObjectInputStream inputStream = null;
     try
     {
         inputStream = new ObjectInputStream(new FileInputStream("numbers.dat"));
         int n;
         System.out.println("Reading the nonnegative integers");
         System.out.println("in the file numbers.dat.");
         
         n = inputStream.readInt( );
         while (n >= 0)
         {
             System.out.println(n);
             n = inputStream.readInt( );
         }

         System.out.println("End of reading from file.");
     }
     catch(FileNotFoundException e)
     {
         System.out.println("Cannot find file numbers.dat.");
     }
     catch(IOException e)
     {
         System.out.println("Problem with input from file numbers.dat.");
     }
     finally {
     	try {
      		if (inputStream != null)
      		inputStream.close( );
      	}
      	catch(IOException e) {
        	System.out.println("Can't seem to close the file...");
        }
     }
  }
}

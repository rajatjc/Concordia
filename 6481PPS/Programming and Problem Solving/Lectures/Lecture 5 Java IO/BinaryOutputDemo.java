import java.io.*;
import java.util.Scanner;

public class BinaryOutputDemo
{
   public static void main(String[] args)
   {
   	  ObjectOutputStream outputStream = null;
      try
      {
         outputStream = new ObjectOutputStream(
         					new FileOutputStream("numbers.dat"));
         int n;
         Scanner keyboard = new Scanner(System.in);

         System.out.println("Enter nonnegative integers.");
         System.out.println("Place a negative number at the end.");

         do
         {
            n = keyboard.nextInt();
            outputStream.writeInt(n);
         }
         while (n >= 0);
        
         System.out.println("Numbers and sentinel value");
         System.out.println("written to the file numbers.dat.");
      }
      catch(IOException e)
      {
         System.out.println("Problem with output to file numbers.dat.");
      }
      finally {
      	try {
      		if (outputStream != null)
      		outputStream.close( );
      	}
      	catch(IOException e) {
           System.out.println("Can't seem to close the file...");
        }
      }
   }
}
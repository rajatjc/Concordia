
import java.io.*;

public class RedirectionDemo
{
   public static void main(String[] args) throws IOException
   {
      PrintStream errStream =
               new PrintStream(
               			new BufferedOutputStream(
                       		new FileOutputStream("errormessages.txt")));
      System.setErr(errStream);

      System.err.println("Hello from System.err.");
      System.out.println("Hello from System.out.");
      System.err.println("Hello again from System.err.");

      errStream.close( );
   }
}



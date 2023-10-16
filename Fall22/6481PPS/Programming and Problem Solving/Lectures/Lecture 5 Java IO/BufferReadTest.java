// BufferedReadTest.java
//
// A test of the difference between buffered reads and unbuffered reads. The timings are done
// with a StopWatch class that is also provided with the sources files from this class.


import java.io.*;

public class BufferReadTest {

	public static void main ( String[] aArguments ) throws IOException{
    
		File file = new File("BigTextFile.txt");
   
		StopWatch stopwatch = new StopWatch();

		// time the buffered reads 
		stopwatch.start();
		readWithBuffer( file );
		stopwatch.stop();
		System.out.println("With buffering: " + stopwatch);

		// time the unbuffered reads
		stopwatch.start();
		readWithoutBuffer( file );
		stopwatch.stop();
		System.out.println("Without buffering: " + stopwatch);
	}

  
  
 
	static public void readWithBuffer(File aFile) throws IOException{
    
		Reader input = new BufferedReader( new FileReader(aFile) );
		int data = 0;
		while ((data = input.read()) != -1){
			//do nothing
		}
	}

  
	static public void readWithoutBuffer(File aFile) throws IOException{
    
		Reader input = new FileReader( aFile );
		int data = 0;
		while ((data = input.read()) != -1){
			//do nothing
		}
	}
} 

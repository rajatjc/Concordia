// FileInfo.java
//
// The File object can be used to obtain various pieces of information about
// the physical file itself. The example shows some of these methods.
// It also shows how you can rename a file and then perfrom a test to show that
// the original file no longer exists. 
// Remember that the File object exists independent of any disk file. We can 
// create a File object even if a file with that name does not yet exist.

import java.io.*;

class FileTester{
		// a method to get lots of info for a specific file
	public void getInfo(File testFile){
		System.out.println("Absolute path: " + testFile.getAbsolutePath());
		System.out.println("Can read: " + testFile.canRead());
		System.out.println("Can write: " + testFile.canWrite());
		System.out.println("getName: " + testFile.getName());
		System.out.println("getParent: " + testFile.getParent());
		System.out.println("getPath: " + testFile.getPath());
		System.out.println("length: " + testFile.length());
		System.out.println("lastModified: " + testFile.lastModified());
		
		if(testFile.isFile())
			System.out.println("It's a file");
		else if(testFile.isDirectory())
			System.out.println("It's a directory");
			
		System.out.println();
	}
}

public class FileInfo {
    public static void main(String[] args) {
  	File testFile, oldFile;  	
  	FileTester myTester = new FileTester();  	
  	testFile = new File("stuff.txt");
  	
  	if (testFile.exists() )
		System.out.println("stuff.txt exists");
  	else
		System.out.println("stuff.txt doesn't exist");
	
  	myTester.getInfo(testFile);
  	
	oldFile = new File("copy.txt");
	myTester.getInfo(oldFile);
  	
	oldFile.renameTo( new File("copy2.txt") );
	myTester.getInfo(oldFile);

	// check to see if original file exists after renaming
	File orgFile = new File("copy.txt"); 
	if (orgFile.exists()) 
		System.out.println("copy.txt still exists");
	else
		System.out.println("copy.txt is gone");
	}
}
// SuperWords.java
//
// Another simple example of inheritance. This time the child class
// calls the constructor of its parent before invoking its own
// constructor code.

public class SuperWords 
{
	public static void main(String[] args) 
	{
	    SuperDictionary webster = new SuperDictionary(1500, 52500);
		
	    System.out.println ("Number of pages: " + webster.getPages());
	    System.out.println ("Number of definitions: " +	webster.getDefinitions());
	    System.out.println ("Definitions per page: " + webster.computeRatio());
	}
}



// base class
class SuperBook
{
   private int pages;
   
   public SuperBook (int numPages)
   {
	  pages = numPages;
   }
   
   public void setPages (int numPages)
   {
	  pages = numPages;
   }

   public int getPages ()
   {
	  return pages;
   }
   
}


// child class - use functionality in base class constructor
class SuperDictionary extends SuperBook 
{
   private int definitions;

   public SuperDictionary (int numPages, int numDefinitions)
   {
   	  // call the superBook constructor first
	 super(numPages);
	 definitions = numDefinitions;
   }

   public double computeRatio ()
   {
	  return definitions/getPages();
   }
   
   public void setDefinitions (int numDefinitions)
   {
	  definitions = numDefinitions;
   }

   public int getDefinitions ()
   {
	  return definitions;
   }
}

public class BankTest {

    public static void main(String [] args) throws Exception{
	    try {
	        throw new RuntimeException();
	    }
	    catch (RuntimeException e) {
	        System.out.println ("1st catch");
	        throw e;
	    }
	    	    catch (Exception e) {
	        System.out.println ("2nd catch");
	        throw e;
	    }

    }
}

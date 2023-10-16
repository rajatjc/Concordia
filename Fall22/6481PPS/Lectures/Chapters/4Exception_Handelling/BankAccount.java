/** BankAccount represents a bank account */



public class BankAccount 
{
 
    public static boolean transactions_available = true;

     private double balance; // the account balance
    
     private double threshold; // the overdraft limit / minimum balance
 
   
    
     /** constructs a new, empty account */
    
     public BankAccount () 
     { 
  
	    balance = 0;

	    threshold = 0;

     }


    
 /** constructs an account with the provided balance */

     public BankAccount (double initialBalance)
     {
   
	    balance = initialBalance;

	    threshold = 0;

     }
   
 
    
     /** adds the indicated amount to this account
 
     * @throws UnavailableTransactionException at certain specified times, check the operating guide  */
   
 
     public void deposit (double amount) throws UnavailableTransactionException 
     {  
	   
        if (transactions_available)
        {

	        double newBalance = balance + amount;

	        balance = newBalance;

	}
        else 
        {
        // throw UnavailableTransactionException

	        throw new UnavailableTransactionException ("deposits not available at this time");

	}

      }
 
   
    /** withdraws the indicated amount from this account. Use getBalance first before
 
       * withdrawing funds

        * @throws InsufficientFundsException when there are insufficient funds for the transaction
 
        */

      public void withdraw (double amount)
     {
   
	    double newBalance = balance - amount;

	    if (newBalance >= threshold)
            {

	        balance = newBalance;
    
	    } 
            else
            {

	        String message = "Check balance beforehand: balance = " + this.getBalance () + 
	
              " amount requested: " + amount;

	        throw new InsufficientFundsException (message);

	    }

     }
 

   
    /** provides this account's current balance */

       public double getBalance ()
       { 
 
	    return balance; 
   
    }


    
    /** updates the minumum balance - a negative value is overdraft*/

       public void setMinimumBalance (double minBalance)
       {

	    threshold = minBalance;

       }


}





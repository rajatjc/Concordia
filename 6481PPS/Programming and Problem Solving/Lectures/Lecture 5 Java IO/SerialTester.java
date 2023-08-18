import java.io.*;
 
public class SerialTester {
   public static void main(String[] args) throws IOException, ClassNotFoundException
   {     
       Bank myBank;
 
       File f = new File("bank.dat");
 
 		if (f.exists()) 
 		{
  			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));

	    	myBank = (Bank) in.readObject(); 
    		in.close();
 		}
 		else 
 		{
    		myBank = new Bank();
    		myBank.addAccount(new BankAccount(1001, 20000)); 
    		myBank.addAccount(new BankAccount(1015, 10000));
 		}

   		 // Deposit some money
    	BankAccount a = myBank.find(1001);
    	a.deposit(100);
    	System.out.println(a.getAccountNumber() + ":" + a.getBalance());
    	a = myBank.find(1015);
    	System.out.println(a.getAccountNumber() + ":" + a.getBalance());
    	ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
    
    	out.writeObject(myBank);
        	out.close();
    }
 } 

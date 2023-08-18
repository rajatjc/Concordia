class SavingsAccount extends BankAccount {
    private static double interestRate;

    /** constructor */
    public SavingsAccount(String name,  double balance) {
		super(name, balance);
    }
    /** constructor */
    public SavingsAccount(String name) {
		super(name);
    }

    /** get interest */
    public double getInterest() {
		return balance*interestRate;
    }

    public static double getInterestRate() {
		return interestRate;
    }

    public static void setInterestRate(double newInterestRate) {
		interestRate = newInterestRate;
    }

    public String toString() {
		return super.toString() + "\nInterest Rate : " + interestRate + "\n";
    }
}

class CheckingAccount extends BankAccount {
	final int CHARGE = 5;
	final int NO_CHARGE = 0;

    /** if you get interest from your checking account, you have to pay monthly
    charge */
    private boolean hasInterest;

    /** constructor */
    public CheckingAccount(String name, double balance, boolean hasInterest) {
		super(name, balance);
		this.hasInterest = hasInterest;
    }

    /** constructor */
    public CheckingAccount(String name, boolean hasInterest) {
		this(name,0,hasInterest);
    }

    /** get monthly charge */
    public int getMonthlyCharge() {
		if (hasInterest) {
		    return CHARGE;
		} else {
	 	   return NO_CHARGE;
		}
    }

    public String toString() {
		String newLine;
		if (hasInterest) {
	    	newLine = "This account has interest.";
		} else {
	    	newLine = "This account does not have interest.";
		}
		return super.toString() + "\n" + newLine;
    }

}

class BankAccount {
    protected double balance; // current amount of money you save in the bank account
    protected String name; // your name

    /** constructor */
    public BankAccount(String name, double balance) {
		this.name = name;
		this.balance = balance;
    }

    /** constructor */
    public BankAccount(String name) {
		this(name,0);
    }

    /** deposit money into the account */
    public void deposit(double depositAmount) {
		if (depositAmount >= 0) {  // depositAmount must be positive
		    balance+= depositAmount;
		}
    }

    /** withdraw money from the account */
    public void withdraw(double withdrawAmount) {
	/* If the withdrawAmount is negative or
	   there is not enough balance for withdraw
	   do nothing */
		if (withdrawAmount >= 0 && withdrawAmount <= balance) {
	    	balance-= withdrawAmount;
		}
    }

    /** return balance */
    public double getbalance() {
		return balance;
    }

    /** return name */
    public String getName() {
		return name;
    }

    public String toString() {
		return "Name: " + name + "\n" + "balance: " + balance ;
    }
}


public class Bank {

	public static void main(String[] args) {
		SavingsAccount ginaAccount = new SavingsAccount("Gina Lollobrigida", 5000);

		System.out.print(ginaAccount);
	}
}

import java.io.*;
import java.util.ArrayList;
 
 /**
    This bank contains a collection of bank accounts.
 */
 public class Bank implements Serializable
 {   
    /**
       Constructs a bank with no bank accounts.
    */
    public Bank()
    {
       accounts = new BankAccount[MAX_NB_ACCOUNTS]; 
    }
 
    /**
       Adds an account to this bank.
       @param a the account to add
    */
    public void addAccount(BankAccount a)
    {
       if (actualNbAccounts == accounts.length) // no more space in the array
       {
        System.out.print("No more space in the array");
        System.exit(0);
       }
       accounts[actualNbAccounts++] = a;
    }
    
    /**
       Gets the sum of the balances of all accounts in this bank.
       @return the sum of the balances
    */
    public double getTotalBalance()
    {
       double total = 0;
       for (BankAccount a : accounts)
       {
          total = total + a.getBalance();
       }
       return total;
    }
 
    /**
       Counts the number of bank accounts whose balance is at
       least a given value.
       @param atLeast the balance required to count an account
       @return the number of accounts having least the given balance
    */
    public int count(double atLeast)
    {
       int matches = 0;
       for (BankAccount a : accounts)
       {
          if (a.getBalance() >= atLeast) 
            matches++; // Found a match
       }
       return matches;
    }
 
    /**
       Finds a bank account with a given number.
       @param accountNumber the number to find
       @return the account with the given number, or null if there
       is no such account
    */
    public BankAccount find(int accountNumber)
    {
       for (BankAccount a : accounts)
       {
          if (a.getAccountNumber() == accountNumber) // Found a match
             return a;
       } 
       return null; // No match in the entire array list
    }
 
    /**
       Gets the bank account with the largest balance.
       @return the account with the largest balance, or null if the
       bank has no accounts
    */
    public BankAccount getMaximum()
    {
       if (accounts.length == 0) 
        return null;
       
       BankAccount largestYet = accounts[0];
       for (int i = 1; i < accounts.length; i++) 
       {
          BankAccount a = accounts[i];
          if (a.getBalance() > largestYet.getBalance())
             largestYet = a;
       }
       return largestYet;
    }
 
    private BankAccount[] accounts;
    private static int MAX_NB_ACCOUNTS = 10; // the maximum number of accounts
    private int actualNbAccounts = 0;
 }

 /**
    A bank account has a balance that can be changed by 
    deposits and withdrawals.
 */
  class BankAccount implements Serializable
 {  
    /**
       Constructs a bank account with a zero balance
       @param anAccountNumber the account number for this account
    */
    public BankAccount(int anAccountNumber)
    {   
       accountNumber = anAccountNumber;
       balance = 0;
    }
 
    /**
       Constructs a bank account with a given balance
       @param anAccountNumber the account number for this account
       @param initialBalance the initial balance
    */
    public BankAccount(int anAccountNumber, double initialBalance)
    {   
       accountNumber = anAccountNumber;
       balance = initialBalance;
    }
 
    /**
       Gets the account number of this bank account.
       @return the account number
    */
    public int getAccountNumber()
    {   
       return accountNumber;
    }
 
    /**
       Deposits money into the bank account.
       @param amount the amount to deposit
    */
    public void deposit(double amount)
    {  
       double newBalance = balance + amount;
       balance = newBalance;
    }
 
    /**
       Withdraws money from the bank account.
       @param amount the amount to withdraw
    */
    public void withdraw(double amount)
    {   
       double newBalance = balance - amount;
       balance = newBalance;
    }
 
    /**
       Gets the current balance of the bank account.
       @return the current balance
    */
    public double getBalance()
    {   
       return balance;
    }
 
    private int accountNumber;
    private double balance;
}
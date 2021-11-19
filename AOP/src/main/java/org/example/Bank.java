package org.example;

// Target
public class Bank {
    int balance = 10000;
    public void Deposit(int x)
    {
      //  System.out.println("Security Check"); // cross cutting concerns
        balance = balance + x;  // busines logic
       // System.out.println("Transaction Completed");

    }
    public void withdraw(int y)
    {
        //System.out.println("Security Check");
        balance = balance - y;
        //System.out.println("Transaction Completed");  //cross cutting code
    }
    public void welcome()
    {
        System.out.println("Welcome to Royal Bank");
    }
    public int showBalance()
    {
        return balance;
    }
}

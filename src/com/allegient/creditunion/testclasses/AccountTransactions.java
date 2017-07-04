/**
 * 
 */
package com.allegient.creditunion.testclasses;

import java.io.File;

import com.allegient.creditunion.Account;
import com.allegient.creditunion.AccountType;
import com.allegient.creditunion.ConsumerAccount;
import com.allegient.creditunion.CreditUnion;
import com.allegient.creditunion.Customer;
import com.allegient.creditunion.exceptions.CustomerAccountDoesNotExistException;
import com.allegient.creditunion.exceptions.ExceededWithdrawalLimitException;
import com.allegient.creditunion.exceptions.LowBalanceException;

/**
 * @author Manav
 *
 */
public class AccountTransactions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			File accountsFile = new File("src/com/allegient/creditunion/Accounts.txt");
			
			// Initialize the app with some data to be processed upon
			CreditUnion cUnion = InitiateSystem.appInit(accountsFile);
			System.out.println("********  WELCOME TO " + cUnion.getName() +" ***********");
			
			/**
			 * Initiate a withdraw transaction
			 */
			
			// Find the account from the list of accounts
			Account withdrawAcc = null;
			Account depositAcc = null;
			Customer c1 = new Customer("Aleks", "Kivuls");
			Customer c2 = new Customer("Ingmar", "Jakob");
			// Customer c = new Customer("Todd", "Ebert");
			// Customer c = new Customer("Cherry", "Woo");
			// Customer c = new Customer("Neal", "Terrell");
			
			for (Account a : cUnion.getListOfAccounts()) {
				//System.out.println(a.toString());
				if (a.getAccountOwner().getFirstName().equalsIgnoreCase(c1.getFirstName()) &&
						a.getAccountOwner().getLastName().equalsIgnoreCase(c1.getLastName())) {
					withdrawAcc = a;
				} else if (a.getAccountOwner().getFirstName().equalsIgnoreCase(c2.getFirstName()) &&
						a.getAccountOwner().getLastName().equalsIgnoreCase(c2.getLastName())) {
					depositAcc = a;
				}
				
				if (withdrawAcc != null && depositAcc != null) {
					break;
				}
			}
			
			if (withdrawAcc == null) {
				throw new CustomerAccountDoesNotExistException("No customer Account Exists");
			}
			
			// Display account details(balance and owner) here
			System.out.println("\n<<<<    Account Details    >>>>");
			System.out.println("First Name\t : " + withdrawAcc.getAccountOwner().getFirstName());
			System.out.println("Last Name\t : " + withdrawAcc.getAccountOwner().getLastName());
			System.out.println("Balance\t\t : " + "$" + withdrawAcc.getBalance());
			
			
			// Call the withdraw method
			// Withdrawing amount from the bank accout of customer c1
			try {
				System.out.println("Withdrawing an amount of $50 from this account");
				withdraw(50, withdrawAcc);
				System.out.println("Amount withdrawn successfully : Remaining balance : $" + withdrawAcc.getBalance());
			} catch (LowBalanceException lbex) {
				
			} catch (ExceededWithdrawalLimitException excdWithExc) {
				
			}
			
			try {
				System.out.println("Withdrawing an amount of $800 from this account");
				withdraw(800, withdrawAcc);		
				System.out.println("Amount withdrawn successfully : Remaining balance : $" + withdrawAcc.getBalance());
			} catch (LowBalanceException lbex) {
				
			} catch (ExceededWithdrawalLimitException excdWithExc) {
				
			}
			
			
			// Account details after withdrawing
			System.out.println("\n<<<<    Account Details    >>>>");
			System.out.println("First Name\t : " + withdrawAcc.getAccountOwner().getFirstName());
			System.out.println("Last Name\t : " + withdrawAcc.getAccountOwner().getLastName());
			System.out.println("Balance\t\t : " + "$" + withdrawAcc.getBalance());
			
			
			
			/**
			 * Initiate a deposit transaction
			 */
			
			// Display account details(balance and owner) here
			System.out.println("\n<<<<    Account Details    >>>>");
			System.out.println("First Name\t : " + depositAcc.getAccountOwner().getFirstName());
			System.out.println("Last Name\t : " + depositAcc.getAccountOwner().getLastName());
			System.out.println("Balance\t\t : " + "$" + depositAcc.getBalance());
			
			// Call the deposit method
			deposit(50, depositAcc);
			
			// Display account details(balance and owner) here
			System.out.println("\n<<<<    Account Details    >>>>");
			System.out.println("First Name\t : " + depositAcc.getAccountOwner().getFirstName());
			System.out.println("Last Name\t : " + depositAcc.getAccountOwner().getLastName());
			System.out.println("Balance\t\t : " + "$" + depositAcc.getBalance());
			
			/**
			 * Initiate a Transfer transaction
			 */
			
			// Display account details(balance and owner) here
			
			// Call the transfer method
			transfer(withdrawAcc, depositAcc, 100);
			
			// Display account details(balance and owner) here
		} catch (Exception e) {
			
		}

	}
	
	public static void withdraw(int amount, Account acc) {
		if (acc.getAccountType().equals(AccountType.MONEY_MARKET) && acc.toString().equalsIgnoreCase("consumer") && 
				amount > ConsumerAccount.WITHDRAWAL_LIMIT) {
			throw new ExceededWithdrawalLimitException("The amount being withdrawn exceeds the withdraw limit for this account"
					+ "which is $" + ConsumerAccount.WITHDRAWAL_LIMIT);
		} else if (amount > acc.getBalance()){ 
			throw new LowBalanceException("The account does not contain sufficient funds");
		} else {
			synchronized (acc) {
				acc.setBalance(acc.getBalance() - amount);
			}
		}
	}
	
	public static void deposit(int amount, Account acc) {
		synchronized(acc) {
			acc.setBalance(acc.getBalance() + amount);
		}
		
	}
	
	/**
	 * Transfer an amount {amount}
	 * From account : from 
	 * To Account : to
	 * Amount transfer is basically withdraw -> deposit
	 * 
	 * @param from
	 * @param to
	 * @param amount
	 */
	public static void transfer(Account from, Account to, int amount) {
		
		try {
			withdraw(amount, from);
			deposit(amount, to);
		} catch (Exception ex) {
			// Code to revert withdraw and deposit
		}
		
	}

}

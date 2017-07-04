/**
 * 
 */
package com.allegient.creditunion;

/**
 * @author Manav
 *
 */
public class Account {

	// A number to identify a unique account. This is like a primary key for this account
	private long accountNumber;
	private Customer accountOwner;
	private long balance;
	private AccountType accountType;

	/**
	 * @return the accountNumber
	 */
	public long getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the accountOwner
	 */
	public Customer getAccountOwner() {
		return accountOwner;
	}

	/**
	 * @param accountOwner
	 *            the accountOwner to set
	 */
	public void setAccountOwner(Customer accountOwner) {
		this.accountOwner = accountOwner;
	}

	/**
	 * @return the balance
	 */
	public long getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(long balance) {
		this.balance = balance;
	}

	/**
	 * @return the accountType
	 */
	public AccountType getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType
	 *            the accountType to set
	 */
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

}

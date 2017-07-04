/**
 * 
 */
package com.allegient.creditunion;

/**
 * @author Manav
 *
 */
public class ConsumerAccount extends Account {
	
	public static final int WITHDRAWAL_LIMIT = 750;
	
	public ConsumerAccount() {
		super();
		this.setAccountType(AccountType.MONEY_MARKET);
	}
	
	@Override
	public String toString() {
		return "Consumer";
	}
}

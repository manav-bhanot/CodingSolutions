/**
 * 
 */
package com.allegient.creditunion;

/**
 * @author Manav
 *
 */
public class CommercialAccount extends Account {
	
	public CommercialAccount() {
		super();
		this.setAccountType(AccountType.MONEY_MARKET);
	}
	
	@Override
	public String toString() {
		return "Commercial";
	}

}

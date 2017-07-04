/**
 * 
 */
package com.allegient.creditunion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Manav
 *
 */
public class CreditUnion {

	private String name;
	private List<Account> listOfAccounts;

	/**
	 * 
	 */
	public CreditUnion() {
		super();
		this.listOfAccounts = new ArrayList<Account>();
	}

	/**
	 * 
	 */
	public CreditUnion(String name) {
		this();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the listOfAccounts
	 */
	public List<Account> getListOfAccounts() {
		return listOfAccounts;
	}

	/**
	 * @param listOfAccounts
	 *            the listOfAccounts to set
	 */
	public void setListOfAccounts(List<Account> listOfAccounts) {
		this.listOfAccounts = listOfAccounts;
	}

}

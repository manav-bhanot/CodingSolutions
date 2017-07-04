/**
 * 
 */
package com.allegient.creditunion;

/**
 * @author Manav
 *
 */
public class Customer {
	
	// Primary key for the customer
	long customerId;
	private String firstName;
	private String lastName;

	public Customer() {
		super();
	}

	/**
	 * 
	 * @param fName
	 * @param lName
	 */
	public Customer(String fName, String lName) {
		this.firstName = fName;
		this.lastName = lName;
	}

	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}

/**
 * 
 */
package com.allegient.creditunion.testclasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.allegient.creditunion.Account;
import com.allegient.creditunion.CommercialAccount;
import com.allegient.creditunion.ConsumerAccount;
import com.allegient.creditunion.CreditUnion;
import com.allegient.creditunion.Customer;

/**
 * @author Manav
 *
 */
public class InitiateSystem {
	
	public static CreditUnion appInit(File accountsFile) {
		
		CreditUnion creditUnion = new CreditUnion();
		creditUnion.setName("American Credit Union");
		try {
			Scanner scan = new Scanner(accountsFile);
			
			while (scan.hasNextLine()) {
				
				Account acc = null;
				
				String firstName = scan.next().trim();
				String lastName = scan.next().trim();
				String accountType = scan.next().trim();
				long balance = scan.nextInt();
				
				if (accountType.equalsIgnoreCase("consumer")) {
					acc = new ConsumerAccount();
				} else if (accountType.equalsIgnoreCase("commercial")) {
					acc = new CommercialAccount();
				} else {
					// Creates a CD account
					// currently no user scenario available for this
				}
				
				Customer cust = new Customer(firstName, lastName);
				acc.setAccountOwner(cust);
				acc.setBalance(balance);
				
				creditUnion.getListOfAccounts().add(acc);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return creditUnion;
	}

}

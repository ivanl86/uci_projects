package labs.lab3;

import java.util.ArrayList;

/**
 * Represents Robert's pet store
 */
public class PetStore {
	// ADD YOUR INSTANCE VARIABLES EHRE
	private ArrayList<Customer> customers;
	
	/**
	 * Constructor that creates this PetStore
	 */
	public PetStore() {
		// FILL IN
		customers = new ArrayList<Customer>();
	}
	
	
	/**
	 * Adds a new Customer to the PetStore
	 * 
	 * @param c	new customer
	 */
	public void addCustomer(Customer c) {
		// FILL IN
		customers.add(c);
	}
	
	
	/**
	 * Returns the name of the Customer who has spent the most money. If there 
	 * are no customers, retursn the empty string. If there is more than one
	 * "best customer," returns any one of them.
	 * 
	 * @return	the best customer in the store
	 */
	public String getNameOfBestCustomer() {
		String bestCustomer = "";
		double mostMoneySpent = 0;
		if (customers.size() < 1) {
			return bestCustomer;
		} else {
			for (int i = 0; i < customers.size(); ++i) {
				if (customers.get(i).getAmountSpent() > mostMoneySpent) {
					bestCustomer = customers.get(i).getName();
					mostMoneySpent = customers.get(i).getAmountSpent();
				}
			}
			return bestCustomer; // FIX ME
		}
	}
}
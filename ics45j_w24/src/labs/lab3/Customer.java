package labs.lab3;

/**
 * Represents a customer in Robert's pet store
 */
public class Customer {
	
	// ADD YOUR INSTANCE VARIABLES HERE
	private String name;
	private double amountSpent;
	
	/**
	 * Constructor that creates this Customer
	 * 
	 * @param name	name of customer
	 */
	public Customer(String name) {
		// FILL IN
		this.name = name;
		amountSpent = 0;
	}
	
	
	/**
	 * @return	name of customer
	 */
	public String getName() {
		return name; // FIX ME
	}
	
	
	/**
	 * @return	amount the customer has spent
	 */
	public double getAmountSpent() {
		return amountSpent; // FIX ME
	}
	
	
	/**
	 * Adds an amount to the customer's amount spent
	 * 
	 * @param amount	amount to add
	 */
	public void addSale(double amount) {
		// FILL IN
		amountSpent += amount;
	}
}
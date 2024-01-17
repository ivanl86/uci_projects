package labs.lab2;

/**
 * A cash register totals up sales and computes change due.
 */
public class CashRegister {

	public static final double QUARTER_VALUE = 0.25;
	public static final double DIME_VALUE = 0.10;
	public static final double NICKEL_VALUE = 0.05;
	public static final double PENNY_VALUE = 0.01;

	private double purchase;
	private double payment;

	/**
	 * Constructs a cash register with no money in it.
	 */
	public CashRegister() {
		purchase = 0;
		payment = 0;
	}


	/**
	 * Records the sale of an item.
	 * 
	 * @param amount the price of the item
	 */
	public void recordPurchase(double amount) {
		purchase = purchase + amount;
	}


	/**
	 * Receives a payment of dollars from the customer.
	 * 
	 * @param amount the number of dollars received for the payment
	 */
	public void enterDollars(int amount) {
		// FILL IN
		payment += amount;
	}


	/**
	 * Receives a payment of quarters from the customer.
	 * 
	 * @param amount the number of quarters received for the payment
	 */
	public void enterQuarters(int amount) {
		// FILL IN
		payment += amount * QUARTER_VALUE;
	}


	/**
	 * Receives a payment of dimes from the customer.
	 * 
	 * @param amount the number of dimes received for the payment
	 */
	public void enterDimes(int amount) {
		// FILL IN
		payment += amount * DIME_VALUE;
	}


	/**
	 * Receives a payment of nickels from the customer.
	 * 
	 * @param amount the number of nickels received for the payment
	 */
	public void enterNickels(int amount) {
		// FILL IN
		payment += amount * NICKEL_VALUE;
	}


	/**
	 * Receives a payment of pennies from the customer.
	 * 
	 * @param amount the number of pennies received for the payment
	 */
	public void enterPennies(int amount) {
		// FILL IN
		payment += amount * PENNY_VALUE;
	}


	/**
	 * Computes the change due and resets the machine for the next customer.
	 * 
	 * @return the change due to the customer; if the payment is < the purchase
	 * amount, the method returns -1 and the machine is not reset
	 */
	public double giveChange() {
		double change = payment - purchase;
		if (change >= 0) {
			purchase = 0;
			payment = 0;
			return change;
		}
		else {
			return -1;
		}
	}
}
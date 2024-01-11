package labs.lab1;

/**
 * A savings account has a balance that can be changed by deposits and
 * withdrawals.
 */
public class SavingsAccount {

	// ADD YOUR INSTANCE VARIABLES HERE
	private double balance;
	private double interestRate;

	/**
	 * Constructs a savings account with a given balance
	 * 
	 * @param initialBalance the initial balance
	 * @param rate           the interest rate in percent
	 */
	public SavingsAccount(double initialBalance, double rate) {
		// FILL IN
		balance = initialBalance;
		interestRate = rate / 100;
	}


	/**
	 * Deposits money into the savings account.
	 * 
	 * @param amount the amount to deposit
	 */
	public void deposit(double amount) {
		// FILL IN
		balance += amount;
	}


	/**
	 * Withdraws money from the savings account,
	 * as long as the withdrawal would not result
	 * in a negative balance
	 * 
	 * @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {
		// FILL IN
		if (amount <= balance)
			balance -= amount;
	}


	/**
	 * Gets the current balance of the savings account.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return balance; // FIX ME
	}


	/**
	 * Adds interest to the savings account.
	 */
	public void addInterest() {
		// FILL IN
		balance += balance * interestRate;
	}

}
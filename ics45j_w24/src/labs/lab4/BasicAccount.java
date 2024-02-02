package labs.lab4;

/**
 * Implement a subclass of BankAccount called BasicAccount whose withdraw method
 * charges a penalty of $30 for each withdrawal that results in an overdraft.
 */
public class BasicAccount extends BankAccount {

	/**
	 * Constructs a bank account with a given balance.
	 * 
	 * @param initialBalance the initial balance
	 */
	public BasicAccount(double initialBalance) {
		super(initialBalance);
	}

	/**
	 * Charges a penalty of $30 for each withdrawal that results in an overdraft.
	 * 
	 * @param amount the amount to be withdrawn
	 */
	@Override
	public void withdraw(double amount) {
		// FILL IN
		final double PENALTY = 30.0;
		super.withdraw(super.getBalance() >= amount ? amount : amount + PENALTY);
	}
}

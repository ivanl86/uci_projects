package labs.lab1;

/**
 * A bank account has a balance that can be changed by deposits and withdrawals.
 */
public class BankAccount {
	// ADD YOUR INSTANCE VARIABLES HERE
	private double currentBalance;
	private int totalFreeTransactions;
	private int totalTransactions;
	private double transactionFee;
	/**
	 * Constructs a bank account with a zero balance.
	 * 
	 * @param free number of free transactions
	 */
	public BankAccount(int free) {
		// FILL IN
		totalFreeTransactions = free;
		totalTransactions = 0;
	}

	/**
	 * Constructs a bank account with a given balance.
	 * 
	 * @param initialBalance the initial balance
	 * @param free           number of free transactions
	 */
	public BankAccount(double initialBalance, int free) {
		// FILL IN
		currentBalance = initialBalance;
		totalFreeTransactions = free;
		totalTransactions = 0;
	}

	/**
	 * Deposits money into the bank account.
	 * 
	 * @param amount the amount to deposit
	 */
	public void deposit(double amount) {
		// FILL IN
		currentBalance += amount;
		++totalTransactions;
	}

	/**
	 * Withdraws money from the bank account.
	 * 
	 * @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {
		// FILL IN
		currentBalance -= amount;
		++totalTransactions;
	}

	/**
	 * Gets the current balance of the bank account.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return currentBalance; // FIX ME
	}

	/**
	 * Sets the transaction fee.
	 * 
	 * @param fee new transaction fee
	 */
	public void setTransactionFee(double fee) {
		// FILL IN
		transactionFee = fee;
	}

	/**
	 * Applies monthly transaction charge.
	 */
	public void deductMonthlyCharge() {
		// FILL IN
		if (totalTransactions > totalFreeTransactions)
			currentBalance -= (totalTransactions - totalFreeTransactions) * transactionFee;
		totalTransactions = 0;
	}
}

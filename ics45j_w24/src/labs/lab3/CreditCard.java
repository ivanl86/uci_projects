package labs.lab3;

import java.time.LocalDate;

/**
 * Represents a credit card
 *
 */
public class CreditCard {

	// ADD YOUR INSTANCE VARIABLES HERE
	private long number;
	private LocalDate expDate;
	
	/**
	 * Constructs a credit card object with the given number and expiration
	 * date
	 * 
	 * Assume the number passed in will always have 16 digits and will not
	 * start with 0. 
	 * 
	 * Assume the date passed in will always be a valid date.
	 * 
	 * @param number	the credit card number
	 * @param expDate	the credit card expiration date
	 */
	public CreditCard(long number, LocalDate expDate) {
		// FILL IN
		this.number = number;
		this.expDate = expDate;
	}


	/**
	 * Returns the credit card number
	 * 
	 * @return	the credit card number
	 */
	public long getNumber() {
		return number; // FIX ME
	}


	/**
	 * Returns the credit card expiration date
	 * 
	 * @return	the credit card expiration date
	 */
	public LocalDate getExpirationDate() {
		return expDate; // FIX ME
	}
	
	
	/**
	 * Returns a string containing the card number, with a space inserted
	 * between every 4 digits
	 * 
	 * @return	the card number, with a space inserted between every 4 digits
	 */
	public String getNumberWithSpaces() {
		final int EVERY_FOUR_DIGIT = 4;
		long temp = number;
		String numberString = "";
		
		while (temp > 0) {
			for (int i = 0; i < EVERY_FOUR_DIGIT; ++i) {
				numberString = temp % 10 + numberString;
				temp /= 10;
			}

			if (temp > 0) {
				numberString = " " + numberString;
			}
		}
		return numberString; // FIX ME
	}


	/**
	 * Returns true if both the card number and expiration date are valid,
	 * false otherwise
	 * 
	 * @return	whether card is valid
	 */
	public boolean isValid() {
		boolean isValidNumber = false;
		boolean isValidDate = false;
		int sum = 0;
		int sumOfNumber = 0;
		int sumOfEvenDigit = 0;
		int greaterThanFive = 0;
		long temp = number;
		
		while (temp > 0) {
			sumOfNumber += temp % 10;
			temp /= 10;
		}
		
		temp = number;
		while (temp > 0) {
			sumOfEvenDigit += temp % 10;
			if (temp % 10 > 5) {
				++greaterThanFive;
			}
			temp /= 100;
		}
		
		sum = sumOfNumber + sumOfEvenDigit + greaterThanFive;
		if (sum % 3 == 0) {
			isValidNumber = true;
		}
		
		if (expDate.compareTo(LocalDate.now()) > 0) {
			isValidDate = true;
		}
		
		return (isValidNumber && isValidDate); // FIX ME
	}

}






package labs.lab6;


/**
 * A box of coins.
 */
public class CoinBox {

	// ADD YOUR INSTANCE VARIABLES HERE
	private double value;
	

	/**
	 * Constructs an empty CoinBox object.
	 */
	public CoinBox() {
		// FILL IN
		value = 0;
		
	}


	/**
	 * Adds a coin.
	 * 
	 * @param c the coin to add
	 */
	public void addCoin(Coin c) {
		// FILL IN
		value += c.getValue();
	}


	/**
	 * Removes coins from another coinbox and adds them to this one. 
	 * 
	 * @param other the box of coins from which to add
	 */
	public void addCoins(CoinBox other) {
		// FILL IN
		value += other.getValue();
		
		other.removeAllCoins();
	}


	/**
	 * Gets the value of all the coins.
	 * 
	 * @return total the total value of all the coins
	 */
	public double getValue() {
		return value; // FIX ME
	}


	/**
	 * Removes all the coins.
	 */
	public void removeAllCoins() {
		// FILL IN
		value = 0;
	}

}
package labs.lab5;

/**
 * Represents an item the player can pick up that benefits them in some way
 *
 */
public abstract class PowerUp implements Collectible {

	// ADD YOUR INSTANCE VARIABLES HERE
	private static final int MIN_VALUE = 0;
	private int initialPointValue;

	/**
	 * Constructs a new PowerUp with the given initial pointValue
	 * 
	 * @param initialPointValue
	 */
	public PowerUp(int initialPointValue) {
		// FILL IN
		if (initialPointValue < MIN_VALUE) {
			this.initialPointValue = MIN_VALUE;
		} else {
			this.initialPointValue = initialPointValue;			
		}
	}


	public int getInitialPointValue() {
		return initialPointValue; // FIX ME
	}

}
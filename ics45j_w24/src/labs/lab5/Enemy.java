package labs.lab5;

/**
 * Represents an enemy in the game
 *
 */

public abstract class Enemy implements Attackable {

	// ADD YOUR INSTANCE VARIABLES HERE
	private static int MAX_HEALTH;
	private static int MIN_HEALTH;
	private int health;

	/**
	 * Constructs a new Enemy with health = 100
	 */
	public Enemy() {
		// FILL IN
		MIN_HEALTH = 0;
		MAX_HEALTH = 100;
		health = MAX_HEALTH;
	}


	public int getHealth() {
		return health; // FIX ME
	}


	/**
	 * Sets health to the given amount, within the bounds of 0 and 100 (inclusive).
	 * If the given amount is > 100, sets it to 100. If the given amount is < 0,
	 * sets it to 0.
	 * 
	 * @param health the new health
	 */
	public void setHealth(int health) {
		// FILL IN
		if (health > MAX_HEALTH) {
			this.health = MAX_HEALTH;
		} else if (health < MIN_HEALTH) {
			this.health = MIN_HEALTH;
		} else {
			this.health = health;
		}
	}

}
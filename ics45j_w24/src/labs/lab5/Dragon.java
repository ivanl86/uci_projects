package labs.lab5;

/**
 * A dragon enemy
 *
 */

public class Dragon extends Enemy {

	// ADD YOUR INSTANCE VARIABLES EHRE
	private boolean fireBreathing;

	/**
	 * Constructs a new Dragon
	 * 
	 * @param fireBreathing whether or not it's fire-breathing
	 */
	public Dragon(boolean fireBreathing) {
		// FILL IN
		this.fireBreathing = fireBreathing;
	}


	public boolean isFireBreathing() {
		return fireBreathing; // FIX ME
	}


	/**
	 * 1) increments the Dragon's health by 25; 2) returns -25 (the number of
	 * strength points deducted for a player attacking this Dragon)
	 * 
	 * @return -25 (the number of strength points deducted for a player attacking
	 *         this Dragon)
	 */
	public int attack() {
		setHealth(getHealth() + 25);
		return -25; // FIX ME
	}


	/**
	 * 1) toggles fireBreathing from true to false or vice-versa; 2) decrements the
	 * Dragon's health by 10
	 */
	public void advanceTime() {
		// FILL IN
		fireBreathing = !fireBreathing;
		setHealth(getHealth() - 10);
	}

}
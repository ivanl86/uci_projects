package labs.lab5;

/**
 * A clown enemy
 *
 */

public class Clown extends Enemy {

	// ADD YOUR INSTANCE VARIABLES HERE
	private boolean weapon;

	/**
	 * Constructs a new Clown with the given weapon status
	 * 
	 * @param weapon status
	 */
	public Clown(boolean weapon) {
		// FILL IN
		this.weapon = weapon;
	}


	public boolean hasWeapon() {
		return weapon; // FIX ME
	}


	/**
	 * If the clown has a weapon: 1) Decreases this Clown's health by 5 2) Returns
	 * -25 (number of strength points deducted from the player attacking this Clown)
	 * 
	 * If the clown doesn't have a weapon: 1) Decreases this Clown's health by 20 2)
	 * Returns 25 (number of strength points awarded to the player attacking this
	 * Clown)
	 * 
	 * @return -25 if the clown has a weapon, 25 otherwise
	 */
	public int attack() {
		if (weapon) {
			setHealth(getHealth() - 5);
			return -25;
		}
		setHealth(getHealth() - 20);
		return 25; // FIX ME
	}


	/**
	 * 1) Decrements this Clown's health by 1; 2) Toggles the presence of a weapon
	 */
	public void advanceTime() {
		// FILL IN
		setHealth(getHealth() - 1);
		weapon = !weapon;
	}

}
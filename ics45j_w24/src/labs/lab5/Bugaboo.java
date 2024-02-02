package labs.lab5;

/**
 * A Bugaboo enemy
 *
 */

public class Bugaboo extends Enemy {

	// ADD YOUR INSTANCE VARIABLES HERE
	private double strength;

	/**
	 * Constructs a new Bugaboo with the given strength
	 * 
	 * @param strength
	 */
	public Bugaboo(double strength) {
		// FILL IN
		this.strength = strength;
	}


	public double getStrength() {
		return strength; // FIX ME
	}


	/**
	 * 1) decreases the Bugaboo's strength by 25%; 2) returns 0 (no strength points
	 * awarded or deducted to the player attacking this Bugaboo)
	 * 
	 * @return 0 (no strength points awarded or deducted to the player attacking
	 *         this Bugaboo)
	 */
	public int attack() {
		strength -= (strength * 0.25);
		return 0; // FIX ME
	}


	/**
	 * increases strength by 15%
	 */
	public void advanceTime() {
		// FILL IN
		strength += (strength * 0.15);
	}

}
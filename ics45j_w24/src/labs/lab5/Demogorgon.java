package labs.lab5;

/**
 * A demogorgon enemy
 *
 */

public class Demogorgon extends Enemy {

	// ADD YOUR INSTANCE VARIABLES HERE
	private static final double MIN_WEIGHT = 0.0;
	private double weight;

	/**
	 * Constructs a new Demogorgon with the given weight
	 * 
	 * @param weight
	 */
	public Demogorgon(double weight) {
		// FILL IN
		if (weight < MIN_WEIGHT) {
			this.weight = MIN_WEIGHT;
		} else {
			this.weight = weight;
		}
	}


	public double getWeight() {
		return weight; // FIX ME
	}


	/**
	 * 1) decreases the Demogorgon's weight by 10%; 2) decrements the Demogorgon's
	 * health by 15; 3) returns 0 (no strength points awarded or deducted to the
	 * player attacking this Demogorgon)
	 * 
	 * @return 0 (no strength points awarded or deducted to the player attacking
	 *         this Demogorgon)
	 */
	public int attack() {
		weight -= (weight * 0.10);
		
		if (weight < MIN_WEIGHT) {
			this.weight = MIN_WEIGHT;
		}
		
		setHealth(getHealth() - 15);
		return 0; // FIX ME
	}


	/**
	 * 1) increases the Demogorgon's weight by 5%; 2) increments the Demogorgon's
	 * health by 10
	 */
	public void advanceTime() {
		// FILL IN
		weight += (weight * 0.05);
		setHealth(getHealth() + 10);
	}

}
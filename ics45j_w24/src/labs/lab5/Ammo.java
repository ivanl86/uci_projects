package labs.lab5;

/**
 * Represents ammo that the player can pick up and use to attack enemies
 *
 */

public abstract class Ammo implements Collectible {

	// ADD YOUR INSTANCE VARIABLES HERE
	private double weight;

	/**
	 * constructs a new Ammo with the given weight
	 * 
	 * @param weight weight of ammo (in pounds)
	 */
	public Ammo(double weight) {
		// FILL IN
		this.weight = weight;
	}


	public double getWeight() {
		return weight; // FIX ME
	}


	public void setWeight(double weight) {
		// FILL IN
		this.weight = weight;
	}


	/**
	 * returns the number of ammo (how many attacks can come from this Ammo)
	 * 
	 * @return the number of ammo (how many attacks can come from this Ammo)
	 */
	public abstract int getNumAmmo();

}
package labs.lab5;

/**
 * Interface for elements that can be attacked
 *
 */
public interface Attackable extends GameElement {

	/**
	 * Attacks this attackable element, and returns the resulting net change in
	 * strength points to the player attacking it
	 * 
	 * @return the resulting net change in strength points to the player attacking
	 *         it
	 */
	int attack();

}
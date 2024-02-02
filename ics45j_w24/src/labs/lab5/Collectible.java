package labs.lab5;

/**
 * Interface for elements that can be collected by the player
 *
 */

public interface Collectible extends GameElement {

	/**
	 * collects this Collectable item; returns the number of items contained in this
	 * Collectable item
	 * 
	 * @return the number of items contained in this Collectable item
	 */
	int collect();


	/**
	 * returns whether or not this item has been collected
	 * 
	 * @return whether or not this item has been collected
	 */
	boolean isCollected();

}
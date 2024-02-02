package labs.lab5;

/**
 * A goblin enemy
 *
 */

public class Goblin extends Enemy {

	// ADD YOUR INSTANCE VARIABLES HERE
	private static final String PURPLE = "purple";
	private static final String ORANGE = "orange";
	private static final String BLACK = "black";
	private static final String RED = "red";
	private String color;

	/**
	 * Constructs a new Goblin with color purple
	 */
	public Goblin() {
		// FILL IN
		color = PURPLE;
	}


	public String getColor() {
		return color; // FIX ME
	}


	/**
	 * 1) changes the Goblin's color to "red"; 2) decrements the Goblin's health by
	 * 50; 3) returns 50 (the number of strength points awarded to a player for
	 * attacking this Goblin)
	 * 
	 * @return 50 (the number of strength points awarded to a player for attacking
	 *         this Goblin)
	 */
	public int attack() {
		color = RED;
		setHealth(getHealth() - 50);
		return 50; // FIX ME
	}


	/**
	 * 1) decrements the Goblin's health by 20; 2) changes Goblin's color to the next
	 * one in the cycle purple, orange, black, purple, orange, black, ..., OR if the
	 * Goblin is red (from a stomp), starts the cycle over again with purple
	 */
	public void advanceTime() {
		setHealth(getHealth() - 20);
		switch(color) {
		case PURPLE:
			color = ORANGE;
			break;
		case ORANGE:
			color = BLACK;
			break;
		case BLACK:
		case RED:
			color = PURPLE;
		}
		// FILL IN
	}

}
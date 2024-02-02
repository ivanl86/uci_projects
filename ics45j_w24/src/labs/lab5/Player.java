package labs.lab5;

/**
 * Player in the battle game
 *
 */
public class Player {

	// ADD YOUR INSTANCE VARIABLES HERE
	private String name;
	private int strength;
	private int ammo;

	/**
	 * Constructs a new Player with the given name, 0 strength points, and 0 ammo
	 * 
	 * @param name name of the player
	 */
	public Player(String name) {
		// FILL IN
		this.name = name;
		strength = 0;
		ammo = 0;
	}


	public String getName() {
		return name; // FIX ME
	}


	public int getStrengthPoints() {
		return strength; // FIX ME
	}


	public int getAmmo() {
		return ammo; // FIX ME
	}


	/**
	 * If the item is a PowerUp: Collects the given PowerUp if it's not already
	 * collected, and increments the player's strength points by the number of
	 * points the PowerUp is worth
	 * 
	 * If the item is Ammo: Collects the given ammo if it's not already collected,
	 * and if the player has enough strength points (each pound of ammo requires 10
	 * strength points); adds to the player's ammo the number of items in the ammo
	 * 
	 * @param c the item to collect
	 * 
	 * @return whether or not the item was collected
	 */
	public boolean collectItem(Collectible c) {
		if (c instanceof PowerUp && !((PowerUp) c).isCollected()) {
//			PowerUp powerup = (PowerUp) c;
//			strength += ((PowerUp) c).getInitialPointValue();
			strength += ((PowerUp) c).collect();
			return true;
		}
		if (c instanceof Ammo && !((Ammo) c).isCollected()) {
//			ammo += ((Ammo) c).getNumAmmo();
			ammo += ((Ammo) c).collect();
			return true;
		}
		return false; // FIX ME
	}


	/**
	 * If the Player has ammo, attacks the given enemy with one ammo (and uses up
	 * one ammo)
	 * 
	 * @param enemy the Enemy to attack
	 * 
	 * @return whether or not the Enemy was attacked
	 */
	public boolean attackEnemy(Enemy enemy) {
		if (ammo > 0) {
			--ammo;
			;
			strength += enemy.attack();
			return true;
		}
		return false; // FIX ME
	}

}
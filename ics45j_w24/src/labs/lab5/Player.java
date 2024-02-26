package labs.lab5;

/**
 * Player in the battle game
 *
 */
public class Player {

	// ADD YOUR INSTANCE VARIABLES HERE
	private static final int MIN_STRENGTH = 0;
	private static final int MIN_AMMO = 0;
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
			strength += ((PowerUp) c).collect();
			if (strength < MIN_STRENGTH) {
				strength = MIN_STRENGTH;
			}
			return true;
		}
		if (c instanceof Ammo && !((Ammo) c).isCollected()) {
			if (strength >= ((Ammo) c).getWeight() * 10) {
				ammo += ((Ammo) c).collect();
				
				if (ammo < MIN_AMMO) {
					ammo = MIN_AMMO;
				}
				
				return true;
			}
			
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
			
			strength += enemy.attack();
			
			if (strength < MIN_STRENGTH) {
				strength = MIN_STRENGTH;
			}
			
			return true;
		}
		
		return false; // FIX ME
	}

}
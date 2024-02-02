package labs.lab5;

/**
 * An ad pest in the Pest game
 */
public class Ad implements Pest {
	
	/**
	 * @return the string made up of blockSomethingYouReallyWantToSee() and 
	 * dontGoAwayEvenWhenYouClickX(), separated by a " | "
	 */
	@Override
	public String annoy() {
		return blockSomethingYouReallyWantToSee() + " | " + dontGoAwayEvenWhenYouClickX(); // FIX ME
	}
	
	
	/**
	 * @return the string "Block something you really want to see"
	 */
	private String blockSomethingYouReallyWantToSee() {
		return "Block something you really want to see"; // FIX ME
	}
	
	
	/**
	 * @return the string "Don't go away even when you click X"
	 */
	private String dontGoAwayEvenWhenYouClickX() {
		return "Don't go away even when you click X"; // FIX ME
	}
}
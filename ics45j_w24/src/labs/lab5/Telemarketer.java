package labs.lab5;

/**
 * A telemarketer pest in the Pest game
 */
public class Telemarketer extends Person implements Pest {
	
	/**
	 * Constructor
	 * 
	 * @param name	name of the telemarketer
	 */
	public Telemarketer(String name) {
		super(name);
	}
	
	
	/**
	 * @return the string made up of callDuringDinner() and continueTalkingWhenYouSayNo(),
	 * separated by a " | "
	 */
	@Override
	public String annoy() {
		return callDuringDinner() + " | " + continueTalkingWhenYouSayNo(); // FIX ME
	}
	
	
	/**
	 * @return the string "Call during dinner"
	 */
	private String callDuringDinner() {
		return "Call during dinner"; // FIX ME
	}
	
	
	/**
	 * @return the string "Continue talking when you say no"
	 */
	private String continueTalkingWhenYouSayNo() {
		return "Continue talking when you say no"; // FIX ME
	}
}
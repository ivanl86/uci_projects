package labs.lab4;

/**
 * An audio book item in a library
 */
public class AudioBook extends Book {
	// ADD YOUR INSTANCE VARIABLES HERE
	private double playingTime;
	private final int maxCheckouts;
	private int currentCheckouts;

	/**
	 * Constructor
	 * 
	 * @param title			audio book title
	 * @param author		audio book author
	 * @param playingTime	audio book playing time
	 */
	public AudioBook(String title, String author, double playingTime) {
		// FILL IN
		super(title, author);
		this.playingTime = playingTime;
		loanPeriod = FOUR_WEEKS;
		maxCheckouts = 2;
		currentCheckouts = 0;
	}

	
	public double getPlayingTime() {
		return playingTime; // FIX ME
	}
	
	
	public void setPlayingTime(double playingTime) {
		// FILL IN
		this.playingTime = playingTime;
	}
	
	
	/**
	 * If the max number of checkouts for this item has not already been reached,
	 * this method checks this item out and returns the loan period; if no more
	 * check outs are available for this item, returns the String "NOT ALLOWED";
	 * overrides LibraryItem.checkOut()
	 */
	@Override
	public String checkOut() {
		if (currentCheckouts < maxCheckouts) {
			++currentCheckouts;
			return loanPeriod + " days";
		}
		return "NOT ALLOWED"; // FIX ME
	}
	
	
	/**
	 * Checks in this item  (frees up one checkout for this item); overrides
	 * LibraryItem.checkIn()
	 */
	@Override
	public void checkIn() {
		// FILL IN
		--currentCheckouts;
	}
	
	
	/**
	 * Returns true if the parameter object is an AudioBook that has the same
	 * instance variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (otherObject instanceof AudioBook) {
			return super.equals(otherObject) && playingTime == ((AudioBook) otherObject).getPlayingTime();
		}
		
		return false; // FIX ME
	}
}
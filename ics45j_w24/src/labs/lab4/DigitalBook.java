package labs.lab4;

/**
 * Digital book item in a library
 */
public class DigitalBook extends Book {
	// ADD YOUR INSTANCE VARIABLES HERE
	private int numPages;
	private final int maxCheckouts;
	private int currentCheckouts;

	
	/**
	 * Constructor
	 * 
	 * @param title		book title
	 * @param author	book author
	 * @param numPages	number of pages
	 */
	public DigitalBook(String title, String author, int numPages) {
		// FILL IN
		super(title, author);
		this.numPages = numPages;
		loanPeriod = TWO_WEEKS;
		maxCheckouts = 3;
		currentCheckouts = 0;
	}

	
	public int getNumPages() {
		return numPages; // FIX ME
	}
	
	
	public void setNumPages(int numPages) {
		// FILL IN
		this.numPages = numPages;
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
	 * Returns true if the parameter object is a DigitalBook that has the same
	 * instance variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (otherObject instanceof DigitalBook) {
			return super.equals(otherObject) && numPages == ((DigitalBook) otherObject).getNumPages();
		}
		
		return false; // FIX ME
	}
}
package labs.lab4;

/**
 * An abstract item that can be checked out of a library
 */
public abstract class LibraryItem {
	// ADD YOUR INSTANCE VARIABLES HERE
	protected static final int ONE_WEEK = 7;
	protected static final int TWO_WEEKS = 14;
	protected static final int THREE_WEEKS = 21;
	protected static final int FOUR_WEEKS = 28;
	private String title;
	private boolean checkedOut;
	protected int loanPeriod;
	
	/**
	 * Constructor
	 * 
	 * @param title	title of the item
	 */
	public LibraryItem(String title) {
		// FILL IN
		this.title = title;
		checkedOut = false;
//		currentCheckouts = 0;
	}
	
	
	public String getTitle() {
		return title; // FIX ME
	}
	
	
	public boolean isCheckedOut() {
		return checkedOut; // FIX ME
	}
	
	
	public void setCheckedOut(boolean checkedOut) {
		// FILL IN
		this.checkedOut = checkedOut;
	}
	
	
	/**
	 * Causes this item to be checked out
	 * 
	 * @return	a message about the check out
	 */
	public abstract String checkOut();
	
	
	/**
	 * Causes this item to be checked in
	 */
	public void checkIn() {
		// FILL IN
		checkedOut = false;
	}
	
	
	public String toString() {
		return "Title: " + title; // FIX ME
	}
	
	
	/**
	 * Returns true if the parameter object is a LibraryItem that has the same instance
	 * variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (otherObject instanceof LibraryItem)
			return this.title == ((LibraryItem) otherObject).title;
		
		return false; // FIX ME
	}
}
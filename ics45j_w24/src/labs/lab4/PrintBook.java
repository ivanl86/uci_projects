package labs.lab4;

/**
 * Print book item in a library
 */
public class PrintBook extends Book {
	// ADD YOUR INSTANCE VARIABLES HERE
	private int numPages;

	/**
	 * Constructor
	 * 
	 * @param title		book title
	 * @param author	book author
	 * @param numPages	number of pages
	 */
	public PrintBook(String title, String author, int numPages) {
		// FILL IN
		super(title, author);
		this.numPages = numPages;
		loanPeriod = THREE_WEEKS;
	}

	
	public int getNumPages() {
		return numPages; // FIX ME
	}

	
	public void setNumPages(int numPages) {
		// FILL IN
		this.numPages = numPages;
	}

	
	/**
	 * If this item is not already checked out, this method checks this item out
	 * and returns the loan period; if it is already checked out, returns the
	 * String "NOT ALLOWED"; overrides LibraryItem.checkOut()
	 */
	@Override
	public String checkOut() {
		if (!super.isCheckedOut()) {
//			checkedOut = true;
			super.setCheckedOut(true);
			return loanPeriod + " days";
		}
		
		return "NOT ALLOWED"; // FIX ME
	}

	
	/**
	 * Returns true if the parameter object is a PrintBook that has the same
	 * instance variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (otherObject instanceof PrintBook) {
			return super.equals(otherObject) && numPages == ((PrintBook) otherObject).getNumPages();
		}
		
		return false; // FIX ME
	}
}
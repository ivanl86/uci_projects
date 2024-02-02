package labs.lab4;

/**
 * A magazine item in a library
 */
public class Magazine extends LibraryItem {
	// ADD YOUR INSTANCE VARIABLES HERE
	private int issueNumber;
	private String publicationDate;

	
	/**
	 * Constructor
	 * 
	 * @param title				magazine title
	 * @param issueNumber		magazine issue number
	 * @param publicationDate	magazine publication date
	 */
	public Magazine(String title, int issueNumber, String publicationDate) {
		// FILL IN
		super(title);
		this.issueNumber = issueNumber;
		this.publicationDate = publicationDate;
		loanPeriod = ONE_WEEK;
	}
	
	
	public int getIssueNumber() {
		return issueNumber; // FIX ME
	}
	
	
	public void setIssueNumber(int issueNumber) {
		// FILL IN
		this.issueNumber = issueNumber;
	}

	
	public String getPublicationDate() {
		return publicationDate; // FIX ME
	}

	
	public void setPublicationDate(String publicationDate) {
		// FILL IN
		this.publicationDate = publicationDate;
	}
	
	
	/**
	 * If this item is not already checked out, this method checks this item out and 
	 * returns the loan period; if it is already checked out, returns the String 
	 * "NOT ALLOWED"; overrides LibraryItem.checkOut()
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
	 * Returns true if the parameter object is a Magazine that has the same instance 
	 * variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (otherObject instanceof Magazine) {
			return (super.equals(otherObject)) && issueNumber == ((Magazine) otherObject).getIssueNumber() && publicationDate == ((Magazine) otherObject).getPublicationDate();
		}
		
		return false; // FIX ME
	}
}
package labs.lab4;

import java.util.List;

/**
 * A DVD item in a library
 */
public class DVD extends LibraryItem {
	// ADD YOUR INSTANCE VARIABLES HERE
	private List<String> actors;

	
	/**
	 * Constructor
	 * 
	 * @param title		title of the DVD
	 * @param actors	actors in the DVD
	 */
	public DVD(String title, List<String> actors) {
		// FILL IN
		super(title);
		this.actors = actors;
		loanPeriod = ONE_WEEK;
	}

	
	public List<String> getActors() {
		return actors; // FIX ME
	}
	
	
	public void setActors(List<String> actors) {
		// FILL IN
		this.actors = actors;
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
	 * Returns true if the parameter object is a DVD that has the same instance 
	 * variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (otherObject instanceof DVD) {
			return (super.equals(otherObject)) && actors == ((DVD) otherObject).getActors();
		}
		
		return false; // FIX ME
	}
}
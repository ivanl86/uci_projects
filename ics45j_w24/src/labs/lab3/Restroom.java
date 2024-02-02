package labs.lab3;

/**
 * A class that shows how restroom stalls are occupied.
 */

public class Restroom {

	// ADD YOUR INSTANCE VARIABLES HERE
	private final char UNOCCUPIED = '_';
	private final char OCCUPIED = 'X';
	private int numStalls;
	private boolean[] stallsOccupancy;
	int count;
	/**
	 * Constructs a restroom with a given number of stalls.
	 * 
	 * @param numStalls the number of stalls
	 */
	public Restroom(int numStalls) {
		// FILL IN
		this.numStalls = numStalls;
		stallsOccupancy = new boolean[numStalls];
		count = 0;
	}


	/**
	 * Adds an occupant in the middle of the longest sequence of unoccupied stalls.
	 * If there are multiple longest sequences, adds occupant in the first one.
	 * If the middle of the sequence falls between 2 stalls, adds occupant in the 
	 * stall just right of the middle.
	 */
	public void addOccupant() {
		// FILL IN
		int i = 0;
		int start = 0;
		int mid = 0;
		int max = 0;
		
		if (count >= numStalls)
			return;
		
		while (start + i < stallsOccupancy.length) {
			while (start + i < stallsOccupancy.length && !stallsOccupancy[start + i]) {
				++i;
			}
			
			if (i > max) {
				max = i;
				mid = (int) Math.ceil(i / 2) + start;
			}
			
			start = start + i + 1;
			i = 0;
		}
		
		stallsOccupancy[mid] = true;
	}

//			if (!stallsOccupancy[mid / 2]) {
//				stallsOccupancy[mid / 2] = true;
//				return;
//			} else if (!stallsOccupancy[(int) Math.ceil(mid + (end - mid))]) {
//				stallsOccupancy[(int) Math.ceil(mid + (end - mid))] = true;
//				return;
//			} else {
//				;
//			}

	/**
	 * Gets a string describing the current stall occupation
	 * 
	 * @return a string with _ for an empty stall and X for an occupied one
	 */
	public String getStalls() {
		String stalls = "";
		
		for (int i = 0; i < stallsOccupancy.length; ++i) {
			stalls += stallsOccupancy[i] ? OCCUPIED : UNOCCUPIED;
			stalls += " ";
		}
		
		return stalls.trim(); // FIX ME
	}

}





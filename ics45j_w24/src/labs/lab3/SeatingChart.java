package labs.lab3;

/**
 * A theater seating chart implemented as a 2-d array of ticket prices
 */
public class SeatingChart {
	// ADD YOUR INSTANCE VARIABLES HERE
	private final int A = 0;
	private final int B = 1;
	private final int C = 2;
	private final int D = 3;
	private final int E = 4;
	private final int ROWS = 5;
	private final int COLS = 5;
	private int[][] seatingChart;
	
	public SeatingChart() {
		seatingChart = new int[][]{
				{40, 50, 50, 50, 40},
				{30, 40, 40, 40, 30},
				{20, 30, 30, 30, 20},
				{10, 20, 20, 20, 10},
				{10, 10, 10, 10, 10}
		};
	}
	
	/**
	 * Returns a string that represents the price of seats in a grid-like pattern.
	 */
	public String getSeatingChart() {
		String seatingString = "";
		
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				if (seatingChart[row][col] == 0) {
					seatingString += " ";
				}
				seatingString += seatingChart[row][col];
				seatingString += (col < COLS - 1) ? " " : System.lineSeparator();
			}
		}
		
		return seatingString; // FIX ME
	}

	
	/**
	 * Goes from left to right and front to back to find a seat with the specified
	 * price, then, if found, sets its price to 0 to mark it as sold. If no seat 
	 * is found with the specified price, the seating chart remains unchanged. 
	 * Assume all inputs are valid ints.
	 * 
	 * @param price the price to mark to zero
	 */
	public void sellSeatByPrice(int price) {
		// FILL IN
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				if (seatingChart[row][col] == price) {
					seatingChart[row][col] = 0;
					return;
				}
			}
		}
	}

	
	/**
	 * Marks the specified seat as sold by setting its price to 0. If the seat 
	 * doesn't exist, the seating chart remains unchanged. Valid rows are A through 
	 * E, case sensitive (A is the front row, E is the back row). Valid seats are 1 
	 * through 5 (if facing the front/stage, 1 is the leftmost seat, 5 is the 
	 * rightmost seat). Assume all inputs are valid chars and ints.
	 */
	public void sellSeatByNumber(char row, int seat) {
		// FILL IN
		final int INVALID = -1;
		int rowNumber = INVALID;
		
		switch (row) {
		case 'A':
			rowNumber = A;
			break;
		case 'B':
			rowNumber = B;
			break;
		case 'C':
			rowNumber = C;
			break;
		case 'D':
			rowNumber = D;
			break;
		case 'E':
			rowNumber = E;
			break;
		}
		
		if (rowNumber > INVALID && rowNumber < ROWS)
			seatingChart[rowNumber][seat - 1] = 0;
	}
}






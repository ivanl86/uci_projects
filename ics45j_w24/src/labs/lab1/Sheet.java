package labs.lab1;

/**
 * Compute international standard sizes for paper, where A0 = 841 x 1189 mm A1 =
 * 594 x 841 mm A2 = 420 x 594 mm A3 = 292 x 423 mm etc
 */
public class Sheet {

	// ADD YOUR INSTANCE VARIABLES HERE
	private int paperSize;
	private String name;
	private int width;
	private int length;
	
	/**
	 * create a sheet of size A0
	 */
	public Sheet() {
		// FILL IN
		paperSize = 0;
		name = "A" + paperSize;
		width = 841;
		length = 1189;
	}

	
	/**
	 * @return the width of the paper
	 */
	public int getWidth() {
		return width; // FIX ME
	}

	
	/**
	 * @return the length of the paper
	 */
	public int getLength() {
		return length; // FIX ME
	}

	
	/**
	 * @return the ISO name for the paper
	 */
	public String getName() {
		return name; // FIX ME
	}

	
	/**
	 *
	 * @return a sheet that is cut in half along the length
	 */
	public Sheet cutInHalf() {
		int temp;
		temp = width;
		width = length / 2;
		length = temp;
		++paperSize;
		name = "A" + paperSize;
		return this; // FIX ME
	}
}

package labs.lab4;

/**
 * A class that represents a cube and can calculate its volume and surface
 * area.
 */
public class Cube {

	// ADD YOUR INSTANCE VARIABLES HERE
	private double length;

	/**
	 * Creates a cube with the given side length.
	 * 
	 * @param sideLength the side length (assume > 0)
	 */
	public Cube(double sideLength) {
		// FILL IN
		length = sideLength;
	}


	/**
	 * Calculates the volume of the cube.
	 * 
	 * @return the volume of the cube.
	 */
	public double getVolume() {
		return length * length * length; // FIX ME
	}


	/**
	 * Calculates the surface area of the cube.
	 * 
	 * @return the surface area of the cube.
	 */
	public double getSurface() {
		return 6 * length * length; // FIX ME
	}
}

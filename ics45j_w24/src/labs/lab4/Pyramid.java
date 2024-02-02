package labs.lab4;

/**
 * A class that represents a right square pyramid and can calculate its volume and surface
 * area.
 */
public class Pyramid {

	 // ADD YOUR INSTANCE VARIABLES HERE
	private double length;
	private double height;

	/**
	 * Creates a new right square pyramid of given edge length and height.
	 * 
	 * @param 	edgeLength		the length of one of the pyramid's base edges (assume > 0)
	 * @param 	height			the height of the pyramid (assume > 0)
	 */
	public Pyramid(double edgeLength, double height) {
		// FILL IN
		length = edgeLength;
		this.height = height;
	}


	/**
	 * Calculates the volume of the pyramid.
	 * 
	 * @return the volume of the pyramid
	 */
	public double getVolume() {
		return length * length * height / 3; // FIX ME
	}


	/**
	 * Calculates the surface area of the pyramid.
	 * 
	 * @return the surface area of the pyramid
	 */
	public double getSurface() {
		return length * length + 2 * length * Math.sqrt(length * length / 4 + height * height); // FIX ME
	}
}

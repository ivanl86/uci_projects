package labs.lab6;

/**
 * A product in a vending machine.
 */
public class VendingMachineProduct {

	// ADD YOUR INSTANCE VARIABLES HERE
	private String description;
	private double price;

	/**
	 * Constructs a VendingMachineProduct object
	 * 
	 * @param aDescription the description of the product
	 * @param aPrice       the price of the product
	 */
	public VendingMachineProduct(String aDescription, double aPrice) {
		// FILL IN
		description = aDescription;
		price = aPrice;
	}


	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description; // FIX ME
	}


	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return price; // FIX ME
	}


	/**
	 * Determines if this vending machine product is the same as the other 
	 * vending machine product.
	 * 
	 * @param other the other product
	 * @return true if the products have the same description and price, false otherwise
	 */
	@Override
	public boolean equals(Object other) {
		if (other instanceof VendingMachineProduct) {
			return description == ((VendingMachineProduct) other).description
				&& price == ((VendingMachineProduct) other).price;
		}
		return false; // FIX ME
	}


	/**
	 * Returns a string representation of the product consisting of the description,
	 * " @ $", and the prices, formatted with two decimal places after the decimal
	 * point
	 */
	@Override
	public String toString() {
		return String.format("%s @ $%.2f", description, price); // FIX ME
	}

}





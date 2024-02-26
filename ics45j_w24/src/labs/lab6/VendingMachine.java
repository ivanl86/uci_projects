package labs.lab6;

import java.util.ArrayList;
import java.util.List;

/**
 * A vending machine.
 */
public class VendingMachine {

	private List<VendingMachineProduct> products; // the products in the machine
	public CoinBox storedCoins; // the coins that have already been used to purchase a product
	public CoinBox currentCoins; // the coins that have been inserted but have not yet been used to purchase a
									// product
	private List<Integer> quantities;

	/**
	 * Constructs a VendingMachine object with no products or coins
	 */
	public VendingMachine() {
		// FILL IN
		products = new ArrayList<>();
		storedCoins = new CoinBox();
		currentCoins = new CoinBox();
		quantities = new ArrayList<>();
	}


	/**
	 * Gets the type of products in the vending machine.
	 * 
	 * @return a list of products in this machine
	 */
	public List<VendingMachineProduct> getProductTypes() {
		return products; // FIX ME
	}


	/**
	 * Adds a product to the vending machine.
	 * 
	 * @param p        the product to add
	 * @param quantity the quantity
	 */
	public void addProduct(VendingMachineProduct p, int quantity) {
		// FILL IN
		if (quantity < 1) {
			return;
		}
		
		if (!products.contains(p)) {
			products.add(p);
			quantities.add(quantity);
		} else {
			quantities.set(products.indexOf(p), quantities.get(products.indexOf(p)) + quantity);
		}
		
	}


	/**
	 * Adds the coin to the vending machine, and returns the total value of coins
	 * that have been inserted but not yet used to buy a product
	 * 
	 * @param c the coin to add
	 * @return the total value of coins that have been inserted but not yet used to
	 *         buy a product
	 */
	public double addCoin(Coin c) {
		currentCoins.addCoin(c);
		return currentCoins.getValue(); // FIX ME
	}


	/**
	 * Buys a product from the vending machine, causing all the coins that have been
	 * inserted since the last purchase to be stored in the machine and unavailable
	 * to use for other purchases.
	 * 
	 * @param p the product to buy
	 * @return "OK" if the product was purchased, "Insufficient money" if the
	 *         product exists but there is not enough to purchase the product, or
	 *         "No such product" if the product doesn't exist in the machine
	 */
	public String buyProduct(VendingMachineProduct p) {
		if (!products.contains(p)) {
			return "No such product";
		}
		
		if (p.getPrice() > currentCoins.getValue()) {
			return "Insufficient money";
		}
		
		quantities.set(products.indexOf(p), quantities.get(products.indexOf(p)) - 1);
		
		if (quantities.get(products.indexOf(p)) == 0) {
			quantities.remove(products.indexOf(p));
			products.remove(products.indexOf(p));
		}
		
		storedCoins.addCoins(currentCoins);
		currentCoins.removeAllCoins();
		return "OK"; // FIX ME
	}


	/**
	 * Removes the stored money from the vending machine.
	 * 
	 * @return the amount of money removed
	 */
	public double removeStoredMoney() {
		double storedValue = storedCoins.getValue();
		storedCoins.removeAllCoins();
		return storedValue; // FIX ME
	}

}





package labs.lab4;

import java.util.ArrayList;

/**
 * A class for a customer in a store that discounts 10% on every purchase
 * after they have spent at least $100 and shopped in at least 3 different stores.
 */
public class Customer {

	// ADD YOUR INSTANCE VARIABLES HERE
	private double totalAmount;
	private int storesVisited;
	private ArrayList<Integer> storeNumRecord;
	
	
	public Customer() {
		// FILL IN
		totalAmount = 0;
		storesVisited = 0;
		storeNumRecord = new ArrayList<>();
	}
	

	/**
	 * 
	 * @param purchaseAmount
	 * @param storeNum	Each store is identified by a unique integer
	 * @return	the purchase amount for this purchase, with any discounts applied
	 */
	public double makePurchase(double purchaseAmount, int storeNum) {
		final double DISCOUNT = 0.90;
		totalAmount += purchaseAmount;
		if (storesVisited < 3) {
			for (int i = 0; i < storeNumRecord.size(); ++i) {
				if (storeNumRecord.get(i) == storeNum) {
					return purchaseAmount;
				}
			}
			storeNumRecord.add(storeNum);
			++storesVisited;
			return purchaseAmount;
		}
		if (totalAmount < 100) {
			return purchaseAmount;
		}
		return purchaseAmount * DISCOUNT; // FIX ME
	}
	
}

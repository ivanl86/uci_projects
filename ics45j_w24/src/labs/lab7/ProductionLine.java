package labs.lab7;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Class for managing the production queue for Robert's business
 */
public class ProductionLine {

	private Queue<Integer> standard;
	private Queue<Integer> rush;

	/**
	 * Constructs a new production line with empty queues
	 */
	public ProductionLine() {
		// FILL IN
		standard = new LinkedList<>();
		rush = new LinkedList<>();
	}


	/**
	 * Adds an order to the standard queue
	 * 
	 * @param customerID the customer ID
	 */
	public void addStandardOrder(Integer customerID) {
		// FILL IN
		((LinkedList<Integer>) standard).addLast(customerID);
	}


	/**
	 * Adds an order to the rush queue
	 * 
	 * @param customerID the customer ID
	 */
	public void addRushOrder(Integer customerID) {
		// FILL IN
		((LinkedList<Integer>) rush).addLast(customerID);
	}


	/**
	 * Handles the next order to be produced
	 * 
	 * @return a string that describes the order that was handled, in the format
	 *         "Producing [rush/standard] order for customer [customerID]"
	 */
	public String handleNextOrder() {
		if (rush.size() > 0) {
			return String.format("Producing rush order for customer %d", ((LinkedList<Integer>) rush).removeFirst());
		}
		
		if (standard.size() > 0) {
			return String.format("Producing standard order for customer %d", ((LinkedList<Integer>) standard).removeFirst());
		}
		
		return ""; // FIX ME
	}

}

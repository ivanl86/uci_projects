package labs.lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Class for simulating a shipping center using stacks of products with
 * descriptions as representation.
 */
public class ShippingCenter {

	private Stack<String> shippingStack; // products ready to be shipped
	private Stack<String> temporaryStack; // products placed on a temporary stack while shuffling around products ready
											// to be shipped

	/**
	 * Constructs a new shipping center with empty stacks
	 */
	public ShippingCenter() {
		// FILL IN
		shippingStack = new Stack<>();
		temporaryStack = new Stack<>();
	}


	/**
	 * Returns a string containing the contents of the storage stack, each item
	 * separated by a comma and space
	 * 
	 * @return a string containing the contents of the storage stack, each item
	 *         separated by a comma and space
	 */
	public String getShippingStack() {
		Object[] objs = null;
		String log = "";
		
		if (shippingStack.empty()) {
			return log;
		}
		
		objs = shippingStack.toArray();
		
		log = "Shipping stack: ";
		
		for (int i = 0; i < objs.length - 1; ++i) {
			log += (String) objs[i] + ", ";
		}
		
		log += (String) objs[objs.length - 1];
		
		return log; // FIX ME
	}


	/**
	 * Returns a string containing the contents of the temporary stack, each item
	 * separated by a comma and space
	 * 
	 * @return a string containing the contents of the temporary stack, each item
	 *         separated by a comma and space
	 */
	public String getTemporaryStack() {
		Object[] objs = temporaryStack.toArray();
		String log = "";
		
		if (shippingStack.empty()) {
			return log;
		}
		
		log += "Temporary stack: ";
		
		if (temporaryStack.empty()) {
			return log;
		}
		
		for (int i = 0; i < objs.length - 1; ++i) {
			log += (String) objs[i] + ", ";
		}
		
		log += (String) objs[objs.length - 1];
		
		return log; // FIX ME
	}


	/**
	 * Add the given product to the shipping stack. Returns a log of the process.
	 * 
	 * @param product description of product
	 * @return a log of the process
	 */
	public List<String> add(String product) {
		List<String> logs = new ArrayList<>();
		
		if (shippingStack.search(product) != -1) {
			logs.add("That product is already on the shipping stack.");
			return logs;
		}
		
		shippingStack.push(product);
		logs.add(getShippingStack());
		logs.add(getTemporaryStack());
		
		return logs; // FIX ME
	}


	/**
	 * Ships the given product (removes it from the shipping stack if it's on the
	 * shipping stack). Returns a log of the process
	 * 
	 * @param product description of product
	 * @return a log of the process (see example and test file for format)
	 */
	public List<String> ship(String product) {
		List<String> logs = new ArrayList<>();
		
		if (shippingStack.search(product) == -1) {
			return new ArrayList<String>(Arrays.asList("That product is not on the shipping stack."));
		}
		
		if (shippingStack.peek().equals(product)) {
			shippingStack.pop();
			logs.add(getShippingStack());
			logs.add(getTemporaryStack());
			return logs;
		}
		
		while (shippingStack.search(product) > 0) {
			if (!shippingStack.peek().equals(product)) {
				temporaryStack.push(shippingStack.pop());
				logs.add(getShippingStack());
				logs.add(getTemporaryStack());
			} else {
				shippingStack.pop();
			}
		}
		
		while (!temporaryStack.empty()) {
			shippingStack.push(temporaryStack.pop());
			logs.add(getShippingStack());
			logs.add(getTemporaryStack());
		}
		
		return logs; // FIX ME
	}
	
//	public static void main(String[] args) {
//		ShippingCenter center = new ShippingCenter();
//		System.out.println(center.add("product 1"));
//		System.out.println(center.add("product 2"));
//		System.out.println(center.add("product 3"));
//		System.out.println(center.add("product 4"));
//		System.out.println(center.ship("product 2"));
//	}
}





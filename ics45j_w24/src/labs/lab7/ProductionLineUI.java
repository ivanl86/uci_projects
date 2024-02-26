package labs.lab7;

import java.util.Scanner;

/**
 * UI for ProductionLine
 */
public class ProductionLineUI {
	public static void main(String[] args) {
		ProductionLine productionLine = new ProductionLine();

		Scanner in = new Scanner(System.in);
		boolean done = false;
		System.out.println("Production Line Menu");
		System.out.println("-----------------------------------------------");
		System.out.println(" > standard/rush followed by the customer ID");
		System.out.println(" > next to perform next action");
		System.out.println(" > quit to quit production line");
		System.out.println();

		while (!done) {
			System.out.print(" > ");
			String action = in.next();
			if (action.equals("standard")) {
				int customerID = in.nextInt();
				productionLine.addStandardOrder(customerID);
			} else if (action.equals("rush")) {
				int customerID = in.nextInt();
				productionLine.addRushOrder(customerID);
			} else if (action.equals("next")) {
				System.out.println(productionLine.handleNextOrder());
			} else if (action.equals("quit")) {
				done = true;
			}
		}
		System.out.println();
		System.out.println(" -- Thank you --");
	}
}

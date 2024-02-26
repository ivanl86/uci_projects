package labs.lab6;

import java.util.Scanner;
import java.util.List;

/**
 * A menu from the vending machine.
 */
public class VendingMachineUI {

	private Scanner in;
	private static final Coin[] COINS = { Coin.NICKEL, Coin.DIME, Coin.QUARTER, Coin.DOLLAR };

	/**
	 * Constructs a VendingMachineMenu object
	 */
	public VendingMachineUI() {
		in = new Scanner(System.in);
	}


	/**
	 * Runs the vending machine system.
	 * 
	 * @param machine the vending machine
	 */
	public void run(VendingMachine machine) {
		boolean more = true;

		while (more) {
			System.out.print("S)how products A)dd B)uy product I)nsert R)emove coins Q)uit: ");
			String command = in.nextLine().toUpperCase();

			if (command.equals("S")) {
				for (VendingMachineProduct p : machine.getProductTypes()) {
					System.out.println(p);
				}
			} else if (command.equals("A")) {
				System.out.print("Description: ");
				String description = in.nextLine();
				System.out.print("Price: ");
				double price = in.nextDouble();
				System.out.print("Quantity: ");
				int quantity = in.nextInt();
				in.nextLine(); // read the new-line character
				machine.addProduct(new VendingMachineProduct(description, price), quantity);
			} else if (command.equals("I")) {
				Coin chosen = pickCoin();
				System.out.println("Current $ " + machine.addCoin(chosen));
			} else if (command.equals("B")) {
				VendingMachineProduct p = pickProduct(machine.getProductTypes());
				String result = machine.buyProduct(p);
				if (result == "OK") {
					System.out.println("Purchased: " + p);
				} else {
					System.out.println("Sorry: " + result);
				}
			} else if (command.equals("R")) {
				System.out.println("Removed: $ " + machine.removeStoredMoney());
			} else if (command.equals("Q")) {
				more = false;
			}
		}
	}


	// Pick a coin from the list of all coins
	private Coin pickCoin() {
		while (true) {
			char c = 'A';
			for (Coin choice : COINS) {
				System.out.println(c + ") " + choice);
				c++;
			}
			String input = in.nextLine();
			int n = input.toUpperCase().charAt(0) - 'A';
			if (0 <= n && n < COINS.length) {
				return COINS[n];
			}
		}
	}


	// Pick a product from all products
	private VendingMachineProduct pickProduct(List<VendingMachineProduct> allProducts) {
		while (true) {
			char c = 'A';
			for (VendingMachineProduct choice : allProducts) {
				System.out.println(c + ") " + choice);
				c++;
			}
			String input = in.nextLine();
			int n = input.toUpperCase().charAt(0) - 'A';
			if (0 <= n && n < allProducts.size()) {
				return allProducts.get(n);
			}
		}
	}


	public static void main(String[] args) {
		new VendingMachineUI().run(new VendingMachine());
	}

}

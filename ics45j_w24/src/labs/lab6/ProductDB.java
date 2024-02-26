package labs.lab6;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

//import java.io.FileWriter;
//import java.io.IOException;

public class ProductDB {

	// ADD YOUR INSTANCE VARIABLES EHRE
	private List<Product> products;
	private String dbFileName;

	/**
	 * Constructor that reads in the product data from a file
	 * 
	 * @param productsFileName name of file with product data
	 */
	public ProductDB(String productsFileName) {
		// FILL IN
		products = new ArrayList<>();
		dbFileName = productsFileName;
		
		try (Scanner inputFile = new Scanner(new File(productsFileName))) {
			
			while (inputFile.hasNextLine()) {
				String[] line = inputFile.nextLine().split(";");
				String name = line[0];
				double price = Double.parseDouble(line[1]);
				int quantity = Integer.parseInt(line[2]);
				
				products.add(new Product(name, price, quantity));
			}
			
		} catch (FileNotFoundException e) {
			System.out.printf("File: %s not found", productsFileName);
		}
	}


	/**
	 * Searches for the product with the given name and returns it if found,
	 * otherwise returns null.
	 * 
	 * @param productName name of product to search for
	 * 
	 * @return product with given name, or null if not found
	 */
	public Product findProduct(String productName) {
		for (Product p : products) {
			if (p.getName().equals(productName)) {
				return p;
			}
		}
		
		return null; // FIX ME
	}


	/**
	 * Adds a new product to the products DB if a product with the given name
	 * doesn't already exist
	 * 
	 * @param name     name of product
	 * @param price    price of product
	 * @param quantity quantity of product
	 */
	public void addProduct(String name, double price, int quantity) {
		// FILL IN
		for (Product p : products) {
			if (p.getName().equals(name)) {
				return;
			}
		}
		
		products.add(new Product(name, price, quantity));
		
		try (PrintWriter output = new PrintWriter(new FileOutputStream(new File(dbFileName), true))) {
			output.printf("%s;%.2f;%d\n", name, price, quantity);
			
		} catch (FileNotFoundException e) {
			System.out.printf("File: %s not found", dbFileName);
		}
	}
	
	public static void main(String[] args) {
		String prodFileName = "res/products.txt";
		ProductDB db = new ProductDB(prodFileName);
		db.addProduct("stuffed sloth", 9.99, 4);
		db.addProduct("stuffed puppy", 19.99, 41);
	}
}





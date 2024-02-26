package labs.lab6.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import labs.lab6.*;


public class Lab6Test {
	
	private final double EPSILON = 1e-3;

	@Test
	public void problem1() {
		AirportData ad = new AirportData("res/airports.dat");
		List<String> airports = ad.getAllAirportsInCity("Seoul");
		Collections.sort(airports);
		assertTrue(airports.equals(new ArrayList<>(
				Arrays.asList(new String[] { "Gimpo International Airport", "Incheon International Airport" }))));
		airports = ad.getAllAirportsInCity("Irvine");
		assertTrue(airports.size() == 0);
	}
	
	@Test
	public void problem2() {
		
		// Test case 1
		CSVReader reader1 = new CSVReader("res/att2007.csv");
		assertEquals(214, reader1.getNumberOfRows());
		assertEquals(7, reader1.getNumberOfFields(10));
		assertEquals("24.95", reader1.getField(10, 2));
		ArrayList<String> fields = new ArrayList<>();
		fields.add("3/1/2007");
		fields.add("24.87");
		fields.add("24.88");
		fields.add("24.75");
		fields.add("24.87");
		fields.add("475000");
		fields.add("22.57");
		assertEquals(fields, reader1.getFields(2));
		
		// Test case 2
		CSVReader reader2 = new CSVReader("res/quotes.csv");
		assertEquals(2, reader2.getNumberOfRows());
		assertEquals(4, reader2.getNumberOfFields(1));
		assertEquals("Hello, World", reader2.getField(1, 2));
		assertEquals("He asked: \"Quo vadis?\"", reader2.getField(1, 3));
		assertEquals("\"...,that all men are created equal,...\"", reader2.getField(0, 3));
	}

	@Test
	public void problem3() {

		// success operations:
		Student george = new Student("George Glass", 1234);
		assertEquals(1234, george.getID());

		george.addClass("ICS 45J");
		george.addClass("Ballet I");
		george.addClass("Chem 51C");
		george.dropClass("Ballet I");

		// exception operations:

		// assigning negative ID:
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Student robert = new Student("Robert Navarro", -1234);
		});
		String expectedMessage = "ID cannot be negative";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));

		// dropping a class that the student doesn't have:
		exception = assertThrows(IllegalArgumentException.class, () -> {
			george.dropClass("ICS 10");
		});
		expectedMessage = "Cannot drop class ICS 10 because student is not enrolled in it";
		actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
		List<String> expClasses = Arrays.asList("Chem 51C", "ICS 45J");
		assertEquals(expClasses, george.getClasses());
	}
	
	@Test
	public void problem4() throws IOException {
		String prodFileName = "res/products.txt";
		ProductDB db = new ProductDB(prodFileName);

		assertEquals(new Product("Blue plaid bow tie collar", 29.95, 6), db.findProduct("Blue plaid bow tie collar"));
		assertEquals(new Product("Red bandana", 3.99, 16), db.findProduct("Red bandana"));
		assertEquals(new Product("White porcelain food and water bowl set", 23.00, 8),
				db.findProduct("White porcelain food and water bowl set"));
		assertEquals(new Product("XL tan fluffy dog bed", 75.25, 2), db.findProduct("XL tan fluffy dog bed"));
		assertNull(db.findProduct("stuffed sloth"));
		db.addProduct("stuffed sloth", 9.99, 4);
		assertEquals(new Product("stuffed sloth", 9.99, 4), db.findProduct("stuffed sloth"));

		// check that file was updated:
		List<String> linesList = Arrays.asList("Blue plaid bow tie collar;29.95;6", "Red bandana;3.99;16",
				"White porcelain food and water bowl set;23.00;8", "XL tan fluffy dog bed;75.25;2",
				"stuffed sloth;9.99;4");
		assertEquals(linesList, java.nio.file.Files.readAllLines(new File(prodFileName).toPath()));

		assertNull(db.findProduct("stuffed puppy"));
		db.addProduct("stuffed puppy", 19.99, 41);
		assertEquals(new Product("stuffed puppy", 19.99, 41), db.findProduct("stuffed puppy"));

		// check that file was updated:
		linesList = Arrays.asList("Blue plaid bow tie collar;29.95;6", "Red bandana;3.99;16",
				"White porcelain food and water bowl set;23.00;8", "XL tan fluffy dog bed;75.25;2",
				"stuffed sloth;9.99;4", "stuffed puppy;19.99;41");
		assertEquals(linesList, java.nio.file.Files.readAllLines(new File(prodFileName).toPath()));

		// check that previous products are still there:
		assertEquals(new Product("Red bandana", 3.99, 16), db.findProduct("Red bandana"));
		assertEquals(new Product("White porcelain food and water bowl set", 23.00, 8),
				db.findProduct("White porcelain food and water bowl set"));

		// check that a product with the same name as existing product isn't added:
		db.addProduct("stuffed sloth", 0.99, 1);
		assertEquals(new Product("stuffed sloth", 9.99, 4), db.findProduct("stuffed sloth"));

		// check that file is unchanged:
		assertEquals(linesList, java.nio.file.Files.readAllLines(new File(prodFileName).toPath()));

		// test exception message is printed out:
		String nonExistentFileName = "res/nothing.txt";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		ProductDB db2 = new ProductDB(nonExistentFileName);

		String result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);
	}
	
	@Test
	public void problem5() {

		// babynames1.txt (10 records):
		BabyNameData data = new BabyNameData("res/babynames1.txt");

		// boy names:
		List<String> boyNames = data.getAllBoyNames();

		List<String> expectedList = Arrays.asList("Michael", "Christopher", "Matthew", "Joshua", "Nicholas", "Jacob",
				"Daniel", "Andrew", "Tyler", "Joseph");

		assertTrue(expectedList.size() == boyNames.size() && expectedList.containsAll(boyNames)
				&& boyNames.containsAll(expectedList));

		// girl names:
		List<String> girlNames = data.getAllGirlNames();

		expectedList = Arrays.asList("Megan", "Ashley", "Samantha", "Sarah", "Emily", "Amanda", "Brittany", "Elizabeth",
				"Taylor", "Jessica");

		assertTrue(expectedList.size() == girlNames.size() && expectedList.containsAll(girlNames)
				&& girlNames.containsAll(expectedList));

		// non-gender specific names:
		List<String> nonGenderSpecificNames = data.getAllNonGenderSpecificNames();

		expectedList = new ArrayList<>();

		assertTrue(
				expectedList.size() == nonGenderSpecificNames.size() && expectedList.containsAll(nonGenderSpecificNames)
						&& nonGenderSpecificNames.containsAll(expectedList));

		// rank:
		int rank = 3;
		assertEquals("Emily", data.getGirlNameAtRank(rank));
		assertEquals("Matthew", data.getBoyNameAtRank(rank));

		rank = 10;
		assertEquals("Megan", data.getGirlNameAtRank(rank));
		assertEquals("Joseph", data.getBoyNameAtRank(rank));

		rank = 1;
		assertEquals("Jessica", data.getGirlNameAtRank(rank));
		assertEquals("Michael", data.getBoyNameAtRank(rank));

		// babynames2.txt (70 records):
		data = new BabyNameData("res/babynames2.txt");
		assertEquals(70, data.getAllBoyNames().size());
		assertEquals(70, data.getAllGirlNames().size());

		expectedList = Arrays.asList("Taylor", "Jordan");

		nonGenderSpecificNames = data.getAllNonGenderSpecificNames();

		assertTrue(
				expectedList.size() == nonGenderSpecificNames.size() && expectedList.containsAll(nonGenderSpecificNames)
						&& nonGenderSpecificNames.containsAll(expectedList));

		// exception for out of range rank:
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			BabyNameData data2 = new BabyNameData("res/babynames2.txt");
			data2.getBoyNameAtRank(-1);
		});

		String expectedMessage = "Rank -1 out of range of data";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

		exception = assertThrows(IllegalArgumentException.class, () -> {
			BabyNameData data2 = new BabyNameData("res/babynames1.txt");
			data2.getBoyNameAtRank(100);
		});

		expectedMessage = "Rank 100 out of range of data";
		actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

		// exception for file not found:
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		String nonExistentFileName = "nobabynames.txt";
		new BabyNameData(nonExistentFileName);

		String result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);
	}
	
	@Test
	public void problems6Through10() {
		// Product:
		VendingMachineProduct candyBar = new VendingMachineProduct("Candy bar", 0.55);
		assertEquals("Candy bar", candyBar.getDescription());
		assertEquals(0.55, candyBar.getPrice(), EPSILON);
		assertEquals("Candy bar @ $0.55", candyBar.toString());
		VendingMachineProduct soda = new VendingMachineProduct("Soda", 0.65);
		assertEquals("Soda", soda.getDescription());
		assertEquals(0.65, soda.getPrice(), EPSILON);
		assertEquals("Soda @ $0.65", soda.toString());
		VendingMachineProduct sameCandyBar = new VendingMachineProduct("Candy bar", 0.55);
		VendingMachineProduct expensiveCandyBar = new VendingMachineProduct("Candy bar", 0.95);
		VendingMachineProduct capsCandyBar = new VendingMachineProduct("CANDY BAR", 0.55);
		assertEquals(sameCandyBar, candyBar);
		assertFalse(candyBar.equals(expensiveCandyBar));
		assertFalse(candyBar.equals(capsCandyBar));
		
		
		// Coin:
		assertEquals(0.25, Coin.QUARTER.getValue(), EPSILON);
		assertEquals("quarter", Coin.QUARTER.getName());
		assertEquals("quarter @ $0.25", Coin.QUARTER.toString());
		
		assertEquals(0.05, Coin.NICKEL.getValue(), EPSILON);
		assertEquals("quarter", Coin.QUARTER.getName());
		assertEquals("quarter @ $0.25", Coin.QUARTER.toString());
		
		Coin quime = new Coin(0.175, "quime");
		assertEquals(0.175, quime.getValue(), EPSILON);
		assertEquals("quime", quime.getName());
		assertEquals("quime @ $0.18", quime.toString());
		
		
		// CoinBox:
		CoinBox box1 = new CoinBox();
		assertEquals(0, box1.getValue(), EPSILON);
		box1.addCoin(Coin.DOLLAR);
		box1.addCoin(Coin.QUARTER);
		box1.addCoin(Coin.NICKEL);
		assertEquals(1.3, box1.getValue(), EPSILON);
		CoinBox box2 = new CoinBox();
		assertEquals(0, box2.getValue(), EPSILON);
		box2.addCoins(box1);
		assertEquals(0, box1.getValue(), EPSILON);
		assertEquals(1.3, box2.getValue(), EPSILON);
		box2.removeAllCoins();
		assertEquals(0, box2.getValue(), EPSILON);
		
		
		// VendingMachine:
		VendingMachine machine = new VendingMachine();
		List<VendingMachineProduct> expectedProducts = Arrays.asList();
		List<VendingMachineProduct> actualProducts = machine.getProductTypes();
		assertTrue(expectedProducts.size() == actualProducts.size() && expectedProducts.containsAll(actualProducts) &&
				actualProducts.containsAll(expectedProducts));
		machine.addProduct(candyBar, 2);
		machine.addProduct(soda, 5);
		expectedProducts = Arrays.asList(
				candyBar,
				soda
				);
		actualProducts = machine.getProductTypes();
		assertTrue(expectedProducts.size() == actualProducts.size() && expectedProducts.containsAll(actualProducts) &&
				actualProducts.containsAll(expectedProducts));
		assertTrue(expectedProducts.size() == actualProducts.size() && expectedProducts.containsAll(actualProducts) &&
				actualProducts.containsAll(expectedProducts));
		assertEquals(0.25, machine.addCoin(Coin.QUARTER), EPSILON);
		assertEquals(0.5, machine.addCoin(Coin.QUARTER), EPSILON);
		assertEquals(0.55, machine.addCoin(Coin.NICKEL), EPSILON);
		assertEquals("OK", machine.buyProduct(candyBar));
		assertEquals(1.0, machine.addCoin(Coin.DOLLAR), EPSILON);
		assertEquals("OK", machine.buyProduct(soda));
		assertEquals(1.55, machine.removeStoredMoney(), EPSILON);
		
		machine = new VendingMachine();
		VendingMachineProduct gum = new VendingMachineProduct("Gum", 0.45);
		machine.addProduct(gum, 2);
		VendingMachineProduct chips = new VendingMachineProduct("Chips", 1.0);
		machine.addProduct(chips, 2);
		VendingMachineProduct nuts = new VendingMachineProduct("Nuts", 1.25);
		machine.addProduct(nuts, 3);
		expectedProducts = Arrays.asList(
				gum,
				chips,
				nuts
				);
		actualProducts = machine.getProductTypes();
		assertTrue(expectedProducts.size() == actualProducts.size() && expectedProducts.containsAll(actualProducts) &&
				actualProducts.containsAll(expectedProducts));
		assertEquals("No such product", machine.buyProduct(candyBar));
		assertEquals("Insufficient money", machine.buyProduct(gum));
		assertEquals(1.0, machine.addCoin(Coin.DOLLAR), EPSILON);
		assertEquals("OK", machine.buyProduct(gum));
		assertEquals("Insufficient money", machine.buyProduct(gum));
		assertEquals(1.0, machine.addCoin(Coin.DOLLAR), EPSILON);
		assertEquals("OK", machine.buyProduct(gum));
		assertEquals(2.0, machine.removeStoredMoney(), EPSILON);
		assertEquals(.10, machine.addCoin(Coin.DIME), EPSILON);
		assertEquals("No such product", machine.buyProduct(gum));
		assertEquals("Insufficient money", machine.buyProduct(chips));
		assertEquals(0.35, machine.addCoin(Coin.QUARTER), EPSILON);
		assertEquals(0.6, machine.addCoin(Coin.QUARTER), EPSILON);
		assertEquals(0.85, machine.addCoin(Coin.QUARTER), EPSILON);
		assertEquals(0.95, machine.addCoin(Coin.DIME), EPSILON);
		assertEquals(1.05, machine.addCoin(Coin.DIME), EPSILON);
		assertEquals("OK", machine.buyProduct(chips));
		assertEquals(1.05, machine.removeStoredMoney(), EPSILON);
	}
}

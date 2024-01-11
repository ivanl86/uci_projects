package labs.lab1.tests;

import static org.junit.Assert.*;

import java.awt.Rectangle;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import labs.lab1.*;

public class Lab1Test {

	private final double EPSILON = 1e-3;

	@Test
	public void problem1() {
		assertEquals("ri", Main.problem1_middle("string"));
		assertEquals("od", Main.problem1_middle("code"));
		assertEquals("Oh", Main.problem1_middle("Oh"));
	}

	@Test
	public void problem2() {
		assertEquals("", Main.problem2_removeChars("xx"));
		assertEquals("XX", Main.problem2_removeChars("XX"));
		assertEquals("X", Main.problem2_removeChars("xX"));
		assertEquals("X", Main.problem2_removeChars("Xx"));
		assertEquals("xxHi", Main.problem2_removeChars("xxHi"));
		assertEquals("Hi", Main.problem2_removeChars("Hix"));
		assertEquals("Hi", Main.problem2_removeChars("Hxi"));
		assertEquals("Hi", Main.problem2_removeChars("Hi"));
		assertEquals("Hi", Main.problem2_removeChars("Hixx"));
		assertEquals("xHi", Main.problem2_removeChars("xHi"));
		assertEquals("xab", Main.problem2_removeChars("xaxb"));
		assertEquals("bxa", Main.problem2_removeChars("bxax"));
		assertEquals("", Main.problem2_removeChars("x"));
		assertEquals("", Main.problem2_removeChars(""));
		assertEquals("Hello there", Main.problem2_removeChars("Hello there"));
		assertEquals("Hexllo", Main.problem2_removeChars("Hexllo"));
		assertEquals("Hxllo", Main.problem2_removeChars("Hxllox"));
	}

	@Test
	public void problem3() {
		// make 5 test runs:
		for (int i = 1; i < 6; i++) {
			String result = Main.problem3_chooseAnswers(i);
			boolean correct = true;

			// The result must have 10 numbers:
			String[] split = result.split(" ");
			if (split.length != 10) {
				correct = false;
			}

			// All numbers must be integers between 1 and i
			for (String num : split) {
				try {
					int number = Integer.parseInt(String.valueOf(num));
					if (number < 1 || number > i) {
						correct = false;
					}
				} catch (Exception e) {
					correct = false; // if conversion from string to integer fails
				}
			}
			assertEquals(true, correct);
		}
	}

	@Test
	public void problem4() {
		Rectangle r1 = Main.problem4_growSquare(new Rectangle(100, 100, 50, 50));
		assertTrue(r1.x == 100 && r1.y == 100 && r1.width == 60 && r1.height == 60);

		Rectangle r2 = Main.problem4_growSquare(new Rectangle(0, 0, 20, 20));
		assertTrue(r2.x == 0 && r2.y == 0 && r2.width == 30 && r2.height == 30);

		Rectangle r3 = Main.problem4_growSquare(new Rectangle(2, 8, 83, 83));
		assertTrue(r3.x == 2 && r3.y == 8 && r3.width == 93 && r3.height == 93);
	}

	@Test
	public void problem5() {
		assertTrue(new BigDecimal(
				"-9.610000000000000550670620214077651938730359583164929117285652827862296732064351090230047702789306640625")
				.equals(Main.problem5_bigPowerNegate(new BigDecimal(3.1), 2)));
		assertTrue(new BigDecimal(
				"0.007916293657000000587393385931278558904560168021331181838069343034723826023096811683978266027338361275704885165065885279929262796638766985779511742293834686279296875")
				.equals(Main.problem5_bigPowerNegate(new BigDecimal(-0.1993), 3)));
		assertTrue(new BigDecimal(
				"-9453529591320953.72957178735145919339954101592137687052611699540982668019762429129774880708606363011469913534638642200087975733527338525018416431081877168468948993054507525862520372790018196063711709801337274912965493211538535801744629307310747020273186548595370012002327021520879242282964734817677544461381930035269708541045399616541649226290379426362875392442219890654087066650390625")
				.equals(Main.problem5_bigPowerNegate(new BigDecimal(99.3), 8)));
	}

	@Test
	public void problem6() {
		BankAccount momsSavings = new BankAccount(1000, 3);
		momsSavings.setTransactionFee(1.00);
		momsSavings.deposit(100);
		momsSavings.withdraw(10);
		momsSavings.withdraw(30);
		momsSavings.withdraw(27.25);
		momsSavings.deposit(30);
		momsSavings.deposit(12);
		momsSavings.deductMonthlyCharge();
		assertEquals(1071.75, momsSavings.getBalance(), EPSILON);
	}

	@Test
	public void problem7() {
		Letter dearJohnLetter = new Letter("Mary", "John");
		dearJohnLetter.addLine("I am sorry we must part.");
		dearJohnLetter.addLine("I wish you all the best.");

		String message = dearJohnLetter.getText();
		Scanner scanner = new Scanner(message);
		List<String> letter = new ArrayList<>();

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			letter.add(line);
		}
		scanner.close();

		assertEquals(8, letter.size());

		if (letter.size() == 8) { // The size depends on the number of body lines we add to the letter.
			assertEquals("DearJohn:", letter.get(0).replaceAll("\\s", ""));
			assertEquals("Iamsorrywemustpart.", letter.get(2).replaceAll("\\s", ""));
			assertEquals("Iwishyouallthebest.", letter.get(3).replaceAll("\\s", ""));
			assertEquals("Mary", letter.get(7).replaceAll("\\s", ""));
		}
		/*
		 * 
		 * Dear John:
		 * 
		 * I am sorry we must part. //body line 1 I wish you all the best. //body line 2
		 * 
		 * Sincerely,
		 * 
		 * Mary
		 * 
		 */

	}

	@Test
	public void problem8() {
		Sheet sheet = new Sheet();
		assertEquals("A0", sheet.getName());
		assertEquals(841, sheet.getWidth());
		assertEquals(1189, sheet.getLength());

		sheet = sheet.cutInHalf();
		assertEquals("A1", sheet.getName());
		assertEquals(594, sheet.getWidth());
		assertEquals(841, sheet.getLength());

		sheet = sheet.cutInHalf();
		assertEquals("A2", sheet.getName());
		assertEquals(420, sheet.getWidth());
		assertEquals(594, sheet.getLength());

		sheet = sheet.cutInHalf();
		assertEquals("A3", sheet.getName());
		assertEquals(297, sheet.getWidth());
		assertEquals(420, sheet.getLength());

		sheet = sheet.cutInHalf();
		assertEquals("A4", sheet.getName());
		assertEquals(210, sheet.getWidth());
		assertEquals(297, sheet.getLength());

		sheet = sheet.cutInHalf();
		assertEquals("A5", sheet.getName());
		assertEquals(148, sheet.getWidth());
		assertEquals(210, sheet.getLength());

		sheet = sheet.cutInHalf();
		assertEquals("A6", sheet.getName());
		assertEquals(105, sheet.getWidth());
		assertEquals(148, sheet.getLength());

		sheet = sheet.cutInHalf();
		assertEquals("A7", sheet.getName());
		assertEquals(74, sheet.getWidth());
		assertEquals(105, sheet.getLength());

		sheet = sheet.cutInHalf();
		assertEquals("A8", sheet.getName());
		assertEquals(52, sheet.getWidth());
		assertEquals(74, sheet.getLength());

		sheet = sheet.cutInHalf();
		assertEquals("A9", sheet.getName());
		assertEquals(37, sheet.getWidth());
		assertEquals(52, sheet.getLength());

		sheet = sheet.cutInHalf();
		assertEquals("A10", sheet.getName());
		assertEquals(26, sheet.getWidth());
		assertEquals(37, sheet.getLength());

		sheet = sheet.cutInHalf();
		assertEquals("A11", sheet.getName());
		assertEquals(18, sheet.getWidth());
		assertEquals(26, sheet.getLength());

		sheet = sheet.cutInHalf();
		assertEquals("A12", sheet.getName());
		assertEquals(13, sheet.getWidth());
		assertEquals(18, sheet.getLength());

		sheet = sheet.cutInHalf();
		assertEquals("A13", sheet.getName());
		assertEquals(9, sheet.getWidth());
		assertEquals(13, sheet.getLength());

		sheet = sheet.cutInHalf();
		assertEquals("A14", sheet.getName());
		assertEquals(6, sheet.getWidth());
		assertEquals(9, sheet.getLength());
	}

	@Test
	public void problem9() {
		Moth gypsy = new Moth(10);
		gypsy.moveToLight(0);
		assertEquals(5.0, gypsy.getPosition(), EPSILON);
		gypsy.moveToLight(10);
		assertEquals(7.5, gypsy.getPosition(), EPSILON);
		gypsy.moveToLight(0);
		assertEquals(3.75, gypsy.getPosition(), EPSILON);

		Moth monte = new Moth(20);
		monte.moveToLight(10);
		assertEquals(15.0, monte.getPosition(), EPSILON);
		monte.moveToLight(10);
		assertEquals(12.5, monte.getPosition(), EPSILON);
		monte.moveToLight(0);
		assertEquals(6.25, monte.getPosition(), EPSILON);
		monte.moveToLight(1000.52);
		assertEquals(503.385, monte.getPosition(), EPSILON);
	}

	@Test
	public void problem10() {
		SavingsAccount momsSavings = new SavingsAccount(1000, 10);
		assertEquals(1000.0, momsSavings.getBalance(), EPSILON);

		momsSavings.addInterest();
		assertEquals(1100.0, momsSavings.getBalance(), EPSILON);

		momsSavings.addInterest();
		assertEquals(1210.0, momsSavings.getBalance(), EPSILON);

		momsSavings.addInterest();
		momsSavings.addInterest();
		assertEquals(1464.1, momsSavings.getBalance(), EPSILON);

		SavingsAccount dadsSavings = new SavingsAccount(0, 20);
		assertEquals(0, dadsSavings.getBalance(), EPSILON);

		dadsSavings.addInterest();
		assertEquals(0, dadsSavings.getBalance(), EPSILON);

		dadsSavings.deposit(50);
		assertEquals(50, dadsSavings.getBalance(), EPSILON);

		dadsSavings.addInterest();
		assertEquals(60, dadsSavings.getBalance(), EPSILON);

		dadsSavings.withdraw(20);
		assertEquals(40, dadsSavings.getBalance(), EPSILON);

		dadsSavings.addInterest();
		assertEquals(48, dadsSavings.getBalance(), EPSILON);

		dadsSavings.addInterest();
		assertEquals(57.6, dadsSavings.getBalance(), EPSILON);

		dadsSavings.withdraw(60);
		assertEquals(57.6, dadsSavings.getBalance(), EPSILON);

		dadsSavings.withdraw(dadsSavings.getBalance());
		assertEquals(0, dadsSavings.getBalance(), EPSILON);

	}
}

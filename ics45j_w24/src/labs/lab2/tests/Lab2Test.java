package labs.lab2.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import labs.lab2.*;

import org.junit.Test;


public class Lab2Test {
	
	private final double EPSILON = 1e-3;

	@Test
	public void problem1() {
		assertEquals(59, Main.problem1_getDiscount(56, 3));
		assertEquals(75, Main.problem1_getDiscount(156, 13));
		assertEquals(0, Main.problem1_getDiscount(0, 0));
	}
	
	@Test
	public void problem2() {
		// Test case 1:
		String input = "53882\n";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem2_printWithCommas(new Scanner(System.in));
		String result = output.toString();
		assertEquals("Please enter an integer between 1000 and 999999: 53,882", result);

		
		// Test case 2:
		input = "1001\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem2_printWithCommas(new Scanner(System.in));
		result = output.toString();
		assertEquals("Please enter an integer between 1000 and 999999: 1,001", result);

		
		// Test case 3:
		input = "523303\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem2_printWithCommas(new Scanner(System.in));
		result = output.toString();
		assertEquals("Please enter an integer between 1000 and 999999: 523,303", result);
	}
	
    @Test
    public void test_problem3() {
        assertEquals("1 6 3 8 4", Main.problem3_printDigits(16384));
        assertEquals("2 2 2 5 0", Main.problem3_printDigits(22250));
    }
    
	@Test
	public void problem4() {
		CashRegister register = new CashRegister();
		register.recordPurchase(20.37);
		register.enterDollars(20);
		register.enterQuarters(2);
		assertEquals(0.13, register.giveChange(), EPSILON);

		register.recordPurchase(0.01);
		register.enterDollars(20);
		assertEquals(19.99, register.giveChange(), EPSILON);

		register.recordPurchase(494.18);
		register.recordPurchase(494.19);
		register.enterDollars(1000);
		register.enterQuarters(1);
		assertEquals(11.88, register.giveChange(), EPSILON);

		register.recordPurchase(3);
		register.recordPurchase(.4);
		register.recordPurchase(.08);
		register.enterDollars(3);
		register.enterQuarters(1);
		register.enterDimes(2);
		assertEquals(-1, register.giveChange(), EPSILON);

		register.enterPennies(3);
		assertEquals(0, register.giveChange(), EPSILON);

		register.recordPurchase(3.48);
		register.enterDollars(3);
		register.enterQuarters(1);
		register.enterDimes(2);
		register.enterNickels(1);
		register.enterPennies(10);
		assertEquals(0.12, register.giveChange(), EPSILON);

		assertEquals(0, register.giveChange(), EPSILON);

		register.recordPurchase(0);
		register.enterDollars(33);
		register.enterQuarters(5);
		register.enterDimes(2);
		register.enterNickels(1);
		register.enterPennies(10);
		assertEquals(34.6, register.giveChange(), EPSILON);

		register.recordPurchase(0);
		register.enterDollars(0);
		register.enterQuarters(0);
		register.enterDimes(0);
		register.enterNickels(0);
		register.enterPennies(0);
		assertEquals(0, register.giveChange(), EPSILON);

		register.recordPurchase(0);
		register.recordPurchase(0);
		register.enterPennies(0);
		assertEquals(0, register.giveChange(), EPSILON);
	}
	
	@Test
	public void problem5() {
		// Test case 1:
		String input = "1500\n4.3\n6\n4";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem5_compoundInterest(new Scanner(System.in));
		String result = output.toString();
		assertEquals("Enter principal amount: " + "Enter the annual rate of interest: " + 
				"Enter the number of years the amount is invested: " + 
				"Enter the number of times the interest is compounded per year: " +
				"$1500.00 invested at 4.3% for 6 years compounded 4 times annually is $1938.84.", result); 
		
		
		// Test case 2:
		input = "10000\n0\n100\n20";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem5_compoundInterest(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter principal amount: " + "Enter the annual rate of interest: " + 
				"Enter the number of years the amount is invested: " + 
				"Enter the number of times the interest is compounded per year: " +
				"$10000.00 invested at 0.0% for 100 years compounded 20 times annually is $10000.00.", result); 
		
		
		// Test case 3:
		input = "83.95\n5.98\n7\n4";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem5_compoundInterest(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter principal amount: " + "Enter the annual rate of interest: " + 
				"Enter the number of years the amount is invested: " + 
				"Enter the number of times the interest is compounded per year: " +
				"$83.95 invested at 5.98% for 7 years compounded 4 times annually is $127.20.", result); 
	}
	
	@Test
	public void problem6() {
		assertTrue(Main.problem6_evenlySpaced(2, 4, 6));
		assertTrue(Main.problem6_evenlySpaced(4, 6, 2));
		assertFalse(Main.problem6_evenlySpaced(4, 6, 3));
		assertTrue(Main.problem6_evenlySpaced(4, 4, 4));
		assertTrue(Main.problem6_evenlySpaced(2, 6, 4));
		assertTrue(Main.problem6_evenlySpaced(20000, 10000, 0));
		assertFalse(Main.problem6_evenlySpaced(-2, 6, 4));
		assertFalse(Main.problem6_evenlySpaced(-2, -6, 4));
		assertFalse(Main.problem6_evenlySpaced(2, 4, -6));
		assertTrue(Main.problem6_evenlySpaced(-2, -6, -4));
		assertFalse(Main.problem6_evenlySpaced(26, 26, 25));
	}
	
	@Test
	public void problem7() {
		assertTrue(Main.problem7_nearAndFar(1, 2, 10)); 
		assertFalse(Main.problem7_nearAndFar(1, 2, 3)); 
		assertTrue(Main.problem7_nearAndFar(4, 1, 3)); 
		assertFalse(Main.problem7_nearAndFar(4, 5, 3)); 
		assertFalse(Main.problem7_nearAndFar(4, 3, 5)); 
		assertTrue(Main.problem7_nearAndFar(-1, 10, 0)); 
		assertTrue(Main.problem7_nearAndFar(0, -1, 10)); 
		assertTrue(Main.problem7_nearAndFar(10, 10, 8)); 
		assertFalse(Main.problem7_nearAndFar(10, 8, 9)); 
		assertFalse(Main.problem7_nearAndFar(8, 9, 10)); 
		assertFalse(Main.problem7_nearAndFar(8, 9, 7)); 
		assertTrue(Main.problem7_nearAndFar(8, 6, 9)); 
	}
	
	@Test
	public void problem8() {
		
		// dashboard left:
		assertEquals("Left door opens", Main.problem8_carDoorControl(
				true, // dashboardLeft
				false, // dashboardRight
				false, // childLock
				true,  // masterUnlock
				false, // insideLeftLatch
				false,  // outsideLeftLatch
				false, // insideRightLatch
				false, // outsideRightLatch
				"P"	   // gearshift
				)); // Left door opens
		
		// dashboard right:
		assertEquals("Right door opens", Main.problem8_carDoorControl(
				false, // dashboardLeft
				true, // dashboardRight
				false, // childLock
				true,  // masterUnlock
				false, // insideLeftLatch
				false,  // outsideLeftLatch
				false, // insideRightLatch
				false, // outsideRightLatch
				"P"	   // gearshift
				)); // Right door opens
		
		// inside left latch:
		assertEquals("Left door opens", Main.problem8_carDoorControl(
				false, // dashboardLeft
				false, // dashboardRight
				false, // childLock
				true,  // masterUnlock
				true, // insideLeftLatch
				false,  // outsideLeftLatch
				false, // insideRightLatch
				false, // outsideRightLatch
				"P"	   // gearshift
				));
		
		// outside left latch
		assertEquals("Left door opens", Main.problem8_carDoorControl(
				false, // dashboardLeft
				false, // dashboardRight
				false, // childLock
				true,  // masterUnlock
				false, // insideLeftLatch
				true,  // outsideLeftLatch
				false, // insideRightLatch
				false, // outsideRightLatch
				"P"	   // gearshift
				)); // Right door opens

		// inside right latch:
		assertEquals("Right door opens", Main.problem8_carDoorControl(
				false, // dashboardLeft
				false, // dashboardRight
				false, // childLock
				true,  // masterUnlock
				false, // insideLeftLatch
				false,  // outsideLeftLatch
				true, // insideRightLatch
				false, // outsideRightLatch
				"P"	   // gearshift
				));
		
		// outside right latch:
		assertEquals("Right door opens", Main.problem8_carDoorControl(
				false, // dashboardLeft
				false, // dashboardRight
				false, // childLock
				true,  // masterUnlock
				false, // insideLeftLatch
				false,  // outsideLeftLatch
				false, // insideRightLatch
				true, // outsideRightLatch
				"P"	   // gearshift
				));
		
		// no doors being activated:
		assertEquals("No door opens", Main.problem8_carDoorControl(
				false, // dashboardLeft
				false, // dashboardRight
				false, // childLock
				true,  // masterUnlock
				false, // insideLeftLatch
				false,  // outsideLeftLatch
				false, // insideRightLatch
				false, // outsideRightLatch
				"P"	   // gearshift
				));
		
		// doors being activated but masterUnlock not on:
		assertEquals("No door opens", Main.problem8_carDoorControl(
				true, // dashboardLeft
				false, // dashboardRight
				false, // childLock
				false,  // masterUnlock
				false, // insideLeftLatch
				false,  // outsideLeftLatch
				false, // insideRightLatch
				false, // outsideRightLatch
				"P"	   // gearshift
				));
		
		// doors being activated but masterUnlock not on:
		assertEquals("No door opens", Main.problem8_carDoorControl(
				false, // dashboardLeft
				false, // dashboardRight
				false, // childLock
				false,  // masterUnlock
				false, // insideLeftLatch
				true,  // outsideLeftLatch
				false, // insideRightLatch
				false, // outsideRightLatch
				"P"	   // gearshift
				));
		
		// doors being activated but masterUnlock not on:
		assertEquals("No door opens", Main.problem8_carDoorControl(
				false, // dashboardLeft
				false, // dashboardRight
				false, // childLock
				false,  // masterUnlock
				false, // insideLeftLatch
				false,  // outsideLeftLatch
				true, // insideRightLatch
				false, // outsideRightLatch
				"P"	   // gearshift
				));
		
		// doors being activated but gearshift not in park:
		assertEquals("No door opens", Main.problem8_carDoorControl(
				false, // dashboardLeft
				true, // dashboardRight
				false, // childLock
				false,  // masterUnlock
				false, // insideLeftLatch
				false,  // outsideLeftLatch
				false, // insideRightLatch
				false, // outsideRightLatch
				"D"	   // gearshift
				));
		
		// inside latch doors being activated but childLock on:
		assertEquals("No door opens", Main.problem8_carDoorControl(
				false, // dashboardLeft
				false, // dashboardRight
				true, // childLock
				true,  // masterUnlock
				true, // insideLeftLatch
				false,  // outsideLeftLatch
				false, // insideRightLatch
				false, // outsideRightLatch
				"P"	   // gearshift
				));
		
		// dashboard switch doors being activated with childLock on:
		assertEquals("Right door opens", Main.problem8_carDoorControl(
				false, // dashboardLeft
				true, // dashboardRight
				true, // childLock
				true,  // masterUnlock
				false, // insideLeftLatch
				false,  // outsideLeftLatch
				false, // insideRightLatch
				false, // outsideRightLatch
				"P"	   // gearshift
				));
		
		// both doors activated through dashboard:
		assertEquals("Both doors open", Main.problem8_carDoorControl(
				true, // dashboardLeft
				true, // dashboardRight
				false, // childLock
				true,  // masterUnlock
				false, // insideLeftLatch
				false,  // outsideLeftLatch
				false, // insideRightLatch
				false, // outsideRightLatch
				"P"	   // gearshift
				));
		
		// both doors activated through different means:
		assertEquals("Both doors open", Main.problem8_carDoorControl(
				false, // dashboardLeft
				false, // dashboardRight
				false, // childLock
				true,  // masterUnlock
				true, // insideLeftLatch
				false,  // outsideLeftLatch
				false, // insideRightLatch
				true, // outsideRightLatch
				"P"	   // gearshift
				));
	}
	
	@Test
	public void problem9() {
		// Test case 1
		String input = "ZIMBABWE";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem9_getFrenchName(new Scanner(System.in));
		String result = output.toString();
		assertEquals("Enter country name: " + "le ZIMBABWE",
				result);
		
		
		// Test case 2
		input = "Mexique";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem9_getFrenchName(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter country name: " + "le Mexique",
				result);
		
		
		// Test case 3
		input = "angola";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem9_getFrenchName(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter country name: " + "l'angola",
				result);
		
		
		// Test case 4
		input = "Etats-Unis";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem9_getFrenchName(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter country name: " + "les Etats-Unis",
				result);
		
		
		// Test case 5
		input = "pays-bas";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem9_getFrenchName(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter country name: " + "les pays-bas",
				result);
		
		
		// Test case 6
		input = "RN";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem9_getFrenchName(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter country name: " + "le RN",
				result);
		
		
		// Test case 7
		input = "re";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem9_getFrenchName(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter country name: " + "la re",
				result);
		
		
		// Test case 8
		input = "Oa";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem9_getFrenchName(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter country name: " + "l'Oa",
				result);
		
		
		// Test case 9
		input = "Belgique";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem9_getFrenchName(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter country name: " + "la Belgique",
				result);
	}
	
	
	@Test
	public void problem10() {
		// Test case 1:
		String input = "88.3 dB\n";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem10_getSoundLevel(new Scanner(System.in));
		String result = output.toString();
		assertEquals("Enter sound level and unit (dB or Pa): Normal conversation", result);
		
		
		// Test case 2:
		input = "0.001 dB\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem10_getSoundLevel(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter sound level and unit (dB or Pa): Light leaf rustling", result);
		
		
		// Test case 3:
		input = "0.049 Pa\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem10_getSoundLevel(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter sound level and unit (dB or Pa): Normal conversation", result);
		
		
		// Test case 4:
		input = "2.5 Pa\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem10_getSoundLevel(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter sound level and unit (dB or Pa): Jack hammer at 1 m", result);
		
		
		// Test case 5:
		input = "3233.33 dB\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem10_getSoundLevel(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter sound level and unit (dB or Pa): Threshold of pain", result);
		
		
		// Test case 6:
		input = "-0.045 m\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem10_getSoundLevel(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter sound level and unit (dB or Pa): Invalid unit and sound level", result);
		
		
		// Test case 7:
		input = "0.045 m\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem10_getSoundLevel(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter sound level and unit (dB or Pa): Invalid unit", result);
		
		
		// Test case 8:
		input = "-0.045 Pa\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem10_getSoundLevel(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter sound level and unit (dB or Pa): Invalid sound level", result);
	}

}

package labs.lab2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	/**
	 * A shop wants to reward its best customers with a discount based on the 
	 * customer's number of items bought (first parameter) and the number of new 
	 * customers referred by the customer (second parameter). The discount is in
	 * percents and is equal to the sum of the number of items purchased and the
	 * referrals, but it cannot exceed 75 percent. 
	 * 
	 * @param numItemsBought	number of items bought
	 * @param numClientsReferred	number of clients referred
	 * 
	 * @return	discount, in percents
	 */
	public static int problem1_getDiscount(int numItemsBought, int numClientsReferred) {
		final int MAX_DISCOUNT = 75;
		return (numItemsBought + numClientsReferred) < MAX_DISCOUNT ? (numItemsBought + numClientsReferred) : MAX_DISCOUNT;
//		return Math.min(numItemsBought + numClientsReferred, MAX_DISCOUNT); // FIX ME
	}
	
	
	/**
	 * Reads a number between 1,000 and 999,999 from the user and prints it with a 
	 * comma separating the thousands.
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem2_printWithCommas(new Scanner(System.in));
	 */
	public static void problem2_printWithCommas(Scanner in) {
		// FILL IN
		int input;
		String output = "";
		System.out.print("Please enter an integer between 1000 and 999999: ");
		input = in.nextInt();
		while (input > 0) {
			output = input % 10 + output;
			input /= 10;
			if (output.length() == 3)
				output = "," + output;
		}
		System.out.print(output);
	}
	
	
	/**
	 * Accepts an int as a parameter and returns a String that contains the 
	 * sequence of individual digits, each separated by one space. You may assume 
	 * that the input always has exactly five digits and is not negative.
	 * 
	 * @param number	the input number
	 * 
	 * @return	a String that contains the sequence of individual digits, each 
	 * separated by one space
	 */
	public static String problem3_printDigits(int number) {
		String result = "";
		while (number > 0) {
			result = number % 10 + result;
			number /= 10;
			if (number > 0 )
				result = " " + result;
		}
		return result; // FIX ME
	}
	
	
	/**
	 * Computes the total of a sticker order based on the price per sticker and number
	 * of stickers, which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problemr_compoundInterest(new Scanner(System.in));
	 */
	public static void problem5_compoundInterest(Scanner in) {
		DecimalFormat percent = new DecimalFormat("0.0#%");
		double principal;
		double rate;
		int numOfYears;
		int numOfCompound;
		double totalAmount;
		System.out.print("Enter principal amount: ");
		principal = in.nextDouble();
		System.out.print("Enter the annual rate of interest: ");
		rate = in.nextDouble();
		System.out.print("Enter the number of years the amount is invested: ");
		numOfYears = in.nextInt();
		System.out.print("Enter the number of times the interest is compounded per year: ");
		numOfCompound = in.nextInt();
		totalAmount = principal * Math.pow(1 + (rate / 100 / numOfCompound), numOfYears * numOfCompound);
		System.out.printf("$%.2f invested at %s for %d years compounded %d times annually is $%.2f.", principal, percent.format(rate / 100), numOfYears, numOfCompound, totalAmount);
	}
	
	
	/**
	 * Given three integers a, b, and c, one of them is small, one is medium, and
	 * one is large. Return true if the three values are evenly spaced, so the
	 * difference between small and medium is the same as the difference between
	 * medium and large.
	 * 
	 * @param a first integer
	 * @param b second integer
	 * @param c third integer
	 * 
	 * @return true if the three values are evenly space, false otherwise
	 */
	public static boolean problem6_evenlySpaced(int a, int b, int c) {
		int small = 0;
		int medium = 0;
		int large = 0;
		if (a >= b && a >= c) {
			large = a;
			if (b >= c) {
				medium = b;
				small = c;
			}
			else {
				medium = c;
				small = b;
			}
		}
		if (b >= a && b >= c) {
			large = b;
			if (a >= c) {
				medium = a;
				small = c;
			}
			else {
				medium = c;
				small = a;
			}
		}
		if (c >= a && c >= b) {
			large = c;
			if (a >= b) {
				medium = a;
				small = b;
			}
			else {
				medium = b;
				small = a;
			}
		}
		return (large - medium) == (medium - small); // FIX ME
	}
	
	
	/**
	 * 
	 * @param a first number
	 * @param b second number
	 * @param c third number
	 * @return true if one of b or c is "close" (differing from a by at most 1),
	 *         while the other is "far", differing from both other values by 2 or
	 *         more.
	 */
	public static boolean problem7_nearAndFar(int a, int b, int c) {
		if (Math.abs(a - b) <= 1) {
			return (Math.abs(a - c) > 1 && Math.abs(b - c) > 1);
		}
		if (Math.abs(a - c) <= 1) {
			return (Math.abs(a - b) > 1 && Math.abs(c - b) > 1);
		}
		if (Math.abs(b - c) <= 1) {
			return (Math.abs(b - a) > 1 && Math.abs(c - a) > 1);
		}
		return false; // FIX ME
	}
	
	
	/**
	 * 
	 * @param dashboardLeft
	 * @param dashboardRight
	 * @param childLock
	 * @param masterUnlock
	 * @param insideLeftLatch
	 * @param outsideLeftLatch
	 * @param insideRightLatch
	 * @param outsideRightLatch
	 * @param gearshift
	 * 
	 * @return "Left door opens", "Right door opens", "Both doors open",
	 * or "No door opens" as appropriate
	 */
	public static String problem8_carDoorControl(
			boolean dashboardLeft,
			boolean dashboardRight, 
			boolean childLock, 
			boolean masterUnlock,
			boolean insideLeftLatch, 
			boolean outsideLeftLatch, 
			boolean insideRightLatch,
			boolean outsideRightLatch, 
			String gearshift
			) {
		final String LEFT_OPEN = "Left door opens";
		final String RIGHT_OPEN = "Right door opens";
		final String BOTH_OPEN = "Both doors open";
		final String NOT_OPEN = "No door opens";
		final String PARK = "P";
		
		if (!masterUnlock || gearshift != PARK)
			return NOT_OPEN;
		
		if (!childLock) {
			if ((dashboardLeft || insideLeftLatch || outsideLeftLatch) && (dashboardRight || insideRightLatch || outsideRightLatch))
				return BOTH_OPEN;
			if (dashboardLeft || insideLeftLatch || outsideLeftLatch)
				return LEFT_OPEN;
			if (dashboardRight || insideRightLatch || outsideRightLatch)
				return RIGHT_OPEN;
		}
		
		if (childLock) {
			if ((dashboardLeft || outsideLeftLatch) && (dashboardRight || outsideRightLatch))
				return BOTH_OPEN;
			if (dashboardLeft || outsideLeftLatch)
				return LEFT_OPEN;
			if (dashboardRight || outsideRightLatch)
				return RIGHT_OPEN;
		}
		
		return NOT_OPEN; // FIX ME
	}
	
	
	/**
	 * Reads the French name of a country from the user and adds the article
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem9_getFrenchName(new Scanner(System.in));
	 */
	public static void problem9_getFrenchName(Scanner in) {
		// FILL IN
		final String VOWELS = "aeiou";
		final String[] EXCEPTIONS = {"Belize", "Cambodge", "Mexique", "Mozambique", "Zaire", "Zimbabwe"};
		String frenchName;
		
		System.out.print("Enter country name: ");
		frenchName = in.next();
		
		if (frenchName.equalsIgnoreCase("Etats-Unis") || frenchName.equalsIgnoreCase("Pays-Bas")) {
			System.out.print("les " + frenchName);
			return;
		}
		
		for (int i = 0; i < VOWELS.length(); ++i) {
			if (frenchName.toLowerCase().charAt(0) == VOWELS.charAt(i)) {
				System.out.print("l\'" + frenchName);
				return;
			}
		}
		
		for (int i = 0; i < EXCEPTIONS.length; ++i) {
			if (frenchName.equalsIgnoreCase(EXCEPTIONS[i])) {
				System.out.print("le " + frenchName);
				return;
			}
		}
		
		if (frenchName.charAt(frenchName.length() - 1) == 'e') {
			System.out.print("la " + frenchName);
			return;
		}
		
		System.out.print("le " + frenchName);
	}
	
	
	/**
	 * Reads a value and a unit (either dB or Pa) from the user, then prints a
	 * string indicating which sound level category the sound falls into.
	 * 
	 * When you print the formatted number, use print instead of println.
	 * 
	 * To run this method using the keyboard for user input, call it like this:
	 * problem10_getSoundLevel(new Scanner(System.in));
	 * 
	 * @param in the Scanner to be used for user input
	 */
	public static void problem10_getSoundLevel(Scanner in) {
		// FILL IN
		final double REFERENCE_SOUND_LEVEL = 20E-6;
		final String DECIBEL = "dB";
		final String PASCAL = "Pa";
		final String INVALID_UNIT = "Invalid unit";
		final String INVALID_SOUND_LEVEL = "Invalid sound level";
		final String INVALID_BOTH = "Invalid unit and sound level";
		final String[] SOUND_CATEGORIES = {"Light leaf rustling", "Calm library", "Normal conversation", "Traffic on a busy roadway at 10 m", "Jack hammer at 1 m", "Possible hearing damage", "Threshold of pain"};
		double soundLevel;
		String unit;
		
		System.out.print("Enter sound level and unit (dB or Pa): ");
		soundLevel = in.nextDouble();
		unit = in.next();
		
		if (soundLevel < 0 && !unit.equals(DECIBEL) && !unit.equals(PASCAL)) {
			System.out.print(INVALID_BOTH);
			return;
		}
		
		
		if (!unit.equals(DECIBEL) && !unit.equals(PASCAL)) {
			System.out.print(INVALID_UNIT);
			return;
		}
		
		if (soundLevel < 0) {
			System.out.print(INVALID_SOUND_LEVEL);
		}
		
		if (unit.equals(PASCAL)) {
			soundLevel = 20 * Math.log10(soundLevel / REFERENCE_SOUND_LEVEL);
		}


		if (soundLevel >= 130) {
			System.out.print(SOUND_CATEGORIES[6]);
		} else if (soundLevel >= 120 && soundLevel < 130) {
			System.out.print(SOUND_CATEGORIES[5]);
		} else if (soundLevel >= 100 && soundLevel < 120) {
			System.out.print(SOUND_CATEGORIES[4]);
		} else if (soundLevel >= 90 && soundLevel < 100) {
			System.out.print(SOUND_CATEGORIES[3]);
		} else if (soundLevel >= 60 && soundLevel < 90) {
			System.out.print(SOUND_CATEGORIES[2]);
		} else if (soundLevel >= 30 && soundLevel < 60) {
			System.out.print(SOUND_CATEGORIES[1]);
		} else if (soundLevel >= 0 && soundLevel < 30) {
			System.out.print(SOUND_CATEGORIES[0]);
		}

		if (soundLevel < 0) {
			System.out.print(INVALID_SOUND_LEVEL);
			return;
		}
		
	}
	
//	public static void printMiddle(String str) {
//
//		int mid = str.length() / 2;
//
//		System.out.println(str.substring(mid - 1, mid + 2));
//
//		}
	
	public static void main(String[] args) {
//		problem2_printWithCommas(new Scanner(System.in));
		
//		problem5_compoundInterest(new Scanner(System.in));
		problem10_getSoundLevel(new Scanner(System.in));

	}

}

package labs.lab1;

import java.awt.Rectangle;
import java.math.BigDecimal;
import java.util.Random;

public class Main {
	/**
	 * Given a string of even length, returns a string made of the middle two chars,
	 * so the string "string" yields "ri". The string length will be at least 2 and
	 * an even length.
	 *
	 * @param str the input string
	 *
	 * @return a string made of the middle two chars
	 */
	public static String problem1_middle(String str) {
		return str.substring(str.length() / 2 - 1, str.length() / 2 + 1); // FIX ME
	}

	/**
	 * Given a string, if one or both of the last 2 chars is 'x' (case-sensitive),
	 * return the string without those 'x' chars, otherwise return the string
	 * unchanged. The string can be any length, including 0.
	 *
	 * @param str the input string
	 *
	 * @return if one or both of the last 2 chars is 'x' (case-sensitive), the
	 *         string without those 'x' chars, otherwise the string unchanged.
	 */
	public static String problem2_removeChars(String str) {
		if (str.length() == 0)
			return str;
		else if (str.length() == 1) {
			if (str.charAt(0) == 'x')
				return "";
			else
				return str;
		}
		else if (str.length() == 2) {
			if (str.charAt(0) == 'x' && str.charAt(1) == 'x')
				return "";
			else if (str.charAt(0) == 'x')
				return str.substring(1);
			else if (str.charAt(1) == 'x')
				return str.substring(0, 1);
			else
				return str;
		}
		else {
			if (str.charAt(str.length() - 2) == 'x' && str.charAt(str.length() - 1) == 'x')
				str = str.substring(0, str.length() - 2);
			else if (str.charAt(str.length() - 2) == 'x')
				str = str.substring(0, str.length() - 2) + str.substring(str.length() - 1);
			else if (str.charAt(str.length() - 1) == 'x')
				str = str.substring(0, str.length() - 1);
			return str; // FIX ME			
		}
	}

	/**
	 * A method for a student who is taking a multiple-choice test and has not
	 * studied, so wants to choose all of their answers randomly. The method will
	 * take as parameters the number of possible choices for each question and
	 * return 10 answers as a string, with each answer separated by a space.
	 *
	 * @param numChoices number of possible choices for each question
	 *
	 * @return 10 answers as a string, with each answer separated by a space
	 */
	public static String problem3_chooseAnswers(int numChoices) {
		final int totalAnswers = 10;
		String answers = "";
		Random rand = new Random();
		for (int x = 0; x < totalAnswers; ++x) {
			answers = answers + (rand.nextInt(numChoices) + 1);
			if (x != 9)
				answers += " ";
		}
		return answers; // FIX ME
	}

	/**
	 * Given a Rectangle object that is a square (has 4 equal sides), applies the
	 * Rectangle.translate and Rectangle.grow methods to modify the square so that:
	 * 
	 * 1) its sides are each 10 units longer than the original, and 2) it has the
	 * same top-left corner as the original.
	 *
	 * Returns the new Rectangle (square).
	 *
	 * @param r the input Rectangle
	 *
	 * @return the Rectangle with its sides each 10 units longer than the original
	 *         and with the same top-left corner as the original
	 */
	public static Rectangle problem4_growSquare(Rectangle r) {
		r.grow(5, 5);
		r.translate(5, 5);
		return r; // FIX ME
	}

	/**
	 * The BigDecimal class represents decimal numbers with an arbitrary number of
	 * digits (the double and float types cannot express very high precision). Given
	 * a BigDecimal object and an integer, calculate a BigDecimal that is equal to
	 * the original BigDecimal raised to the power of the given integer. Then negate
	 * that number and return the result.
	 *
	 * See the BigDecimal class in the Java API docs.
	 *
	 * @param big   the original BigDecimal
	 * @param power the power to which to raise big
	 *
	 * @return big raised to the power of power, then negated
	 */
	public static BigDecimal problem5_bigPowerNegate(BigDecimal big, int power) {
		return big.pow(power).negate(); // FIX ME
	}
	
	public static void main(String[] args) {
		
	}
}

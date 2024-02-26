package labs.lab7;

public class Main {

	/**
	 * Given a string that contains a single pair of parentheses, compute recursively
	 * a new string made of only the parentheses and their contents, so "xyz(abc)123"
	 * yields "(abc)". You can assume that the string will always contain a single
	 * pair of parentheses, with the opening parenthesis appearing before the
	 * closing parenthesis.
	 * 
	 * @param str	the input string
	 * 
	 * @return	a new string made of only the parentheses and their contents
	 */
	public static String problem1_parenPart(String str) {
		if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
			return str;
		} else if (str.charAt(0) == '(') {
			return problem1_parenPart(str.substring(0, str.length() - 1));
		} else if (str.charAt(str.length() - 1) == ')') {
			return problem1_parenPart(str.substring(1));
		}
		
		return problem1_parenPart(str.substring(1, str.length() - 1)); // FIX ME
	}
	
	
	/**
	 * We'll say that a "double" in a string is two instances of a char, separated by a char. 
	 * So in "AxA", the A's make a double. Doubles can overlap, so "AxAxA" contains 3 doubles -- 2 for A and 1 for x. 
	 * This method recursively computes the number of doubles in the given string.
	 * 
	 * @param str	the string to check for doubles
	 * @return		the number of doubles in the given string
	 */
	public static int problem2_countDoubles(String str) {
		if (str.length() < 3) {
			return 0;
		}
		
		if (str.charAt(0) == str.charAt(2)) {
			return 1 + problem2_countDoubles(str.substring(1));
		}
		
		return problem2_countDoubles(str.substring(1)); // FIX ME
	}
	
	
	/**
	 * Given a string and a non-empty substring sub, compute recursively the number
	 * of times that sub appears in the string, without the sub-strings overlapping.
	 * 
	 * @param str the string in which to count occurrences of sub
	 * @param sub the substring to count
	 * 
	 * @return the number of times that sub appears in the string, without the sub
	 *         strings overlapping
	 */
	public static int problem3_countSubs(String str, String sub) {
		if (str.length() < 1 || str.length() < sub.length()) {
			return 0;
		}
		
		if (str.substring(0, sub.length()).equals(sub)) {
			return 1 + problem3_countSubs(str.substring(sub.length()), sub);
		}
		
		return problem3_countSubs(str.substring(1), sub); // FIX ME
	}
}





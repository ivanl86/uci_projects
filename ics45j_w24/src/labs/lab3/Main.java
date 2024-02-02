package labs.lab3;

public class Main {

	/**
	 * An uppercase 'E' in a string is "happy" if there is another uppercase 'E'
	 * immediately to its left or right. Returns true if all the E's in the given
	 * string are happy. (A string with no 'E' in it returns true.)
	 * 
	 * @param str
	 * @return whether or not all E's in the string are happy
	 */
	public static boolean problem1_EHappy(String str) {
		if (str.length() == 0)
			return true;
		
		if (str.length() == 1)
			return !(str.charAt(0) == 'E');
		
		if (str.length() == 2)
			return (str.charAt(0) == 'E' && str.charAt(1) == 'E');
		
		if (str.charAt(0) == 'E' && str.charAt(1) != 'E')
			return false;
		
		for (int  i = 1; i < str.length() - 1; ++i) {
			if (str.charAt(i) == 'E') {
				if (str.charAt(i - 1) != 'E' && str.charAt(i + 1) != 'E') {
					return false;
				}
			}
		}
		
		if (str.charAt(str.length() - 1) == 'E')
			return str.charAt(str.length() - 2) == 'E';
		
		return true; // FIX ME
	}
	
	
	/**
	 * Given a string, returns true if the number of appearances of "are"
	 * anywhere in the string is equal to the number of appearances of 
	 * "not" anywhere in the string (case sensitive).
	 * 
	 * @param str	the input strings
	 * 
	 * @return	true if the number of appearances of "are"
	 * anywhere in the string is equal to the number of appearances of 
	 * "not" anywhere in the string (case sensitive)
	 */
	public static boolean problem2_equalAreNot(String str) {
		final String ARE = "are";
		final String NOT = "not";
		int numOfAre = 0;
		int numOfNot = 0;
		
		for (int i = 0; i < str.length() - 2; ++i) {
			if (str.charAt(i) ==  'a') {
				if (str.substring(i, i + 3).equals(ARE))
					++numOfAre;
			}
			if (str.charAt(i) ==  'n') {
				if (str.substring(i, i + 3).equals(NOT))
					++numOfNot;
			}
		}
		
		return (numOfAre == numOfNot); // FIX ME
	}
	
	
	/**
	 * Given a string, return the sum of the digits 0-9 that appear in the string,
	 * ignoring all other characters. Return 0 if there are no digits in the string.
	 * (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1',
	 * .. '9'. Integer.parseInt(String) converts a string to an int.)
	 * 
	 * @param str the string from which to sum the digits
	 * @return the sum of the digits 0-9 that appear in the string
	 */
	public static int problem3_sum(String str) {
		int sum = 0;
		
		for (int i = 0; i < str.length(); ++i) {
			if (Character.isDigit(str.charAt(i))) {
				sum += Integer.parseInt(str.substring(i, i + 1));
			}
		}
		
		return sum; // FIX ME
	}
	
	
	/**
	 * Returns the minimum number of twists to unlock a lock, based on the starting
	 * and target values.
	 * 
	 * Assume input values will never start with 0 except for the case 0000.
	 * 
	 * @param starting	the current numbers of the lock
	 * @param target	the combination required to unlock the lock
	 * 
	 * @return	the minimum number of twists to unlock the lock
	 */
	public static int problem5_getNumTwists(int starting, int target) {
		final int FOUR_DIGIT = 4;
		int numOfTwists = 0;
		int lastStartingDigit = 0;
		int lastTargetDigit = 0;
		int down = 0;
		int up = 0;
		
		if (starting == target)
			return numOfTwists;
		
//		if (starting == 0) {
			for (int i = 0; i < FOUR_DIGIT; ++i) {
				lastStartingDigit = starting % 10;
				lastTargetDigit = target % 10;
				starting /= 10;
				target /= 10;
				if (lastStartingDigit > lastTargetDigit) {
					down = lastStartingDigit - lastTargetDigit;
					up = 10 + lastTargetDigit - lastStartingDigit;
				} else if (lastStartingDigit < lastTargetDigit) {
					up = lastTargetDigit - lastStartingDigit;
					down = 10 + lastStartingDigit - lastTargetDigit;
				}
				numOfTwists += (down < up) ? down : up;
				down = 0;
				up = 0;
			}
//		}
		
		return numOfTwists; // FIX ME
	}
	
	
	/**
	 * Takes an array of ints and returns an array that contains the exact same numbers 
	 * as the given array, but rearranged so that all the even numbers come before all
	 * the odd numbers
	 * 
	 * @param nums	the input array
	 * 
	 * @return	the rearranged array with all even numbers coming before all odd numbers
	 */
	public static int[] problem6_evenOdd(int[] nums) {
		int temp;
		int start = 0;
		int end = nums.length - 1;
		
		if (nums.length < 2)
			return nums;
		
		while (end >= 0 && nums[end] % 2 == 1) {
			--end;
		}
		
		while (start < end) {
			if (nums[start] % 2 == 1) {
				temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
			}
			++start;
			
			while (nums[end] % 2 == 1) {
				--end;
			}
		}
		
		return nums; // FIX ME
	}
	
	
	/**
	 * Say that a "clump" in an array is a series of 2 or more adjacent elements of
	 * the same value. Return the number of clumps in the given int array.
	 * 
	 * @param nums the input array
	 * 
	 * @return the number of clumps in the input array
	 */
	public static int problem7_countClumps(int[] nums) {
		int i = 0;
		int clumps = 0;
		if (nums.length < 2)
			return clumps;
		
		while (i < nums.length - 1) {
			if (nums[i] == nums[i + 1]) {
				++clumps;
				while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
					++i;
				}
			} else {
				++i;
			}
		}
		
		return clumps; // FIX ME
	}
	
	public static void main(String[] args) {
        
	}
}





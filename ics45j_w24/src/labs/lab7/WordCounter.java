package labs.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * A program that reads text from a file and breaks it up into individual words,
 * inserts the words into a tree set, and allows you to get stats about the
 * words.
 */
public class WordCounter {
	private TreeSet<String> uniqueWords;
	// FILL IN ANY OTHER PRIVATE INSTANCE VARIABLES YOU NEED HERE
	private int wordCount;

	/**
	 * Constructor
	 * 
	 * @param filename file from which to read words
	 */
	public WordCounter(String filename) {
		// FILL IN
		uniqueWords = new TreeSet<>();
		wordCount = 0;
		
		try (Scanner input = new Scanner(new File(filename))) {
			while (input.hasNextLine()) {
				String[] words = input.nextLine().toLowerCase().split("[\\s,]+", -1);
				for (int i = 0; i < words.length; ++i) {
					if (!words[i].equals("")) {
						uniqueWords.add(words[i].trim().replaceAll("\\p{Punct}", ""));
						++wordCount;
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.print(String.format("File: %s not found", filename));
		}
		
	}


	/**
	 * Returns the number of unique words in the file
	 * 
	 * @return number of unique words
	 */
	public int getNumUniqueWords() {
		return uniqueWords.size(); // FIX ME
	}


	/**
	 * Returns the number of words in the file
	 * 
	 * @return number of words
	 */
	public int getNumWords() {
		return wordCount; // FIX ME
	}


	/**
	 * returns a list of the unique words with all non-letter and non-digit
	 * characters removed, all in lower case, as a List in alphabetical order
	 * 
	 * @return list of unique words
	 */
	public List<String> getUniqueWords() {
		return new ArrayList<String>(uniqueWords); // FIX ME
	}
	
//	public static void main(String[] args) {
//		WordCounter wc1 = new WordCounter("res/test1.txt");
//		List<String> test = wc1.getUniqueWords();
//		
//		System.out.println(wc1.getNumUniqueWords());
//		System.out.println(wc1.getNumWords());
//		
//		for (String s : test) {
//			System.out.print(s + " ");
//		}
//	}
}





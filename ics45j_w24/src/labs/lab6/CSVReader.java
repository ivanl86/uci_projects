package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Class to read and process the contents of a standard CSV file
 */
public class CSVReader {
	// ADD YOUR INSTANCE VARIABLES HERE
	private List<String> lines;
	private String[][] words;

	/**
	 * Constructor opens the input file and stores each line in a list of Strings.
	 * 
	 * @param fileName the name of the csv file to be processed
	 */
	public CSVReader(String fileName) {
		// FILL IN
		lines = new ArrayList<>();
		
		try (Scanner input = new Scanner(new File(fileName))) {
			while (input.hasNextLine()) {
				lines.add(input.nextLine());
			}
			
			input.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File: " + fileName + " not found");
		}
		
		getWords();
		
	}

	/**
	 * Returns the number of lines in the CSV file
	 * 
	 * @return the number of rows (lines) in the file
	 */
	public int getNumberOfRows() {
		return lines.size(); // FIX ME
		
	}

	/**
	 * Returns the number of fields in a particular row
	 * 
	 * @param row the line number (0 <= row < number of lines)
	 * @return the number of fields in the given row
	 */
	public int getNumberOfFields(int row) throws IllegalArgumentException {
//		String[] words;
		if (row < 0 || row >= words.length) {
			throw new IllegalArgumentException();
		}

		return words[row].length; // FIX ME
	}

	/**
	 * Extract fields from a String corresponding to the row number given as
	 * argument. Handles fields surrounded by quotes.
	 * 
	 * @param row the line number (0 <= row < number of lines)
	 * @return a list of fields in the given row
	 */
	public List<String> getFields(int row) {
//		String[] words;
		if (row < 0 || row >= words.length) {
			throw new IllegalArgumentException();
		}
	
		return Arrays.asList(words[row]); // FIX ME
	}

	/**
	 * Returns the field in a particular row and column
	 * 
	 * @param row    the line number (0 <= row < number of lines)
	 * @param column the column number (0 <= row < number of columns in row)
	 * @return the field in the given row and column
	 */
	public String getField(int row, int column) throws IllegalArgumentException {
		if (row < 0 || row >= words.length || column < 0 || column >= words[row].length) {
			throw new IllegalArgumentException();
		}
		
		return words[row][column]; // FIX ME
	}
	
	private void getWords() {
		words = new String[lines.size()][];
		
		for (int i = 0; i < lines.size(); ++i) {
			words[i] = lines.get(i).split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			
			for (int j = 0; j < words[i].length; ++j) {
				if (words[i][j].charAt(0) == '"' && words[i][j].charAt(words[i][j].length() - 1) == '"') {
					words[i][j] = words[i][j].substring(1, words[i][j].length() - 1);
				}
				
				if (words[i][j].contains("\"\"")) {
					words[i][j] = words[i][j].replaceAll("\"\"", "\"");
				}
			}
		}
	}
	
}





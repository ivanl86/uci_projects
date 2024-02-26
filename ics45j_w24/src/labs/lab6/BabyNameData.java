package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * A set of baby name data ranking the most popular baby names in the U.S. in a
 * particular year
 */
public class BabyNameData {

	// ADD YOUR INSTANCE VARIABLES HERE
	List<BabyName> babyNames;

	/**
	 * Constructor that creates this object with data from a file
	 * 
	 * @param babyNamesFileName name of input file
	 */
	public BabyNameData(String babyNamesFileName) {
		// FILL IN
		babyNames = new ArrayList<>();
		
		try (Scanner inputFile = new Scanner(new File(babyNamesFileName))) {
			while (inputFile.hasNext()) {
				int rank = inputFile.nextInt();
				String name = inputFile.next();
				int count = inputFile.nextInt();
				double percent = inputFile.nextDouble();
				
				babyNames.add(new BabyName(name, rank, count, percent));
				
				name = inputFile.next();
				count = inputFile.nextInt();
				percent = inputFile.nextDouble();
				
				babyNames.add(new BabyName(name, rank, count, percent));
			}
		} catch (FileNotFoundException e) {
			System.out.printf("File: %s not found", babyNamesFileName);
		}
	}


	/**
	 * 
	 * @return all girl names (in a non-specific order)
	 */
	public List<String> getAllGirlNames() {
		List<String> girlNames = new ArrayList<>();
		
		for (int i = 1; i < babyNames.size(); i += 2) {
			girlNames.add(babyNames.get(i).getName());
		}
		
		return girlNames; // FIX ME
	}


	/**
	 * 
	 * @return all boy names (in a non-specific order)
	 */
	public List<String> getAllBoyNames() {
		List<String> boyNames = new ArrayList<>();
		
		for (int i = 0; i < babyNames.size(); i += 2) {
			boyNames.add(babyNames.get(i).getName());
		}
		
		return boyNames; // FIX ME
	}


	/**
	 * 
	 * @return all names that appear in the data for both boys and girls (in a
	 *         non-specific order)
	 */
	public List<String> getAllNonGenderSpecificNames() {
		List<String> girlNames = getAllGirlNames();
		List<String> boyNames = getAllBoyNames();
		List<String> nonSpecificNames = new ArrayList<>();
		
		for (int i = 0; i < girlNames.size(); ++i) {
			if (boyNames.contains(girlNames.get(i))) {
				nonSpecificNames.add(girlNames.get(i));				
			}
		}
		
		return nonSpecificNames; // FIX ME
	}


	/**
	 * 
	 * @param rank
	 * @return the girl name at the rank specified
	 * 
	 *         If rank is out of the range of data, throw an
	 *         IllegalArgumentException with the message "Rank [rank] out of range
	 *         of data"
	 */
	public String getGirlNameAtRank(int rank) throws IllegalArgumentException {
		if (rank < 0 || rank >= babyNames.size()) {
			throw new IllegalArgumentException("Rank " + rank + " out of range of data");
		}
		
		for (int i = 1; i < babyNames.size(); i += 2) {
			if (babyNames.get(i).getRank() == rank) {
				return babyNames.get(i).getName();
			}
		}
		
		return ""; // FIX ME
	}


	/**
	 * 
	 * @param rank
	 * @return the boy name at the rank specified
	 * 
	 *         If rank is out of the range of data, throw an
	 *         IllegalArgumentException with the message "Rank [rank] out of range
	 *         of data"
	 */
	public String getBoyNameAtRank(int rank) {
		if (rank < 0 || rank >= babyNames.size()) {
			throw new IllegalArgumentException("Rank " + rank + " out of range of data");
		}
		
		for (int i = 0; i < babyNames.size(); i += 2) {
			if (babyNames.get(i).getRank() == rank) {
				return babyNames.get(i).getName();
			}
		}
		
		return ""; // FIX ME
	}
	
//	public static void main(String[] args) {
//		BabyNameData data = new BabyNameData("res/babynames1.txt");
//	}
}

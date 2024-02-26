package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Holds airport data from a file and provides a query for getting all
 * the airports in a city
 */
public class AirportData {

	// ADD YOUR INSTANCE VARIABLES HERE
	private static final int SECOND = 1;
	private static final int THIRD = 2;
	private List<String> airportNames;
	private List<String> cityNames;

	
	/**
	 * Constructor that creates an AirportData object using the specified data file
	 * 
	 * @param dataFileName	data file name
	 */
	public AirportData(String dataFileName) {
		// FILL IN
		airportNames = new ArrayList<>();
		cityNames = new ArrayList<>();
		
		try (Scanner scan = new Scanner(new File(dataFileName))) {
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] words = line.split(",");
				airportNames.add(words[SECOND].replaceAll("\"", ""));
				cityNames.add(words[THIRD].replaceAll("\"", ""));
			}
		} catch(FileNotFoundException e) {
			System.out.println("File: " + dataFileName + " not found");
		}
	}

	
	/**
	 * 
	 * @param cityName city name
	 * 
	 * @return a list of all airport names in the given city
	 */
	public List<String> getAllAirportsInCity(String cityName) {
		List<String> names = new ArrayList<>();
		for (int i = 0; i < cityNames.size(); ++i) {
			if (cityNames.get(i).equals(cityName)) {
				names.add(airportNames.get(i));
			}
		}
		
		return names; // FIX ME
	}
	
}





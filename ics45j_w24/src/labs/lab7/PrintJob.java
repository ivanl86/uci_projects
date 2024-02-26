package labs.lab7;

import java.util.AbstractMap;
import java.util.Map;

/**
 * Class for creating a priority print queue.
 */
public class PrintJob implements Comparable<Object> {
	// ADD YOUR INSTANCE VARIABLES HERE
	private static Map<String, Integer> empolyeePriority = Map.ofEntries(
			new AbstractMap.SimpleEntry<String, Integer>("CEO", 1),
			new AbstractMap.SimpleEntry<String, Integer>("Vice-President", 2),
			new AbstractMap.SimpleEntry<String, Integer>("Executive-Manager", 3),
			new AbstractMap.SimpleEntry<String, Integer>("Manager", 4),
			new AbstractMap.SimpleEntry<String, Integer>("Senior-Associate", 5),
			new AbstractMap.SimpleEntry<String, Integer>("Associate", 6),
			new AbstractMap.SimpleEntry<String, Integer>("Junior-Associate", 7),
			new AbstractMap.SimpleEntry<String, Integer>("Clerical", 8),
			new AbstractMap.SimpleEntry<String, Integer>("Intern", 9),
			new AbstractMap.SimpleEntry<String, Integer>("Volunteer", 10)
			);
	private String employeeType;
	private String description;
	private int priorityLevel;
	

	/**
	 * Constructor.
	 * 
	 * @param employeeType   The type of employee requesting the print job
	 * @param description    The description of the print job.
	 */
	public PrintJob(String employeeType, String description) {
		// FILL IN
		this.employeeType = employeeType;
		this.description = description;
		priorityLevel = empolyeePriority.get(employeeType);
	}

	public int getPriority() {
		// FILL IN
		return priorityLevel; // FIX ME
	}

	public String getEmployeeType() {
		// FILL IN
		return employeeType; // FIX ME
	}
	
	public String getDescription() {
		// FILL IN
		return description; // FIX ME
	}

	@Override
	public int compareTo(Object otherObject) {
		// FILL IN
		if (priorityLevel < ((PrintJob) otherObject).priorityLevel) {
			return -1;
		} else if (priorityLevel > ((PrintJob) otherObject).priorityLevel) {
			return 1;
		}
		return 0; // FIX ME
	}
	
}





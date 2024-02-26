package labs.lab7;

import java.util.PriorityQueue;

public class Printer {
	private PriorityQueue<PrintJob> jobs;

	/**
	 * Constructor
	 */
	public Printer() {
		// FILL IN
		jobs = new PriorityQueue<>();
	}

	/**
	 * adds a new print job with the given employee type and description to the queue
	 * 
	 * @param employeeType
	 * @param description
	 */
	public void addJob(String employeeType, String description) {
		// FILL IN
		jobs.add(new PrintJob(employeeType, description));
	}

	/**
	 * Get the next most urgent priority job; if two jobs have the same priority,
	 * return either one
	 */
	public PrintJob nextJob() {
		return jobs.poll(); // FIX ME
	}
}
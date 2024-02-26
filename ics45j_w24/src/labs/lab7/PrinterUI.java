package labs.lab7;

import java.util.Scanner;

/**
 * Class for creating a priority print queue UI.
 */
public class PrinterUI {
	private Printer printQueue;

	/**
	 * Constructor
	 */
	public PrinterUI() {
		printQueue = new Printer();
	}

	/**
	 * Display a menu and accepts commands.
	 */
	public void run() {
		String option = "";
		System.out.println("Printer - Please enter an option");
		System.out.println("  add employeeType description (add a new print job)");
		System.out.println("  next (remove and print most urgent print job)");
		System.out.println("  quit (exit this program)");
		System.out.println();

		Scanner in = new Scanner(System.in);

		do {
			System.out.print("> ");
			option = in.nextLine();
			if (option.startsWith("add")) {
				addJob(option);
			} else if (option.equals("next")) {
				nextJob();
			}
		} while (!option.equals("quit"));
	}

	/**
	 * Parse the add option line.
	 * 
	 * @param optionStr the option line
	 */
	public void addJob(String optionStr) {
		Scanner sin = new Scanner(optionStr);
		sin.next(); // throw away the 'add' part
		if (sin.hasNext()) // next part must be employeeType
		{
			String employeeType = sin.next();
			if (isValidEmployeeType(employeeType)) {
				String description = sin.nextLine().trim();
				printQueue.addJob(employeeType, description);
			} else {
				System.out.println("Invalid employee type");
			}
		} else {
			System.out.println("Use 'add employeeType description' to add a task.");
		}
	}

	/**
	 * Get the next highest priority print job and display the description to the user.
	 */
	public void nextJob() {
		PrintJob next = printQueue.nextJob();
		if (next == null) {
			System.out.println("There are no tasks in the list.");
		} else {
			System.out.println(next.getEmployeeType() + " " + next.getDescription());
		}
	}
	
	private boolean isValidEmployeeType(String s) {
		return s.equals("CEO") || 
				s.equals("Vice-President") ||
				s.equals("Executive-Manager") ||
				s.equals("Manager") ||
				s.equals("Senior-Associate") ||
				s.equals("Associate") ||
				s.equals("Junior-Associate") ||
				s.equals("Clerical") ||
				s.equals("Intern") ||
				s.equals("Volunteer");
	}
	
	public static void main(String[] args) {
		PrinterUI ui = new PrinterUI();
		ui.run();
	}
}
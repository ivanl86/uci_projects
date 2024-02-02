package labs.lab5;

/**
 * A person in the Pest game
 */
public abstract class Person implements Comparable {
	private String name;

	
	/**
	 * Constructor
	 * 
	 * @param name	name of person
	 */
	public Person(String name) {
		// FILL IN
		this.name = name;
	}

	
	public String getName() {
		return name; // FIX ME
	}

	
	/**
	 * Compares Persons by name, lexicographically
	 */
	public int compareTo(Object otherPerson) {
		return this.name.compareTo(((Person) otherPerson).getName()); // FIX ME
	}
}
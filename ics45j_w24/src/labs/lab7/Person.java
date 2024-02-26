package labs.lab7;

/**
 * A person.
 */
public class Person implements Comparable<Object> {
	// ADD YOUR INSTANCE VARIABLES HERE
	private int id;
	private String name;

	/**
	 * Construct a Person object.
	 * 
	 * @param aName the name of the person
	 */
	public Person(int id, String name) {
		// FILL IN
		this.id = id;
		this.name = name;
	}

	/**
	 * Compares Person objects by name
	 */
	@Override
	public int compareTo(Object otherObject) {
		if (name.compareTo(((Person) otherObject).name) < 0) {
			return -1;
		}
		
		if (name.compareTo(((Person) otherObject).name) > 0) {
			return 1;
		}
		
		return 0; // FIX ME
	}

	/**
	 * Gets the name of the person.
	 * 
	 * @return the name of the person
	 */
	public String getName() {
		return name; // FIX ME
	}
	
	/**
	 * Gets the id of the person
	 * 
	 * @return	the id of the person
	 */
	public int getId() {
		return id; // FIX ME
	}
}

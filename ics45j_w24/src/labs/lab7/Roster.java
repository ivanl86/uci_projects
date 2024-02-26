package labs.lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class maintains a roster of Persons
 */
public class Roster {
	// ADD YOUR INSTANCE VARIABLES EHRE
	private List<Person> personList;
	
	/**
	 * Constructs an empty Roster
	 */
	public Roster() {
		// FILL IN 
		personList = new ArrayList<>();
	}
	
	
	/**
	 * Adds a Person with the given id and name to the roster
	 * 
	 * @param id
	 * @param name
	 */
	public void addPerson(int id, String name) {
		// FILL IN
		personList.add(new Person(id, name));
	}
	
	
	/**
	 * if a Person with the given name is found, removes all
	 * Persons with this name from the roster and returns true; if
	 * not found, returns false.
	 * 
	 * @param name	name of person to remove
	 * 
	 * @return	true if person was found, otherwise false
	 */
	public boolean removePerson(String name) {
		boolean isRemoved = false;
		
		for (int i = 0; i < personList.size(); ++i) {
			if (personList.get(i).getName().equals(name)) {
				personList.remove(i);
				isRemoved = true;
			}
		}
		
		return isRemoved; // FIX ME
	}
	
	
	/**
	 * if a Person with the given id is found, removes all
	 * Persons with this id from the roster and returns true; if
	 * not found, returns false.
	 * 
	 * @param id	id of person to remove
	 * 
	 * @return	true if person was found, otherwise false
	 */
	public boolean removePerson(int id) {
		boolean isRemoved = false;
		
		for (int i = 0; i < personList.size(); ++i) {
			if (personList.get(i).getId() == id) {
				personList.remove(i);
				isRemoved = true;
			}
		}
		
		return isRemoved; // FIX ME;
	}
	
	
	/**
	 * if a Person with the given name is found, returns the
	 * first Person found with this name; if not found, returns null
	 * 
	 * @param name	name of person to find
	 * 
	 * @return	person if found, otherwise null
	 */
	public Person findPerson(String name) {
		for (int i = 0; i < personList.size(); ++i) {
			if (personList.get(i).getName().equals(name)) {
				return personList.get(i);
			}
		}
		
		return null; // FIX ME
	}
	
	
	/**
	 * if a Person with the given id is found, returns the
	 * first Person found with this id; if not found, returns null
	 * 
	 * @param id	id of person to find
	 * 
	 * @return	person if found, otherwise null
	 */
	public Person findPerson(int id) {
		for (int i = 0; i < personList.size(); ++i) {
			if (personList.get(i).getId() == id) {
				return personList.get(i);
			}
		}
		
		return null; // FIX ME
	}
	
	
	/**
	 * returns a String containing the names of all Persons in the
	 * roster, in ascending lexicographic order, with a space in
	 * between each name
	 * 
	 * @return
	 */
	public String getNamesInAlphaOrder() {
		String namesInAlphaOrder = "";

		Collections.sort(personList);
		
		for (int i = 0; i < personList.size(); ++i) {
			namesInAlphaOrder += personList.get(i).getName() + " ";
		}
		
		return namesInAlphaOrder.trim(); // FIX ME
	}
	
//	public static void main(String[] args) {
//		Person p1 = new Person(1, "John");
//		Person p2 = new Person(2, "Emily");
//		if (p1.compareTo(p2) == 1) {
//			System.out.println("It works correctly");
//		} else {
//			System.out.println("It doesn't work");
//		}
//		System.out.println(p1.compareTo(p2));
//		System.out.println(p1.getName().compareTo(p2.getName()));
//	}
}

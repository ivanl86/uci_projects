package labs.lab5;

/**
 * Test class for Comparable Student objects.
 */
public class StudentFinder {

	/**
	 * Determines first student in a non-empty array of Student objects.
	 * 
	 * @param students array of Student objects
	 * @return first Student
	 */
	public static Student firstStudent(Student[] students) {
		Student first = null;
		
		if (students == null) {
			return null;
		}
		
		first = students[0];
		
		for (int i = 1; i < students.length; ++i) {
			if (first.compareTo(students[i]) > 0) {
				first = students[i];
			}
		}
		
		return first; // FIX ME
	}


	/**
	 * Determines last student in a non-empty array of Student objects.
	 * 
	 * @param students array of Student objects
	 * @return last Student
	 */
	public static Student lastStudent(Student[] students) {
		Student last = null;
		
		if (students == null) {
			return null;
		}
		
		last = students[0];
		
		for (int i = 1; i < students.length; ++i) {
			if (last.compareTo(students[i]) < 0) {
				last = students[i];
			}
		}
		
		return last; // FIX ME
	}

}

package labs.lab8;

import java.util.Iterator;

public class IterableUtil {

	/**
	 * Takes as input any object that implements the Iterable<E> interface and returns 
	 * a string containing the object's elements, each one separated by a comma and a 
	 * space
	 * 
	 * @param <T>	type of object that implements Iterable
	 * @param <E>
	 * @param <E>	the Iterable type
	 * @param iterable	the object that is Iterable
	 * 
	 * @return	a string containing the object's elements, each one separated by a 
	 * comma and a space
	 */
	// WRITE YOUR PRINT METHOD HERE
	public static <T extends Iterable<E>, E> String print(T arr) {
		String str = "";
		Iterator<E> iter = arr.iterator();
		
		while (iter.hasNext()) {
			str += iter.next() + ", ";
		}
		
		if (str.length() == 0) {
			return str;
		}
		
		return str.substring(0, str.length() - 2);
	}
}

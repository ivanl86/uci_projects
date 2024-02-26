package labs.lab8;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	
	
	/**
	 * Given a Map<K, V>, as a parameter, returns a List<Pair<K, V>> of the 
	 * key/value pairs in the map
	 * 
	 * @param <K>	type of the key
	 * @param <V>	type of the value
	 * @param map	input map
	 * 
	 * @return	a List<Pair<K, V>> of the  key/value pairs in the map
	 */
	// WRITE YOUR PROBLEM 1 METHOD HERE
	public static List<Pair<String, Color>> problem1_mapToList(Map<String, Color> colors) {
		// TODO Auto-generated method stub
		List<Pair<String, Color>> list = new ArrayList<>();
		Iterator<String> iter = colors.keySet().iterator();
		
		while (iter.hasNext()) {
			String name = iter.next();
			list.add(new Pair<String, Color>(name, colors.get(name)));
		}
		
		return list;
	}
	
	
	/**
	 * Takes a Pair, swaps the two elements, and returns it
	 * @param <T>
	 * 
	 * @param <T>	type of the first element in the pair
	 * @param <S>	type of the second element in the pair
	 * @param p		the pair to swap
	 * 
	 * @return		the swapped pair
	 */
	// WRITE YOUR PROBLEM 2 METHOD HERE
	public static <S, T> Pair<S, T> problem2_swap(Pair<T, S> pair) {
		return new Pair<S, T>(pair.getSecond(), pair.getFirst());
	}
	
	
	/**
	 * Takes a generic list and returns true if it its elements are in decreasing
	 * order, or false if not. Decreasing order in this case means non-increasing,
	 * so there can be multiple equivalent elements next to each other (e.g., 4, 2,
	 * 2, 0) and it will still be considered decreasing.
	 * 
	 * @param <T> the type of element in the list
	 * @param a   the list to check for decreasing order
	 * 
	 * @return true if decreasing, false if not
	 */
	// WRITE PROBLEM 4 METHOD HERE
	public static <T> boolean problem4_isDecreasing(List<T> list) {
		for (int i = 0; i < list.size() - 1; ++i) {
			if (((Comparable<T>) list.get(i)).compareTo(list.get(i + 1)) < 0) {
				return false;
			}
		}
		
		return true;
	}
}

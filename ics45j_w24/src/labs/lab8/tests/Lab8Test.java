package labs.lab8.tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.junit.Test;

import labs.lab8.*;


public class Lab8Test {
	
	private final double EPSILON = 1e-3;

    @Test
    public void problem1() {
        Map<String, Color> colors = new TreeMap<>();
        colors.put("Juliet", Color.BLUE);
        colors.put("Adam", Color.RED);
        colors.put("Eve", Color.BLUE);
        List<Pair<String, Color>> list = Main.problem1_mapToList(colors);
        Iterator<Pair<String, Color>> iter = list.iterator();
        Pair<String, Color> item = iter.next();
        assertEquals("Adam", item.getFirst());
        assertEquals(Color.RED, item.getSecond());
        item = iter.next();
        assertEquals("Eve", item.getFirst());
        assertEquals(Color.BLUE, item.getSecond());
    }
    
    @Test
    public void problem2() {
        Pair<String, Integer> p = new Pair<>("Lucky Number", 13);
        Pair<Integer, String> q = Main.problem2_swap(p);
        assertEquals(13, q.getFirst().intValue());
        assertEquals("Lucky Number", q.getSecond());

        Pair<Double, Boolean> r = new Pair<>(8.5, false);
        Pair<Boolean, Double> s = Main.problem2_swap(r);
        assertFalse(s.getFirst());
        assertEquals(8.5, s.getSecond().doubleValue(), EPSILON);
    }
    
	@Test
	public void problem3() {
		String sentence = "Mary had a little lamb";
		Iterable<String> it = Arrays.asList(sentence.split(" "));
		assertEquals("Mary, had, a, little, lamb", IterableUtil.print(it));

		EnumSet<Injury> set = EnumSet.allOf(Injury.class);
		assertEquals("SEIZURE, HEMORRHAGE, CHEST_PAIN, BURN, FRACTURE, ABDOMINAL_PAIN, OTHER", IterableUtil.print(set));

		Queue<Integer> q = new LinkedList<>();
		q.add(5);
		q.add(6);
		q.add(2);
		q.add(33);
		q.add(1000);
		q.add(0);
		q.add(-2);
		assertEquals("5, 6, 2, 33, 1000, 0, -2", IterableUtil.print(q));

		List<Integer> nums = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 });
		assertEquals("1, 2, 3, 4, 5", IterableUtil.print(nums));
	}
	
	@Test
	public void problem4() {
		List<String> a = new ArrayList<>();
		a.add("cupcake");
		a.add("banana");
		a.add("apple");
		assertTrue(Main.problem4_isDecreasing(a));

		a.set(2, "Apple");
		assertTrue(Main.problem4_isDecreasing(a));

		a.set(0, "Cupcake");
		assertFalse(Main.problem4_isDecreasing(a));

		a.set(1, "Cupcake");
		a.set(2, "Cupcake");
		assertTrue(Main.problem4_isDecreasing(a));

		List<String> b = new ArrayList<>();
		b.add("banana");
		b.add("pear");
		assertFalse(Main.problem4_isDecreasing(b));

		List<Integer> c = new ArrayList<>();
		for (int i = 0; i < 10; i += 2)
			c.add(i);
		assertFalse(Main.problem4_isDecreasing(c));

		List<Integer> d = new ArrayList<>();
		for (int i = 10; i >= 0; i -= 2)
			d.add(i);
		assertTrue(Main.problem4_isDecreasing(d));

		d.set(2, d.get(2) + 2);
		assertTrue(Main.problem4_isDecreasing(d));

		d.set(2, d.get(2) * 2);
		assertFalse(Main.problem4_isDecreasing(d));
		
		List<Double> e = new ArrayList<>();
		for (double i = 0; i < 10; i += 2.5)
			e.add(i);
		assertFalse(Main.problem4_isDecreasing(e));
		
		List<Double> f = new ArrayList<>();
		for (double i = 10; i >= 0; i -= 2.5)
			f.add(i);
		assertTrue(Main.problem4_isDecreasing(f));

		f.set(2, f.get(2) + 2.0);
		assertTrue(Main.problem4_isDecreasing(f));

		f.set(2, f.get(2) * 2);
		assertFalse(Main.problem4_isDecreasing(f));
		
		List<String> g = new ArrayList<>();
		assertTrue(Main.problem4_isDecreasing(g));
		
		g.add("Robert");
		assertTrue(Main.problem4_isDecreasing(g));
	}
	
    @Test
    public void problem5() {
		String[] words = { "Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliet",
				"Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform",
				"Victor", "Whiskey", "X-Ray", "Yankee", "Zulu" };
		BinarySearcher<String> strSearcher = new BinarySearcher<>(words);
		assertEquals(13, strSearcher.search("November"));
		assertEquals(-1, strSearcher.search("October"));
		assertEquals(0, strSearcher.search("Alpha"));
		assertEquals(25, strSearcher.search("Zulu"));

		Integer[] ints = { 3, 4, 8, 13, 15, 28, 45, 46, 80, 95, 110, 112, 113, 2000, 28938 };
		BinarySearcher<Integer> intSearcher = new BinarySearcher<>(ints);
		assertEquals(-1, intSearcher.search(-8));
		assertEquals(7, intSearcher.search(46));
		assertEquals(-1, intSearcher.search(-3));
		assertEquals(0, intSearcher.search(3));
		assertEquals(1, intSearcher.search(4));
		assertEquals(14, intSearcher.search(28938));
		assertEquals(13, intSearcher.search(2000));

		Double[] dbls = { -10.22, -9.0, -3.229, 0.0, 4.4, 18.2, 99.003, 101.0, 283.88978, 329.0, 444003.1, 500999.882,
				278397483.3 };
		BinarySearcher<Double> dblSearcher = new BinarySearcher<>(dbls);
		assertEquals(-1, dblSearcher.search(4.0));
		assertEquals(-1, dblSearcher.search(9.0));
		assertEquals(3, dblSearcher.search(0.0));
		assertEquals(7, dblSearcher.search(101.0));
		assertEquals(8, dblSearcher.search(283.88978));
    }
    
	
	private enum Injury {

		SEIZURE, HEMORRHAGE, CHEST_PAIN, BURN, FRACTURE, ABDOMINAL_PAIN, OTHER;

		
		// maps injuries to triage levels:
		private static final Map<Injury, Integer> triageTable = new HashMap<>();

		
		// This is called a static initialization block, and it is used to initialize static variables.
		// These statements are executed once when the class is loaded.
		// See p. 290 of the textbook, or google for more info
		static {
			triageTable.put(Injury.SEIZURE, 1);
			triageTable.put(Injury.HEMORRHAGE, 1);
			triageTable.put(Injury.CHEST_PAIN, 2);
			triageTable.put(Injury.BURN, 2);
			triageTable.put(Injury.FRACTURE, 3);
			triageTable.put(Injury.ABDOMINAL_PAIN, 3);
			triageTable.put(Injury.OTHER, 4);
		}
	}

}

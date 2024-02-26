package labs.lab7.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import labs.lab7.*;


public class Lab7Test {

	@Test
	public void problem1() {
		assertEquals("(abc)", Main.problem1_parenPart("xyz(abc)123")); // returns "(abc)"
		assertEquals("(hello)", Main.problem1_parenPart("x(hello)")); // returns "(hello)"
		assertEquals("(xy)", Main.problem1_parenPart("(xy) 1")); // returns "(xy)"
		assertEquals("()", Main.problem1_parenPart("()")); // returns "()"
	}
	
	@Test
	public void problem2() {
		assertEquals(1, Main.problem2_countDoubles("axa"));
		assertEquals(2, Main.problem2_countDoubles("axax"));
		assertEquals(1, Main.problem2_countDoubles("axbx"));
		assertEquals(0, Main.problem2_countDoubles("hi"));
		assertEquals(3, Main.problem2_countDoubles("hihih"));
		assertEquals(3, Main.problem2_countDoubles("ihihhh"));
		assertEquals(0, Main.problem2_countDoubles("ihjxhh"));
		assertEquals(0, Main.problem2_countDoubles(""));
		assertEquals(0, Main.problem2_countDoubles("a"));
		assertEquals(0, Main.problem2_countDoubles("aa"));
		assertEquals(1, Main.problem2_countDoubles("aaa"));
	}
	
	@Test
	public void problem3() {
		assertEquals(2, Main.problem3_countSubs("catcowcat", "cat"));
		assertEquals(1, Main.problem3_countSubs("catcowcat", "cow"));
		assertEquals(0, Main.problem3_countSubs("catcowcat", "dog"));
		assertEquals(2, Main.problem3_countSubs("cacatcowcat", "cat"));
		assertEquals(2, Main.problem3_countSubs("xyx", "x"));
		assertEquals(4, Main.problem3_countSubs("iiiijj", "i"));
		assertEquals(2, Main.problem3_countSubs("iiiijj", "ii"));
		assertEquals(2, Main.problem3_countSubs("iiiiijj", "ii"));
		assertEquals(1, Main.problem3_countSubs("iiiijj", "iii"));
		assertEquals(2, Main.problem3_countSubs("iiiijj", "j"));
		assertEquals(1, Main.problem3_countSubs("iiiijj", "jj"));
		assertEquals(4, Main.problem3_countSubs("aaabababab", "ab"));
		assertEquals(1, Main.problem3_countSubs("aaabababab", "aa"));
		assertEquals(6, Main.problem3_countSubs("aaabababab", "a"));
		assertEquals(4, Main.problem3_countSubs("aaabababab", "b"));
		assertEquals(0, Main.problem3_countSubs("aaabababab", "aaababababaaabababab"));
		assertEquals(0, Main.problem3_countSubs("", "b"));
	}
	
    @Test
    public void problems4Thru5() {
        Roster roster = new Roster();
        roster.addPerson(3, "Robert");
        roster.addPerson(5, "Adriana");
        roster.addPerson(188, "Rujun");
        roster.addPerson(9, "Anupriya");
        roster.addPerson(45, "Yizhen");
        roster.addPerson(88, "Emily");
        assertEquals("Adriana Anupriya Emily Robert Rujun Yizhen", roster.getNamesInAlphaOrder());
        assertEquals("Anupriya", roster.findPerson(9).getName());
        assertEquals(45, roster.findPerson("Yizhen").getId());
        roster.removePerson(3);
        roster.removePerson("Emily");
        assertEquals("Adriana Anupriya Rujun Yizhen", roster.getNamesInAlphaOrder());
    }
    
	@Test
	public void problem6() {
		ShippingCenter center = new ShippingCenter();
		assertEquals("", center.getShippingStack());
		assertEquals("", center.getTemporaryStack());
		
		List<String> expected = Arrays.asList(
				"Shipping stack: product 1", 
				"Temporary stack: ");
		assertEquals(expected, center.add("product 1"));
		
		expected = Arrays.asList(
				"Shipping stack: product 1, product 2", 
				"Temporary stack: ");
		assertEquals(expected, center.add("product 2"));
		
		expected = Arrays.asList(
				"Shipping stack: product 1, product 2, product 3", 
				"Temporary stack: ");
		assertEquals(expected, center.add("product 3"));
		
		expected = Arrays.asList("That product is already on the shipping stack.");
		assertEquals(expected, center.add("product 3"));
		
		expected = Arrays.asList(
				"Shipping stack: product 1, product 2, product 3, product 4", 
				"Temporary stack: ");
		assertEquals(expected, center.add("product 4"));
		
		expected = Arrays.asList(
				"Shipping stack: product 1, product 2, product 3", 
				"Temporary stack: product 4",
				"Shipping stack: product 1, product 2",
				"Temporary stack: product 4, product 3",
				"Shipping stack: product 1, product 3",
				"Temporary stack: product 4",
				"Shipping stack: product 1, product 3, product 4",
				"Temporary stack: "
				);
		assertEquals(expected, center.ship("product 2"));

		expected = Arrays.asList(
				"Shipping stack: product 1, product 3",
				"Temporary stack: "
				);
		assertEquals(expected, center.ship("product 4"));
		
		expected = Arrays.asList(
				"Shipping stack: product 1, product 3, product 5",
				"Temporary stack: "
				);
		assertEquals(expected, center.add("product 5"));
		
		expected = Arrays.asList(
				"Shipping stack: product 1, product 3, product 5, product 6",
				"Temporary stack: "
				);
		assertEquals(expected, center.add("product 6"));

		expected = Arrays.asList(
				"Shipping stack: product 1, product 3, product 5", 
				"Temporary stack: product 6", 
				"Shipping stack: product 1, product 3", 
				"Temporary stack: product 6, product 5", 
				"Shipping stack: product 1", 
				"Temporary stack: product 6, product 5, product 3",
				"Shipping stack: product 3", 
				"Temporary stack: product 6, product 5", 
				"Shipping stack: product 3, product 5", 
				"Temporary stack: product 6", 
				"Shipping stack: product 3, product 5, product 6", 
				"Temporary stack: "
				);
		assertEquals(expected, center.ship("product 1"));
		
		expected = Arrays.asList("That product is not on the shipping stack.");
		assertEquals(expected, center.ship("product 1"));
		assertEquals(expected, center.ship("product 99"));
	}
	
	@Test 
	public void problems7and8() { 
		PrintJob myPrintJob = new PrintJob("CEO","Important document");
		PrintJob anotherPrintJob = new PrintJob("Manager","Not an important document");
		assertEquals(1, myPrintJob.getPriority());
		assertEquals("Important document", myPrintJob.getDescription());
		assertEquals("CEO", myPrintJob.getEmployeeType());
		assertTrue(myPrintJob.compareTo(anotherPrintJob) < 0); //Checks if myPrintJob.priority < anotherPrintJob.priority
		
		Printer myPrinter = new Printer();
		myPrinter.addJob("Manager","Not an important document");
		myPrinter.addJob("CEO","Important document");
		assertEquals(myPrintJob.getEmployeeType(), myPrinter.nextJob().getEmployeeType()); //CEO top priority
		assertEquals(anotherPrintJob.getDescription(), myPrinter.nextJob().getDescription()); //Next job executed
	}
	
	@Test
	public void problem9() {
		ProductionLine pl = new ProductionLine();
		assertEquals("", pl.handleNextOrder());
		pl.addStandardOrder(34);
		pl.addStandardOrder(889);
		pl.addRushOrder(18);
		pl.addRushOrder(203);
		assertEquals("Producing rush order for customer 18", pl.handleNextOrder());
		assertEquals("Producing rush order for customer 203", pl.handleNextOrder());
		assertEquals("Producing standard order for customer 34", pl.handleNextOrder());
		pl.addRushOrder(78);
		assertEquals("Producing rush order for customer 78", pl.handleNextOrder());
		assertEquals("Producing standard order for customer 889", pl.handleNextOrder());
		assertEquals("", pl.handleNextOrder());
	}
	
	@Test
	public void problem10() {
		// test1.txt:
		WordCounter wc1 = new WordCounter("res/test1.txt");
		assertEquals(37, wc1.getNumUniqueWords());
		assertEquals(50, wc1.getNumWords());
		ArrayList<String> result = new ArrayList<String>(Arrays.asList("a", "across", "actually", "alice", "and", "at",
				"before", "either", "feet", "flashed", "for", "had", "her", "hurried", "it", "its", "looked", "mind",
				"never", "of", "on", "or", "out", "rabbit", "seen", "she", "started", "take", "that", "the", "then",
				"to", "took", "waistcoatpocket", "watch", "when", "with"));
		assertEquals(result, wc1.getUniqueWords());

		// test2.txt:
		WordCounter wc2 = new WordCounter("res/test2.txt");
		assertEquals(23, wc2.getNumUniqueWords());
		assertEquals(26, wc2.getNumWords());
		result = new ArrayList<String>(Arrays.asList("a", "as", "but", "disappointment", "down", "empty", "from",
				"great", "her", "it", "jar", "labelled", "marmalade", "of", "one", "orange", "passed", "she", "shelves",
				"the", "to", "took", "was"));
		assertEquals(result, wc2.getUniqueWords());

		// text3.txt:
		WordCounter wc3 = new WordCounter("res/test3.txt");
		assertEquals(28, wc3.getNumUniqueWords());
		assertEquals(33, wc3.getNumWords());
		result = new ArrayList<String>(Arrays.asList("12", "again", "alice", "began", "cat", "dinah", "dinahll", "do",
				"down", "else", "i", "me", "miss", "much", "nothing", "old", "should", "so", "soon", "talking", "the",
				"there", "think", "to", "tonight", "very", "was", "years"));
		assertEquals(result, wc3.getUniqueWords());
	}
}

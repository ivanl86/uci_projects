package labs.lab4.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import labs.lab4.*;


public class Lab4Test {
	
	private final double EPSILON = 1e-3;

	@Test
	public void problem1() {
		Customer c1 = new Customer();
		assertEquals(50.0, c1.makePurchase(50, 3), EPSILON);
		assertEquals(50.0, c1.makePurchase(50, 3), EPSILON);
		assertEquals(50.0, c1.makePurchase(50, 3), EPSILON);
		assertEquals(50.0, c1.makePurchase(50, 1), EPSILON);
		assertEquals(50.0, c1.makePurchase(50, 11), EPSILON);
		assertEquals(45.0, c1.makePurchase(50, 3), EPSILON);
		assertEquals(90.0, c1.makePurchase(100, 13), EPSILON);

		Customer c2 = new Customer();
		assertEquals(101.0, c2.makePurchase(101, 13), EPSILON);
		assertEquals(100.0, c2.makePurchase(100, 12), EPSILON);
		assertEquals(100.0, c2.makePurchase(100, 3), EPSILON);
		assertEquals(9.0, c2.makePurchase(10, 13), EPSILON);
		
		Customer c3 = new Customer();
		assertEquals(11.0, c3.makePurchase(11, 13), EPSILON);
		assertEquals(10.0, c3.makePurchase(10, 12), EPSILON);
		assertEquals(10.0, c3.makePurchase(10, 3), EPSILON);
		assertEquals(10.0, c3.makePurchase(10, 13), EPSILON);
	}
	
	@Test
	public void problem3() {
		TimeKeeper tk = new TimeKeeper();
		tk.doActivity(new Activity("Eat breakfast", 0.05, Activity.Category.OTHER));
		tk.doActivity(new Activity("Go for a run with Mommy", 1.0, Activity.Category.EXERCISE));
		tk.doActivity(new Activity("Bring in the newspaper", 0.03, Activity.Category.WORK));
		tk.doActivity(new Activity("Take my siblings to school", 0.75, Activity.Category.WORK));
		tk.doActivity(new Activity("Play ball with Mommy", 0.05, Activity.Category.PLAY));
		tk.doActivity(new Activity("Take a nap", 3.5, Activity.Category.SLEEP));
		tk.doActivity(new Activity("Sunbathe", 0.5, Activity.Category.OTHER));
		tk.doActivity(new Activity("Play tug of war with Daddy", 0.05, Activity.Category.PLAY));
		tk.doActivity(new Activity("Attend Mom's 45J lecture", 1.3, Activity.Category.WORK));
		tk.doActivity(new Activity("Afternoon nap", 2.0, Activity.Category.SLEEP));
		tk.doActivity(new Activity("Pick my siblings up from school", 1.0, Activity.Category.WORK));
		tk.doActivity(new Activity("Eat dinner", 0.05, Activity.Category.OTHER));
		tk.doActivity(new Activity("Evening walk around the neighborhood", 0.5, Activity.Category.EXERCISE));
		tk.doActivity(new Activity("Go outside and bark at nothing", 0.15, Activity.Category.WORK));

		assertEquals(3.23, tk.getTotalTimeForCategory(Activity.Category.WORK), EPSILON);
		assertEquals(29.55169258920402, tk.getPercentageOfTimeSpentInCategory(Activity.Category.WORK), EPSILON);
		assertEquals(0.1, tk.getTotalTimeForCategory(Activity.Category.PLAY), EPSILON);
		assertEquals(0.9149130832570904, tk.getPercentageOfTimeSpentInCategory(Activity.Category.PLAY), EPSILON);
		assertEquals(1.5, tk.getTotalTimeForCategory(Activity.Category.EXERCISE), EPSILON);
		assertEquals(13.723696248856356, tk.getPercentageOfTimeSpentInCategory(Activity.Category.EXERCISE), EPSILON);
		assertEquals(5.5, tk.getTotalTimeForCategory(Activity.Category.SLEEP), EPSILON);
		assertEquals(50.32021957913998, tk.getPercentageOfTimeSpentInCategory(Activity.Category.SLEEP), EPSILON);
		assertEquals(0.6, tk.getTotalTimeForCategory(Activity.Category.OTHER), EPSILON);
		assertEquals(5.489478499542544, tk.getPercentageOfTimeSpentInCategory(Activity.Category.OTHER), EPSILON);
	}

	@Test
	public void problem5() {
		// static methods:
		assertEquals(1.0, Geometry.cubeVolume(1.0), EPSILON);
		assertEquals(6.0, Geometry.cubeSurface(1.0), EPSILON);
		assertEquals(151.419437, Geometry.cubeVolume(5.33), EPSILON);
		assertEquals(6605.4744, Geometry.cubeSurface(33.18), EPSILON);
		assertEquals(1.0, Geometry.prismVolume(1.0, 1.0, 1.0), EPSILON);
		assertEquals(6.0, Geometry.prismSurface(1.0, 1.0, 1.0), EPSILON);
		assertEquals(135.1647, Geometry.prismVolume(11.1, 12.3, 0.99), EPSILON);
		assertEquals(319.392, Geometry.prismSurface(11.1, 12.3, 0.99), EPSILON);
		assertEquals(0.3333, Geometry.pyramidVolume(1.0, 1.0), EPSILON);
		assertEquals(3.23607, Geometry.pyramidSurface(1.0, 1.0), EPSILON);
		assertEquals(0.00291667, Geometry.pyramidVolume(0.5, 0.035), EPSILON);
		assertEquals(0.50244, Geometry.pyramidSurface(0.5, 0.035), EPSILON);

		// Object-oriented:
		Cube cube = new Cube(1.0);
		assertEquals(1.0, cube.getVolume(), EPSILON);
		assertEquals(6.0, cube.getSurface(), EPSILON);
		cube = new Cube(5.33);
		assertEquals(151.419437, cube.getVolume(), EPSILON);
		cube = new Cube(33.18);
		assertEquals(6605.4744, cube.getSurface(), EPSILON);

		Prism prism = new Prism(1.0, 1.0, 1.0);
		assertEquals(1.0, prism.getVolume(), EPSILON);
		assertEquals(6.0, prism.getSurface(), EPSILON);
		prism = new Prism(11.1, 12.3, 0.99);
		assertEquals(135.1647, prism.getVolume(), EPSILON);
		assertEquals(319.392, prism.getSurface(), EPSILON);

		Pyramid pyramid = new Pyramid(1.0, 1.0);
		assertEquals(0.3333, pyramid.getVolume(), EPSILON);
		assertEquals(3.23607, pyramid.getSurface(), EPSILON);
		pyramid = new Pyramid(0.5, 0.035);
		assertEquals(0.00291667, pyramid.getVolume(), EPSILON);
		assertEquals(0.50244, pyramid.getSurface(), EPSILON);
	}
	
	@Test
	public void problem6() {
		// Test case 1
		BankAccount account = new BasicAccount(100.00);
		account.withdraw(80.00);
		assertEquals(20.0, account.getBalance(), EPSILON);
		account.withdraw(50.00);
		assertEquals(-60.0, account.getBalance(), EPSILON);
		account.withdraw(50.00);
		assertEquals(-140.0, account.getBalance(), EPSILON);
		assertTrue(BankAccount.class.isAssignableFrom(BasicAccount.class));
	}
	
	@Test
	public void problems7to10() {
		// Test case 1
		List<String> actors = new ArrayList<String>();
		actors.add("Amy Adams");
		actors.add("Glenn Close");
		actors.add("Haley Bennett");
		actors.add("Gabriel Basso");
		DVD dvd1 = new DVD("Hillbilly Elegy", actors);
		Magazine mag1 = new Magazine("Time", 435, "February 2021");
		DigitalBook db1 = new DigitalBook("Hillbilly Elegy", "J.D. Vance", 264);
		PrintBook pb1 = new PrintBook("Hillbilly Elegy", "J.D. Vance", 264);
		PrintBook pb2 = new PrintBook("The Warmth of Other Suns", "Isabel Wilkerson", 622);
		PrintBook pb3 = new PrintBook("Caste", "Isabel Wilkerson", 496);
		AudioBook ab1 = new AudioBook("Hillbilly Elegy", "J.D. Vance", 6.8);
		AudioBook ab2 = new AudioBook("Hillbilly Elegy", "J.D. Vance", 6.8);
		assertEquals(true, ab1.equals(ab2));
		assertEquals(false, dvd1.equals(db1));
		assertEquals(false, pb2.equals(pb3));

		LibraryItem[] items = new LibraryItem[8];
		items[0] = dvd1;
		items[1] = mag1;
		items[2] = db1;
		items[3] = pb1;
		items[4] = pb2;
		items[5] = pb3;
		items[6] = ab1;
		items[7] = ab2;
		
		String[] checkoutDays = new String[] {"7 days", "7 days", "14 days", "21 days", "21 days", "21 days", "28 days", "28 days"};
		for (int i=0;i<items.length; i++) {
			assertEquals(checkoutDays[i], items[i].checkOut());
		}
		assertEquals("28 days", items[6].checkOut());
		assertEquals("NOT ALLOWED", items[6].checkOut());
		items[6].checkIn();
		assertEquals("28 days", items[6].checkOut());
	}

}

package labs.lab4;

import static org.junit.Assert.*;

import org.junit.Test;


public class CustomerTest {
	private final double EPSILON = 1e-3;

	@Test
    public void testTotalOver100NumStoresLessThan3() {
		// FILL IN
		Customer c = new Customer();
		assertEquals(50.0, c.makePurchase(50, 3), EPSILON);
		assertEquals(50.0, c.makePurchase(50, 3), EPSILON);
		assertEquals(50.0, c.makePurchase(50, 2), EPSILON);
		assertEquals(50.0, c.makePurchase(50, 3), EPSILON);
    }
	
	
	@Test
	public void testTotalOver100NumStoresGreaterThan3() {
		// FILL IN
		Customer c = new Customer();
		assertEquals(50.0, c.makePurchase(50, 3), EPSILON);
		assertEquals(30.0, c.makePurchase(30, 1), EPSILON);
		assertEquals(1.00, c.makePurchase(1, 2), EPSILON);
		assertEquals(18.0, c.makePurchase(20, 3), EPSILON);
	}
	
	
	@Test
	public void testTotalLessThan100NumStoresGreaterThan3() {
		// FILL IN
		Customer c = new Customer();
		assertEquals(50.0, c.makePurchase(50, 3), EPSILON);
		assertEquals(30.0, c.makePurchase(30, 1), EPSILON);
		assertEquals(10.0, c.makePurchase(10, 2), EPSILON);
		assertEquals(9.9, c.makePurchase(9.9, 3), EPSILON);
	}
}
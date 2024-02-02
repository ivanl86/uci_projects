package labs.lab3.tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import labs.lab3.*;


public class Lab3Test {

    @Test
    public void problem1() {
        assertTrue(Main.problem1_EHappy("xxEExx"));
        assertFalse(Main.problem1_EHappy("xxExx"));
        assertFalse(Main.problem1_EHappy("xxEyyExx"));
        assertTrue(Main.problem1_EHappy("1234"));
        assertTrue(Main.problem1_EHappy(""));
        assertFalse(Main.problem1_EHappy("E"));
        assertTrue(Main.problem1_EHappy("EE"));
        assertTrue(Main.problem1_EHappy("xxEEExyz"));
        assertFalse(Main.problem1_EHappy("xxEEExyE"));
        assertTrue(Main.problem1_EHappy("xxEEExyEE"));
        assertFalse(Main.problem1_EHappy("MEM"));
        assertTrue(Main.problem1_EHappy("MEEM"));
        assertTrue(Main.problem1_EHappy("YYYEEExYY"));
        assertFalse(Main.problem1_EHappy("EYYYXX"));
        assertFalse(Main.problem1_EHappy("EYYYEXX"));
    }
    
	@Test
	public void problem2() {
		assertFalse(Main.problem2_equalAreNot("Hares are not"));
		assertTrue(Main.problem2_equalAreNot("Hares are notnot"));
		assertTrue(Main.problem2_equalAreNot("noarexxnotyynotxarear"));
		assertFalse(Main.problem2_equalAreNot("noarexxnotyynotxera"));
		assertTrue(Main.problem2_equalAreNot("xxxyyyzzzantant"));
		assertTrue(Main.problem2_equalAreNot(""));
		assertTrue(Main.problem2_equalAreNot("arearenotnot"));
		assertFalse(Main.problem2_equalAreNot("arearenotno3NOT"));
		assertFalse(Main.problem2_equalAreNot("arenotare"));
		assertFalse(Main.problem2_equalAreNot("mare3notpotbotare"));
	}
	
	@Test
	public void problem3() {
		assertEquals(6, Main.problem3_sum("aa1bc2d3"));
		assertEquals(8, Main.problem3_sum("aa11b303"));
		assertEquals(0, Main.problem3_sum("Robert"));
		assertEquals(7, Main.problem3_sum("5hoco1a1e"));
		assertEquals(12, Main.problem3_sum("123ab0c123"));
		assertEquals(0, Main.problem3_sum(""));
		assertEquals(0, Main.problem3_sum("Hello Robert"));
		assertEquals(12, Main.problem3_sum("X1z9b2"));
		assertEquals(14, Main.problem3_sum("5432a"));
		assertEquals(15, Main.problem3_sum("54321"));
		assertEquals(14, Main.problem3_sum("-5432a"));
		assertEquals(14, Main.problem3_sum("-5432"));
		assertEquals(0, Main.problem3_sum("R0BERT"));
	}
	
	@Test
	public void problem4() {
		CreditCard cc1 = new CreditCard(4022888888881881L, LocalDate.of(2024, 2, 28));
		assertEquals(4022888888881881L, cc1.getNumber());
		assertEquals(LocalDate.of(2024, 2, 28), cc1.getExpirationDate());
		assertEquals("4022 8888 8888 1881", cc1.getNumberWithSpaces());
		assertTrue(cc1.isValid());

		CreditCard cc2 = new CreditCard(4022888888881881L, LocalDate.of(2021, 2, 28));
		assertEquals(4022888888881881L, cc2.getNumber()); //
		assertEquals(LocalDate.of(2021, 2, 28), cc2.getExpirationDate());
		assertEquals("4022 8888 8888 1881", cc2.getNumberWithSpaces());
		assertFalse(cc2.isValid());

		CreditCard cc3 = new CreditCard(5022888888881881L, LocalDate.of(2024, 2, 28));
		assertEquals(5022888888881881L, cc3.getNumber());
		assertEquals(LocalDate.of(2024, 2, 28), cc3.getExpirationDate());
		assertEquals("5022 8888 8888 1881", cc3.getNumberWithSpaces());
		assertFalse(cc3.isValid());

		CreditCard cc4 = new CreditCard(3333333333333333L, LocalDate.of(2019, 4, 9));
		assertEquals(3333333333333333L, cc4.getNumber());
		assertEquals(LocalDate.of(2019, 4, 9), cc4.getExpirationDate());
		assertEquals("3333 3333 3333 3333", cc4.getNumberWithSpaces());
		assertFalse(cc4.isValid());

		CreditCard cc5 = new CreditCard(3333333333333333L, LocalDate.of(2030, 4, 9));
		assertEquals(3333333333333333L, cc5.getNumber());
		assertEquals(LocalDate.of(2030, 4, 9), cc5.getExpirationDate());
		assertEquals("3333 3333 3333 3333", cc5.getNumberWithSpaces());
		assertTrue(cc5.isValid());

		CreditCard cc6 = new CreditCard(3000333333333333L, LocalDate.of(2030, 4, 9));
		assertEquals(3000333333333333L, cc6.getNumber());
		assertEquals(LocalDate.of(2030, 4, 9), cc6.getExpirationDate());
		assertEquals("3000 3333 3333 3333", cc6.getNumberWithSpaces());
		assertTrue(cc6.isValid());

		CreditCard cc7 = new CreditCard(3000333333330000L, LocalDate.of(2030, 4, 9));
		assertEquals(3000333333330000L, cc7.getNumber());
		assertEquals(LocalDate.of(2030, 4, 9), cc7.getExpirationDate());
		assertEquals("3000 3333 3333 0000", cc7.getNumberWithSpaces());
		assertTrue(cc7.isValid());
	}
	
    @Test
    public void problem5() {
    	assertEquals(10, Main.problem5_getNumTwists(1729, 5714));
    	assertEquals(4, Main.problem5_getNumTwists(0000, 9999));
    	assertEquals(0, Main.problem5_getNumTwists(4590, 4590));
    	assertEquals(8, Main.problem5_getNumTwists(7712, 1729));
    	assertEquals(16, Main.problem5_getNumTwists(9593, 5939));
    }
    
	@Test
	public void problem6() {
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] { 1, 0, 1, 0, 0, 1, 1 })));
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] { 3, 3, 2 })));
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] { 2, 2, 2 })));
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] { 3, 2, 2 })));
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] { 1, 1, 0, 1, 0 })));
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] { 1 })));
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] { 1, 2 })));
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] { 2, 1 })));
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] {})));
	}
	
	@Test
	public void problem6_1() {
	assertTrue(evensFirst(Main.problem6_evenOdd(new int[]{2, 4, 6, 8})));
	assertTrue(evensFirst(Main.problem6_evenOdd(new int[]{1, 3, 5, 7})));
	assertTrue(evensFirst(Main.problem6_evenOdd(new int[]{9, 6, 3, 0})));
	}
	
	// returns true if all the evens come before all the odds in an array of ints
	private boolean evensFirst(int[] nums) {
		// if an even comes after an odd, return false:
		for (int i=1; i<nums.length; i++) {
			if ((nums[i-1] % 2 == 1) && (nums[i] % 2 == 0)) {
				return false;
			}
		}
		return true;
	}
	
    @Test
    public void problem7() {
        assertEquals(2, Main.problem7_countClumps(new int[]{1, 2, 2, 3, 4, 4}));
        assertEquals(2, Main.problem7_countClumps(new int[]{1, 1, 2, 1, 1}));
        assertEquals(1, Main.problem7_countClumps(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}));
        assertEquals(0, Main.problem7_countClumps(new int[]{}));
        assertEquals(4, Main.problem7_countClumps(new int[] {0, 13, 13, 13, 26, -7, -7, 1, 1, 1, 1, 88, 1543, 1543}));
    }
    
    @Test
    public void problem8() {
        PetStore myStore = new PetStore();
        Customer emily = new Customer("Emily");
        emily.addSale(55.33);
        emily.addSale(.99);
        Customer adriana = new Customer("Adriana");
        adriana.addSale(89.30);
        adriana.addSale(9.99);
        Customer anupriya = new Customer("Anupriya");
        anupriya.addSale(101.54);
        Customer rujun = new Customer("Rujun");
        rujun.addSale(55.33);
        rujun.addSale(.99);
        rujun.addSale(55.33);
        rujun.addSale(10.99);
        Customer yizhen = new Customer("Yizhen");
        yizhen.addSale(.33);
        yizhen.addSale(.99);
        yizhen.addSale(121.09);
        myStore.addCustomer(emily);
        myStore.addCustomer(adriana);
        myStore.addCustomer(anupriya);
        myStore.addCustomer(rujun);
        myStore.addCustomer(yizhen);
        assertEquals("Rujun", myStore.getNameOfBestCustomer());
    }
    
	@Test
	public void problem9() {
		
		// even number of stalls:
		Restroom wc = new Restroom(12);
		assertEquals("_ _ _ _ _ _ _ _ _ _ _ _", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("_ _ _ _ _ _ X _ _ _ _ _", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("_ _ _ X _ _ X _ _ _ _ _", wc.getStalls());

		wc.addOccupant();
		assertEquals("_ _ _ X _ _ X _ _ X _ _", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("_ X _ X _ _ X _ _ X _ _", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("_ X _ X _ X X _ _ X _ _", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("_ X _ X _ X X _ X X _ _", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("_ X _ X _ X X _ X X _ X", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("X X _ X _ X X _ X X _ X", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("X X X X _ X X _ X X _ X", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("X X X X X X X _ X X _ X", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("X X X X X X X X X X _ X", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("X X X X X X X X X X X X", wc.getStalls());
		
		
		// odd number of stalls:
		wc = new Restroom(9);
		assertEquals("_ _ _ _ _ _ _ _ _", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("_ _ _ _ X _ _ _ _", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("_ _ X _ X _ _ _ _", wc.getStalls());

		wc.addOccupant();
		assertEquals("_ _ X _ X _ _ X _", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("_ X X _ X _ _ X _", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("_ X X _ X _ X X _", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("X X X _ X _ X X _", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("X X X X X _ X X _", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("X X X X X X X X _", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("X X X X X X X X X", wc.getStalls());
		
		
		// one stall:
		wc = new Restroom(1);
		assertEquals("_", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("X", wc.getStalls());
		
		
		// two stalls:
		wc = new Restroom(2);
		assertEquals("_ _", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("_ X", wc.getStalls());
		
		wc.addOccupant();
		assertEquals("X X", wc.getStalls());
	}
	
    @Test
    public void problem10() {
        SeatingChart chart = new SeatingChart();
        String seating = "40 50 50 50 40" + System.lineSeparator() +
                "30 40 40 40 30" + System.lineSeparator() +
                "20 30 30 30 20" + System.lineSeparator() +
                "10 20 20 20 10" + System.lineSeparator() +
                "10 10 10 10 10" + System.lineSeparator();
        assertEquals(seating, chart.getSeatingChart());

        chart.sellSeatByNumber('D', 5);
        chart.sellSeatByNumber('B', 2);
        chart.sellSeatByNumber('b', 3);
        chart.sellSeatByPrice(10);
        chart.sellSeatByPrice(10);
        chart.sellSeatByPrice(30);
        chart.getSeatingChart();
        seating = "40 50 50 50 40" + System.lineSeparator() +
                " 0  0 40 40 30" + System.lineSeparator() +
                "20 30 30 30 20" + System.lineSeparator() +
                " 0 20 20 20  0" + System.lineSeparator() +
                " 0 10 10 10 10" + System.lineSeparator();
        assertEquals(seating, chart.getSeatingChart());
    }

}

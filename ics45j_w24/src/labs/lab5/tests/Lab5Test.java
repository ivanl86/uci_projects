package labs.lab5.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import labs.lab5.*;

import org.junit.Test;

public class Lab5Test {
	
	private final double EPSILON = 1e-2;

	@Test
	public void problems1Through5() {
		// players:
		Player robert = new Player("Robert");
		Player emily = new Player("Emily");

		// Collectables:
		// bags of gems:
		Collectible bigBag = new BagOfGems(10);
		Collectible smallBag = new BagOfGems(2);
		Collectible mediumBag = new BagOfGems(5);

		// boxes of rocks:
		Collectible bigBox = new BoxOfRocks(7.5, true);
		Collectible smallBox = new BoxOfRocks(1.0, false);
		Collectible mediumBox = new BoxOfRocks(2.25, true);

		// enemies:
		Enemy goblin1 = new Goblin();
		Enemy goblin2 = new Goblin();
		Enemy fbDragon = new Dragon(true);
		Enemy dragon = new Dragon(false);
		Enemy bigDemo = new Demogorgon(100.0);
		Enemy mediumDemo = new Demogorgon(50.0);
		Enemy smallDemo = new Demogorgon(10.5);
		Enemy weakBugaboo = new Bugaboo(50.25);
		Enemy strongBugaboo = new Bugaboo(534.2);
		Enemy armedClown = new Clown(true);
		Enemy unarmedClown = new Clown(false);

		// gameplay:

		// colllecting stuff:
		assertTrue(robert.collectItem(bigBag));
		assertEquals(50, robert.getStrengthPoints());
		assertFalse(emily.collectItem(bigBag));
		assertEquals(0, emily.getStrengthPoints());
		assertFalse(emily.collectItem(smallBox));
		assertEquals(0, emily.getStrengthPoints());
		assertEquals(0, emily.getAmmo());
		assertTrue(robert.collectItem(mediumBox));
		assertEquals(50, robert.getStrengthPoints());
		assertEquals(9, robert.getAmmo());
		assertTrue(emily.collectItem(mediumBag));
		assertEquals(25, emily.getStrengthPoints());
		assertFalse(emily.collectItem(mediumBag));
		assertTrue(emily.collectItem(smallBox));
		assertEquals(2, emily.getAmmo());

		// attacking enemies:
		assertEquals(100, goblin1.getHealth());
		assertTrue(emily.attackEnemy(goblin1));
		assertEquals(1, emily.getAmmo());
		assertEquals(75, emily.getStrengthPoints());
		assertEquals("red", ((Goblin) goblin1).getColor());
		assertEquals(50, goblin1.getHealth());

		assertEquals(100, fbDragon.getHealth());
		assertTrue(emily.attackEnemy(fbDragon));
		assertEquals(0, emily.getAmmo());
		assertEquals(50, emily.getStrengthPoints());
		assertEquals(100, fbDragon.getHealth());

		assertEquals(100, bigDemo.getHealth());
		assertFalse(emily.attackEnemy(bigDemo)); // (false because Emily has 0 ammo)
		assertEquals(50, emily.getStrengthPoints());
		assertEquals(100, bigDemo.getHealth()); // 100

		// advancing time:
		// Collectables:
		Collectible[] collectables = new Collectible[] { bigBag, smallBag, mediumBag, bigBox, smallBox, mediumBox };

		assertEquals(10, ((BagOfGems) bigBag).getNumGems());
		assertEquals(2, ((BagOfGems) smallBag).getNumGems());
		assertEquals(30, ((BoxOfRocks) bigBox).getNumAmmo());
		assertEquals(9, ((BoxOfRocks) mediumBox).getNumAmmo());

		for (Collectible c : collectables) {
			c.advanceTime();
		}

		assertEquals(10, ((BagOfGems) bigBag).getNumGems());
		assertEquals(3, ((BagOfGems) smallBag).getNumGems());
		assertEquals(29, ((BoxOfRocks) bigBox).getNumAmmo());
		assertEquals(9, ((BoxOfRocks) mediumBox).getNumAmmo());

		for (Collectible c : collectables) {
			c.advanceTime();
		}

		assertEquals(10, ((BagOfGems) bigBag).getNumGems());
		assertEquals(4, ((BagOfGems) smallBag).getNumGems());
		assertEquals(27, ((BoxOfRocks) bigBox).getNumAmmo());
		assertEquals(9, ((BoxOfRocks) mediumBox).getNumAmmo());

		// Enemies:
		Enemy[] enemies = new Enemy[] { armedClown, unarmedClown, goblin1, goblin2, fbDragon, dragon, bigDemo,
				mediumDemo, smallDemo, weakBugaboo, strongBugaboo };

		assertEquals("red", ((Goblin) goblin1).getColor());
		assertEquals(50, goblin1.getHealth());
		assertEquals(100, goblin2.getHealth());
		assertEquals("purple", ((Goblin) goblin2).getColor());
		assertTrue(((Dragon) fbDragon).isFireBreathing());
		assertEquals(100, fbDragon.getHealth());
		assertEquals(100.0, ((Demogorgon) bigDemo).getWeight(), EPSILON);
		assertEquals(100, bigDemo.getHealth());
		assertEquals(50.25, ((Bugaboo) weakBugaboo).getStrength(), EPSILON);
		assertEquals(100, weakBugaboo.getHealth());
		assertTrue(((Clown) armedClown).hasWeapon());
		assertEquals(100, armedClown.getHealth());

		for (Enemy e : enemies) {
			e.advanceTime();
		}

		assertEquals("purple", ((Goblin) goblin1).getColor());
		assertEquals(30, goblin1.getHealth());
		assertEquals(80, goblin2.getHealth());
		assertEquals("orange", ((Goblin) goblin2).getColor());
		assertFalse(((Dragon) fbDragon).isFireBreathing());
		assertEquals(90, fbDragon.getHealth());
		assertEquals(105.0, ((Demogorgon) bigDemo).getWeight(), EPSILON);
		assertEquals(100, bigDemo.getHealth());
		assertEquals(57.7875, ((Bugaboo) weakBugaboo).getStrength(), EPSILON);
		assertEquals(100, weakBugaboo.getHealth());
		assertFalse(((Clown) armedClown).hasWeapon());
		assertEquals(99, armedClown.getHealth());

		for (Enemy e : enemies) {
			e.advanceTime();
		}

		assertEquals("orange", ((Goblin) goblin1).getColor());
		assertEquals(10, goblin1.getHealth());
		assertEquals(60, goblin2.getHealth());
		assertEquals("black", ((Goblin) goblin2).getColor());
		assertTrue(((Dragon) fbDragon).isFireBreathing());
		assertEquals(80, fbDragon.getHealth());
		assertEquals(110.25, ((Demogorgon) bigDemo).getWeight(), EPSILON);
		assertEquals(100, bigDemo.getHealth());
		assertEquals(66.4556, ((Bugaboo) weakBugaboo).getStrength(), EPSILON);
		assertEquals(100, weakBugaboo.getHealth());
		assertTrue(((Clown) armedClown).hasWeapon());
		assertEquals(98, armedClown.getHealth());

		for (Enemy e : enemies) {
			e.advanceTime();
		}

		assertEquals("black", ((Goblin) goblin1).getColor());
		assertEquals(0, goblin1.getHealth());
		assertEquals(40, goblin2.getHealth());
		assertEquals("purple", ((Goblin) goblin2).getColor());
		assertFalse(((Dragon) fbDragon).isFireBreathing());
		assertEquals(70, fbDragon.getHealth());
		assertEquals(115.7625, ((Demogorgon) bigDemo).getWeight(), EPSILON);
		assertEquals(100, bigDemo.getHealth());
		assertEquals(76.42397, ((Bugaboo) weakBugaboo).getStrength(), EPSILON);
		assertEquals(100, weakBugaboo.getHealth());
		assertFalse(((Clown) armedClown).hasWeapon());
		assertEquals(97, armedClown.getHealth());

		assertTrue(robert.attackEnemy(enemies[0]));
		assertTrue(robert.attackEnemy(enemies[1]));
		assertTrue(robert.attackEnemy(enemies[2]));
		assertTrue(robert.attackEnemy(enemies[3]));
		assertTrue(robert.attackEnemy(enemies[4]));
		assertTrue(robert.attackEnemy(enemies[5]));
		assertTrue(robert.attackEnemy(enemies[6]));
		assertTrue(robert.attackEnemy(enemies[7]));
		assertTrue(robert.attackEnemy(enemies[8]));
		assertFalse(robert.attackEnemy(enemies[9]));
		assertFalse(robert.attackEnemy(enemies[10]));

		assertFalse(((Clown) armedClown).hasWeapon());
		assertEquals(77, armedClown.getHealth());
		assertEquals("red", ((Goblin) goblin1).getColor());
		assertEquals(0, goblin1.getHealth());
		assertEquals(0, goblin2.getHealth());
		assertEquals("red", ((Goblin) goblin2).getColor());
		assertFalse(((Dragon) fbDragon).isFireBreathing());
		assertEquals(95, fbDragon.getHealth());
		assertEquals(104.18625, ((Demogorgon) bigDemo).getWeight(), EPSILON);
		assertEquals(85, bigDemo.getHealth());
		assertEquals(76.42397, ((Bugaboo) weakBugaboo).getStrength(), EPSILON);
		assertEquals(100, weakBugaboo.getHealth());

		assertEquals(0, robert.getAmmo());
		assertEquals(100, robert.getStrengthPoints());
	}
	
    @Test
    public void problems6through8() {
        Telemarketer telemarketer = new Telemarketer("Jose");
        Sibling s1 = new Sibling("Mollie");
        Sibling s2 = new Sibling("Corey");
        Pest[] pests = {
                telemarketer,
                s1,
                s2,
                new Ad(),
                new Ad(),
                new Fly()
        };
        String [] expected = new String [] {
                "Call during dinner | Continue talking when you say no",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Block something you really want to see | Don't go away even when you click X",
                "Block something you really want to see | Don't go away even when you click X",
                "Fly around your head | Land on things",
        };
        for (int i = 0; i < pests.length; i++) {
            assertEquals(expected[i], pests[i].annoy());
        }

        Person[] people = { telemarketer, s1, s2 };
        Arrays.sort(people); // people is now sorted: Corey, Jose, Mollie
        String [] expected_name = new String [] {"Corey", "Jose", "Mollie"};
        for (int i = 0; i < people.length; i++){
            assertEquals(expected_name[i], people[i].getName());
        }
    }
    
	@Test
	public void problem9() {
		String book = " 0 1 2 3 4 5 6 7 8 910111213141516171819";
		Segment fullbook = new Segment(book, 0, 40);
		assertEquals(book, fullbook.toString());
		
		Segment firstHalf = new Segment(book, 0, 20);
		assertEquals(" 0 1 2 3 4 5 6 7 8 9", firstHalf.toString());
		
		Segment secondHalf = new Segment(book, 20, 40);
		assertEquals("10111213141516171819", secondHalf.toString());

		
		// Using subSequence:
		CharSequence firstHalfcs = fullbook.subSequence(0, 20);
		assertEquals(firstHalf.toString(), firstHalfcs.toString());
		
		CharSequence secondHalfcs = fullbook.subSequence(20, 40);
		assertEquals(secondHalf.toString(), secondHalfcs.toString());

		// Checking charAt:
		assertEquals('3', firstHalf.charAt(7));
		assertEquals('9', firstHalf.charAt(19));
		assertEquals(' ', firstHalf.charAt(0));
		
		// Checking length:
		assertEquals(20, firstHalf.length());
		assertEquals(10, firstHalf.subSequence(5, 15).length());

		// Demonstrate that join works with Segments:
		assertEquals(" 0 1 2 3 4 5 6 7 8 9XXXXX10111213141516171819", 
				String.join("XXXXX", firstHalf, secondHalf));

		// Demonstrate PrintSteam.append works with Segments
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		System.out.print(firstHalf);
		System.out.print("-----");
		System.out.print(secondHalf);
		
		String result = output.toString();
		assertEquals(" 0 1 2 3 4 5 6 7 8 9-----10111213141516171819", result);
	}
	
	@Test
	public void problem10() {
		Student[] students = new Student[] { new Student("Robert", 1234), new Student("Emily", 4321),
				new Student("Harry", 1111), new Student("Kelly", 18), new Student("Mike", 18), new Student("Mike", 18),
				new Student("Robert", 50000), new Student("Emily", 9832), new Student("Emily", 19),
				new Student("ROBERT", 7778) };

		// test toString:
		assertEquals("Robert, 1234", students[0].toString());
		assertEquals("Mike, 18", students[4].toString());
		assertEquals("ROBERT, 7778", students[9].toString());

		// test compareTo:
		assertTrue(students[8].compareTo(students[7]) < 0);
		assertTrue(students[1].compareTo(students[8]) > 0);
		assertTrue(students[4].compareTo(students[5]) == 0);

		// test equals:
		assertTrue(students[4].equals(students[5]));
		assertFalse(students[7].equals(students[8]));
		assertFalse(students[3].equals(students[4]));

		// test StudentFinder methods:
		assertEquals(students[8], StudentFinder.firstStudent(students));
		assertEquals(students[6], StudentFinder.lastStudent(students));

		students = new Student[] { new Student("Robert", 0) };

		assertEquals(students[0], StudentFinder.firstStudent(students));
		assertEquals(students[0], StudentFinder.lastStudent(students));
	}

}

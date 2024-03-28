package labs.lab5.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import labs.lab5.*;

import org.junit.Test;

public class Lab5TestGrader {

    private final double EPSILON = 1e-2;
    @Test
    //Problems 1-5:  Battle Game 50pts
    //5pt
    public void problems1Through5_1() {
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");
        Collectible largeBag = new BagOfGems(20);
        Collectible smallBag = new BagOfGems(5);
        Collectible largeBox = new BoxOfRocks(10.0, true);
        Collectible smallBox = new BoxOfRocks(2.0, false);
        Enemy goblin = new Goblin();
        Enemy dragon = new Dragon(true);
        Enemy demogorgon = new Demogorgon(75.0);
        Enemy bugaboo = new Bugaboo(30.0);
        Enemy clown = new Clown(true);
        assertTrue(alice.collectItem(largeBag));
        assertTrue(alice.collectItem(largeBox));
        assertTrue(alice.collectItem(smallBox));
        assertTrue(bob.collectItem(smallBag));
        assertFalse(bob.collectItem(largeBox));
        assertEquals(100, alice.getStrengthPoints());
        assertEquals(44, alice.getAmmo());
        assertEquals(25, bob.getStrengthPoints());
        assertEquals(0, bob.getAmmo());
        assertEquals(100, goblin.getHealth());
        assertFalse(bob.attackEnemy(goblin));
        assertFalse(bob.attackEnemy(dragon));
        assertTrue(alice.attackEnemy(dragon));
        assertTrue(alice.attackEnemy(demogorgon));
        assertFalse(bob.attackEnemy(bugaboo));
        assertFalse(bob.attackEnemy(clown)); // Bob has 0 ammo
        assertEquals(100, goblin.getHealth());
        assertEquals(100, dragon.getHealth());
        assertEquals(85, demogorgon.getHealth());
        assertEquals(100, bugaboo.getHealth());
        assertEquals(100, clown.getHealth());
        Collectible[] collectibles = new Collectible[]{largeBag, smallBag, largeBox, smallBox};
        for (Collectible c : collectibles) {
            c.advanceTime();
        }
        assertEquals(20, ((BagOfGems) largeBag).getNumGems());
        assertEquals(5, ((BagOfGems) smallBag).getNumGems());
        assertEquals(40, ((BoxOfRocks) largeBox).getNumAmmo());
        assertEquals(4, ((BoxOfRocks) smallBox).getNumAmmo());
        for (Collectible c : collectibles) {
            c.advanceTime();
        }
        assertEquals(20, ((BagOfGems) largeBag).getNumGems());
        assertEquals(5, ((BagOfGems) smallBag).getNumGems());
        assertEquals(40, ((BoxOfRocks) largeBox).getNumAmmo());
        assertEquals(4, ((BoxOfRocks) smallBox).getNumAmmo());
        assertTrue(alice.attackEnemy(goblin));
        assertTrue(alice.attackEnemy(demogorgon));
        assertEquals(50, goblin.getHealth());
        assertEquals(100, dragon.getHealth());
        assertEquals(70, demogorgon.getHealth());
        assertEquals(100, bugaboo.getHealth());
        assertEquals(100, clown.getHealth());
        assertEquals(125, alice.getStrengthPoints());
        assertEquals(40, alice.getAmmo());
        assertEquals(25, bob.getStrengthPoints());
        assertEquals(0, bob.getAmmo());
    }

    @Test
    // 5pt
    public void problems1Through5_2() {
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");
        Collectible largeBag = new BagOfGems(20);
        Collectible smallBag = new BagOfGems(5);
        Collectible zeroGemsBag = new BagOfGems(0); // Edge case: Zero Gems in Bag
        Collectible largeBox = new BoxOfRocks(10.0, true);
        Collectible smallBox = new BoxOfRocks(2.0, false);
        Enemy goblin = new Goblin();
        Enemy dragon = new Dragon(true);
        Enemy demogorgon = new Demogorgon(75.0);
        Enemy bugaboo = new Bugaboo(30.0);
        Enemy clown = new Clown(true);
        assertTrue(alice.collectItem(largeBag));
        assertTrue(alice.collectItem(largeBox));
        assertTrue(alice.collectItem(smallBox));
        assertTrue(bob.collectItem(smallBag));
        //testing 0 gems in the bag
        assertTrue(bob.collectItem(zeroGemsBag));
        assertFalse(bob.collectItem(largeBox));
        assertEquals(100, alice.getStrengthPoints());
        assertEquals(44, alice.getAmmo());
        assertEquals(25, bob.getStrengthPoints());
        assertEquals(0, bob.getAmmo());
        assertEquals(100, goblin.getHealth());
        assertFalse(bob.attackEnemy(goblin));
        assertFalse(bob.attackEnemy(dragon));
        assertTrue(alice.attackEnemy(dragon));
        assertTrue(alice.attackEnemy(demogorgon));
        assertFalse(bob.attackEnemy(bugaboo));
        assertFalse(bob.attackEnemy(clown)); // Bob has 0 ammo
        assertEquals(100, goblin.getHealth());
        assertEquals(100, dragon.getHealth());
        assertEquals(85, demogorgon.getHealth());
        assertEquals(100, bugaboo.getHealth());
        assertEquals(100, clown.getHealth());
        Collectible[] collectibles = new Collectible[]{largeBag, smallBag, zeroGemsBag, largeBox, smallBox};
        for (Collectible c : collectibles) {
            c.advanceTime();
        }
        assertEquals(20, ((BagOfGems) largeBag).getNumGems());
        assertEquals(5, ((BagOfGems) smallBag).getNumGems());
        assertEquals(0, ((BagOfGems) zeroGemsBag).getNumGems());
        assertEquals(40, ((BoxOfRocks) largeBox).getNumAmmo());
        assertEquals(4, ((BoxOfRocks) smallBox).getNumAmmo());
        for (Collectible c : collectibles) {
            c.advanceTime();
        }
        assertEquals(20, ((BagOfGems) largeBag).getNumGems());
        assertEquals(5, ((BagOfGems) smallBag).getNumGems());
        assertEquals(0, ((BagOfGems) zeroGemsBag).getNumGems());
        assertEquals(40, ((BoxOfRocks) largeBox).getNumAmmo());
        assertEquals(4, ((BoxOfRocks) smallBox).getNumAmmo());
        assertTrue(alice.attackEnemy(goblin));
        assertTrue(alice.attackEnemy(demogorgon));
        assertEquals(50, goblin.getHealth());
        assertEquals(100, dragon.getHealth());
        assertEquals(70, demogorgon.getHealth());
        assertEquals(100, bugaboo.getHealth());
        assertEquals(100, clown.getHealth());
        assertEquals(125, alice.getStrengthPoints());
        assertEquals(40, alice.getAmmo());
        assertEquals(25, bob.getStrengthPoints());
        assertEquals(0, bob.getAmmo());
    }
    @Test
    // 5pt
    public void problems1Through5_3() {
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");
        Collectible largeBag = new BagOfGems(20);
        Collectible smallBag = new BagOfGems(5);
        Collectible zeroGemsBag = new BagOfGems(0);
        Collectible largeBox = new BoxOfRocks(10.0, true);
        Collectible smallBox = new BoxOfRocks(2.0, false);
        Enemy goblin = new Goblin();
        Enemy dragon = new Dragon(true);
        Enemy demogorgon = new Demogorgon(75.0);
        Enemy bugaboo = new Bugaboo(30.0);
        Enemy clown = new Clown(true);
        assertTrue(alice.collectItem(largeBag));
        assertTrue(alice.collectItem(largeBox));
        assertTrue(alice.collectItem(smallBox));
        assertTrue(bob.collectItem(smallBag));
        assertTrue(bob.collectItem(zeroGemsBag));
        assertFalse(bob.collectItem(largeBox));
        assertEquals(100, alice.getStrengthPoints());
        assertEquals(44, alice.getAmmo());
        assertEquals(25, bob.getStrengthPoints());
        assertEquals(0, bob.getAmmo());
        assertEquals(100, goblin.getHealth());
        assertFalse(bob.attackEnemy(goblin)); // Bob has 0 ammo
        assertFalse(bob.attackEnemy(dragon)); // Bob has 0 ammo
        assertTrue(alice.attackEnemy(dragon));
        assertTrue(alice.attackEnemy(demogorgon));
        assertFalse(bob.attackEnemy(bugaboo));
        assertFalse(bob.attackEnemy(clown)); // Bob has 0 ammo
        assertEquals(100, goblin.getHealth());
        assertEquals(100, dragon.getHealth());
        assertEquals(85, demogorgon.getHealth());
        assertEquals(100, bugaboo.getHealth());
        assertEquals(100, clown.getHealth());
        for (int i = 0; i < 5; i++) {
            assertTrue(alice.attackEnemy(goblin));
            assertTrue(alice.attackEnemy(dragon));
            assertTrue(alice.attackEnemy(demogorgon));
            assertTrue(alice.attackEnemy(bugaboo));
            assertTrue(alice.attackEnemy(clown));
        }
        Collectible[] collectibles = new Collectible[]{largeBag, smallBag, zeroGemsBag, largeBox, smallBox};

        for (Collectible c : collectibles) {
            c.advanceTime();
        }
        for (int i = 0; i < 5; i++) {
            goblin.advanceTime();
            dragon.advanceTime();
            demogorgon.advanceTime();
            bugaboo.advanceTime();
            clown.advanceTime();
        }
        assertEquals(75, alice.getStrengthPoints());
        assertEquals(17, alice.getAmmo());
        assertEquals(25, bob.getStrengthPoints());
        assertEquals(0, bob.getAmmo());
        assertEquals(0, goblin.getHealth());
        assertEquals(50, dragon.getHealth());
        assertEquals(60, demogorgon.getHealth());
        assertEquals(100, bugaboo.getHealth());
        assertEquals(70, clown.getHealth());
    }
    @Test
    // 5pt
    public void problems1Through5_4() {
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");
        Collectible largeBag = new BagOfGems(20);
        Collectible smallBag = new BagOfGems(5);
        Collectible zeroGemsBag = new BagOfGems(0);
        Collectible largeBox = new BoxOfRocks(10.0, true);
        Collectible smallBox = new BoxOfRocks(2.0, false);
        Enemy goblin = new Goblin();
        Enemy dragon = new Dragon(true);
        Enemy demogorgon = new Demogorgon(75.0);
        Enemy bugaboo = new Bugaboo(30.0);
        Enemy clown = new Clown(true);
        assertTrue(alice.collectItem(largeBag));
        assertTrue(alice.collectItem(largeBox));
        assertTrue(alice.collectItem(smallBox));
        assertTrue(bob.collectItem(smallBag));
        assertTrue(bob.collectItem(zeroGemsBag));
        assertFalse(bob.collectItem(largeBox));
        assertEquals(100, alice.getStrengthPoints());
        assertEquals(44, alice.getAmmo());
        assertEquals(25, bob.getStrengthPoints());
        assertEquals(0, bob.getAmmo());
        assertFalse(bob.attackEnemy(goblin));
        assertFalse(bob.attackEnemy(dragon));
        assertFalse(bob.attackEnemy(bugaboo));
        assertFalse(bob.attackEnemy(clown));
        assertTrue(alice.attackEnemy(dragon));
        assertTrue(alice.attackEnemy(demogorgon));
        assertTrue(alice.attackEnemy(goblin));
        assertEquals(50, goblin.getHealth());
        assertEquals(100, dragon.getHealth());
        assertEquals(85, demogorgon.getHealth());
        assertEquals(100, bugaboo.getHealth());
        assertEquals(100, clown.getHealth());
        Collectible[] collectibles = new Collectible[]{largeBag, smallBag, zeroGemsBag, largeBox, smallBox};
        for (Collectible c : collectibles) {
            c.advanceTime();
        }
        for (int i = 0; i < 5; i++) {
            goblin.advanceTime();
            dragon.advanceTime();
            demogorgon.advanceTime();
            bugaboo.advanceTime();
            clown.advanceTime();
        }
        assertEquals(125, alice.getStrengthPoints());
        assertEquals(41, alice.getAmmo());
        assertEquals(25, bob.getStrengthPoints());
        assertEquals(0, bob.getAmmo());
        assertEquals(0, goblin.getHealth());
        assertEquals(50, dragon.getHealth());
        assertEquals(100, demogorgon.getHealth());
        assertEquals(100, bugaboo.getHealth());
        assertEquals(95, clown.getHealth());
    }
    @Test
    // 2pt
    public void problems1Through5_5() {
        // Players:
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");
        Collectible smallBag = new BagOfGems(5);
        Collectible smallBox = new BoxOfRocks(2.0, false);
        Enemy goblin = new Goblin();
        assertTrue(bob.collectItem(smallBag));
        assertTrue(bob.collectItem(smallBox));
        goblin.advanceTime();
        assertTrue(bob.attackEnemy(goblin));
        assertEquals(75, bob.getStrengthPoints());
        assertEquals(30, goblin.getHealth());
    }
    @Test
    // 2pt
    public void problems1Through5_6() {
        // Players:
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");
        Collectible smallBag = new BagOfGems(0);
        Collectible smallBox = new BoxOfRocks(0.0, false);
        Enemy goblin = new Goblin();
        assertTrue(bob.collectItem(smallBag));
        assertTrue(bob.collectItem(smallBox));
        goblin.advanceTime();
        assertFalse(bob.attackEnemy(goblin));
        assertEquals(0, bob.getStrengthPoints());
        assertEquals(80, goblin.getHealth());
    }
    @Test
    // 3pt
    public void problems1Through5_7() {
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");
        Collectible smallBox = new BoxOfRocks(2.0, false);
        Collectible zeroGemsBag = new BagOfGems(0);
        Enemy goblin = new Goblin();
        assertFalse(alice.collectItem(smallBox));
        assertTrue(bob.collectItem(zeroGemsBag));
        assertEquals(0, alice.getStrengthPoints());
        assertEquals(0, alice.getAmmo());
        assertEquals(0, bob.getStrengthPoints());
        assertEquals(0, bob.getAmmo());
        assertFalse(alice.attackEnemy(goblin));
        assertEquals(100, goblin.getHealth());
    }
    @Test
    //5pt
    public void problems1Through5_8() {
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");
        Collectible largeBag = new BagOfGems(20);
        Collectible smallBag = new BagOfGems(5);
        Collectible zeroGemsBag = new BagOfGems(0);
        Collectible largeBox = new BoxOfRocks(10.0, true);
        Collectible smallBox = new BoxOfRocks(2.0, false);
        Enemy goblin = new Goblin();
        Enemy dragon = new Dragon(true);
        assertTrue(alice.collectItem(largeBag));
        assertTrue(alice.collectItem(smallBox));
        assertTrue(bob.collectItem(smallBag));
        assertTrue(bob.collectItem(zeroGemsBag));
        assertEquals(100, alice.getStrengthPoints());
        assertEquals(4, alice.getAmmo());
        assertEquals(25, bob.getStrengthPoints());
        assertEquals(0, bob.getAmmo());
        assertTrue(alice.attackEnemy(goblin));
        assertTrue(alice.attackEnemy(dragon));
        assertEquals(50, goblin.getHealth());
        assertEquals(100, dragon.getHealth());
    }
    @Test
    // 3pt
    public void problems1Through5_9() {
        Player alice = new Player("Alice");
        Collectible largeBag = new BagOfGems(20);
        Collectible smallBag = new BagOfGems(5);
        Collectible largeBox = new BoxOfRocks(10.0, true);
        Collectible smallBox = new BoxOfRocks(2.0, false);
        Enemy bugaboo = new Bugaboo(30.0);

        assertTrue(alice.collectItem(largeBag));
        assertTrue(alice.collectItem(largeBox));
        assertTrue(alice.collectItem(smallBag));
        assertTrue(alice.collectItem(smallBox));
        assertEquals(125, alice.getStrengthPoints());
        assertEquals(44, alice.getAmmo());
        assertTrue(alice.attackEnemy(bugaboo));
        assertEquals(100, bugaboo.getHealth());
    }
    @Test
    // 5pt
    public void problems1Through5_10() {
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");
        Collectible largeBag = new BagOfGems(15);
        Collectible smallBag = new BagOfGems(10);
        Collectible zeroGemsBag = new BagOfGems(0);
        Collectible largeBox = new BoxOfRocks(5.0, true);
        Collectible smallBox = new BoxOfRocks(3.0, false);
        Enemy goblin = new Goblin();
        Enemy dragon = new Dragon(true);
        Enemy demogorgon = new Demogorgon(50.0);
        Enemy bugaboo = new Bugaboo(40.0);
        Enemy clown = new Clown(true);
        assertTrue(alice.collectItem(largeBag));
        assertTrue(alice.collectItem(largeBox));
        assertTrue(alice.collectItem(smallBox));
        assertTrue(bob.collectItem(smallBag));
        assertTrue(bob.collectItem(zeroGemsBag));
        assertFalse(bob.collectItem(largeBag));
        assertEquals(75, alice.getStrengthPoints());
        assertEquals(26, alice.getAmmo());
        assertEquals(50, bob.getStrengthPoints());
        assertEquals(0, bob.getAmmo());
        assertFalse(bob.attackEnemy(goblin));
        assertFalse(bob.attackEnemy(dragon));
        assertFalse(bob.attackEnemy(bugaboo));
        assertFalse(bob.attackEnemy(clown));
        assertTrue(alice.attackEnemy(dragon));
        assertTrue(alice.attackEnemy(demogorgon));
        assertTrue(alice.attackEnemy(goblin));
        assertEquals(50, goblin.getHealth());
        assertEquals(100, dragon.getHealth());
        assertEquals(85, demogorgon.getHealth());
        assertEquals(100, bugaboo.getHealth());
        assertEquals(100, clown.getHealth());
        Collectible[] collectibles = new Collectible[]{largeBag, smallBag, zeroGemsBag, largeBox, smallBox};
        for (Collectible c : collectibles) {
            c.advanceTime();
        }
        for (int i = 0; i < 5; i++) {
            goblin.advanceTime();
            dragon.advanceTime();
            demogorgon.advanceTime();
            bugaboo.advanceTime();
            clown.advanceTime();
        }
        assertEquals(100, alice.getStrengthPoints());
        assertEquals(23, alice.getAmmo());
        assertEquals(50, bob.getStrengthPoints());
        assertEquals(0, bob.getAmmo());
        assertEquals(0, goblin.getHealth());
        assertEquals(50, dragon.getHealth());
        assertEquals(100, demogorgon.getHealth());
        assertEquals(100, bugaboo.getHealth());
        assertEquals(95, clown.getHealth());
    }
    @Test
    // 5pt
    public void problems1Through5_11() {
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");
        Collectible largeBag = new BagOfGems(25);
        Collectible smallBag = new BagOfGems(3);
        Collectible zeroGemsBag = new BagOfGems(0);
        Collectible largeBox = new BoxOfRocks(8.0, true);
        Collectible smallBox = new BoxOfRocks(1.0, false);
        Enemy goblin = new Goblin();
        Enemy dragon = new Dragon(true);
        Enemy demogorgon = new Demogorgon(90.0);
        Enemy bugaboo = new Bugaboo(35.0);
        Enemy clown = new Clown(true);
        assertTrue(alice.collectItem(largeBag));
        assertTrue(alice.collectItem(largeBox));
        assertTrue(alice.collectItem(smallBox));
        assertTrue(bob.collectItem(smallBag));
        assertTrue(bob.collectItem(zeroGemsBag));
        assertFalse(bob.collectItem(largeBag));
        assertEquals(125, alice.getStrengthPoints());
        assertEquals(34, alice.getAmmo());
        assertEquals(15, bob.getStrengthPoints());
        assertEquals(0, bob.getAmmo());
        assertFalse(bob.attackEnemy(goblin));
        assertFalse(bob.attackEnemy(dragon));
        assertFalse(bob.attackEnemy(bugaboo));
        assertFalse(bob.attackEnemy(clown));
        assertTrue(alice.attackEnemy(dragon));
        assertTrue(alice.attackEnemy(demogorgon));
        assertTrue(alice.attackEnemy(goblin));
        assertEquals(50, goblin.getHealth());
        assertEquals(100, dragon.getHealth());
        assertEquals(85, demogorgon.getHealth());
        assertEquals(100, bugaboo.getHealth());
        assertEquals(100, clown.getHealth());
        Collectible[] collectibles = new Collectible[]{largeBag, smallBag, zeroGemsBag, largeBox, smallBox};
        for (Collectible c : collectibles) {
            c.advanceTime();
        }
        for (int i = 0; i < 5; i++) {
            goblin.advanceTime();
            dragon.advanceTime();
            demogorgon.advanceTime();
            bugaboo.advanceTime();
            clown.advanceTime();
        }
        assertEquals(150, alice.getStrengthPoints());
        assertEquals(31, alice.getAmmo());
        assertEquals(15, bob.getStrengthPoints());
        assertEquals(0, bob.getAmmo());
        assertEquals(0, goblin.getHealth());
        assertEquals(50, dragon.getHealth());
        assertEquals(100, demogorgon.getHealth());
        assertEquals(100, bugaboo.getHealth());
        assertEquals(95, clown.getHealth());
    }
    @Test
    // 5pt
    public void problems1Through5_12() {
        // Setting up players, collectibles, and enemies
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");
        Collectible largeBag = new BagOfGems(10);
        Collectible smallBag = new BagOfGems(8);
        Collectible zeroGemsBag = new BagOfGems(0);
        Collectible largeBox = new BoxOfRocks(6.0, true);
        Collectible smallBox = new BoxOfRocks(4.0, false);
        Enemy goblin = new Goblin();
        Enemy dragon = new Dragon(true);
        Enemy demogorgon = new Demogorgon(80.0);
        Enemy bugaboo = new Bugaboo(45.0);
        Enemy clown = new Clown(true);
        assertTrue(alice.collectItem(largeBag));
        assertTrue(alice.collectItem(smallBox));
        assertTrue(bob.collectItem(smallBag));
        assertTrue(bob.collectItem(zeroGemsBag));
        assertFalse(bob.collectItem(largeBag));
        assertEquals(50, alice.getStrengthPoints());
        assertEquals(8, alice.getAmmo());
        assertEquals(40, bob.getStrengthPoints());
        assertEquals(0, bob.getAmmo());
        assertFalse(bob.attackEnemy(goblin));
        assertFalse(bob.attackEnemy(dragon));
        assertFalse(bob.attackEnemy(bugaboo));
        assertFalse(bob.attackEnemy(clown));
        assertTrue(alice.attackEnemy(dragon));
        assertTrue(alice.attackEnemy(demogorgon));
        assertTrue(alice.attackEnemy(goblin));
        assertEquals(50, goblin.getHealth());
        assertEquals(100, dragon.getHealth());
        assertEquals(85, demogorgon.getHealth());
        assertEquals(100, bugaboo.getHealth());
        assertEquals(100, clown.getHealth());
        Collectible[] collectibles = new Collectible[]{largeBag, smallBag, zeroGemsBag, largeBox, smallBox};
        for (Collectible c : collectibles) {
            c.advanceTime();
        }
        for (int i = 0; i < 5; i++) {
            goblin.advanceTime();
            dragon.advanceTime();
            demogorgon.advanceTime();
            bugaboo.advanceTime();
            clown.advanceTime();
        }
        assertEquals(75, alice.getStrengthPoints());
        assertEquals(5, alice.getAmmo());
        assertEquals(40, bob.getStrengthPoints());
        assertEquals(0, bob.getAmmo());
        assertEquals(0, goblin.getHealth());
        assertEquals(50, dragon.getHealth());
        assertEquals(100, demogorgon.getHealth());
        assertEquals(100, bugaboo.getHealth());
        assertEquals(95, clown.getHealth());
    }
    @Test
    //Problems 6-8: Pests (30 pts)
    //5pts
    public void problems6through8_1() {
        Telemarketer telemarketer = new Telemarketer("Alice");
        Sibling s1 = new Sibling("Bob");
        Sibling s2 = new Sibling("Charlie");
        Ad ad1 = new Ad();
        Ad ad2 = new Ad();
        Fly fly = new Fly();
        assertEquals("Alice", telemarketer.getName());
        assertEquals("Bob", s1.getName());
        assertEquals("Charlie", s2.getName());
        Pest[] pests = { telemarketer, s1, s2, ad1, ad2, fly };
        String[] expected = {
                "Call during dinner | Continue talking when you say no",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Block something you really want to see | Don't go away even when you click X",
                "Block something you really want to see | Don't go away even when you click X",
                "Fly around your head | Land on things"
        };
        for (int i = 0; i < pests.length; i++) {
            assertEquals(expected[i], pests[i].annoy());
        }
        Person[] people = { telemarketer, s1, s2 };
        Arrays.sort(people);
        String[] expectedNames = {"Alice", "Bob", "Charlie"};
        for (int i = 0; i < people.length; i++) {
            assertEquals(expectedNames[i], people[i].getName());
        }
    }

    @Test
    //2pts
    public void problems6through8_2() {
        Pest telemarketer = new Telemarketer("John");
        String expectedFormat = "Call during dinner | Continue talking when you say no";
        assertEquals(expectedFormat, telemarketer.annoy());
        Pest sibling = new Sibling("Emily");
        String siblingFormat = "Tease you about your insecurities | Laugh at you when you are mad";
        assertEquals(siblingFormat, sibling.annoy());
        Pest ad = new Ad();
        String adFormat = "Block something you really want to see | Don't go away even when you click X";
        assertEquals(adFormat, ad.annoy());
        Pest fly = new Fly();
        String flyFormat = "Fly around your head | Land on things";
        assertEquals(flyFormat, fly.annoy());
    }
    @Test
    //3pts
    public void problems6through8_3() {
        Telemarketer telemarketer1 = new Telemarketer("Alice");
        Telemarketer telemarketer2 = new Telemarketer("Bob");
        Sibling s1 = new Sibling("Charlie");
        Sibling s2 = new Sibling("Diana");
        Ad ad1 = new Ad();
        Ad ad2 = new Ad();
        Fly fly1 = new Fly();
        Fly fly2 = new Fly();
        Pest[] pests = { telemarketer1, s1, ad1, fly1, telemarketer2, s2, ad2, fly2 };
        String[] expected = {
                "Call during dinner | Continue talking when you say no",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Block something you really want to see | Don't go away even when you click X",
                "Fly around your head | Land on things",
                "Call during dinner | Continue talking when you say no",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Block something you really want to see | Don't go away even when you click X",
                "Fly around your head | Land on things"
        };
        for (int i = 0; i < pests.length; i++) {
            assertEquals(expected[i], pests[i].annoy());
        }
        Person[] people = { telemarketer1, s1, telemarketer2, s2 };
        Arrays.sort(people); // people is now sorted: Alice, Bob, Charlie, Diana
        String[] expectedNames = {"Alice", "Bob", "Charlie", "Diana"};
        for (int i = 0; i < people.length; i++) {
            assertEquals(expectedNames[i], people[i].getName());
        }
    }
    @Test
    // 3pts
    public void problems6through8_4() {
        Telemarketer telemarketer = new Telemarketer("Eva");
        Sibling sibling = new Sibling("Frank");
        Ad ad = new Ad();
        Fly fly = new Fly();
        assertEquals("Eva", telemarketer.getName());
        assertEquals("Frank", sibling.getName());
        Pest[] pests = { telemarketer, sibling, ad, fly};
        String[] expected = {
                "Call during dinner | Continue talking when you say no",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Block something you really want to see | Don't go away even when you click X",
                "Fly around your head | Land on things",
                "Spam your inbox | Send irrelevant messages"
        };
        for (int i = 0; i < pests.length; i++) {
            assertEquals(expected[i], pests[i].annoy());
        }
        Person[] people = { telemarketer, sibling };
        Arrays.sort(people); // people is now sorted: Eva, Frank
        String[] expectedNames = {"Eva", "Frank"};
        for (int i = 0; i < people.length; i++) {
            assertEquals(expectedNames[i], people[i].getName());
        }
    }
    @Test
    // 2pts
    public void problems6through8_5() {
        Telemarketer telemarketer1 = new Telemarketer("Alice");
        Telemarketer telemarketer2 = new Telemarketer("Bob");
        Sibling s1 = new Sibling("Charlie");
        Sibling s2 = new Sibling("Diana");
        Ad ad1 = new Ad();
        Ad ad2 = new Ad();
        Fly fly1 = new Fly();
        Fly fly2 = new Fly();
        Pest[] pests = { telemarketer1, s1, ad1, fly1, telemarketer2, s2, ad2, fly2 };
        String[] expected = {
                "Call during dinner | Continue talking when you say no",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Block something you really want to see | Don't go away even when you click X",
                "Fly around your head | Land on things",
                "Call during dinner | Continue talking when you say no",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Block something you really want to see | Don't go away even when you click X",
                "Fly around your head | Land on things"
        };
        for (int i = 0; i < pests.length; i++) {
            assertEquals(expected[i], pests[i].annoy());
        }

        Person[] people = { telemarketer1, s1,telemarketer2, s2};
        Arrays.sort(people); // people is now sorted: Alice, Bob, Charlie, Diana
        String[] expectedNames = {"Alice", "Bob", "Charlie", "Diana"};
        for (int i = 0; i < people.length; i++) {
            assertEquals(expectedNames[i], people[i].getName());
        }
    }
    @Test
    // 5pts
    public void problems6through8_6() {
        Telemarketer telemarketer = new Telemarketer("Grace");
        Sibling s1 = new Sibling("Ethan");
        Sibling s2 = new Sibling("Fiona");
        Ad ad1 = new Ad();
        Ad ad2 = new Ad();
        Fly fly = new Fly();

        assertEquals("Grace", telemarketer.getName());
        assertEquals("Ethan", s1.getName());
        assertEquals("Fiona", s2.getName());

        Pest[] pests = { telemarketer, s1, s2, ad1, ad2, fly };
        String[] expected = {
                "Call during dinner | Continue talking when you say no",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Block something you really want to see | Don't go away even when you click X",
                "Block something you really want to see | Don't go away even when you click X",
                "Fly around your head | Land on things"
        };
        for (int i = 0; i < pests.length; i++) {
            assertEquals(expected[i], pests[i].annoy());
        }

        Person[] people = { telemarketer, s1, s2 };
        Arrays.sort(people);
        String[] expectedNames = {"Ethan", "Fiona", "Grace"};
        for (int i = 0; i < people.length; i++) {
            assertEquals(expectedNames[i], people[i].getName());
        }
    }

    @Test
    // 5pts
    public void problems6through8_7() {
        Telemarketer telemarketer1 = new Telemarketer("Oliver");
        Telemarketer telemarketer2 = new Telemarketer("Hazel");
        Sibling s1 = new Sibling("George");
        Sibling s2 = new Sibling("Isabel");
        Ad ad1 = new Ad();
        Ad ad2 = new Ad();
        Fly fly1 = new Fly();
        Fly fly2 = new Fly();

        Pest[] pests = { telemarketer1, s1, ad1, fly1, telemarketer2, s2, ad2, fly2 };
        String[] expected = {
                "Call during dinner | Continue talking when you say no",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Block something you really want to see | Don't go away even when you click X",
                "Fly around your head | Land on things",
                "Call during dinner | Continue talking when you say no",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Block something you really want to see | Don't go away even when you click X",
                "Fly around your head | Land on things"
        };
        for (int i = 0; i < pests.length; i++) {
            assertEquals(expected[i], pests[i].annoy());
        }

        Person[] people = { telemarketer1, s1, telemarketer2, s2 };
        Arrays.sort(people);
        String[] expectedNames = {"George", "Hazel", "Isabel", "Oliver"};
        for (int i = 0; i < people.length; i++) {
            assertEquals(expectedNames[i], people[i].getName());
        }
    }
    @Test
    // 5pts
    public void problems6through8_8() {
        // Create various pests and people
        Telemarketer telemarketer1 = new Telemarketer("Alice");
        Telemarketer telemarketer2 = new Telemarketer("Bob");
        Sibling s1 = new Sibling("Charlie");
        Sibling s2 = new Sibling("Diana");
        Ad ad1 = new Ad();
        Ad ad2 = new Ad();
        Fly fly1 = new Fly();
        Fly fly2 = new Fly();
        Telemarketer telemarketer3 = new Telemarketer("Eve");
        Sibling s3 = new Sibling("Frank");
        Ad ad3 = new Ad();
        Fly fly3 = new Fly();
        String[] expected = {
                "Call during dinner | Continue talking when you say no",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Block something you really want to see | Don't go away even when you click X",
                "Fly around your head | Land on things",
                "Call during dinner | Continue talking when you say no",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Block something you really want to see | Don't go away even when you click X",
                "Fly around your head | Land on things",
                "Call during dinner | Continue talking when you say no",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Block something you really want to see | Don't go away even when you click X",
                "Fly around your head | Land on things"
        };
        Pest[] pests = { telemarketer1, s1, ad1, fly1, telemarketer2, s2, ad2, fly2, telemarketer3, s3, ad3, fly3 };
        for (int i = 0; i < pests.length; i++) {
            assertEquals(expected[i], pests[i].annoy());
        }
        Person[] people = { telemarketer1, s1, telemarketer2, s2, telemarketer3, s3 };
        Arrays.sort(people);
        String[] expectedNames = {"Alice", "Bob", "Charlie", "Diana", "Eve", "Frank"};
        for (int i = 0; i < people.length; i++) {
            assertEquals(expectedNames[i], people[i].getName());
        }
    }



    @Test
    //Problem 9: Segment (10 pts)
    //2pts
    public void problem9_1(){
        String book = " 0 1 2 3 4 5 6 7 8 91011121314151617181920212223";
        Segment fullbook = new Segment(book, 0, 48);
        assertEquals(book, fullbook.toString());
        Segment firstHalf = new Segment(book, 0, 13);
        assertEquals(" 0 1 2 3 4 5 ", firstHalf.toString());
        Segment secondHalf = new Segment(book, 13, 48);
        assertEquals("6 7 8 91011121314151617181920212223", secondHalf.toString());
        CharSequence firstHalfcs = fullbook.subSequence(0, 13);
        assertEquals(firstHalf.toString(), firstHalfcs.toString());
        CharSequence secondHalfcs = fullbook.subSequence(13, 48);
        assertEquals(secondHalf.toString(), secondHalfcs.toString());
        System.out.println(firstHalf.charAt(10));
        assertEquals('1', firstHalf.charAt(3));
        assertEquals('4', firstHalf.charAt(9));
        assertEquals(' ', firstHalf.charAt(4));
        assertEquals(13, firstHalf.length());
        assertEquals(6, firstHalf.subSequence(5, 11).length());
        assertEquals(" 0 1 2 3 4 5 XXXXX6 7 8 91011121314151617181920212223",
                String.join("XXXXX", firstHalf, secondHalf));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        System.out.print(firstHalf);
        System.out.print("-----");
        System.out.print(secondHalf);
        String result = output.toString();
        assertEquals(" 0 1 2 3 4 5 -----6 7 8 91011121314151617181920212223", result);
    }
    @Test
    //2pts
    public void problem9_2() {
        String book = "2021222324 ";
        Segment fullbook = new Segment(book, 0, 11);
        assertEquals(book, fullbook.toString());
        Segment firstHalf = new Segment(book, 0, 5);
        assertEquals("20212", firstHalf.toString());
        Segment secondHalf = new Segment(book, 5, 11);
        assertEquals("22324 ", secondHalf.toString());
        CharSequence firstHalfcs = fullbook.subSequence(0, 5);
        assertEquals(firstHalf.toString(), firstHalfcs.toString());
        CharSequence secondHalfcs = fullbook.subSequence(5, 11);
        assertEquals(secondHalf.toString(), secondHalfcs.toString());
        assertEquals('1', firstHalf.charAt(3));
        assertEquals('3', secondHalf.charAt(2));
        assertEquals(' ', secondHalf.charAt(5));
        assertEquals(5, firstHalf.length());
        assertEquals(2, secondHalf.subSequence(3, 5).length());
        assertEquals("20212XX22324 ",
                String.join("XX", firstHalf, secondHalf));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        System.out.print(firstHalf);
        System.out.print("- - -");
        System.out.print(secondHalf);
        String result = output.toString();
        assertEquals("20212- - -22324 ", result);
    }
    @Test
    //2pts
    public void problem9_3() {
        String text1 = "This is ";
        String text2 = "a test.";
        Segment segment1 = new Segment(text1, 0, text1.length());
        Segment segment2 = new Segment(text2, 0, text2.length());
        String joinedResult = String.join("XX", segment1, segment2);
        assertEquals("This is XXa test.", joinedResult);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        System.out.append(segment1).append(" - ").append(segment2);
        String result = output.toString();
        assertEquals("This is  - a test.", result);
    }
    @Test
    //2pts
    public void problem9_4() {
        Segment emptySegment = new Segment("", 0, 0);
        assertEquals("", emptySegment.toString());
        String specialText = "!@#";
        Segment specialSegment = new Segment(specialText, 0, specialText.length());
        assertEquals("!@#", specialSegment.toString());
        CharSequence emptySubsequence = emptySegment.subSequence(0, 0);
        assertEquals("", emptySubsequence.toString());
        CharSequence fullSubsequence = specialSegment.subSequence(0, specialSegment.length());
        assertEquals(0, emptySegment.length());
        assertEquals(3, specialSegment.length());
        assertEquals("XX22324 ",
                String.join("XX", emptySegment, new Segment("22324 ", 0, 6)));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.out.print(emptySegment);
        System.out.print("- - -");
        System.out.print(specialSegment);
        String result = output.toString();
        assertEquals("", result);
    }
    @Test
    //2pts
    public void problem9_5() {
        String text1 = "The fox jumped";
        String text2 = " over the lazy dog.";
        Segment segment1 = new Segment(text1, 0, text1.length());
        Segment segment2 = new Segment(text2, 0, text2.length());
        String joinedResult = String.join("X!_X", segment1, segment2);
        assertEquals("The fox jumpedX!_X over the lazy dog.", joinedResult);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String j_result = String.join(" - ", segment1, segment2);
        assertEquals("The fox jumped -  over the lazy dog.", j_result);
    }
    @Test
    // Problem 10: Student and StudentFinder (10 pts)
    //2pts
    public void problem10_1() {
        Student[] students = new Student[]{
                new Student("Alice", 9876),
                new Student("Bob", 5432),
                new Student("Charlie", 1111),
                new Student("David", 2222),
                new Student("Eve", 8888),
                new Student("Alice", 1234),
                new Student("David", 3333),
                new Student("Frank", 5555),
                new Student("Bob", 9999),
                new Student("Grace", 7777)
        };
        assertEquals("Charlie, 1111", students[2].toString());
        assertEquals("David, 3333", students[6].toString());
        assertEquals("Grace, 7777", students[9].toString());
        assertTrue(students[0].compareTo(students[1]) < 0);
        assertTrue(students[3].compareTo(students[5]) > 0);
        assertTrue(students[1].compareTo(students[8]) == -1);
        assertFalse(students[0].equals(students[5]));
        assertEquals(students[5], StudentFinder.firstStudent(students));
        assertEquals(students[9], StudentFinder.lastStudent(students));
    }
    @Test
    //2pt
    public void problem10_2() {
        Student student1 = new Student("John", 123);
        Student student2 = new Student("John", 123);
        assertTrue(student1.equals(student2));
        Student student3 = new Student("Alice", 456);
        Student student4 = new Student("Bob", 456);
        assertFalse(student3.equals(student4));
        Student student5 = new Student("Charlie", 789);
        Student student6 = new Student("Charlie", 987);
        assertFalse(student5.equals(student6));
        Student student7 = new Student("Mary-Jane", 555);
        Student student8 = new Student("Mary&John", 555);
        assertFalse(student7.equals(student8));
    }
    @Test
    //2pt
    public void problem10_3() {
        Student student9 = new Student("Sam", Integer.MIN_VALUE);
        Student student10 = new Student("Sam", Integer.MIN_VALUE + 1);
        assertTrue(student9.compareTo(student10) < 0);
        Student student11 = new Student("Max", Integer.MAX_VALUE);
        Student student12 = new Student("Max", Integer.MAX_VALUE - 1);
        assertTrue(student11.compareTo(student12) > 0);
    }
    @Test
    //2pt
    public void problem10_4() {
        Student[] students = new Student[]{
                new Student("Alice", 9876),
                new Student("Alice", 0000),
                new Student("Charlie", 1111),
                new Student("Charlie", 2222),
                new Student("Eve", 8888),
                new Student("Eve", 8888),
                new Student("David", 3333),
                new Student("David", 3334),
                new Student("Alice", 9876)
        };
        assertEquals("Alice, 0", students[1].toString()); //DIYA: CHECK SHOULDN'T IT BE ALICE, 0000
        assertEquals("Charlie, 2222", students[3].toString());
        assertEquals("Eve, 8888", students[5].toString());
        assertTrue(students[3].compareTo(students[5]) < 0);
        assertTrue(students[1].compareTo(students[7]) < 0);
        assertEquals(students[4], StudentFinder.lastStudent(students));
        assertEquals(students[1], StudentFinder.firstStudent(students));
    }
    @Test
    //2pt
    public void problem10_5() {
        Student[] students = new Student[]{
                new Student("Alice", 9876),
                new Student("Alice", 0000),
                new Student("Charlie", 1111),
                new Student("Charlie", 2222),
                new Student("Eve", 8888),
                new Student("Eve", 8888),
                new Student("David", 3333),
                new Student("David", 3334),
                new Student("Alice", 9876)
        };
        assertEquals("Alice, 0", students[1].toString()); //DIYA: CHECK SHOULDN'T IT BE ALICE, 0000
        assertEquals("Charlie, 2222", students[3].toString());
        assertEquals("Eve, 8888", students[5].toString());
        assertTrue(students[3].compareTo(students[5]) < 0);
        assertTrue(students[1].compareTo(students[7]) < 0);
        assertEquals(students[4], StudentFinder.lastStudent(students));
        assertEquals(students[1], StudentFinder.firstStudent(students));
    }

}

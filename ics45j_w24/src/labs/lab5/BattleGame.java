package labs.lab5;

/**
 * A test class for the battle game
 *
 */

public class BattleGame {

	public static void main(String[] args) {

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
		System.out.println("Collecting stuff"); // 
		System.out.println(robert.collectItem(bigBag)); // true
		System.out.println(robert.getStrengthPoints()); // 50
		System.out.println(emily.collectItem(bigBag)); // false
		System.out.println(emily.getStrengthPoints()); // 0
		System.out.println(emily.collectItem(smallBox)); // false
		System.out.println(emily.getStrengthPoints()); // 0
		System.out.println(emily.getAmmo()); // 0
		System.out.println(robert.collectItem(mediumBox)); // true
		System.out.println(robert.getStrengthPoints()); // 50
		System.out.println(robert.getAmmo()); // 9
		System.out.println(emily.collectItem(mediumBag)); // true
		System.out.println(emily.getStrengthPoints()); // 25
		System.out.println(emily.collectItem(mediumBag)); // false
		System.out.println(emily.collectItem(smallBox)); // true
		System.out.println(emily.getAmmo()); // 2
		System.out.println(); // 

		// attacking enemies:
		System.out.println("Attacking enemies"); // 
		System.out.println(goblin1.getHealth()); // 100
		System.out.println(emily.attackEnemy(goblin1)); // true
		System.out.println(emily.getAmmo()); // 1
		System.out.println(emily.getStrengthPoints()); // 75
		System.out.println(((Goblin) goblin1).getColor()); // red
		System.out.println(goblin1.getHealth()); // 50

		System.out.println(fbDragon.getHealth()); // 100
		System.out.println(emily.attackEnemy(fbDragon)); // true
		System.out.println(emily.getAmmo()); // 0
		System.out.println(emily.getStrengthPoints()); // 50
		System.out.println(fbDragon.getHealth()); // 100

		System.out.println(bigDemo.getHealth()); // 100
		System.out.println(emily.attackEnemy(bigDemo)); // false (because Emily has 0 ammo)
		System.out.println(emily.getStrengthPoints()); // 50
		System.out.println(bigDemo.getHealth()); // 100
		System.out.println(); // 

		// advancing time:
		// Collectables:
		System.out.println("Collectables"); // 
		Collectible[] collectables = new Collectible[] { bigBag, smallBag, mediumBag, bigBox, smallBox, mediumBox };

		System.out.println(((BagOfGems) bigBag).getNumGems()); // 10
		System.out.println(((BagOfGems) smallBag).getNumGems()); // 2
		System.out.println(((BoxOfRocks) bigBox).getNumAmmo()); // 30
		System.out.println(((BoxOfRocks) mediumBox).getNumAmmo()); // 9

		for (Collectible c : collectables) {
			c.advanceTime();
		}

		System.out.println(((BagOfGems) bigBag).getNumGems()); // 10
		System.out.println(((BagOfGems) smallBag).getNumGems()); // 3
		System.out.println(((BoxOfRocks) bigBox).getNumAmmo()); // 29
		System.out.println(((BoxOfRocks) mediumBox).getNumAmmo()); // 9

		for (Collectible c : collectables) {
			c.advanceTime();
		}

		System.out.println(((BagOfGems) bigBag).getNumGems()); // 10
		System.out.println(((BagOfGems) smallBag).getNumGems()); // 4
		System.out.println(((BoxOfRocks) bigBox).getNumAmmo()); // 27
		System.out.println(((BoxOfRocks) mediumBox).getNumAmmo()); // 9
		System.out.println(); // 

		// Enemies:
		System.out.println("Enemies"); // 
		Enemy[] enemies = new Enemy[] { armedClown, unarmedClown, goblin1, goblin2, fbDragon, dragon, bigDemo,
				mediumDemo, smallDemo, weakBugaboo, strongBugaboo };

		System.out.println(((Goblin) goblin1).getColor()); // red
		System.out.println(goblin1.getHealth()); // 50
		System.out.println(goblin2.getHealth()); // 100
		System.out.println(((Goblin) goblin2).getColor()); // purple
		System.out.println(((Dragon) fbDragon).isFireBreathing()); // true
		System.out.println(fbDragon.getHealth()); // 100
		System.out.println(((Demogorgon) bigDemo).getWeight()); // 100.0
		System.out.println(bigDemo.getHealth()); // 100
		System.out.println(((Bugaboo) weakBugaboo).getStrength()); // 50.25
		System.out.println(weakBugaboo.getHealth()); // 100
		System.out.println(((Clown) armedClown).hasWeapon()); // true
		System.out.println(armedClown.getHealth()); // 100

		for (Enemy e : enemies) {
			e.advanceTime();
		}

		System.out.println(((Goblin) goblin1).getColor()); // purple
		System.out.println(goblin1.getHealth()); // 30
		System.out.println(goblin2.getHealth()); // 80
		System.out.println(((Goblin) goblin2).getColor()); // orange
		System.out.println(((Dragon) fbDragon).isFireBreathing()); // false
		System.out.println(fbDragon.getHealth()); // 90
		System.out.println(((Demogorgon) bigDemo).getWeight()); // 105.0
		System.out.println(bigDemo.getHealth()); // 100
		System.out.println(((Bugaboo) weakBugaboo).getStrength()); // 57.7875
		System.out.println(weakBugaboo.getHealth()); // 100
		System.out.println(((Clown) armedClown).hasWeapon()); // false
		System.out.println(armedClown.getHealth()); // 99

		for (Enemy e : enemies) {
			e.advanceTime();
		}

		System.out.println(((Goblin) goblin1).getColor()); // orange
		System.out.println(goblin1.getHealth()); // 10
		System.out.println(goblin2.getHealth()); // 60
		System.out.println(((Goblin) goblin2).getColor()); // black
		System.out.println(((Dragon) fbDragon).isFireBreathing()); // true
		System.out.println(fbDragon.getHealth()); // 80
		System.out.println(((Demogorgon) bigDemo).getWeight()); // 110.25
		System.out.println(bigDemo.getHealth()); // 100
		System.out.println(((Bugaboo) weakBugaboo).getStrength()); // 66.4556
		System.out.println(weakBugaboo.getHealth()); // 100
		System.out.println(((Clown) armedClown).hasWeapon()); // true
		System.out.println(armedClown.getHealth()); // 98

		for (Enemy e : enemies) {
			e.advanceTime();
		}

		System.out.println(((Goblin) goblin1).getColor()); // black
		System.out.println(goblin1.getHealth()); // 0
		System.out.println(goblin2.getHealth()); // 40
		System.out.println(((Goblin) goblin2).getColor()); // purple
		System.out.println(((Dragon) fbDragon).isFireBreathing()); // false
		System.out.println(fbDragon.getHealth()); // 70
		System.out.println(((Demogorgon) bigDemo).getWeight()); // 115.7625
		System.out.println(bigDemo.getHealth()); // 100
		System.out.println(((Bugaboo) weakBugaboo).getStrength()); // 76.42397
		System.out.println(weakBugaboo.getHealth()); // 100
		System.out.println(((Clown) armedClown).hasWeapon()); // false
		System.out.println(armedClown.getHealth()); // 97

		for (Enemy e : enemies) {
			System.out.println(robert.attackEnemy(e));
		}

		System.out.println(((Clown) armedClown).hasWeapon()); // false
		System.out.println(armedClown.getHealth()); // 77
		System.out.println(((Goblin) goblin1).getColor()); // red
		System.out.println(goblin1.getHealth()); // 0
		System.out.println(goblin2.getHealth()); // 0
		System.out.println(((Goblin) goblin2).getColor()); // red
		System.out.println(((Dragon) fbDragon).isFireBreathing()); // false
		System.out.println(fbDragon.getHealth()); // 95
		System.out.println(((Demogorgon) bigDemo).getWeight()); // 104.18625
		System.out.println(bigDemo.getHealth()); // 85
		System.out.println(((Bugaboo) weakBugaboo).getStrength()); // 76.42397
		System.out.println(weakBugaboo.getHealth()); // 100

		System.out.println(robert.getAmmo()); // 0
		System.out.println(robert.getStrengthPoints()); // 100
	}

}
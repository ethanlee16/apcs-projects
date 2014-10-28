/*
 * CritterTester.java - instantiates Critter
 * 
 * @author ethan.lee
 * 
 */


public class CritterTester {

	public static void main(String[] args) {
		
		Critter c = new Critter(20, 89);
		
		// Uncomment to see log messages of moveCount
	    // Critter.printLogMessages = true;
		c.moveUp(95); c.moveLeft(41.2); c.moveRight(20); c.moveDown(1);
		c.moveUp(12); c.moveLeft(18); c.moveRight(Math.PI); c.moveDown(188);
		c.moveUp(23); c.moveLeft(40); 
		
		printResults(c);
		
		c.hospitalize(); //E.T. go home
		
		// NOTE: Moves in less random numbers, easier-to-read Critter (you can see the results work)
		c.moveUp(1); c.moveLeft(2); c.moveRight(3); c.moveDown(4);
		c.moveUp(4); c.moveLeft(3); c.moveRight(2); c.moveDown(1);
		c.moveUp(3); c.moveLeft(5); c.moveRight(6); c.moveDown(4);
		
		printResults(c);
		
	}
	
	private static void printResults(Critter critter) {
		System.out.println("Current coordinates of the Critter are: (" +
		critter.getCoords()[0] + ", " + critter.getCoords()[1] + ")");
				
		System.out.println("Current distance of the Critter from the origin is " + critter.getDist());
	}
}

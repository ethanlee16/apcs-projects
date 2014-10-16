/**
 * Critter.java - moves around a Cartesian plane (does not fly)
 * 
 * @author ethan.lee
 *
 */
public class Critter {

	static double posX;
	static double posY;
	static int moveCount = 0;
	public static boolean printLogMessages = false;
	
	public Critter() {
		posX = 0;
		posY = 0;
	}
	
	public Critter(int initialX, int initialY) {
		posX = (double) initialX;
		posY = (double) initialY;
	}
	
	public void moveUp(double deltaY) {
		posY += deltaY;
		count();
	}
	
	public void moveDown(double deltaY) {
		posY -= deltaY;
		count();
	}
	
	public void moveLeft(double deltaX) {
		posX -= deltaX;
		count();
	}
	
	public void moveRight(double deltaX) {
		posX += deltaX;
		count();
	}
	
	public double[] getCoords() {
		double[] coords = {posX, posY};
		return coords;
	}
	
	
	public double getDist() {
		double distance;
		distance = Math.sqrt(Math.pow(posX, 2) + Math.pow(posY, 2));
		return distance;
	}
	
	public void hospitalize() {
		//Resets to origin
		posX = 0;
		posY = 0;
		System.out.println("Critter hospitalized and returned to (0,0)");
		count();
	}
	
	private static void count() {
		moveCount++;
		if(printLogMessages) {
			System.out.println("LOG: moveCount is now " + moveCount);
		}
	}
	
}

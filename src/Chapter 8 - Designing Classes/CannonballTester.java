import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class CannonballTester {
	
	private static Scanner prompt;
	
	public static void main(String args[]) {
		
		// Assuming that our cannonball will start at x-pos 0
		Cannonball c = new Cannonball(0);
		prompt = new Scanner(System.in);
		
		System.out.print("Please enter a starting angle (in degrees) "
				+ "for the cannonball's trajectory.\n> ");
		double angle = prompt.nextDouble();
		
		System.out.print("Please enter an initial velocity (in m/s) "
				+ "for the cannonball.\n> ");
		double velocity = prompt.nextDouble();
		
		ArrayList<Point> list = c.shoot(angle, velocity, 0.5);
		for(Point p : list) {
			System.out.println("(" + p.getX() + ", " + p.getY() + ")");
		}
	}
}

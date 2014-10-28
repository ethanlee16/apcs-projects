/**
 * RoachSimulation.java - calls out RoachPopulation.
 * 
 * Yuck.
 * @author ethan.lee
 * @version 0.1
 *
 */
public class RoachSimulation {
	public static void main(String[] args) {
		
		RoachPopulation roaches = new RoachPopulation(10);
		
		for(int i = 0; i < 3; i++) {
			roaches.breed(); roaches.spray(0.1);
			System.out.println("Current Population after " + (i + 1) + " breeds and"
					+ " 10% reductions after each: "  + roaches.getRoaches());
		}
	}
}

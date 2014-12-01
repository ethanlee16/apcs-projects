/**
 * BuffonNeedle.java
 * @author ethan.lee
 *
 */
import java.util.Random;
public class BuffonNeedle {
	
	public static final int TRIES = 10000;
	
	public static void main(String[] args) {
		Random rand = new Random();
		double toRadians = Math.PI / 180;
		int hits = 0;
		
		for(int i = 0; i < TRIES; i++) {
			double ylow = rand.nextDouble() * 2 + Double.MIN_VALUE;
			// min value is added to make inclusive
			double angle = rand.nextDouble() * 180 + Double.MIN_VALUE;
			double yhigh = ylow + Math.sin(angle * toRadians);
			if(yhigh >= 2) {
				hits++;
			}
		}

		System.out.println((double)TRIES / hits);
	}
}

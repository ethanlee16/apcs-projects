/**
 * DrunkardsWalk.java
 * @author ethan.lee
 *
 */
import java.util.Random;
public class DrunkardsWalk {
	
	public static void main(String[] args) {
		int[] coords = {0, 0};
		Random rand = new Random();
		
		for(int i = 0; i < 100; i++) {
			int direction = rand.nextInt(4);
			switch(direction) {
				// LEFT
				case 0:
					coords[0]--;
					break;
			
				// RIGHT
				case 1:
					coords[0]++;
					break;
					
				// UP
				case 2:
					coords[1]++;
					break;
					
				// DOWN
				case 3:
					coords[1]--;
					break;
			}
		}
		
		System.out.println("Drunkard ended up at ("
				+ coords[0] + ", " + coords[1] + ").");
	}
}

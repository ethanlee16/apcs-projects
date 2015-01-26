import java.util.Random;
import java.util.ArrayList;
public class RandomPermutations {
	
	public static final int NUMBER = 10;
	
	public static void main(String[] args) {
		int[] array = new int[NUMBER];
		ArrayList<Integer> randArray = new ArrayList<Integer>();
		Random rand = new Random();
		
		for(int i = 1; i < NUMBER + 1; i++) {
			randArray.add(i);
		}
		
		int newSize = NUMBER;
		for(int i = 0; i < array.length; i++) {
			int random = rand.nextInt(newSize);
			array[i] = randArray.get(random);
			randArray.remove(random);
			newSize--;
			
			/* Print the array while we're at it. */
			System.out.println("Random array at index " + i + " has " + array[i]);
		}
		
		
	}
}

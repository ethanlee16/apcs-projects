import java.util.Random;
public class RandomArray {

		public static final int NUMBER_OF_ELEMENTS = 10;

		public static void main(String[] args) {
			Random rand = new Random();
			int[] array = new int[NUMBER_OF_ELEMENTS];

			for(int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
				array[i] = rand.nextInt(Integer.MAX_VALUE);
			}
			
			/* Print the results */
			for(int i = 0; i < NUMBER_OF_ELEMENTS; i += 2) {
				if(i % 2 == 0) {
					System.out.println("Index at " + i + " has " + array[i]);
				}
			}

			for(int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
				if(array[i] % 2 == 0) {
					System.out.println("Element at index " + i + " is even, being " + array[i]);
				}
			}

			for(int i = NUMBER_OF_ELEMENTS; i > 0; i--) {
				System.out.println("Element at index " + (i - 1) + " has " + array[i-1]);
			}

			System.out.println("First element is " + array[0] + " and last element is " + array[array.length - 1]);
		}
}

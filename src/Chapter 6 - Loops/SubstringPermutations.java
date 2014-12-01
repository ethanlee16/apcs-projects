/**
 * SubstringPermutations - All possible permutations
 * of substrings of a String input.
 * 
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class SubstringPermutations {
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		System.out.println("Please enter a string "
				+ "to see all of its permutations.");
		prompt = new Scanner(System.in);
		String input = prompt.nextLine();
		
		// Iterate through each number of characters
		for(int x = 0; x <= input.length(); x++) {
			// Iterate through each number of combinations
			for(int y = 0; y < input.length() - x; y++) {
				// Print out the combination (between the current
				// y and non-inclusive of the number we're on and
				// length of current combo)
				System.out.println(input.substring(y, y + x + 1));
			}
		}
		
	}
}

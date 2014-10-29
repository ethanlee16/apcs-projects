/**
 * PairChecker.java
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class PairChecker {

	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		System.out.println("Please enter four numbers, formatted "
				+ "as follows to check for pairs: 1 2 2 1");
		String input = "";
		prompt = new Scanner(System.in);
		
		input = prompt.nextLine();
		while(!input.matches("\\d+ \\d+ \\d+ \\d+")) {
			System.out.println("Invalid input.");
			input = prompt.nextLine();
		}
		
		String[] stringNums = input.split("\\s");
		int[] nums = {0, 0, 0, 0};
		
		for(int i = 0; i < 4; i++) {
			nums[i] = Integer.valueOf(stringNums[i]);
		}
		
		// Case of example: [0, 0, 1, 1]
		if (nums[0] == nums[1] && nums[2] == nums[3]) {
			System.out.println("Two pairs");
		}
		// Case of example: [0, 1, 0, 1]
		else if (nums[0] == nums[2] && nums[1] == nums[3]) {
			System.out.println("Two pairs");
		}
		// Case of example: [0, 1, 1, 0]
		else if (nums[0] == nums[3] && nums[1] == nums[2]) {
			System.out.println("Two pairs");
		}
		else {
			System.out.println("Not two pairs");
		}

	}
}

/**
 * NumberOrder.java - outputs how a set of three user-inputted numbers are ordered
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class NumberOrder {

	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		System.out.println("Please enter three numbers separated by spaces.");
		
		String input = "";
		prompt = new Scanner(System.in);
		
		input = prompt.nextLine();
		while(!input.matches("\\d+ \\d+ \\d+")) {
			System.out.println("Invalid input.");
			input = prompt.nextLine();
		}
		
		String[] stringNums = input.split("\\s");
		int[] nums = {0, 0, 0};
		for(int i = 0; i < 3; i++) {
			nums[i] = Integer.valueOf(stringNums[i]);
			// DIAG: System.out.println("in: " + i + " " + nums[i]);
		}
		
		if(nums[2] > nums[1] && nums[1] > nums[0]) {
			System.out.println("This pattern is increasing.");
		}
		else if(nums[2] < nums[1] && nums[1] < nums[0]) {
			System.out.println("This pattern is decreasing.");
		}
		else {
			System.out.println("No pattern was found.");
		}
	
		
	}
}

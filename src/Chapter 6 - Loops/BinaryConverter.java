/**
 * BinaryConverter - takes an integer and converts it
 * to its equivalent in a base-2 (binary) number system.
 * Does not work for signed integers.
 * 
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class BinaryConverter {
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		System.out.println("Please enter an integer number "
				+ "to get its unsigned binary equivalent.");
		prompt = new Scanner(System.in);
		
		while(!prompt.hasNextInt()) {
			System.out.println("Invalid input");
			prompt.next();
		} int input = prompt.nextInt();
		
		while(input > 0) {
			System.out.print(input % 2);
			input /= 2;
		}
		
	}
}

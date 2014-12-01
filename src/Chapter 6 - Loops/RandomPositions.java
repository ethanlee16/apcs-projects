/**
 * RandomPositions.java - moves characters around in a String
 * @author ethan.lee
 *
 */
import java.util.Scanner;
import java.util.Random;
public class RandomPositions {

	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		System.out.println("Please enter a string to be randomly "
				+ "mutated.");
		prompt = new Scanner(System.in);
		String input = prompt.nextLine();
		Random rand = new Random();
		int i, j;
		String first, middle, last;
		
		for(int x = input.length(); x > 0; x--) {
			
			// Can be any position in the string 
			// except the last character. (nextInt() is
			// exclusive to argument)
			i = rand.nextInt(input.length() - 1);
			
			// Can be any position in the string
			// between i (minimum, written as (i + 1)
			// to avoid getting i) and input.length()
			j = rand.nextInt(input.length() - (i + 1)) + (i + 1);
			
			first = input.substring(0, i);
			middle = input.substring((i + 1), j);
			
			// Catch a case here in which i and j make up
			// the last two characters of the String, prevent
			// IndexOutOfBoundsException. 
			if(j < input.length() - 1) {
				last = input.substring((j + 1), input.length());
			}
			else {
				last = "";
			}
			input = first + input.charAt(j) + middle
					+ input.charAt(i) + last;
		}
		System.out.println(input);
	}
}

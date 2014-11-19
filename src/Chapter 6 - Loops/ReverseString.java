/**
 * ReverseString.java - reverses String input
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class ReverseString {
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		prompt = new Scanner(System.in);
		String input = prompt.nextLine();
		String reversed = "";
		
		for(int i = input.length() - 1; i >= 0; i--) {
			reversed += input.charAt(i);
		}
		System.out.println(reversed);
	}
}

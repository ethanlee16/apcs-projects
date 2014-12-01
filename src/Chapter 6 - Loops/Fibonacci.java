/**
 * Fibonacci.java - prints the nth number in the 
 * Fibonacci sequence.
 * 
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class Fibonacci {
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;		
		
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		System.out.print("Enter an integer to get the nth "
				+ "number in the Fibonacci sequence.\n> ");
		prompt = new Scanner(System.in);
		
		while(!prompt.hasNextInt() || !prompt.hasNext("[0-9]+")) {
			System.out.print("Invalid input. Try again.\n> ");
			prompt.next();
		}
		int input = prompt.nextInt();
		
		if(input == 2 || input == 3) {
			System.out.println("1");
			return;
		}
		
		int f1 = 1;
		int f2 = 1;
		int fnew = 0;
		
		for(int i = 0; i < input - 3; i++) {
			fnew = f1 + f2;
			f2 = f1;
			f1 = fnew;
		}
		System.out.println(fnew);		
	}
}

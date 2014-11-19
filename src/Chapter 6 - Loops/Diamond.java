/**
 * Diamond.java - prints out a diamond of specified
 * int length.
 * 
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class Diamond {
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;		
		
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		String halfDiamond = "";
		prompt = new Scanner(System.in);
		while(!prompt.hasNextInt()) {
			System.out.println("Invalid input");
			prompt.next();
		}
		int input = prompt.nextInt();
		for(int i = 0; i < input - 1; i++) {
			halfDiamond += "\n";
			for(int j = input - i - 1; j > 0; j--) {
				halfDiamond += " ";
			}
			for(int k = 0; k < i * 2 + 1; k++) {
				halfDiamond += "*";
			}
			// We need to add spaces again so that
			// when we reverse it, it shows up the
			// same way.
			for(int j = input - i - 1; j > 0; j--) {
				halfDiamond += " ";
			}
		}
		String diamond = halfDiamond;
		
		// Bit of an ugly hack to add the middle row.
		diamond += "\n";
		for(int l = 0; l < input * 2 - 1; l++) {
			diamond += "*";
		}
		diamond += "\n";
		
		// Reverse the half-diamond.
		for(int m = halfDiamond.length() - 1; m >= 0; m--) {
			diamond += halfDiamond.charAt(m);
		}
		System.out.print(diamond);
	}
}

/**
 * Alphabetize.java - sorts words lexicographically
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class Alphabetize {
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		System.out.println("Please enter three words to be sorted:");
		prompt = new Scanner(System.in);
		
		String input = prompt.nextLine();
		while(!input.matches("\\w+ \\w+ \\w+")) {
			System.out.println("Invalid input: enter three words.");
			input = prompt.nextLine();
		}
		
		String[] strs = input.split("\\s");

		// *restrains self from using Arrays.sort()*
		for(int i = 0; i < strs.length; i++) {
			int x = i + 1;
			boolean endOfLoop = false;
			
			// A hack to make sure that it compares
			// 0 to 2 and not 2 to 0. endOfLoop resets
			// i so it's not infinitely recursive.
			
			if(x >= strs.length) {
				endOfLoop = true;
				x = 2;
				i = 0;
			}
 
			if(strs[i].compareTo(strs[x]) > 0) {
				String backup = strs[x];
				strs[x] = strs[i];
				strs[i] = backup;
			
			}
			if (endOfLoop) {
				i = strs.length;
				
				// Another hack to make sure one last
				// check is made, between 0 and 1.
				//
				// For the case `c b a`, 0 and 1 are 
				// checked to get b c a, 1 and 2 are
				// checked to get b a c, but 0 and 2
				// does not yield a b c. One last check
				// must be made.
				
				if(strs[0].compareTo(strs[1]) > 0) {
					String backup = strs[1];
					strs[1] = strs[0];
					strs[0] = backup;
				}
			}
			
		}

		for(String s : strs) {
			System.out.print(s + " ");
		}
		
	}
}

/* DIAG:
 * 	System.out.println("Test: " + strs[i].compareTo(strs[x]));
 *	System.out.println("Replaced " + strs[x] + " for " + strs[i] + " at " + i);
 *	System.out.println("Replaced " + strs[i] + " for " + strs[x] + " at " + x);	
 *	System.out.println("Currently: [0] " + strs[0] + ", [1] " + strs[1] + ", [2] " + strs[2]); 
 */

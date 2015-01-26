import java.util.Scanner;
import java.util.Arrays;
public class RestroomStalls {
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		
		System.out.print("Enter a number for the stalls in the restroom.\n> ");
		prompt = new Scanner(System.in);
		
		int stalls;
		while(!prompt.hasNextInt()) {
			System.out.println("Error: requires an integer number.");
			prompt.next();
		}
		
		stalls = prompt.nextInt();
		boolean[] room = new boolean[stalls];
		Arrays.fill(room, false);
		
		int middle = room.length / 2;
		int current = middle;
		
		for(int i = 0; i < room.length; i++) {
			for(int j = 0; j < room.length; j++) {
				if(room[j]) {
					System.out.print(" X ");
				}
				else {
					System.out.print(" _ ");
				}
			}
			
			current = current / 2;
			middle = (i % 2 == 0) ? current : (room.length - 1) - current; // for next run
			
			if(room[middle]) {
				if(i % 2 == 0 ) {
					room[middle + 1] = true;
				}
				else {
					room[middle - 1] = true;
				}
			}
			else {
				room[middle] = true;
			}
			
			System.out.print("\n");
		}
	}
}

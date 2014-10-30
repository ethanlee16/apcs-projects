/**
 * MinivanDoorControl.java
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class MinivanDoorControl {
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		
		System.out.println("Please enter a set of control values to simulate.\n"
				+ "The format is 0/1 0/1 0/1 0/1 0/1 0/1 0/1 0/1 P/N/D/1/2/3/R.\n"
				+ "All the 0/1 groups can be EITHER 0 or 1, representing on and off.\n"
				+ "Each group is also separated by spaces. The values are defined as "
				+ "the following: \n"
				+ "- Left door dashboard switch (0/1)\n"
				+ "- Right door dashboard switch (0/1)\n"
				+ "- Child lock (0/1)\n"
				+ "- Master unlock (0/1)\n"
				+ "- Inside left door handle (0/1)\n"
				+ "- Inside right door handle (0/1)\n"
				+ "- Outside left door handle (0/1)\n"
				+ "- Outside right door handle (0/1)\n"
				+ "- Gear (P[park]/N[neutral]/D[drive]/1/2/3/R[reverse]");
		
		prompt = new Scanner(System.in);
		
		String input = prompt.nextLine();
		while(!input.matches("[0-1] [0-1] [0-1] [0-1] "
				+ "[0-1] [0-1] [0-1] [0-1] (P|N|D|[1-3]|R){1}")) {
			System.out.println("Invalid input. Try again.");
			input = prompt.nextLine();
		}
		
		String[] inputArray = input.split(" ");
		
		// Are any doors trying to be opened?
		if(inputArray[0].equals("1") || inputArray[1].equals("1")
				|| inputArray[4].equals("1") || inputArray[5].equals("1")
				|| inputArray[6].equals("1") || inputArray[7].equals("1")) {
			
			// Are we in park?
			if(inputArray[8].equals("P")) {
				
				// Is master unlock activated?
				if(inputArray[3].equals("1")) {
					
					//Is it one of the dashboard switches?
					if(inputArray[0].equals("1") || inputArray[1].equals("1")) {
						if(inputArray[0].equals("1")) {
							System.out.println("Left door opened, "
									+ "via dashboard switch.");
						}
						if(inputArray[1].equals("1")) {
							System.out.println("Right door opened, "
									+ "via dashboard switch.");
						}
						
					// Is it one of the inside handles?
					} else if (inputArray[4].equals("1") || inputArray[5].equals("1")
							&& inputArray[2].equals("0")) {
						if(inputArray[4].equals("1")) {
							System.out.println("Left door opened, "
									+ "via inside handle.");
						}
						if(inputArray[5].equals("1")) {
							System.out.println("Right door opened, "
									+ "via inside handle.");
						}	
						
					// That didn't work. Was child lock not off?
					} else if (inputArray[4].equals("1") || inputArray[5].equals("1")
							&& !inputArray[2].equals("0")) {
						System.out.println("Both doors stay closed. "
								+ "Child lock is on.");
						
					// Was it one of the outside handles?
					} else if (inputArray[6].equals("1") || inputArray[7].equals("1")) {
						if(inputArray[6].equals("1")) {
							System.out.println("Left door opened, "
									+ "via outside handle.");
						}
						if(inputArray[7].equals("1")) {
							System.out.println("Right door opened, "
									+ "via outside handle.");
						}
					}
				} else {
					System.out.println("Both doors stay closed. "
							+ "Master unlock switch is off.");
				}
			} else {
				System.out.println("Both doors stay closed. "
						+ "Car is not in park.");
			}
		} else {
			System.out.println("Both doors stay closed. "
					+ "No switches or handles were toggled.");
		}
	}		
}
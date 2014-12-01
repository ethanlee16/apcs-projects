import java.util.Scanner;


public class FactorPrinter {
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;		
		
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		System.out.println("Enter a number to get its factors.");
		prompt = new Scanner(System.in);
		int number = prompt.nextInt();
		FactorGenerator f = new FactorGenerator(number);
		
		while(f.hasMoreFactors()) {
			System.out.println(f.nextFactor());
		}
	}
	
}

/**
 * 
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class DataSetTester {
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		DataSet set = new DataSet();
		prompt = new Scanner(System.in);
		System.out.print("Enter the first number "
				+ "of a set of values to get the average "
				+ "and standard deviation.\nThis program "
				+ "will automatically prompt you for the "
				+ "next input.\n> ");
		
		while(prompt.hasNextDouble()) {
			set.add(prompt.nextDouble());
			System.out.print("Enter the next value, "
				+ "or Q to abort.\n> ");
		}
		
		System.out.println("Average is: " 
				+ set.getAverage());
		System.out.println("Standard deviation is: "
				+ set.getStandardDeviation());
		
		System.out.println("Goodbye!");

		
	}
}

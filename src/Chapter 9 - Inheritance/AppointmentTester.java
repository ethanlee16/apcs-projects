import java.util.Scanner;
import java.util.ArrayList;

public class AppointmentTester {
	
	private static Scanner prompt;
	private static String info = "Please enter a date if you would like to see your appointments for that date.\n"
			+ "Enter 'new' to create a new appointment."
			+ "Enter 'q' to quit. Note that dates must be entered as MM/DD/YYYY. \n>";
	private static ArrayList<Appointment> appointments;
	
	public static void main(String[] args) {
		
		// Initialization and setup
		System.out.print("Welcome to JAppointments.\n" + info);
		prompt = new Scanner(System.in);
		appointments = new ArrayList<Appointment>();
		
		// Initial checks for beginning input
		String input = prompt.nextLine();
		boolean isDate = input.matches("[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}");
		boolean isCreateOp = input.matches("new");
		
		// Input loop until sentinel
		while(!input.matches("[Qq]")) {
			while(!(isDate || isCreateOp)) {
				System.out.println("Try again.\n" + info);
			}
			
			if(isDate) {
				int y = Integer.valueOf(input.substring(input.lastIndexOf('/') + 1, input.length()));
				int m = Integer.valueOf(input.substring(0, input.indexOf('/')));
				int d = Integer.valueOf(input.substring(input.indexOf('/') + 1, input.lastIndexOf('/')));
				
				for(Appointment a : appointments) {
					if(a.occursOn(y, m, d)) {
						System.out.println("Appointment on " 
								+ m + "/" + d + "/" + y + ": " 
								+ a.getDescription());
					}
				}
				System.out.println(info);
			}
			
			if(isCreateOp) {
				System.out.print("Enter which type of appointment you would like to create."
						+ "\n[1] One-time appointment"
						+ "\n[2] Daily appointment"
						+ "\n[3] Monthly appointment");
			}
			
			input = prompt.nextLine();
			isDate = input.matches("[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}");
			isCreateOp = input.matches("new");
		}
		System.out.println("Good bye!");
	}
}

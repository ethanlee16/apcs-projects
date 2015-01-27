import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Gradebook {
	
	private static Scanner prompt;
	private static ArrayList<Student> students = new ArrayList<Student>();
	
	public static void main(String[] args) {
		Date today = new Date();
		System.out.print("Welcome to Gradebook. "
				+ "\nPlease enter the name of the first student to input.\n> ");
		prompt = new Scanner(System.in);
		String input = prompt.nextLine();
		
		while(!input.toLowerCase().matches("end")) {
			System.out.print("Please enter the name of the next student."
					+ " Type END to finish.\n> ");
			students.add(new Student(input));
			input = prompt.nextLine();
		}
		
		System.out.println("Enrolled " + students.size() + " students. Now for scores!");
		
		for(Student s : students) {
			System.out.print("Please enter the scores, separated by spaces, for "
					+ s.getName() + "\n> ");
			input = prompt.nextLine();
			while(!input.matches("[\\d+.*\\d* ]+")) {
				System.out.print("That's not valid input. Try again.\n> ");
				input = prompt.nextLine();
			}
			String[] values = input.split(" ");
			double[] scores = new double[values.length];
			for(int i = 0; i < values.length; i++) {
				scores[i] = Double.valueOf(values[i]);
			}
			s.setScores(scores);
		}
	
		System.out.print("Inputs finished. Here are the results!"
				+ "\n*****GRADEBOOK GENERATED ON " + today +  "*****"
				+ "\nStudents enrolled: " + students.size() + "\n");
		
		for(Student s : students) {
			System.out.println(s.getName() + ": " + s.getAverage());
		}
	}
}

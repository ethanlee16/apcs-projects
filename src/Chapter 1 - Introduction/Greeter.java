/**
 * 
 * Greeter.java - takes user input and prints greeting in language of choice
 * 
 * Unnecessarily uses HashMap to store greetings. In practice could be used for 
 * warehouse databases but we probably would import a HashMap from file (however 
 * you do that). 
 * 
 * @author ethan.lee
 *
 */

import java.util.*;

public class Greeter {
	 
	private static Scanner prompt = new Scanner(System.in);
	
	//adapted from http://stackoverflow.com/questions/13298823/get-variable-by-name-from-a-string
	static final Map<String, String> LANGUAGES_BY_ID;
		static {
			 final Map<String, String> languagesByID = new HashMap<>();
			    languagesByID.put("GREETING_1", "Hello");
			    languagesByID.put("GREETING_2", "Bonjour");
			    languagesByID.put("GREETING_3", "Annyong-haseyo");
			    languagesByID.put("GREETING_4", "Ni hao");
			    languagesByID.put("GREETING_5", "Hola");
			    LANGUAGES_BY_ID = Collections.unmodifiableMap(languagesByID);
			}
	
	public static void main(String[] args) {
		System.out.println("Please select a language: \n[1]English [2]French [3]Korean [4]Chinese [5]Spanish\n"
				+ "Type in the number of your desire language.");
		String langNumber = prompt.nextLine();
		String greetingID = "GREETING_" + langNumber;
		
		//TODO: make a while loop to loop this until user gives an acceptable response
		if (LANGUAGES_BY_ID.get(greetingID) == null) {
			System.out.println("This lang id does not exist, exiting. Restart Greeter if you want "
					+ "to try that again.");
		}
		else {
			System.out.println(LANGUAGES_BY_ID.get(greetingID));
		}
	}
}

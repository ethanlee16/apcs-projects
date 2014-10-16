/*
 * JCowsay.java - a Java port of the humorous UNIX `cowsay`
 * 
 * @author ethan.lee
 * 
 */
import java.util.*;

public class JCowsay {
	static Scanner prompt = new Scanner(System.in);
	
	public static void main (String[] args) {
		System.out.println("Welcome to JCowsay, a port of cowsay for Java! Type in a message to moo.");
		String message = prompt.nextLine();
		
		if (message.isEmpty()){
			message = "I think, therefore, I moo.";
		}
		
		int bubbleWidth = message.length() + 2;
		String dashes = "  ";
		String spaces = "";
		
		while (bubbleWidth > 0){
			dashes += "_";
			bubbleWidth--;
		}
		
		System.out.println(dashes + "\n<  " + message + "  >");
		dashes = dashes.replaceAll("_", "-");
		System.out.println(dashes);
		
		for (int i = message.length()/3; i>0; i--) {
			spaces += " ";
		}
		
		System.out.print(spaces + "\\   ^__^\n" + spaces + " \\  (oo)\\_______\n");
		System.out.print(spaces + "    (__)\\       )\\/\\\n");
		System.out.print(spaces + "         ||----w ||\n" + spaces + "         ||      ||");
	}
}


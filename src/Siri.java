/*
 * Siri.java - mimics Siri's "core functionality." Everything here is sarcasm.
 * 
 * @author ethan.lee
 * 
 */
import java.awt.*;
import java.net.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Siri {
	public static void main(String[] args) {
		
		String name = "";	
		Random random = new Random();
		
		while (name.isEmpty()) {
			name = JOptionPane.showInputDialog("What is your name?");
		}
		
		try {
			
			// A lot of statements in this code (specifically Desktop.browse and URLEncoder require
			// try-catch blocks, so it's all wrapped up into one, since we're really not worrying too
			// much about errors here.
			
			String request = JOptionPane.showInputDialog("What would you like me to do, " + name + "?");
			String parsedRequest = URLEncoder.encode(request, "UTF-8");
			if (!request.isEmpty()){
			switch (random.nextInt(3)) {
			case 0:
				JOptionPane.showMessageDialog(null, "I'm really sorry about this, "
						+ "but I can't take any requests right now. Please try again it a little while.");
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Searching the web for: " + request);
				Desktop.getDesktop().browse(new URL("http://lmgtfy.com/?q=" + parsedRequest).toURI());
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Here are some restaurants I found relating to \"" + request + "\".");
				Desktop.getDesktop().browse(new URL("http://yelp.com/search?find_desc=" + parsedRequest).toURI());
				break;
			}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//To fulfill assignment conditions
		System.out.printf("I'm sorry about this, %s, I can't do that.", name);
	}
}

/**
 * 
 * AreaTester - tests...areas...
 * 
 * Version 1.0
 * 
 * @author ethan.lee
 *
 */
import java.util.*;
import java.awt.Rectangle;

public class AreaTester {	
	static Scanner prompt = new Scanner(System.in);	
	public static void main (String[] args) {
		
		System.out.println("Welcome to AreaTester, please enter the width of your rectangle.");
		
		int rectWidth;
		int rectLength;
		
		try {rectWidth=prompt.nextInt();}
		catch (Exception e) {rectWidth = 0; prompt.nextLine();}
		
		//	Using prompt.nextLine() without reference to an object to prevent whatever was in the
		//	buffer from the invalid input from being used for the nextInt(). 
		
		while(rectWidth <= 0 || (rectWidth % 1) != 0){
			System.out.println("Error, requires integer number above zero. Try again.");
			try {rectWidth=prompt.nextInt();}
			catch (Exception e) {rectWidth = 0; prompt.nextLine();}
		}
		
		System.out.println("And now, the width:");
		
		try {rectLength=prompt.nextInt();}
		catch (Exception e) {rectLength = 0; prompt.nextLine();}
		
		while(rectLength <= 0 || (rectLength % 1) != 0){
			System.out.println("Error, requires integer number above zero. Try again.");
			try {rectLength=prompt.nextInt();}
			catch (Exception e) {rectLength = 0; prompt.nextLine();}
		}
		
		Rectangle rect = new Rectangle(0, 0, rectWidth, rectLength);
		System.out.println("Expected: " + rectWidth * rectLength);
		System.out.println("************RESULTS************\nArea:" + rect.getWidth() * rect.getHeight());
		
	}
}

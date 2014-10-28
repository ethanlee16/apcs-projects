/**
 * CalendarTest.java - Gets the job done. Undeserving of a 1.0 until it takes user input
 * and delegates all this repetitive code to a function.
 * 
 * version 0.1
 *  
 * @author ethan.lee
 *
 */
import java.util.*;

public class CalendarTest {
	
	// static TimeZone tmz = TimeZone.getTimeZone("America/Los_Angeles"); not needed as GregorianCalendar
	// constructor with no arguments uses default locale and timezone
	
	static GregorianCalendar calNow = new GregorianCalendar();
	static GregorianCalendar myBirthday = new GregorianCalendar(1998, Calendar.DECEMBER, 11);
	
	public static void main (String[] args) {
		
		// TODO: add user input for date & parse. Use DateFomat object.
		System.out.println("Today's date is: " + 
		calNow.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " +
		calNow.get(Calendar.DAY_OF_MONTH) + ", " +
		calNow.get(Calendar.YEAR) + "."); 
		
		calNow.add(Calendar.DAY_OF_MONTH, 100);
		
		System.out.println("In 100 days, it will be: " + 
		calNow.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " +
		calNow.get(Calendar.DAY_OF_MONTH) + ", " +
		calNow.get(Calendar.YEAR) + ".\n");

		System.out.println("In 1998, my birthday fell on a " + 
		myBirthday.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US) + ".");
		
		myBirthday.set(Calendar.YEAR, calNow.get(Calendar.YEAR)); //works for any year!
		System.out.println("This year, it will fall on a " +
		myBirthday.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US) + ".");
		
		myBirthday.set(Calendar.YEAR, 1998); myBirthday.add(Calendar.DAY_OF_MONTH, 10000);
		System.out.println("10,000 days from my birthday in 1998 will be " + 
		myBirthday.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " +
		myBirthday.get(Calendar.DAY_OF_MONTH) + ", " +
		myBirthday.get(Calendar.YEAR) + ".\n");
	}
}

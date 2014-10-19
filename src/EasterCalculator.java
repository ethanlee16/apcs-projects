/**
 * 
 * EasterCalculator.java - takes a year and gives you Easter date
 * 
 * @author ethan.lee
 * @version 1.0
 *
 */
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class EasterCalculator {
	
	private static Scanner prompt = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Please enter a year you'd like to know when Easter falls upon.");
		
		int years;
		while(!prompt.hasNextInt() || !prompt.hasNext("[0-9]?[0-9]?[0-9]?[0-9]")){
			System.out.println("Invalid year, try again.");
			prompt.next();
		}
		years = prompt.nextInt();
		
		/* 
		 * The following represents Gauss' algorithm
		 * to calculate the day when Easter falls given a year.
		 * 
		 * Guy had way too much free time or something.
		 */
		
		int a = years % 19;
		int b = years / 100;
		int c = years % 100;
		int d = b / 4;
		int e = b % 4;
		int g = (8 * b + 13) / 25;
		int h = (19 * a + b - d - g + 15) % 30;
		int j = c / 4;
		int k = c % 4;
		int m = (a + 11 * h) / 319;
		int r = (2 * e + 2 * j - k - h + m + 32) % 7;
		int n = (h - m + r + 90) / 25;
		int p = (h - m + r + n + 19) % 32;
		
		GregorianCalendar cal = new GregorianCalendar(years, n - 1, p);
		System.out.println("Easter in " + years + " falls on " + 
				cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " + p + ".");
	}

}

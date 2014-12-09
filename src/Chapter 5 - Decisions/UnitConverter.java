/**
 * UnitConverter.java
 * @author ethan.lee
 *
 */
import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.HashMap;

public class UnitConverter {
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** LinkedHashMap with all supported length units. 
	 *  Linked was chosen in order to preserve order of insertion. **/
	private static final Map<String, String> units = new LinkedHashMap<>();
	
	static {
		units.put("fl. oz", "liquid");
		units.put("gal", "liquid");
		units.put("ml", "liquid");
		units.put("l", "liquid");
		units.put("oz", "weight");
		units.put("lb", "weight");
		units.put("g", "weight");
		units.put("kg", "weight");
		units.put("in", "length");
		units.put("ft", "length");
		units.put("mi", "length");
		units.put("mm", "length");
		units.put("cm", "length");
		units.put("m", "length");
		units.put("km", "length");
	}
	
	/** HashMap of all the conversion constants. **/
	private static final Map<String, Double> conversions = new HashMap<>();
	
	static {
		conversions.put("fl. oz_to_ml", 29.5735);
		conversions.put("fl. oz_to_gal", 0.0078125);
		conversions.put("fl. oz_to_l", 0.0295735);
		conversions.put("gal_to_ml", 3785.41);
		conversions.put("gal_to_l", 3.78541);
		conversions.put("ml_to_l", 0.001);
		conversions.put("oz_to_lb", 0.0625);
		conversions.put("oz_to_g", 28.3495);
		conversions.put("oz_to_kg", 0.0283495);
		conversions.put("lb_to_g", 453.592);
		conversions.put("lb_to_kg", 0.453592);
		conversions.put("g_to_kg", 0.001);
		conversions.put("in_to_ft", 0.0833333);
		conversions.put("in_to_mi", 1.5783E-5);
		conversions.put("in_to_mm", 25.4);
		conversions.put("in_to_cm", 2.54);
		conversions.put("in_to_m", 0.0254);
		conversions.put("in_to_km", 2.54E-5);
		conversions.put("ft_to_mi", 0.000189394);
		conversions.put("ft_to_mm", 304.8);
		conversions.put("ft_to_cm", 30.48);
		conversions.put("ft_to_m", 0.3048);
		conversions.put("ft_to_km", 0.0003048);
		conversions.put("mi_to_mm", 1.609E+6);
		conversions.put("mi_to_cm", 1.609E+5);
		conversions.put("mi_to_m", 1609.34);
		conversions.put("mi_to_km", 1.60934);
		conversions.put("mm_to_cm", 0.1);
		conversions.put("mm_to_m", 0.001);
		conversions.put("mm_to_km", 1E-6);
		conversions.put("cm_to_m", 0.01);
		conversions.put("cm_to_km", 1E-5);
		conversions.put("m_to_km", 0.001);
		conversions.put("mi_to_in", 63360.0);
		conversions.put("mi_to_ft", 5280.0);
	}
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		System.out.println("Convert from? Available units: ");
		for(Map.Entry<String, String> entry : units.entrySet()) {
			System.out.print("| " + entry.getKey() + " |");
		}
		System.out.println("\nConversion only allowed from matching types. "
				+ "i.e. capacity -> capacity, length -> length.");
		
		prompt = new Scanner(System.in);
		String unit = prompt.nextLine();
		while(units.get(unit) == null) {
			System.out.println("No units found for this token, try again.");
			unit = prompt.nextLine();
		}
		String type = units.get(unit);
		System.out.println(unit);
		System.out.println("Convert to? Available units: ");
		for(Map.Entry<String, String> entry : units.entrySet()) {
			if(entry.getValue().equals(type) && !entry.getKey().equals(unit)) {
				System.out.print("| " + entry.getKey() + " |");
			}
		}
		
		String unit2 = prompt.nextLine();
		while(units.get(unit2) == null && units.get(unit2) != type) {
			System.out.println("No units found for this token, try again.");
			unit2 = prompt.nextLine();
		}
		
		System.out.println("How many of " + unit + " to convert to " + unit2 + "?");
		double amount;
		while(!prompt.hasNextDouble()) {
			System.out.println("Requires a floating point value above 0, try again.");
			prompt.next();
		}
		amount = prompt.nextDouble();
		while(amount <= 0) {
			System.out.println("Requires a floating point value above 0, try again.");
			amount = prompt.nextDouble();
		}
		
		// Check for conversion constant under name unit_to_unit2
		// and if it doesn't exist, reverse it, because it exists
		// in the form unit2_to_unit. Then take the reciprocal of it
		// to get the correct conversion constant.
		
		String conversionName = unit + "_to_" + unit2;
		double conversion;
		if(conversions.get(conversionName) == null) {
			conversionName = unit2 + "_to_" + unit;
			conversion = 1 / conversions.get(conversionName);
		}
		else {
			conversion = conversions.get(conversionName);
		}
		System.out.println("The answer is "
				+ Math.ceil((amount * conversion) * 100) / 100 + " " + unit2);
	}
}

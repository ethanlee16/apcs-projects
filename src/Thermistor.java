/**
 * Thermistor.java - Calculates the resistance of a certain thermistor
 * at a given temperature. Utilizes a derived form of the Steinhart-Hart equation, 
 * which is 1/T = A + B ln(R) + C(ln(R))^3.
 * 
 * @author ethan.lee
 * @version 1.0
 *
 */
import java.util.Scanner;
public class Thermistor {
	
	/** Part of the formula for calculating temperature-dependent resistance.
	 *  For this particular model of thermistor, the resistance at T0 is this
	 *  value. **/
	static final int INITIAL_RESISTANCE = 1075;
	
	/** T0 in the formula for calculating the resistance of a thermistor. **/
	static final int INITIAL_TEMP = 358;
	
	/** Represents the B coefficient in the Steinhart-Hart equation for this
	 *  model of thermistor. **/
	static final int STEINHART_COEFF_B = 3969;
	
	/** The unit conversion for temperature, from Celsius to Kelvin. **/
	static final int CELSIUS_FOR_KELVIN = 273;
	
	private static Scanner prompt = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Please input a resistance value (in ohms).");
		double res;
		while(!prompt.hasNextDouble()) {
			System.out.println("Must be a floating point value.");
		}
		res = prompt.nextDouble();
		
		System.out.println("The temperature at a resistance of " + res
				+ " ohms for this thermistor is " +
				+ ((STEINHART_COEFF_B * INITIAL_TEMP) 
				/ (INITIAL_TEMP * Math.log(res / INITIAL_RESISTANCE) 
				+ STEINHART_COEFF_B) - CELSIUS_FOR_KELVIN) + " degrees Celsius.");
		
		
		
	}
}

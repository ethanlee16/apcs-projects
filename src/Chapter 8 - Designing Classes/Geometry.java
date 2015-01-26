/**
 * 
 * @author ethan
 *
 */
import java.util.Scanner;
public class Geometry {
	
	private static Scanner prompt;
	
	public static void main(String args[]) {
		System.out.print("Please enter a value for the radius of a "
				+ "sphere, cylinder, or cone\n and then the height of a cube, "
				+ "sphere, cylinder, or cone like so: 9.3 (radius) 10 (height)"
				+ " or 5 6.2\n> ");
		prompt = new Scanner(System.in);
		
		String input;
		
		while(!prompt.hasNext("\\d+\\.*\\d* \\d+\\.*\\d*")) {
			System.out.print("That's not valid input. Try again.\n> ");
			input = prompt.nextLine();
		}
		
		input = prompt.nextLine();
		
		String[] stringArray = input.split(" ");
		
		double r = Double.valueOf(stringArray[0]);
		double h = Double.valueOf(stringArray[1]);
		
		System.out.print("Cube volume with height " + h + ": " + cubeVolume(h) +
				"\nCube surface area with height " + h + ": " + cubeSurface(h) +
				"\nSphere volume with radius " + r + ": " + sphereVolume(r) + 
				"\nSphere surface area with radius " + r + ": " + sphereSurface(r) +
				"\nCylinder volume with radius " + r + " and height " + h + ": " + cylinderVolume(r, h) + 
				"\nCylinder surface area with radius " + r + " and height " + h + ": " + cylinderSurface(r, h) +
				"\nCone volume with radius " + r + " and height " + h + ": " + coneVolume(r, h) + 
				"\nCone surface area with radius " + r + " and height " + h + ": " + coneSurface(r, h));
	}
	
	public static double cubeVolume(double h) {
		return h * h * h;
	}
	
	public static double cubeSurface(double h) {
		return 6 * h * h;
	}
	
	public static double sphereVolume(double r) {
		return (4/3) * Math.PI * r * r * r;
	}
	
	public static double sphereSurface(double r) {
		return 4 * Math.PI * r * r;
	}
	
	public static double cylinderVolume(double r, double h) {
		return Math.PI * r * r * h;
	}
	
	public static double cylinderSurface(double r, double h) {
		return (2 * Math.PI * r * h) + (2 * Math.PI * r * r);
	}
	
	public static double coneVolume(double r, double h) {
		return Math.PI * r * r * (h / 3);
	}
	
	public static double coneSurface(double r, double h) {
		return Math.PI * r * (r + Math.sqrt(h * h + r * r));
	}
}

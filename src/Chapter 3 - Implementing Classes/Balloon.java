/**
 * Balloon.java - inflates.
 * 
 * @author ethan.lee
 *
 */
public class Balloon {
	private double radius;
	
	public Balloon() {
		radius = 0;
	}
	
	public void inflate(double air) {
		radius += air;
	}
	
	public double getVolume() {
		return (4.0 / 3) * Math.PI * (radius * radius * radius);
	}
}

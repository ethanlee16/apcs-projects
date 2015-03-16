
public class Man implements Measurable {
	private String name;
	private double height; // in metres!
	
	public Man(double height) {
		name = "";
		this.height = height;
	}
	
	public Man(String name, double height){
		this.name = name;
		this.height = height;
	}
	
	/**
	 * Gets the height of a person, in meters.
	 * @return the meter value of height 
	 */
	public double getMeasure() {
		return height;
	}
	
	public String getName() {
		return name;
	}
}

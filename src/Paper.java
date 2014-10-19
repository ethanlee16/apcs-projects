/**
 * Paper.java - returns dimensions of paper in millimeters.
 * @author ethan.lee
 *
 */
import java.text.DecimalFormat;

public class Paper {
	
	/** Describes the width of U.S. standard paper in inches. **/
	public static final double US_PAPER_WIDTH = 8.5;
	
	/** Describes the height of U.S. standard paper in inches. **/
	public static final double US_PAPER_HEIGHT = 11.0;
	
	/** Accpted conversion factor for millimeters to inches. **/
	public static final double MM_PER_INCH = 25.4;
		
	public static void main(String[] args) {
		DecimalFormat roundToTenths = new DecimalFormat("#.#"); //needed to fix rounding error
		System.out.println("The dimensions of 8.5\" by 11\" paper in millimeters are about: "
				+  roundToTenths.format(US_PAPER_WIDTH * MM_PER_INCH) + "mm by " 
				+ roundToTenths.format(US_PAPER_HEIGHT * MM_PER_INCH) + "mm.");
	}
}

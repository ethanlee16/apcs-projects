/**
 * Data.java
 * @author ethan.lee
 *
 */
public class Data {
	
	public static double average(Measurable[] objects) {
		double sum = 0;
		for(Measurable obj : objects) {
			sum = sum + obj.getMeasure();
		}
		if(objects.length > 0) {
			return sum / objects.length;
		}
		else {
			return 0;
		}
	}
	public static Measurable max(Measurable[] objects) {
		if(objects.length <= 0) {
			throw new IllegalArgumentException();
		}
		Measurable largest = objects[0];
		for(Measurable obj : objects) {
			if(obj.getMeasure() > largest.getMeasure()) {
				largest = obj;
			}
		}
		return largest;
	}
}

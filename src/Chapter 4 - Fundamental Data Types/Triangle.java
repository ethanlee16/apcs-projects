/**
 * Triangle.java - Creates a triangle and generates some properties
 * 
 * @author ethan.lee
 * @version 0.1
 *
 */
public class Triangle {
	private double[] pointA, pointB, pointC;
	
	public Triangle(double[] pointA, double[] pointB, double[] pointC) {
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}
	
	public double getDistance(double[] point1, double[] point2) {
		double distance = Math.sqrt(Math.pow(point2[0] - point1[0], 2)
				+ Math.pow(point2[1] - point1[1], 2));

		return distance;
	}
	
	public double getPerimeter() {
		// TODO: Make generating the side lengths a private function
		// that runs on initialization.
		double sideA = this.getDistance(this.pointB, this.pointC);
		double sideB = this.getDistance(this.pointC, this.pointA);
		double sideC = this.getDistance(this.pointA, this.pointB);
		double perim = sideA + sideB + sideC;
		return perim;
	}
	
	public double getAngle(double[] point1, double[] point2, double[] point3) {
		double sideA = this.getDistance(point2, point3);
		double sideB = this.getDistance(point3, point1);
		double sideC = this.getDistance(point1, point2);
		double angle3 = Math.toDegrees(Math.acos(((Math.pow(sideA, 2) + Math.pow(sideB, 2)
				- Math.pow(sideC, 2)) / (2 * sideA * sideB))));
		return angle3;
	}
	
	public double getArea() {
		double s = this.getPerimeter() / 2;
		double area = Math.sqrt(s * (s - this.getDistance(this.pointB, this.pointC)) 
				* (s - this.getDistance(this.pointC, this.pointA))
				* (s - this.getDistance(this.pointA, this.pointB)));
		return area;
	}
}

/**
 * TriangleCreator.java - tests Triangles
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class TriangleCreator {
	
	private static Scanner prompt = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		/*
		 * FIXED TESTS
		double[] pointA = {0,1};
		double[] pointB = {0,4};
		double[] pointC = {5,1};
		*/
		
		double ax, ay, bx, by, cx, cy;
		//TODO: User input validation
		System.out.println("Enter the x-coordinate for point A.");
		ax = prompt.nextDouble();
		System.out.println("Enter the y-coordinate for point A.");
		ay = prompt.nextDouble();
		
		System.out.println("Enter the x-coordinate for point B.");
		bx = prompt.nextDouble();
		System.out.println("Enter the y-coordinate for point B.");
		by = prompt.nextDouble();
		
		System.out.println("Enter the x-coordinate for point C.");
		cx = prompt.nextDouble();
		System.out.println("Enter the y-coordinate for point C.");
		cy = prompt.nextDouble();
		
		double[] pointA = {ax, ay};
		double[] pointB = {bx, by};
		double[] pointC = {cx, cy};
		Triangle t = new Triangle(pointA, pointB, pointC);
		
		System.out.println("--- PROPERTIES ---"
				+ "\nSide A: \t" + t.getDistance(pointB, pointC)
				+ "\nSide B: \t" + t.getDistance(pointA, pointC)
				+ "\nSide C: \t" + t.getDistance(pointA, pointB)
				+ "\nAngle A: \t" + t.getAngle(pointB, pointC, pointA)
				+ "\nAngle B: \t" + t.getAngle(pointC, pointA, pointB)
				+ "\nAngle C: \t" + t.getAngle(pointA, pointB, pointC)
				+ "\nPerimeter: \t" + t.getPerimeter()
				+ "\nArea: \t\t" + t.getArea());


	}

}

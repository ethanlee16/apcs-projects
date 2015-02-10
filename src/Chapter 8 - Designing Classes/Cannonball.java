import java.awt.Point;
import java.util.ArrayList;

public class Cannonball {
	
	final double GRAV_CONSTANT = -9.81;
	private double x, y = 0;
	private double xVelocity = 0;
	private double yVelocity = 0;
	private double time;
	
	public Cannonball(int xPos) {
		x = xPos;
		time = 0;
	}
	
	public void move(double deltaSec) {
		time += deltaSec;
		x += xVelocity * deltaSec;
		y += yVelocity * deltaSec;
		yVelocity += deltaSec * GRAV_CONSTANT;
	}
	
	public Point getLocation() {
		return new Point((int) Math.round(x), (int) Math.round(y));
	}
	
	/**
	 * Fires the cannonball with given parameters.
	 * @param alpha Angle, in degrees, at which the Cannonball is shot.
	 * @param v Initial velocity (not in components) of the Cannonball.
	 * @param deltaSec Time interval with which to move the cannonball
	 * @return an ArrayList of Points for each move of the cannonball
	 */
	public ArrayList<Point> shoot(double alpha, double v, double deltaSec) {
		ArrayList<Point> points = new ArrayList<Point>();
		alpha = Math.toRadians(alpha);
		xVelocity = v * Math.cos(alpha);
		yVelocity = v * Math.sin(alpha);
		while(y > 0 || time == 0) {
			move(deltaSec);
			points.add(getLocation());
		}
		return points;
	}
	
}
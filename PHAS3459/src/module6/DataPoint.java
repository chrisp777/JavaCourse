package module6;

import module6.TestDataPoints.Point;

public class DataPoint implements Point {
	// Variables for the constructor
	protected double x;
	protected double y;
	protected double ey;
	
	// DataPoint constructor which is an implementation of the Point interface
	public DataPoint(double X, double Y, double eY) {
		x = X;
		y = Y;
		ey = eY;
		
	}

	// Getters required as laid out by the interface
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getEy() {
		return ey;
	}
	
	// To string method to define how the point is outputted to the user
	public String toString() {
		return "x = "+x+", y = "+y+" +- "+ey;
	}
	
}


package module6;

import module6.TestDataPoints.Point;

public class DataPoint implements Point {
	protected double x;
	protected double y;
	protected double ey;
	
	public DataPoint(double X, double Y, double eY) {
		x = X;
		y = Y;
		ey = eY;
		
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getEy() {
		return ey;
	}
	
	public String toString() {
		return "x = "+x+", y = "+y+" +- "+ey;
	}
	
}


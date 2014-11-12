package module5;

public class DataPoint {
	// Set up the variables used by the constructor
	private double x;
	private double y;
	private double ey;
	
	// Assign values to the variables defined above
	public DataPoint(double X, double Y, double eY) {
		x = X;
		y = Y;
		ey = eY;
		
	}

	// Getters for the constructor values
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getEy() {
		return ey;
	}
	
	// Define how to output a dataPoint
	public String toString() {
		return "("+x+","+y+","+ey+")";
	}
	
}


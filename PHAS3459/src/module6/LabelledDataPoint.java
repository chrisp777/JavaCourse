package module6;

import module6.TestDataPoints.Point;

public class LabelledDataPoint extends DataPoint implements Point {
	// Adds a new variable string to store the label
	private String label;

	// LabelledDataPoint constructor which adds on the label the DataPoint object which is an implementation of Point
	public LabelledDataPoint(double X, double Y, double eY, String label) {
		super(X, Y, eY);
		this.label = label;
		
	}
	
	// Getters that are required by the interface
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getEy() {
		return ey;
	}
	
	// To string method to print out a labelled data point to the user
	public String toString() {
		return label+": x = "+x+", y = "+y+" +- "+ey;
	}
	

}

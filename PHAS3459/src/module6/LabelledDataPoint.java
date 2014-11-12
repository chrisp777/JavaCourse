package module6;

import module6.TestDataPoints.Point;

public class LabelledDataPoint extends DataPoint implements Point {
	private String label;

	public LabelledDataPoint(double X, double Y, double eY, String label) {
		super(X, Y, eY);
		this.label = label;
		
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
		return label+": x = "+x+", y = "+y+" +- "+ey;
	}
	

}

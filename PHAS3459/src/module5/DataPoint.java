package module5;

public class DataPoint {
	private double x;
	private double y;
	private double ey;
	
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
		return "("+x+","+y+","+ey+")";
	}
	
}


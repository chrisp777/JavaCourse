package module6;

public class QuadraticTheory implements Theory {
	private double a;
	private double b;
	private double c;
	
	public QuadraticTheory(double A, double B, double C) {
		a = A;
		b = B;
		c = C;
	}
	
	@Override
	public double y(double x) {
		return a*Math.pow(x, 2)+b*x +c;
	}
	
	public String toString() {
		return a+"x^2 + "+b+" x+ "+c;
	}

}

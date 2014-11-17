package module6;

// A new theory called quatratic theory which implements the theory interface
public class QuadraticTheory implements Theory {
	// Variables essential to the quadratic theory
	private double a;
	private double b;
	private double c;
	
	// QuadtraticTheory constructor which assigns the above variables
	public QuadraticTheory(double A, double B, double C) {
		a = A;
		b = B;
		c = C;
	}
	
	// Method which calcualtes the y for a given x using a theory that was provided
	@Override
	public double y(double x) {
		return a*Math.pow(x, 2)+b*x +c;
	}
	
	// To string method which allows the theory to be outputted to the user
	public String toString() {
		return a+"x^2 + "+b+" x+ "+c;
	}

}

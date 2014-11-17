package module6;

// A new theory that implements the theory interface
public class PowerLawTheory implements Theory{
	// Makes a new variable which is key to the quadratic theory 
	private double n;
	
	// PowerLawTheory constructor which assigns the variable n
	public PowerLawTheory (double N) {
		n = N;
	}
	
	// method which calcualtes the y value for the given x value using the theory provided
	@Override
	public double y(double x) {
		double y = Math.pow(x, n);
		return y;
	}
	
	// To string method which prints out the theory to the user
	public String toString() {
		return "x^"+n;
	}
	
}

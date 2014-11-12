package module5;

//Theory constructor to be used in the X2 calculations
public class Theory {
	static double n;
	
	// Assigns the constructor variables
	public Theory(double N) {
		n = N;
	}
	
	// Calculates the theoritcal value for the given power N
	public double y(double x) {
		return Math.pow(x, n);
	}

}

package module6;

public class PowerLawTheory implements Theory{

	private double n;
	public PowerLawTheory (double N) {
		n = N;
	}
	
	@Override
	public double y(double x) {
		double y = Math.pow(x, n);
		return y;
	}
	
	public String toString() {
		return "x^"+n;
	}
	
}

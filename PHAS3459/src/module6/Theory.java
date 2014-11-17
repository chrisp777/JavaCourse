package module6;

// interface Theory which outlines how a theory should look
public interface Theory {
	// Every theory must find the y values for a given x value
	public double y(double x);
	// Every Theory must have a way of outputting a theory to the user
	public String toString();
}

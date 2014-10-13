package module3;

public class FallingParticle {

	public static void main(String[] args) {
	}
	
	// Variables used throughout the code
	private double m; // mass
	private double d; // drag
	private double t; // time
	private double z; // vertical pos
	private double v; // velocity (measured upwards)
	static final double g = 9.81; // gravity
	
	// Falling particle construct
	public FallingParticle(double mass, double drag) throws Exception{
		if (mass < 0) {throw new Exception("ERROR: Mass cannot be negative.");}
		m = mass;
		if (drag < 0) {throw new Exception("ERROR: Drag cannot be negative.");}
		d = drag;
	}
	
	// Setters and Getters for Z and V and a Getter for T
	// START setters and getters
	public double getZ() {
		return z;
	}
	
	public void setZ(double z) throws Exception{
		if(z < 0) {throw new Exception("ERROR: Cannot have a negative z position.");}
		this.z = z;
	}
	
	public double getV() {
		return v;
	}

	public void setV(double v) {
		this.v = v;
	}
	public double  getT() {
		return t;
	}
	// END setters and getters

	// Method which advances the simulation by a 'tick' of length defined by deltaT
	private void doTimeStep(double deltaT) throws Exception {
		double a = ((d*v*v)/m)-g; // Calculate the acceleration taking the drag into account
		setV(v+a*deltaT); // Speeding up due to gravity
		setZ(z+v*deltaT); // Getting closer to the bottom if v is -ve
		t = t + deltaT;	// Increment time by the dT each call
	}
	// Simulates the dropping of an object with mass and drag coefficient into a tank of viscous liquid,
	// returns the time and velocity when the object hits the bottom of this vertical tank.
	public void drop(double deltaT) throws Exception {
		t = 0; // reset drop timer
		setV(0); // Initial drop speed 0
		
		while (getZ() >= 0) { // Loop through until the end of the tank is met
			doTimeStep(deltaT); // Do a simulation step
		}
		
		// output the time and velocity when the object hit the bottom of the tank
		System.out.println("The t when the object hit the floor was:"+getT());
		System.out.println("The v when the object hit the floor was:"+getV()+"\n");
	}
}

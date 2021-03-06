package module3;

import module3.ThreeVector;

public class ThreeVector {
	// Set up the variables for the construct ThreeVector
	private double x;
	private double y;
	private double z;
	
	// ThreeVector construct assigning the variables above
	public ThreeVector(double x1, double y1, double z1) {
		x = x1;
		y = y1;
		z = z1;
	}
	
	// Main stub
	public static void main(String[] args) {

	}

	// Method which gives the magnitude of the vector given through the arguments
	double magnitude() {
		return (Math.sqrt((this.x*this.x)+(this.y*this.y)+(this.z*this.z)));
	}
	
	// Method which returns the unitVector of the supplied three vector
	ThreeVector unitVector() throws Exception {
		//Throws an exception if a zero vector is passed to the method
		if (this.x==0&&this.y==0&&this.z==0) {throw new Exception("ERROR: Cannot find the unitvector of a zero vector.");}
		double mag = magnitude();
		ThreeVector unit = new ThreeVector(this.x/mag, this.y/mag, this.z/mag);
	return unit;
	}

	// Method to handle the printing of a ThreeVector as a string
	public String toString() {
		String components = "("+this.x+","+this.y+","+this.z+")";
		return components;
	}
	
	// Method which calculates the scalarProduct between the two ThreeVectors supplied as arguments
	static double scalarProduct(ThreeVector vector1, ThreeVector vector2) {
		double product = vector1.x*vector2.x + vector1.y*vector2.y + vector1.z*vector2.z;
		return product;
	}
	// Non-static wrapper for the scalarProdcut
	public double scalarProduct(ThreeVector arg) {
		return scalarProduct(this, arg);
	}
	
	// Method which calculates the vectorProduct between two ThreeVectors
	static ThreeVector vectorProduct(ThreeVector vector1, ThreeVector vector2) {
		ThreeVector product = new ThreeVector((vector1.y*vector2.z-vector2.y*vector1.z),(-vector1.x*vector2.z+vector2.x*vector1.z),(vector1.x*vector2.y-vector2.x*vector1.y));
		return product;
	}
	// Non-static wrapper for the vector product
	public ThreeVector vectorProduct(ThreeVector arg) {
		return vectorProduct(this, arg);
	}
	
	// Method which adds two ThreeVectors together and returns the sum ThreeVector
	static ThreeVector add(ThreeVector vector1, ThreeVector vector2) {
		ThreeVector sum = new ThreeVector((vector1.x+vector2.x),(vector1.y+vector2.y),(vector1.z+vector2.z));
		return sum;
	}
	// Non-static wrapper for the vector add method
	public ThreeVector add(ThreeVector arg) {
		return add(this, arg);
	}
	
	// Method which calculates the angle between two vectors
	static double angle(ThreeVector vector1, ThreeVector vector2) throws Exception {
		// Throws exception if there is a zero vector
		if ((vector1.x==0&&vector1.y==0&&vector1.z==0)||(vector2.x==0&&vector2.y==0&&vector2.z==0)) {throw new Exception("ERROR: Cannot find the angle between zero and a vector.");}
		double angle = Math.acos((scalarProduct(vector1,vector2))/(vector1.magnitude()*vector2.magnitude()));
		return angle;
	}
	// Non-static wrapper for the angle method
	public double angle(ThreeVector arg) throws Exception {
		return angle(this, arg);
	}

}
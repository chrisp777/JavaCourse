package module2;

public class ThreeVector {
	private double x;
	private double y;
	private double z;
	

	public ThreeVector(double x1, double y1, double z1) {
		x = x1;
		y = y1;
		z = z1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeVector a = new ThreeVector(1,2,3);
		System.out.println(a.magnitude());
	}
	
	double magnitude() {
		//Function which gives the magnitude of the vector given through the arguments
		return (Math.sqrt((this.x*this.x)+(this.y*this.y)+(this.z*this.z)));
	}
	
	ThreeVector unitVector() {
		double mag = magnitude();
		ThreeVector unit = new ThreeVector(this.x/mag, this.y/mag, this.z/mag);
	return unit;
	}
	
	public String toString() {
		String components = "("+this.x+","+this.y+","+this.z+")";
		return components;
	}
	
	static double scalarProduct(ThreeVector vector1, ThreeVector vector2) {
		double product = vector1.x*vector2.x + vector1.y*vector2.y + vector1.z*vector2.z;
		return product;
	}
	static ThreeVector VectorProduct(ThreeVector vector1, ThreeVector vector2) {
		ThreeVector product = new ThreeVector((vector1.y*vector2.z-vector2.y*vector1.z),-(vector1.x*vector2.z-vector2.x*vector1.z),(vector1.x*vector2.y-vector2.x*vector1.y));
		return product;
	}
	
}

package module2;
import module2.ThreeVector;

public class TestThreeVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeVector v1 = new ThreeVector(3,4,1);
		ThreeVector v2 = new ThreeVector(5,3,2);
		ThreeVector v3 = new ThreeVector(0,0,0);
		
		//Show the use the vectors
		System.out.println("v1 is "+v1);
		System.out.println("v2 is "+v2);
		System.out.println("v3 is "+v3);
		
		// Testing the scalar product
		System.out.println("Scalar product of v1 and v2: "+ThreeVector.scalarProduct(v1,v2));
		System.out.println("Scalar product of v1 and v3: "+ThreeVector.scalarProduct(v1,v3));
		
		// Testing the vector product 
		System.out.println("Vector product of v1 and v2: "+ThreeVector.vectorProduct(v1,v2));
		System.out.println("Vector product of v1 and v3: "+ThreeVector.vectorProduct(v1,v3));
		
		// Testing the angle
		System.out.println("Angle between v1 and v2: "+ThreeVector.angle(v1,v2));
		System.out.println("Angle between v1 and v3: "+ThreeVector.angle(v1,v3)+". It is NaN because there is no angle between a vector and a point (0,0,0).");
		
		// String out test
		System.out.println(v1);
		System.out.println("The above wouldn't have displayed properly without the ToString method defining how the vector should be displayed. It would have displayed only the memory location.");
	}

}

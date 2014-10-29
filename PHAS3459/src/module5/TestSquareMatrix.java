package module5;
import module5.SquareMatrix;

public class TestSquareMatrix {
	// Define matrix holders which will be filled in a try catch later
	static SquareMatrix a;
	static SquareMatrix b;
	static SquareMatrix c;
	static SquareMatrix d;
	static SquareMatrix I;
	
	public static void main(String[] args) {
		// Define the elements within each matrix
		double[][] A = {{1,0,2},{0,1,0},{-3,0,-1}};
		double[][] B = {{0,0,1},{0,1,0},{-1,0,1}};
		double[][] C = {{4,3},{3,2}};
		double[][] D = {{-2,3},{3,-4}};
			
	
		try {
			// Try and assign the elements to a matrix
			a = new SquareMatrix(A);
			b = new SquareMatrix(B);
			c = new SquareMatrix(C);
			d = new SquareMatrix(D);
			I = SquareMatrix.unitMatrix(2);			
		}
		catch (Exception e) {
			// Catch the error if the dimensions of the matrix are wrong
			System.out.println(e.getMessage());
		}
		
		//Print out what the matrix are
		System.out.println("A is defined as: "+a);
		System.out.println("B is defined as: "+b);
		System.out.println("C is defined as: "+c);
		System.out.println("D is defined as: "+d);
		System.out.println("A two by two unit matrix is defined as: "+I+"\n");
		
		
		// Add a to b and print the output
		System.out.println("Add a to b:");
		try {System.out.println(SquareMatrix.add(a,b)+"\n");}
		catch (Exception e){System.out.println(e.getMessage());}

		// Subtract b from a and print the output
		System.out.println("Subtract b from a:");
		try {System.out.println(SquareMatrix.subtract(a,b)+"\n");}
		catch (Exception e){System.out.println(e.getMessage());}
		
		// Multiply a and b and print the output
		System.out.println("Multiply a and b:");
		try {System.out.println(SquareMatrix.multiply(a,b)+"\n");}
		catch (Exception e){System.out.println(e.getMessage());}	
		
		// Multiply b and a and print the output
		System.out.println("Multiply b and a:");
		try {System.out.println(SquareMatrix.multiply(b,a)+"\n");}
		catch (Exception e){System.out.println(e.getMessage());}	
		
		// Calculate and print the commutator [A,B], defined as (AB - BA) and print the output
		System.out.println("Calculate and print the commutator [A,B], defined as (AB - BA):");
		try {System.out.println(SquareMatrix.subtract(SquareMatrix.multiply(a,b),SquareMatrix.multiply(b,a))+"\n");}
		catch (Exception e){System.out.println(e.getMessage());}	
		
		// Calculate the product CD and check whether the result is equal to the 2x2 unit matrix and print the boolean output
		System.out.println("Calculate the product CD and check whether the result is equal to the 2x2 unit matrix:");
		try {System.out.println(SquareMatrix.multiply(c,d).equals(I)+"\n");}
		catch (Exception e){System.out.println(e.getMessage());}	
		
	}
}
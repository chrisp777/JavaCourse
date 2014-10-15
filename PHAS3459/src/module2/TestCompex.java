package module2;
import module2.Complex;

public class TestCompex {

	public static void main(String[] args) {
		// Defines the two complex numbers that will be used in the tests
		Complex c1 = new Complex(2,-1);
		Complex c2 = new Complex(-1,2);
		
		// Multiplies or divides the two complexes c1 and c2 along with the constants I and ZERO in
		// various ways to test all the different functionalities 
		System.out.println("Multiply two complex numbers. c1*c2 = ");
		System.out.println(Complex.multiply(c1, c2));
		System.out.println("Divide two complex numbers. c1/c2 = ");
		System.out.println(Complex.divide(c1, c2));
		System.out.println("Multiply two complex numbers. c1*I = ");
		System.out.println(Complex.multiply(c1, Complex.I));
		System.out.println("Divide two complex numbers. c1*ZERO (Not a number) = ");
		System.out.println(Complex.divide(c1, Complex.ZERO));
		System.out.println("Multiply two complex numbers. c1*c1^* = ");
		System.out.println(Complex.multiply(c1, Complex.conjugate(c1)));
		System.out.println("Multiply two complex numbers. c2*c2^* = ");
		System.out.println(Complex.multiply(c2, Complex.conjugate(c2)));
		
	}

}

package module2;
import module2.Complex;

public class TestCompex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Defines the two complex numbers that will be used in the tests
		Complex c1 = new Complex(2,-1);
		Complex c2 = new Complex(-1,2);
		
		// Multiplies or divides the two complexes c1 and c2 along with the constants I and ZERO in
		// various ways to test all the different functionalities 
		System.out.println(Complex.multiplay(c1, c2));
		System.out.println(Complex.divide(c1, c2));
		System.out.println(Complex.multiplay(c1, Complex.I));
		System.out.println(Complex.divide(c1, Complex.ZERO));
		System.out.println(Complex.multiplay(c1, Complex.conjugate(c1)));
		System.out.println(Complex.multiplay(c2, Complex.conjugate(c2)));
		
	}

}

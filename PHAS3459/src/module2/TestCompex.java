package module2;
import module2.Complex;

public class TestCompex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Complex c1 = new Complex(2,-1);
		Complex c2 = new Complex(-1,2);
			
		System.out.println(Complex.multiplay(c1, c2));
		System.out.println(Complex.divide(c1, c2));
		System.out.println(Complex.multiplay(c1, Complex.I));
		System.out.println(Complex.divide(c1, Complex.ZERO));
		System.out.println(Complex.multiplay(c1, Complex.conjugate(c1)));
		System.out.println(Complex.multiplay(c2, Complex.conjugate(c2)));
		
	}

}

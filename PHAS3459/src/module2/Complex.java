package module2;

public class Complex {
	private double i;
	private double r;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public Complex(double imaginarypart, double realPart) {
		i = imaginarypart;
		r = realPart;
	}
	
	double real() {	
		return this.r;
	}
	
	double imag() {	
		return this.i;
	}
	
	double modulus() {
		return Math.sqrt(this.i*this.i+this.r*this.r);
	}
	
	double angle() {
		return Math.atan2(this.i,this.r);
	}
	
	Complex conjugate() {
		this.i=-1*this.i;
		return new Complex(this.i,this.r);
	}
	
	Complex normalised() {
		return new Complex(this.i/modulus(),this.r/modulus());
	}
	
	boolean equals(Complex c) {
		if((this.r == c.r)||(this.i == c.i)){
			return true;
		}
		return false;
	}
	
	public String toString() {
		String complex = "The real part is: "+r+" and the imaginary part is: "+i;
		return complex;
	}
	
	Complex setFromModulusAngle(double mag, double ang){
		double real = mag*Math.acos(ang);
		double imag = mag*Math.asin(ang);
		
		return new Complex(imag, real);
	}
	
	static public Complex add(Complex c1, Complex c2) {
		Complex result = new Complex(c1.i+c2.i, c1.r+c2.r);
		return result;
	}
	static public Complex subtract(Complex c1, Complex c2) {
		Complex result = new Complex(c1.i-c2.i,c1.r-c2.r);
		return result;
	}
	static public Complex multiplay(Complex c1, Complex c2) {
		Complex result = new Complex(c1.r*c2.r+(-1)*(c1.i*c2.i),(c1.r*c2.i+c2.r*c1.i));
		return result;		
	}
	static public Complex divide(Complex c1, Complex c2) {
		Complex denominator = multiplay(c2,c2.conjugate());
		Complex numerator = multiplay(c1,c2.conjugate())
		Complex result = new Complex();
		return result;
	}
}

package module3;

public class Complex {
	// Set up the constant variables for the complex identities
	// Complex with the value one which means a real value of 1
	static final Complex ONE = new Complex(0,1);
	// Complex with the value 0 with both imaginary and real parts being 0
	static final Complex ZERO = new Complex(0,0);
	// Complex wit the value i  which means a real value of 0 and an imaginary value of 1
	static final Complex I = new Complex(1,0);
	// Variables used in the construct for imaginary and real
	private double i;
	private double r;
	
	//Complex construct with both imaginary parts and real parts
	public Complex(double imaginarypart, double realPart) {
		i = imaginarypart;
		r = realPart;
	}
	
	// Method which returns the real part of the complex 
	double real() {	
		return this.r;
	}
	
	// Method which returns the imaginary part of the complex
	double imag() {	
		return this.i;
	}
	
	// Method to calculate/return the modulus of a complex number
	double modulus() {
		return Math.sqrt(this.i*this.i+this.r*this.r);
	}
	
	// Method to calculate/return the angle of a complex number
	double angle() {
		return Math.atan2(this.i,this.r);
	}
	
	// Method to calculate/return the complex conjugate of a complex number
	Complex conjugate() {
		return new Complex(this.i*-1,this.r);
	}
	
	// Static version of the above function to allow it to be called in a different way
	static public Complex conjugate(Complex arg) {
		return arg.conjugate();
	}
	
	// Method that returns a normalised complex of the complex that was supplied
	Complex normalised() throws Exception {
		//Throw an exception if the magnitude is zero ie the complex was zero
		if(this.modulus()==0){throw new Exception("ERROR: Modulus of complex is zero.");}
		return new Complex(this.i/modulus(),this.r/modulus());
	}
	
	// Checks to see if on complex equals another complex for comparisons using this data type
	boolean equals(Complex c) {
		// Imaginary parts and real parts must both be equal for the complex to be equal
		if((this.r == c.r)&&(this.i == c.i)){
			return true;
		}
		return false;
	}
	
	// Adds a toString behaviour so that Complex can be outputted in a readable format to te user
	public String toString() {
		String complex = "("+r+" + "+i+"i) - The real part is: "+r+" and the imaginary part is: "+i;
		return complex;
	}
	
	// Method that returns a complex from the magnitude and angle supplied ei working backwards from mag and angle
	Complex setFromModulusAngle(double mag, double ang){
		double real = mag*Math.acos(ang);
		double imag = mag*Math.asin(ang);
		
		return new Complex(imag, real);
	}
	
	// Static method that adds two complex numbers together ei c1 + c2
	static public Complex add(Complex c1, Complex c2) {
		Complex result = new Complex(c1.i+c2.i, c1.r+c2.r);
		return result;
	}
	
	// Static method that subtract two complex numbers together ei c1 - c2 
	static public Complex subtract(Complex c1, Complex c2) {
		Complex result = new Complex(c1.i-c2.i,c1.r-c2.r);
		return result;
	}
	
	// Static method that multiplies two complex numbers ei c1 * c2
	static public Complex multiplay(Complex c1, Complex c2) {
		Complex result = new Complex((c1.r*c2.i+c2.r*c1.i),c1.r*c2.r+(-1)*(c1.i*c2.i));
		return result;		
	}
	
	// Static method that divides two complex numbers ei c1 / c2
	static public Complex divide(Complex c1, Complex c2) throws Exception {
		// Throws an exception if the given argument is a zero complex 
		if (c2.equals(ZERO)) {throw new Exception("ERROR: Cannot divide by zero.");}
	
		//Performed the divide
		Complex numerator = multiplay(c1,conjugate(c2));
		double denominator = (c2.r*conjugate(c2).r)+((-1)*c2.i*conjugate(c2).i);
		Complex result = new Complex(numerator.i/denominator,numerator.r/denominator);
		return result;
	}
}

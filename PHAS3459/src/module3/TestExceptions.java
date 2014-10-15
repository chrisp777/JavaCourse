package module3;
import module3.*;

public class TestExceptions {

	public static void main(String[] args) {
		// Sets up two vectors to test the exceptions with, one is a zero vector
		ThreeVector v1 = new ThreeVector(1,1,1);
		ThreeVector v2 = new ThreeVector(0,0,0);
		
		// Sets up two complex number with one being a zero complex
		Complex c1 = new Complex(1,1);
		Complex c2 = new Complex(0,0);
		
		// Tests the divide by zero exception in the complex class
		try {
			System.out.println(Complex.divide(c1,c2));
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e);
		} 
		
		// Tests the divide by zero exception in the complex class
		try {
			System.out.println(c2.normalised());
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e);
		}
		
		// Tests the unit vector with a zero exception in the three vector class
		try {
			System.out.println(v2.unitVector());
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e);
		}
		
		// Tests the angle method with a zero vector exception in the three vector class
		try {
			System.out.println(ThreeVector.angle(v1, v2));
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e);
		}
		
		// Negative mass in the falling particle class
		try {
			// Make a new falling particle called ball with its mass and drag set
			FallingParticle ball = new FallingParticle(-5.3,2.1);
			ball.setZ(10); // Drop tank depth/height.
			ball.drop(0.0001);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e);	
		}
		// Negative drag in the falling particle class
		try {
			// Make a new falling particle called ball with its mass and drag set
			FallingParticle ball = new FallingParticle(5.3,-2.1);
			ball.setZ(10); // Drop tank depth/height.
			ball.drop(0.0001);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e);	
		}
		// Negative z in the falling particle class
		try {
			// Make a new falling particle called ball with its mass and drag set
			FallingParticle ball = new FallingParticle(5.3,2.1);
			ball.setZ(-10); // Drop tank depth/height.
			ball.drop(0.0001);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e);	
		}
		// Negative time interval in the falling particle class
		try {
			// Make a new falling particle called ball with its mass and drag set
			FallingParticle ball = new FallingParticle(5.3,2.1);
			ball.setZ(10); // Drop tank depth/height.
			ball.drop(-0.0001);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e);	
		}
	}

}

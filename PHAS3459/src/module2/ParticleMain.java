package module2;
import module2.FallingParticle;

public class ParticleMain {
	// Main class to test the falling particle class.
	public static void main(String[] args) {
		// Make a new falling particle called ball with its mass and drag set
		FallingParticle ball = new FallingParticle(5.3,2.1);
		ball.setZ(10); // Drop tank depth/height.
		ball.drop(0.5); // 'Drop' the ball through a vertical tank with dT varying
		ball.setZ(10); // The depth of the tank is set each time because the same object is being used.
		ball.drop(0.1);
		ball.setZ(10);
		ball.drop(0.01);
		ball.setZ(10);
		ball.drop(0.001);
		ball.setZ(10);
		ball.drop(0.0001);
	}

}

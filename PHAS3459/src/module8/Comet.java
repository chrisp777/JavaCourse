package module8;

import java.awt.Color;
/**
 * Comet class extents the orbital body object with the variables added by the Comet. The constructor also sets the type variable.
 * @author Chris
 * @see OrbitalBody SpaceStuff
 */
public class Comet extends OrbitalBody {
	private SpaceStuff parent;
	
	public Comet(String name, int index, int height, int width, Color color, SpaceStuff parent, int xPos, int yPos, double angle, double delta) {
		super(name, index, height, width, "comet", color, xPos, yPos, angle, delta);
		this.parent = parent;		
	}
	
	public SpaceStuff getParent() {
		return parent;
	}
}

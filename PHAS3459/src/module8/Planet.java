package module8;

import java.awt.Color;
/**
 * Planet class extents the orbital body object with the variables added by the planet. The constructor also sets the type variable.
 * @author Chris
 * @see OrbitalBody SpaceStuff
 */
public class Planet extends OrbitalBody  {
	// Initiates private variables
	private SpaceStuff parent;
	
	// Planet Constructor
	public Planet(String name, int index, int height, int width, Color color, SpaceStuff parent, int xPos, int yPos, double angle, double delta) {
		super(name, index, height, width, "planet", color, xPos, yPos, angle, delta);
		this.parent = parent;		
	}
	
	// Getter
	public SpaceStuff getParent() {
		return parent;
	}
}

package module8;

import java.awt.Color;

public class Moon extends OrbitalBody {
	private SpaceStuff parent;
	
	public Moon(String name, int index, int height, int width, Color color, SpaceStuff parent, int xPos, int yPos, double angle, double delta) {
		super(name, index, height, width, "moon", color, xPos, yPos, angle, delta);
		this.parent = parent;		
	}
	
	public SpaceStuff getParent() {
		return parent;
	}
}

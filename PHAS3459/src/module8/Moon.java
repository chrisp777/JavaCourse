package module8;

import java.awt.Color;

public class Moon extends OrbitalBody {
	private SpaceStuff parent;
	
	public Moon(String name, int index, int height, int width, Color color, SpaceStuff spaceStuff, int xPos, int yPos, double angle) {
		super(name, index, height, width, "moon", color, xPos, yPos, angle);
		this.parent = spaceStuff;		
	}
	
	public SpaceStuff getParent() {
		return parent;
	}
}

package module8;

import java.awt.Color;

public interface SpaceStuff {
	public void setXPos(int xPos);	
	public void setYPos(int yPos);	
	public int getXPos();	
	public int getYPos();
	public String getName();	
	public int getIndex();
	public int getHeight();
	public int getWidth();
	public String getType();
	public Color getColor();
	public SpaceStuff getParent();
	public double getAngle();

}

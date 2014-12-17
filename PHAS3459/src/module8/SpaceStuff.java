package module8;

import java.awt.Color;

/**
 * SpaceStuff is the interface for anything that needs to have its position calculated or its object drawn. 
 * All the dependant functions are listed here so that the code can run.
 * @author Chris
 *
 */
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
	public void setAngle(double angle);
	public double getDelta();

}

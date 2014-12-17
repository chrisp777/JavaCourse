package module8;

import java.awt.Color;
/**
 * OribitalBody is the object  class for stars. Any functions or variables that are shared by all objects are outlined here. This is mostly a stub however the 
 * functionality of more than one star in a system could be expanded too easier by including the structures here. NOTE this is not an OrbitalBody
 * @author Chris
 * @see SpaceStuff
 *
 */
public class Star implements SpaceStuff{
	// Initates the variables that will be set
	private String name;
	private int height;
	private int width;
	private Color color;
	private int xPos;
	private int yPos;
	
	// Star Constructor
	public Star(String name, int height, int width, Color color, int xPos, int yPos) {
		this.name = name;
		this.height = height;
		this.width = width;
		this.color = color;
		this.xPos = xPos;
		this.yPos= yPos;
	}
	
	// Setters and getters
	public void setXPos(int xPos) {
		this.xPos = xPos;
	}
	
	public void setYPos(int yPos) {
		this.yPos = yPos;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	public Color getColor() {
		return color;
	}


	// Below are all unused in this implementation as the star doesn't have settings for these variables.
	// The simulation however could be extended to include multiple stars and then these variables could be
	// used.
	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public SpaceStuff getParent() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public double getAngle() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void setAngle(double angle) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public double getDelta() {
		// TODO Auto-generated method stub
		return 0;
	}
}

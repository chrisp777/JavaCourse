package module8;

import java.awt.Color;

public class OrbitalBody implements SpaceStuff{
	private String name;
	private int index;
	private int height;
	private int width;
	private String type;
	private Color color;
	private int xPos;
	private int yPos;
	private double angle;
	
	public OrbitalBody(String name, int index, int height, int width, String type, Color color, int xPos, int yPos, double angle) {
		this.name = name;
		this.index = index;
		this.height = height;
		this.width = width;
		this.type = type;
		this.color = color;
		this.xPos = xPos;
		this.yPos = yPos;
		this.angle = angle;
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
	}
	public double getAngle() {
		return angle;
	}
	
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
	
	public int getIndex() {
		return index;
	}
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public String getType() {
		return type;
	}
	
	public Color getColor() {
		return color;
	}


	@Override
	public SpaceStuff getParent() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}

package module8;

import java.awt.Color;

public class Star implements SpaceStuff{
	private String name;
	private int height;
	private int width;
	private Color color;
	private int xPos;
	private int yPos;
	
	public Star(String name, int height, int width, Color color, int xPos, int yPos) {
		this.name = name;
		this.height = height;
		this.width = width;
		this.color = color;
		this.xPos = xPos;
		this.yPos= yPos;
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
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	public Color getColor() {
		return color;
	}


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

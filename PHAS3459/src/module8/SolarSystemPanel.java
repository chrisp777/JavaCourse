package module8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;





public class SolarSystemPanel extends JPanel {
	ArrayList<SpaceStuff> spaceStuff = new ArrayList<SpaceStuff>();
	Star sun = new Star("Sun",200,200, Color.YELLOW, 0, 0);
	
	public SolarSystemPanel(int width, int height) {
		setPreferredSize(new Dimension(width,height));
		}
	
	public void calculatePos(/*int delta*/) {
		int delta = 1;
		for(SpaceStuff thing : spaceStuff) {
			SpaceStuff parent = thing.getParent();
			double radius = parent.getWidth() + thing.getIndex()*(parent.getWidth()*0.3);
			double angle = thing.getAngle() + ( 2 * Math.PI / (100 * delta));
			double xPos = (parent.getXPos() + (radius*Math.cos(angle)));
			double yPos = (parent.getYPos() + (radius*Math.sin(angle)));
			thing.setXPos((int) Math.floor(xPos));
			thing.setYPos((int) Math.floor(yPos));
		}
	}
	
	public void paintUniverse(Graphics g){
		for(SpaceStuff thing : spaceStuff) {
			g.setColor(thing.getColor());
			g.fillOval(thing.getXPos(), thing.getYPos(), thing.getWidth(), thing.getHeight());
		}
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // call superclass method first
		
		int midX = getWidth()/2;
		int midY = getHeight()/2;
		
		//Star sun = new Star("Sun",200,200, Color.YELLOW, midX-100, midY-100);
		sun.setXPos(midX-100);
		sun.setYPos(midY-100);
		
		//spaceStuff.add(new Planet("Earth", 4, 30, 30, Color.BLUE, sun,0,0,0));
		//spaceStuff.add(new Moon("Luna", 1, 10, 10, Color.GRAY, spaceStuff.get(spaceStuff.size()-1),0,0,0));
		//spaceStuff.add(new Planet("Mars", 5, 20, 20, Color.RED, sun,0,0,0));

		
		
		//Planet earth = new Planet("Earth", 4, 30, 30, Color.BLUE, sun,0,0);
		//Moon luna = new Moon("Luna", 1, 10, 10, Color.GRAY, earth,0,0);
		
		
		g.setColor(sun.getColor());
		g.fillOval(sun.getXPos(), sun.getYPos(), sun.getWidth(), sun.getHeight());
		
		calculatePos();
		paintUniverse(g);
		
	}
}
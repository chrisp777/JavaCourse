package module8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;





public class SolarSystemPanel extends JPanel implements ActionListener {
	ArrayList<SpaceStuff> spaceStuff = new ArrayList<SpaceStuff>();
	private JButton toggleMoons;
	private JButton toggleOrbits;
	Star sun = new Star("Sun",100,100, Color.ORANGE, 0, 0);
	double time = 0;
	int tickTime = 10000;
	boolean moons = false;
	boolean orbits = true;
	
	public SolarSystemPanel(int width, int height) {
		setPreferredSize(new Dimension(width,height));
		toggleMoons = new JButton("Moon Toggle");
		toggleOrbits = new JButton("Orbits Toggle");
		add(toggleMoons);
		add(toggleOrbits);
		toggleOrbits.addActionListener(this);
		toggleMoons.addActionListener(this);
		}
	
	public void calculatePos(/*int delta*/) {
		for(SpaceStuff thing : spaceStuff) {
			if (thing.getType()!= "comet") {
				// Circular orbits
				SpaceStuff parent = thing.getParent();
				int radius = (int)(parent.getWidth() + thing.getIndex()*(parent.getWidth()*0.6));
				double angle = thing.getAngle() + ( 2 * Math.PI / (tickTime * thing.getDelta()));
				thing.setAngle(angle);
				double xPos = (parent.getXPos()+parent.getWidth()/2-thing.getWidth()/2 + ((radius/2)*Math.cos(angle)));
				double yPos = (parent.getYPos()+parent.getHeight()/2-thing.getHeight()/2 + ((radius/2)*Math.sin(angle)));
				thing.setXPos((int) Math.floor(xPos));
				thing.setYPos((int) Math.floor(yPos));
			}
			else {
				// Odd Orbits
				SpaceStuff parent = thing.getParent();
				int radius = (int)(parent.getWidth() + thing.getIndex()*(parent.getWidth()*0.6));
				double sunDist = Math.sqrt(Math.pow(sun.getXPos()+sun.getWidth()/2-thing.getXPos(),2)+Math.pow(sun.getYPos()+sun.getHeight()/2-thing.getYPos(),2));
				double delta = 1/(thing.getDelta()*100/sunDist);
				double angle = thing.getAngle() + ( 2 * Math.PI / (tickTime * delta));
				thing.setAngle(angle);
				double xPos = (parent.getXPos()+parent.getWidth()/2-thing.getWidth()/2 + ((radius)*Math.cos(angle)))+220;
				double yPos = (parent.getYPos()+parent.getHeight()/2-thing.getHeight()/2 + ((radius/2)*Math.sin(angle)));
				thing.setXPos((int) Math.floor(xPos));
				thing.setYPos((int) Math.floor(yPos));
			}
		}
	}
	
	public void paintUniverse(Graphics g){
		for(SpaceStuff thing : spaceStuff) {
			if(thing.getType() == "moon" && moons == false){continue;};
			SpaceStuff parent = thing.getParent();
			int radius = (int)(parent.getWidth() + thing.getIndex()*(parent.getWidth()*0.6));
			g.setColor(thing.getColor());
			//g.drawOval(parent.getXPos()+parent.getWidth()/2, parent.getYPos()+parent.getHeight()/2, 2, 2);
			if(orbits == true) {
				if (thing.getType()== "comet"){
					g.drawOval(parent.getXPos()+parent.getWidth()/2-radius+220, parent.getYPos()+parent.getHeight()/2-radius/2, radius*2, radius);
				}
				else{
					g.drawOval(parent.getXPos()+parent.getWidth()/2-radius/2, parent.getYPos()+parent.getHeight()/2-radius/2, radius, radius);
				}
			}
			//g.setColor(thing.getColor());
			g.fillOval(thing.getXPos(), thing.getYPos(), thing.getWidth(), thing.getHeight());
			
			Font f = new Font("TimesRoman", Font.PLAIN,14);
			g.setFont(f);
			if(thing.getType()=="planet"){
				g.drawString(thing.getName(), thing.getXPos(), thing.getYPos()-10);
			}
		}
		Font f = new Font("TimesRoman", Font.PLAIN,28);
		g.setFont(f);
		g.setColor(Color.GRAY);
		g.drawString("Time passed: "+Math.floor(time/(tickTime/100))/100+" earth years", 1, 21);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // call superclass method first
		
		int midX = getWidth()/2;
		int midY = getHeight()/2;

		sun.setXPos(midX-50);
		sun.setYPos(midY-50);
		
		g.setColor(sun.getColor());
		g.fillOval(sun.getXPos(), sun.getYPos(), sun.getWidth(), sun.getHeight());
		
		Font f = new Font("TimesRoman", Font.PLAIN,28);
		g.setFont(f);
		g.setColor(Color.GRAY);
		g.drawString("Orbit Radii are not to scale, particularly in the case of moons", 1, 995);
		
	
		paintUniverse(g);
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == toggleMoons) {
			if(moons == false){moons = true;}
			else {moons = false;}
		}
		else if (e.getSource() == toggleOrbits) {
			if(orbits == false){orbits = true;}
			else {orbits = false;}
		}
	}
}
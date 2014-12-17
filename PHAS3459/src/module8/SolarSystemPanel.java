package module8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * SolarSystemPanel is the class which outlines all the method and variables directly involved in the simulation.
 * Objects however are added from SolarSystem.
 * 
 * @author Chris
 * @see SpaceStuff OrbitalBody Star Planet Moon Comet
 */

public class SolarSystemPanel extends JPanel implements ActionListener {
	// Creates the array of objects that will be painted
	ArrayList<SpaceStuff> spaceStuff = new ArrayList<SpaceStuff>();
	// Create new buttons for toggles
	private JButton toggleMoons;
	private JButton toggleOrbits;
	// Make the sun star object
	Star sun = new Star("Sun",100,100, Color.ORANGE, 0, 0);
	// Time variable holds the simulation time
	double time = 0;
	// Tick time gives the time for one full earth orbit in ticks, should be 10 seconds but almost all computers 
	// will struggle to simulate that fast
	int tickTime = 10000;
	// Button toggles
	boolean moons = false;
	boolean orbits = true;
	
	/**
	 * SolarSystemPanel is the constructor for the panel and sets up all the variables and the click event listeners
	 * @param width
	 * @param height
	 */
	public SolarSystemPanel(int width, int height) {
		setPreferredSize(new Dimension(width,height));
		toggleMoons = new JButton("Moon Toggle");
		toggleOrbits = new JButton("Orbits Toggle");
		add(toggleMoons);
		add(toggleOrbits);
		toggleOrbits.addActionListener(this);
		toggleMoons.addActionListener(this);
		}
	
	/**
	 * calculatePos calculates the position of every orbital body in the spaceStuff array of SpaceStuff.
	 * All orbits apart from testing out commet orbits are circular to simplify the equation of motion. 
	 * The position of each object of course depends heavily on the parent position, and then a circle around that point
	 * is the path which the object will orbit. The radius of this orbit is somewhat made up however it works
	 * to show all the object in the screen size, and a warning message is printed to tell the user that the 
	 * radii are NOT TO SCALE. Not even close. It is important to remember also that the width of the parent and 
	 * in some cases the width of the object need to be taken into account to give true positioning.
	 * The angle and delta are taken from each objects variables and then the angle is increamented for each time the 
	 * position is drawn.
	 * 
	 * @see SpaceStuff
	 */
	public void calculatePos(/*int delta*/) {
		for(SpaceStuff thing : spaceStuff) {
			if (thing.getType()!= "comet") {
				// Circular orbits
				SpaceStuff parent = thing.getParent();
				// 0.6 in the following formular can be taken as a scale factor and is set to avoid too much orbital body overlap
				int radius = (int)(parent.getWidth() + thing.getIndex()*(parent.getWidth()*0.6));
				double angle = thing.getAngle() + ( 2 * Math.PI / (tickTime * thing.getDelta()));
				thing.setAngle(angle);
				double xPos = (parent.getXPos()+parent.getWidth()/2-thing.getWidth()/2 + ((radius/2)*Math.cos(angle)));
				double yPos = (parent.getYPos()+parent.getHeight()/2-thing.getHeight()/2 + ((radius/2)*Math.sin(angle)));
				thing.setXPos((int) Math.floor(xPos));
				thing.setYPos((int) Math.floor(yPos));
			}
			else {
				// Odd Orbits for commets, this is a rough draft of comet motion and is very inaccurate scientifically
				// This being said the comet does speed up closer to the sun and follows an elipical path rather than a circle
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
	/**
	 * paintUniverse takes a graphic input and then paints each orbital body from the arrayList with the position and size and colour data contained there.
	 * the orbital paths of each object is also calulated and painted as this makes it much clearer to the user wher ethe objects need to be. Again comets
	 * are included as a special case however this is VERY rough and is hard coded.
	 * @param g the graphic to add the objects too
	 */
	public void paintUniverse(Graphics g){
		// For all spaceStuff
		for(SpaceStuff thing : spaceStuff) {
			// Detect moons
			if(thing.getType() == "moon" && moons == false){continue;};
			SpaceStuff parent = thing.getParent(); // parent data
			// Same radius calculation as above
			int radius = (int)(parent.getWidth() + thing.getIndex()*(parent.getWidth()*0.6));
			// Get the colour
			g.setColor(thing.getColor());
			// detect if the orbits of the objects are to be drawn.
			if(orbits == true) {
				if (thing.getType()== "comet"){
					// comet special case
					g.drawOval(parent.getXPos()+parent.getWidth()/2-radius+220, parent.getYPos()+parent.getHeight()/2-radius/2, radius*2, radius);
				}
				else{
					// normal circular orbit
					g.drawOval(parent.getXPos()+parent.getWidth()/2-radius/2, parent.getYPos()+parent.getHeight()/2-radius/2, radius, radius);
				}
			}
			// DRAW THE OBJECT BODY
			g.fillOval(thing.getXPos(), thing.getYPos(), thing.getWidth(), thing.getHeight());
			
			// If the names of the objects are turns on print out the name next to the object
			Font f = new Font("TimesRoman", Font.PLAIN,14);
			g.setFont(f);
			if(thing.getType()=="planet"){
				g.drawString(thing.getName(), thing.getXPos(), thing.getYPos()-10);
			}
		}
		// update the simulation time in earth years
		Font f = new Font("TimesRoman", Font.PLAIN,28);
		g.setFont(f);
		g.setColor(Color.GRAY);
		g.drawString("Time passed: "+Math.floor(time/(tickTime/100))/100+" earth years", 1, 21);
	}
	
	/**
	 * paintComponent prints a few object to the panel including the sun in the centre and the warning message for the radii
	 */
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
		
		// As this is called first we want to print the rest of the universe now
		paintUniverse(g);
		
	}

	// Code that handles the button presses and changes the toggle variables
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
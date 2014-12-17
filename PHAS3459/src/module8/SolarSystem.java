package module8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * SolarSystem is the main class which creates the panel which the solar system is simulated in.
 * The orbital bodies are added to the simulation here with accurate orbit period data
 * however the radius of orbit is not to scale at all. Moons are also included however again
 * these are not to scale and do not have correct period data either. This could be exteded using 
 * keplers 3 equations focusing on mass, radius of orbit and period however the mass would make 
 * density assumptions to get an 'accurate' size, radius of orbit data cannot be shown to scale and
 * be able to see the whole solar system. Where as period could be calculated and shown this would mean
 * inputting both the radius and the mass which would then be discarded, and so it would make more sense
 * to just provide accurate orbital period data. This is given as a fraction of the earth's orbital time.
 * Names of bodies are only displayed in the simulation for planets as moons become cluttered, however all
 * name data is outputted to the console at runtime. 
 * 
 * @author Chris Davenport
 * @see SolarSystemPanel SpaceStuff Star Planet Moon Comet OrbitalBody
 *
 */

public class SolarSystem extends JPanel{
	static SolarSystemPanel panel;
	
	/**
	 * createAndDisplayGui creates the new panel in which the simulation is run with a default size which fits on UCL computers
	 * @return SolarSystemPanel the panel which objects will be later added to
	 */
	private static  SolarSystemPanel createAndDisplayGui() {
		// Give title closing method and also size.
		JFrame frame = new JFrame("Solar System Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new SolarSystemPanel(1000,1000);
		frame.add(panel); // Add panel to frame
		frame.pack(); // Set component sizes and layout
		frame.setVisible(true); // Display the resulting frame
		return panel;
	}
	
	/**
	 * printSpaceStuff prints out the names of all the obital bodies which are being simulated to the console.
	 */
	public static void printSpaceStuff() {
		// Print a header
		System.out.println("The following objects are being simulated:");
		boolean hasMoons = false; // Moons toggle
		for(SpaceStuff thing : panel.spaceStuff) {
			if (thing.getType()=="planet"){
				// Print each planet
				System.out.println("The planet: "+thing.getName());
				hasMoons = false;
			}
			else if (thing.getType()=="moon"){
				if(hasMoons == false ){
					// If the first moon of a planet print the header
					System.out.println("\t"+"With its moon(s):");
					// Set the toggle
					hasMoons = true;
				}
				// Print the moon
				System.out.println("\t"+thing.getName());
			}
		}
	}
	
	/**
	 * The SolarSystem Main method is where all the obrital bodies are added to the panel along with the data needed to simulate them
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			/**
			 * Run method first creates the panel and then adds to the Array contained by the panel all the planets and moons to be simulated.
			 */
			public void run() {
				panel = createAndDisplayGui();
				// The order in which the data is given is,
				// Name, index, x size, y size, colour, parent, x pos, y pos, angle, period(in earth periods)
				// The type of the object is intrinsic in the creation of the object
				// Only ROUND orbital bodies are added. Additional moons exist however are not round.
				panel.spaceStuff.add(new Planet("Mercury", 1, 10, 10, Color.RED, panel.sun,0,0,0,0.24));
				panel.spaceStuff.add(new Planet("Venus", 2, 29, 29, Color.RED, panel.sun,0,0,0,0.72));
				panel.spaceStuff.add(new Planet("Earth", 3, 30, 30, Color.BLUE, panel.sun,0,0,0,1));
				panel.spaceStuff.add(new Moon("Moon", 1, 5, 5, Color.GRAY, panel.spaceStuff.get(2),0,0,0,0.1));
				panel.spaceStuff.add(new Planet("Mars", 4, 15, 15, Color.RED, panel.sun,0,0,0,1.88));
				panel.spaceStuff.add(new Moon("Phobos", 1, 2, 2, Color.GRAY, panel.spaceStuff.get(4),0,0,0,0.1));
				panel.spaceStuff.add(new Moon("Deimos", 1, 2, 2, Color.GRAY, panel.spaceStuff.get(4),0,0,3.141,0.1));
				panel.spaceStuff.add(new Planet("Jupiter", 6, 55, 55, Color.RED, panel.sun,0,0,0,11.86));
				panel.spaceStuff.add(new Moon("Io", 1, 5, 5, Color.GRAY, panel.spaceStuff.get(7),0,0,0,0.1));
				panel.spaceStuff.add(new Moon("Europa", 1, 4, 4, Color.GRAY, panel.spaceStuff.get(7),0,0,3.14,0.1));
				panel.spaceStuff.add(new Moon("Gaymede", 1, 5, 5, Color.GRAY, panel.spaceStuff.get(7),0,0,0,0.2));
				panel.spaceStuff.add(new Moon("Callisto", 1, 4, 4, Color.GRAY, panel.spaceStuff.get(7),0,0,3.14,0.2));
				panel.spaceStuff.add(new Planet("Saturn", 8, 40, 40, Color.ORANGE, panel.sun,0,0,0,29.46));
				panel.spaceStuff.add(new Moon("Titan", 1, 5, 5, Color.ORANGE, panel.spaceStuff.get(12),0,0,0,0.1));
				panel.spaceStuff.add(new Moon("Rhea", 1, 2, 2, Color.GRAY, panel.spaceStuff.get(12),0,0,1.552,0.1));
				panel.spaceStuff.add(new Moon("Tethys", 1, 2, 2, Color.GRAY, panel.spaceStuff.get(12),0,0,3.141,0.1));
				panel.spaceStuff.add(new Moon("Dione", 1, 2, 2, Color.GRAY, panel.spaceStuff.get(12),0,0,4.593,0.1));
				panel.spaceStuff.add(new Moon("Lapetus", 1, 2, 2, Color.YELLOW, panel.spaceStuff.get(12),0,0,0,0.2));
				panel.spaceStuff.add(new Moon("Mimas", 1, 2, 2, Color.GRAY, panel.spaceStuff.get(12),0,0,1.552,0.2));
				panel.spaceStuff.add(new Moon("Enceladus", 1, 2, 2, Color.GRAY, panel.spaceStuff.get(12),0,0,3.141,0.2));
				panel.spaceStuff.add(new Moon("Hyperion", 1, 2, 2, Color.GRAY, panel.spaceStuff.get(12),0,0,4.593,0.2));
				panel.spaceStuff.add(new Moon("Pheoebe", 1, 2, 2, Color.GRAY, panel.spaceStuff.get(12),0,0,0,0.3));
				panel.spaceStuff.add(new Planet("Uranus", 10, 35, 35, Color.GREEN, panel.sun,0,0,0,84.01));
				panel.spaceStuff.add(new Moon("Puck", 1, 2, 2, Color.GRAY, panel.spaceStuff.get(22),0,0,0,0.1));
				panel.spaceStuff.add(new Moon("Miranda", 1, 2, 2, Color.GRAY, panel.spaceStuff.get(22),0,0,1,0.1));
				panel.spaceStuff.add(new Moon("Ariel", 1, 2, 2, Color.GRAY, panel.spaceStuff.get(22),0,0,2,0.1));
				panel.spaceStuff.add(new Moon("Umbriel", 1, 2, 2, Color.GRAY, panel.spaceStuff.get(22),0,0,3,0.1));
				panel.spaceStuff.add(new Moon("Titania", 1, 2, 2, Color.GRAY, panel.spaceStuff.get(22),0,0,4,0.1));
				panel.spaceStuff.add(new Moon("Oberon", 1, 2, 2, Color.GRAY, panel.spaceStuff.get(22),0,0,5,0.2));
				panel.spaceStuff.add(new Planet("Neptune", 12, 35, 35, Color.BLUE, panel.sun,0,0,0,164.8));
				panel.spaceStuff.add(new Moon("Proteus", 1, 2, 2, Color.GRAY, panel.spaceStuff.get(29),0,0,0,0.1));
				panel.spaceStuff.add(new Moon("Triton", 1, 4, 4, Color.BLACK, panel.spaceStuff.get(29),0,0,2,0.1));
				panel.spaceStuff.add(new Moon("Nereid", 1, 2, 2, Color.GRAY, panel.spaceStuff.get(29),0,0,4,0.1));
				panel.spaceStuff.add(new Planet("Pluto", 14, 5, 5, Color.GRAY, panel.sun,0,0,0,247.7));
				// A test comet to see how one could be simulated however it is very inaccurate
				panel.spaceStuff.add(new Comet("TEST", 3, 10, 10, Color.BLACK, panel.sun,100,100,0,4));
				
				// PAINT THE SOLAR SYSTEM!
				printSpaceStuff();
			}
		});
		// This is the tick timer which calls the calucalte pos method, increments the time variable and repaints the solarsystem
		ActionListener tick = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {;
				//System.out.println("Tick");
			    panel.calculatePos();
			    panel.time++;
				panel.repaint();
			}
		};
		// Tick every micro second, however this is unlikely to be an accurate time frame on every computer
		Timer timer = new Timer(1, tick);
		timer.start();
		
		
	}

	
}

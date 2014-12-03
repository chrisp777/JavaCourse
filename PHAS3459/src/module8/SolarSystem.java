package module8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class SolarSystem extends JPanel{
	static SolarSystemPanel panel;
	
	private static  SolarSystemPanel createAndDisplayGui() {
		JFrame frame = new JFrame("Solar System Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new SolarSystemPanel(1000,1000);
		frame.add(panel); // Add panel to frame
		frame.pack(); // Set component sizes and layout
		frame.setVisible(true); // Display the resulting frame
		return panel;
	}
	
	public static void printSpaceStuff() {
		System.out.println("The following objects are being simulated:");
		boolean hasMoons = false;
		for(SpaceStuff thing : panel.spaceStuff) {
			if (thing.getType()=="planet"){
				System.out.println("The planet: "+thing.getName());
				hasMoons = false;
			}
			else if (thing.getType()=="moon"){
				if(hasMoons == false ){
					System.out.println("\t"+"With its moon(s):");
					hasMoons = true;
				}
				System.out.println("\t"+thing.getName());
			}
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				panel = createAndDisplayGui();
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
				panel.spaceStuff.add(new Comet("TEST", 3, 10, 10, Color.BLACK, panel.sun,100,100,0,4));
				
				printSpaceStuff();
			}
		});
		ActionListener tick = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {;
				//System.out.println("Tick");
			    panel.calculatePos();
			    panel.time++;
				panel.repaint();
			}
		};
		Timer timer = new Timer(1, tick);
		timer.start();
		
		
	}

	
}

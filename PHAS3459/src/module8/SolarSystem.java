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
		SolarSystemPanel panel = new SolarSystemPanel(1000,1000);
		frame.add(panel); // Add panel to frame
		frame.pack(); // Set component sizes and layout
		frame.setVisible(true); // Display the resulting frame
		return panel;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				panel.spaceStuff.add(new Planet("Earth", 4, 30, 30, Color.BLUE, panel.sun,0,0,0));
				panel.spaceStuff.add(new Moon("Luna", 1, 10, 10, Color.GRAY, panel.spaceStuff.get(panel.spaceStuff.size()-1),0,0,0));
				panel.spaceStuff.add(new Planet("Mars", 5, 20, 20, Color.RED, panel.sun,0,0,0));
				panel = createAndDisplayGui();
			}
		});
		ActionListener tick = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {;
				panel.repaint();
			}
		};
		Timer timer = new Timer(100, tick);
		timer.start();
		
	}

	
}

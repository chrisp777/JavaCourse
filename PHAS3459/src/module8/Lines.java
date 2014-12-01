package module8;
import javax.swing.*;

public class Lines extends JPanel {

	private static void createAndDisplayGui() {
		JFrame frame = new JFrame("Swing graphics example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LinesPanel panel = new LinesPanel(400,400);
		frame.add(panel); // Add panel to frame
		frame.pack(); // Set component sizes and layout
		frame.setVisible(true); // Display the resulting frame
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndDisplayGui();
			}
		});
	}
}
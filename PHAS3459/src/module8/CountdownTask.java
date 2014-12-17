package module8;
/**
 * Countdown task is a runnable method which counts down from a number in seconds printing
 * out each as it goes and returning when it has finished
 * 
 * @author Chris
 *
 */
public class CountdownTask implements Runnable {
	// Set up the variables used and give them a value through the contructor
	private int countLength;
	public CountdownTask (int numSeconds) {
		countLength = numSeconds;
	}

	//Run method which does the actual counting down loop, sleeping for 1 second each loop
	@Override
	public void run() {
		int count = countLength;
		while (count >= 0) {
			// Interruption handleing 
			if (Thread.currentThread().isInterrupted()) return;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
			System.out.println(count);
			count--;
		}
		return;
	}

}

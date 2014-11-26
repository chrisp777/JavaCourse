package module8;

public class CountdownTask implements Runnable {
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountdownTask task = new CountdownTask(3);
		task.run();
	}*/
	
	private int countLength;
	public CountdownTask (int numSeconds) {
		countLength = numSeconds;
	}

	@Override
	public void run() {
		int count = countLength;
		while (count >= 0) {
			if (Thread.currentThread().isInterrupted()) return;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
			System.out.println(count);
			count--;
		}
	}

}

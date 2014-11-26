package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable{
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeNumberTask task = new PrimeNumberTask();
		task.run();
	}*/
		
	private ArrayList<Integer> primes = new ArrayList<Integer>();
	private int i;

	public ArrayList<Integer> getPrimes() {
		return primes;
	}
	
	public int getLargestInt() {
		return i;
	}
	
	@Override
	public void run() {
		i = 1;
		while (0<1) {
			if (Thread.currentThread().isInterrupted()) return;
			boolean prime = true;
			int j = i -1;
			while (j>1) {
				if ((i % j) == 0) {
					prime = false;
				}
				j--;
			}
			if (prime) {
				primes.add(i);
			}
			i++;
		}
	}

	
	
}

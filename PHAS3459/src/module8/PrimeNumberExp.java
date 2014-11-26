package module8;

import java.util.ArrayList;

public class PrimeNumberExp implements Runnable{
	private ArrayList<Long> primes = new ArrayList<Long>();
	private long i;

	public ArrayList<Long> getPrimes() {
		return primes;
	}
	
	public long getLargestInt() {
		return i;
	}
	
	@Override
	public void run() {
		i = 1;
		while (0<1) {
			if (Thread.currentThread().isInterrupted()) return;
			boolean prime = true;
			long j = i -1;
			while (j>1) {
				if ((i % j) == 0) {
					prime = false;
				}
				j--;
			}
			if (prime) {
				primes.add(i);
			}
			//i++;
			if (i<=10) {
				i++;
			}
			else {
				String string = Long.toString(i);
				int digit = (string.charAt(string.length()-1));	
				if(digit == 49 || digit == 55 || digit == 57) {
					i+=2;
				}
				else if (digit == 51) {
					i+=4;
				}
			}
		}
	}

	
	
}

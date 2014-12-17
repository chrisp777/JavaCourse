package module8;

import java.util.ArrayList;
/**
 * PrimeNumberTask is runnable method which calculates prime numbers starting
 * from 1 and getting larger. Each number is divided by every number smaller than it to
 * test to see if there are any factors, ei prime or not.
 * Primes are then added to a list.
 * 
 * @author Chris
 *
 */
public class PrimeNumberTask implements Runnable{
	// Set up the arrayList which will hold the primes that are found.
	private ArrayList<Integer> primes = new ArrayList<Integer>();
	private int i;
	
	// Getters so that the information about the primes can be calculated from another method.
	public ArrayList<Integer> getPrimes() {
		return primes;
	}
	
	public int getLargestInt() {
		return i;
	}
	
	// Run method which does the actaul prime finding as described above
	@Override
	public void run() {
		i = 1;
		while (0<1) {
			if (Thread.currentThread().isInterrupted()) return;
			boolean prime = true;
			int j = i -1;
			while (j>1) {
				if ((i % j) == 0) {
					// Factor was found
					prime = false;
				}
				j--;
			}
			if (prime) {
				// No factors were found, therefore it is prime
				primes.add(i);
			}
			i++;
		}
	}

	
	
}

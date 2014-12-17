package module8;

import java.util.ArrayList;

/**
 * The threads main class calls the two methods countTask and primeTask as sepurate threads
 * and then then once the countdown has finished interupts the prime number generatetor and prints some results
 * 
 * @author Chris
 * @see countTask primeTask
 *
 */
public class ThreadsMain {

	public static void main(String[] args) {
		// Make the two runnable objects that will be put into the threads
		CountdownTask countTask = new CountdownTask(10);
		PrimeNumberTask primeTask = new PrimeNumberTask();
		// Make and start the threads
		Thread count = new Thread(countTask);		
		Thread prime = new Thread(primeTask);
		count.start();
		prime.start();
		
		//Wait for the count task to finish
		try {
			count.join();
		} 
		catch (InterruptedException e) {
			//This exception should never happen.
		}
		//Interrupt the prime number calculator
		prime.interrupt();
		// Get the list of primes and output the stats required
		ArrayList<Integer> primes = primeTask.getPrimes();
		System.out.println("Number of ints checked: "+primeTask.getLargestInt());
		System.out.println("Largest prime found was: "+primes.get(primes.size()-1));
		System.out.println("Number of prime numbers found: "+primes.size()+"\n");
		
	}

}

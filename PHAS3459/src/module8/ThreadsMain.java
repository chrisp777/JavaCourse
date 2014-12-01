package module8;

import java.util.ArrayList;

public class ThreadsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountdownTask countTask = new CountdownTask(10);
		PrimeNumberTask primeTask = new PrimeNumberTask();
		Thread count = new Thread(countTask);		
		Thread prime = new Thread(primeTask);
		count.start();
		prime.start();
		try {
			count.join();
		} 
		catch (InterruptedException e) {}
		prime.interrupt();
		ArrayList<Integer> primes = primeTask.getPrimes();
		System.out.println("Number of ints checked: "+primeTask.getLargestInt());
		System.out.println("Largest prime found was: "+primes.get(primes.size()-1));
		System.out.println("Number of prime numbers found: "+primes.size()+"\n");
		
	}

}

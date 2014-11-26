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
		
		CountdownTask countTask2 = new CountdownTask(10);
		PrimeNumberExp primeTaskExp = new PrimeNumberExp();
		Thread count2 = new Thread(countTask2);		
		Thread prime2 = new Thread(primeTaskExp);
		count2.start();
		prime2.start();
		try {
			count2.join();
		} 
		catch (InterruptedException e) {}
		prime2.interrupt();
		ArrayList<Long> primes2 = primeTaskExp.getPrimes();
		System.out.println("Number of ints checked: "+primeTaskExp.getLargestInt());
		System.out.println("Largest prime found was: "+primes2.get(primes2.size()-1));
		System.out.println("Number of prime numbers found: "+primes2.size());
		
	}

}

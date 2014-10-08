package module1;

public class AlgorithmControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlgorithmControl ac = new AlgorithmControl();
		
		//loop test
		ac.loop();
		//decrement test
		ac.decrement();
		//increment test
		ac.increment();
		//First loop test with a 4sec runtime and loop step print out every 100 loops
		long firstLoop = ac.timer(4000,100);
		System.out.println(firstLoop);
		//Second loop test with a 4sec runtime and loop step print out every 50000 loops
		long secondLoop = ac.timer(4000, 50000);
		System.out.println(secondLoop);
		
		//print both the loop numbers again to compare them
		System.out.println("First Loop: "+firstLoop);
		System.out.println("Second Loop: "+secondLoop);
		System.out.println("Because the second loop doesn't have to print out so often it can run faster, therefore it can reach a higher loop number.");
		
	}
	
	void loop() {
		/* Set up variables with a blank iteration variable,
		 * a max loop number and the loop through printing out
		 * the iteration number each time. Every loop increments
		 * the loop variable by 1
		 */
		int i = 0;
		int maxN = 20;
		for ( i = 1; i <= maxN ; i++) {
			System.out.println(i);
		}
	}
	
	void decrement() {
		/*Uses a while loop to go from a start number to a
		 * lower end number in decrements of 1
		 */
		int i = 5; 
		int minN = -10;
		while (i>=minN) {
			System.out.println(i);
			i = i-1;
			
		}
	}
	
	void increment() {
		/* Goes from a starting decimal number to a decimal end
		 * number in steps of 0.5 printing out each loop		  
		 */
		double startN = 2.4;
		double endN = 14.9;
		double currentN = startN;
		
		while (currentN <= endN) {
			System.out.println(currentN);
			currentN = currentN + 0.5;
		}
				
	}
	
	/* Takes a run time and how often an output is required 
	 * The start time is recorded at the beginning and the end 
	 * time is calculated and then the loop continues until the
	 * current time matches or is larger tha the end time to allow
	 * for the runtime to not exactally coincide with the if statement
	 * Each time the remainder of the number of loops done, divided 
	 * by the loopStep is 0 the number of loops is outputed to the user
	 * the final number of loops is then printed out ot the user when the 
	 * function is originaly called.
	 */
	int timer(long maxTime, int loopSteps) {
		
		long startTime = System.currentTimeMillis();
		long endTime = startTime + maxTime;
		int numberLoops = 0;
			while (System.currentTimeMillis() <= endTime) {
				if ((numberLoops%loopSteps)==0) {
					System.out.println(numberLoops);
				}
			numberLoops = numberLoops + 1;
			}
		return numberLoops;
	}
	
}

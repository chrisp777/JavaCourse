package module6;

import java.util.ArrayList;
import java.util.Collection;

import module6.TestDataPoints.Point;

// Main class which loads in the data and then finds the best fit
public class DataAnalysis {
	public static void main(String args[]) {
		// Collection to hold the data that is loaded in from the URL
		Collection<Point> data =  TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
		
		// Two new objects to be passed to the bestTheory method
		GoodnessOfFitCalculator gofc = new ChiSquared();
		ArrayList<Theory> theory = new ArrayList<Theory>();
		
		// Adding each theory to a collection to be tested out
		System.out.println("There are three theories that will best tested:");
		theory.add(new PowerLawTheory(2));
		System.out.println("\t"+new PowerLawTheory(2));
		theory.add(new PowerLawTheory(2.05));
		System.out.println("\t"+new PowerLawTheory(2));
		theory.add(new QuadraticTheory(1,10,0));
		System.out.println("\t"+new QuadraticTheory(1,10,0)+"\n");
		
		// Test all the theories and print out the best one to the user
		System.out.println("The best theory that fits the data input is: "+bestTheory(data, theory, gofc));
	}
	
	// Method which finds the best theory for the list of theories provided
	// This was provided in the brief for this module however has been slightly altered to allow the Point object type that was used through this solution
    private static Theory bestTheory(Collection<Point> data, Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
        boolean first = true;
        double bestGoodnessOfFit = 0.0;
        Theory bestTheory = null;
        for (Theory theory : theories) {
            double gof = gofCalculator.goodnessOfFit(data, theory);
            if (first) {
                bestTheory = theory;
                bestGoodnessOfFit = gof;
                first = false; 
            } else if (gof < bestGoodnessOfFit) {
                bestTheory = theory;
                bestGoodnessOfFit = gof;
            }
        }
        return bestTheory;
    }
}

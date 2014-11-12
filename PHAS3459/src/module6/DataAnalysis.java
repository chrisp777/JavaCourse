package module6;

import java.util.ArrayList;
import java.util.Collection;

import module6.TestDataPoints.Point;

public class DataAnalysis {
	public static void main(String args[]) {
		Collection<Point> data =  TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
		Theory theoryPow = new PowerLawTheory(2);
		Theory theoryQuad = new QuadraticTheory(1,10,0);
		GoodnessOfFitCalculator gofc = new ChiSquared();
		ArrayList<Theory> theory = new ArrayList<Theory>();
		
		theory.add(theoryPow);
		theory.add(theoryQuad);
			
		bestTheory(data, theory, gofc);
	}
	
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

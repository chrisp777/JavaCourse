package module6;

import java.util.Collection;
import java.util.Iterator;

public class ChiSquared implements GoodnessOfFitCalculator{
	@Override
	public double goodnessOfFit(Collection<DataPoint> actual,Theory theory) {
		double chiSq = 0.0;
		// Uses an Iterator to go through the list and calculated the X2 for each by comparing it to the Theory
		Iterator<DataPoint> it = actual.iterator();
		while (it.hasNext()) {
			DataPoint line = it.next();
			chiSq += Math.pow(line.getY()-theory.y(line.getX()),2)/Math.pow(line.getEy(),2);
		}
		
		return chiSq;
	}

	@Override
	public Theory bestTheory() {
		// TODO Auto-generated method stub
		return null;
	}
}

package module6;

import java.util.Collection;
import java.util.Iterator;
import module6.TestDataPoints.Point;

public class ChiSquared implements GoodnessOfFitCalculator{
	@Override
	public double goodnessOfFit(Collection<Point> actual,Theory theory) {
		double chiSq = 0.0;
		// Uses an Iterator to go through the list and calculated the X2 for each by comparing it to the Theory
		Iterator<Point> it = actual.iterator();
		while (it.hasNext()) {
			Point line = it.next();
			chiSq += Math.pow(line.getY()-theory.y(line.getX()),2)/Math.pow(line.getEy(),2);
		}
		
		return chiSq;
	}
}

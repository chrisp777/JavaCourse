package module6;

import java.util.Collection;

import module6.TestDataPoints.Point;

// GoodnessOfFitCalculator interface that only requires one method
public interface GoodnessOfFitCalculator {
	// GoodnessOfFit method which takes a collection of points which is the measured data and then a theory to test
	double goodnessOfFit(Collection<Point> actual, Theory theory);
	
}

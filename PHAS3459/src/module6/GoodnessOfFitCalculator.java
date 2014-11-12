package module6;

import java.util.Collection;

import module6.TestDataPoints.Point;

public interface GoodnessOfFitCalculator {
	double goodnessOfFit(Collection<Point> actual, Theory theory);
	
}

package module6;

import java.util.Collection;

public interface GoodnessOfFitCalculator {
	public Theory bestTheory();
	double goodnessOfFit(Collection<DataPoint> actual, Theory theory);
	
}

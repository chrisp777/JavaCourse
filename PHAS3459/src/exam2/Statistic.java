package exam2;

import java.util.ArrayList;
/**
 * Interface for the Statistics that will be calculated using the tidal data
 * 
 * @author Chris Davenport
 * @see Mean, Range
 */
public interface Statistic {
	/**
	 * Method which will find the given statistic using the given data at the given site
	 * @param readings		The data which will be processed
	 * @param siteId		The site Id for which the stat is being found. I chose to include this
	 * 						value because all the statistics required by the program specification
	 * 						Required the stat to be per site, and so this is included in the lowest
	 * 						common input.
	 * @return				Returns a double, which will hold the stats value
	 */
	double calculate(ArrayList<Tide> readings, String siteId);

}

package exam2;

import java.util.ArrayList;
/**
 * Class which calculates the mean for a given data set, implements the Statistic interface
 * 
 * @author Chris Davenport
 * @see Statistic
 */
public class Mean implements Statistic {

	/**
	 * Returns the mean for a given data set in line with the Statistic interface
	 */
	@Override
	public double calculate(ArrayList<Tide> readings, String siteId) {
		// Initiate the variables and then loop over all the data.
		// If the id is correct then the mean required data is built up. 
		int count = 0 ;
		double sum = 0.0;
		for(Tide tide:readings){
			if(tide.getId().equals(siteId)){
				sum += tide.getLevel();
				count++;
			}
		}
		// Round to 3dp
		return Math.floor(((sum/count)*1000))/1000;
	}

}

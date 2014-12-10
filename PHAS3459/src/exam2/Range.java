package exam2;

import java.util.ArrayList;

/**
 * Class which calculates the Range for a given data set, implements the Statistic interface
 * 
 * @author Chris Davenport
 * @see Statistic
 */

public class Range implements Statistic {
	/**
	 * Calculates the tidal range at a given site id
	 * i.e. the difference between the highest and the lowest reading
	 */
	@Override
	public double calculate(ArrayList<Tide> readings, String siteId) {
		// Initiates variables and then loops over the data
		// if the current object has a large level it replaces the highest and similar for the lower
		// Once the highest and lowest has been found calculate the range
		Tide highestTide = new Tide(null, 0, 0, 0, 0, 0, 0, 0);
		Tide lowestTide = new Tide(null, 0, 0, 0, 0, 0, 999999, 0);
		for(Tide tide:readings){
			if(tide.getId().equals(siteId)){
				if(tide.getLevel()>highestTide.getLevel()){
					highestTide = tide;
				}
				if(tide.getLevel()<lowestTide.getLevel()){
					lowestTide = tide;
				}
			}
		}
		// returns the value rounded to 3dp
		return Math.floor((highestTide.getLevel()-lowestTide.getLevel())*1000)/1000;
	}

}

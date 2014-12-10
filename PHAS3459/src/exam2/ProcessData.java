package exam2;

import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * 
 * This class handles the processing of the tidal data. It will first load in the data and then procede
 * to find a number of values based on that data.
 * 
 * @author Chris Davenport
 * @see Tide Statistic Mean Range
 *
 */

public class ProcessData {
	
	// Sets up the ArrayList and HashMap that will be used to hold the tidal data
	// as well as the id + name for each location
	static ArrayList<Tide> tides = new ArrayList<>();
	static HashMap<String,String> sites = new HashMap<>();
	
	public static void main(String[] args) {
		// Load in the first batch of tidal data
		loadTides(1999);
		loadTides(2000);
		loadTides(2001);
		loadSites(); // Load in the first set of sites
		
		// Find the highest tide over all locations
		Tide highestTide = new Tide(null, 0, 0, 0, 0, 0, 0, 0);
		for(Tide tide:tides){
			if(tide.getLevel()>highestTide.getLevel()){
				highestTide = tide;
			}
		}
		
		// Print out the details of the highest tide observed in an location
		System.out.println("The highest observed level in the tide data was:");
		System.out.println("\t"+highestTide.getLevel()+" m in "+sites.get(highestTide.getId())+" : "+highestTide.getId());
		System.out.println("\tOn the date "+pad(highestTide.getDay())+"/"+pad(highestTide.getMonth())+"/"+pad(highestTide.getYear())+
				" at the time "+pad(highestTide.getHours())+":"+pad(highestTide.getMinutes())+"\n");
		
		// Find the mean and range for each location separately and print the details
		// This is rounded to three decimal places
		for(Map.Entry<String, String> cursor : sites.entrySet()) {
			Statistic mean = new Mean();
			Statistic range = new Range();
			System.out.println("For the site "+cursor.getValue()+" : "+cursor.getKey());
			System.out.println("\t"+"The mean is "+mean.calculate(tides, cursor.getKey())+"m (3dp)");
			System.out.println("\t"+"The range is "+range.calculate(tides, cursor.getKey())+"m (3dp)\n");
			
		}
		
		// Find the highest surge in the tidal data and print out the details
		// a surge is defined as the actual value - predicted level
		// This is rounded to three decimal places
		Tide highestSurge = findLargestSurge();
		double surge = Math.floor((highestSurge.getLevel()-highestSurge.getPredictedLevel())*1000)/1000;
		System.out.println("The highest observed surge in the tide data was:");
		System.out.println("\t"+surge+" m (3dp) in "+sites.get(highestSurge.getId())+" : "+highestSurge.getId());
		System.out.println("\tOn the date "+pad(highestSurge.getDay())+"/"+pad(highestSurge.getMonth())+"/"+pad(highestSurge.getYear())+
				" at the time "+pad(highestSurge.getHours())+":"+pad(highestSurge.getMinutes())+"\n");
		
		// Alert the user that the data is now going to change to part3 data
		System.out.println("\n\t*****PART3*****\n");
		System.out.println("Loading new data...");
		System.out.println("Loading new sites..."+"\n");
		
		// Reset the tides ArrayList
		tides = new ArrayList<>();
		// Load in the additional sites to the hashmap, these are ADDED to the sites already present
		loadAdditionalSites();
		loadTides(2004);
		loadTides(2005);
		loadTides(2006);
		
		// Again find the highest surge as above just with different data
		highestSurge = findLargestSurge();
		surge = Math.floor((highestSurge.getLevel()-highestSurge.getPredictedLevel())*1000)/1000;
		System.out.println("The highest observed surge in the tide data was:");
		System.out.println("\t"+surge+" m (3dp) in "+sites.get(highestSurge.getId())+" : "+highestSurge.getId());
		System.out.println("\tOn the date "+pad(highestSurge.getDay())+"/"+pad(highestSurge.getMonth())+"/"+pad(highestSurge.getYear())+
				" at the time "+pad(highestSurge.getHours())+":"+pad(highestSurge.getMinutes())+"\n");
		
	}
		
	/**
	 * Creates a buffered reader from a URL object which can then be used to load in data.
	 * 
	 * @param url	A URL object containing the web address from which the buffered reader can be created
	 * @return 		The buffered reader object that can be used in other methods to load in data
	 * @throws		Throws a IOException
	 */	
	
	public static BufferedReader loadStreamUrl(URL url) throws IOException{
			InputStream is = url.openStream();			
			InputStreamReader isr = new InputStreamReader(is);
			return new BufferedReader(isr);
	}
	
	/**
	 * Loads in the tides data processing it into the containers that will be used through the processing.
	 * Note that this does not return a collection only fills one already in the class
	 * 
	 * @param year			An int object that is used to locate the file and also tell which order the data is in within the file
	 */	
	
	public static void loadTides(int year){
		// Initate the stream variable
		BufferedReader stream = null;
		// Try and form a URL object and load the data from it
		try {
			// Slightly different file paths
			if(year<2004){
				stream = loadStreamUrl(new URL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-"+year+".txt"));
			}
			else {
				stream = loadStreamUrl(new URL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-"+year+".txt"));
			}

		} catch (IOException e) {
			// Handle the error if the file cannot be read from, no point continuing if there is no data so quit
			System.out.println("ERROR: "+year+" tide file could not be found or connection issues.");
			System.exit(1);
		}
		
		// Set up a scanner with a conditional statement which handles the data being in slightly different formats
		Scanner lines = new Scanner(stream);
		// If year < 2004 format is id, year, month, day, hour, minutes, level,predicted level
		if(year < 2004) {
			while(lines.hasNextLine()){
				String[] parts = lines.nextLine().split("\\s+");
				// Add each line to the tides ArrayList Object
				tides.add(new Tide(parts[0],
						Integer.parseInt(parts[1]),
						Integer.parseInt(parts[2]),
						Integer.parseInt(parts[3]),
						Integer.parseInt(parts[4]),
						Integer.parseInt(parts[5]),
						Double.parseDouble(parts[6]),
						Double.parseDouble(parts[7])));
				
			}
		}
		// PART3 ADDITION
		// If year > 2004 format is year, month, day, hour, minutes, id, level, predicted level
		else {
			while(lines.hasNextLine()){
				String[] parts = lines.nextLine().split("\\s+");
				// Add each line to the tides ArrayList Object

				tides.add(new Tide(parts[5],
						Integer.parseInt(parts[0]),
						Integer.parseInt(parts[1]),
						Integer.parseInt(parts[2]),
						Integer.parseInt(parts[3]),
						Integer.parseInt(parts[4]),
						Double.parseDouble(parts[6]),
						Double.parseDouble(parts[7])));
			}
			
		}
		// Close the stream/scanner
		lines.close();

	}
	/**
	 * Loads in the sites data processing it into the containers that will be used through the processing.
	 * Note that this does not return a collection only fills one already in the class
	 */	
	
	public static void loadSites(){
		// Initate the stream variable
		BufferedReader stream = null;
		// Try and form a URL object and pass it to the loader which returns the web stream
		try {
			 stream = loadStreamUrl(new URL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/sites.txt"));

		} catch (IOException e) {
			// Handle the error if the file cannot be read from, no point continuing if there is no data so quit
			System.out.println("ERROR: sites file could not be found or connection issues.");
			System.exit(1);
		}
		
		// Start a new scanner and skip the first line to miss the headers
		Scanner lines = new Scanner(stream);
		lines.nextLine();
		while(lines.hasNextLine()){
			// Add each location to the hashmap so that the id can be looked up giving the name
			String[] parts = lines.nextLine().split("\\s+");
			// note the order in which the data is given in the file
			sites.put(parts[1],parts[0]);
			
		}
		// Close the scanner/stream
		lines.close();
	}
	
	/**
	 * Loads in the additional sites data processing it into the containers that will be used through the processing.
	 * Note that this does not return a collection only fills one already in the class
	 */
	public static void loadAdditionalSites(){
		// PART3 ADDITIONS
		// Same method as above just with a different file
		// Different methods are used to highlight the fact that one has to be done before the other for correct 
		// running of the first two parts of the code specification. However the url could be passed to the method
		// above with little modification to reduce code length
		BufferedReader stream = null;
		try {
			 stream = loadStreamUrl(new URL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/sites.txt"));

		} catch (IOException e) {
			System.out.println("ERROR:  Additional sites file could not be found or connection issues.");
		}
		
		Scanner lines = new Scanner(stream);
		lines.nextLine();
		while(lines.hasNextLine()){
			String[] parts = lines.nextLine().split("\\s+");
			sites.put(parts[1],parts[0]);
			
		}
		lines.close();
	}
	
	/**
	 * Method which find the largest surge in the tides ArrayList and returns it.
	 * The surge is defined as actual level - predicted level 
	 * 
	 * @return Returns a Tide object with the largest surge
	 */
	public static Tide findLargestSurge(){
		Tide highestSurge = new Tide(null, 0, 0, 0, 0, 0, 0, 0);
		for(Tide tide:tides){
			if((tide.getLevel()-tide.getPredictedLevel())>(highestSurge.getLevel()-highestSurge.getPredictedLevel())) {
				highestSurge = tide;
			}
		}
		return highestSurge;
	}
	/**
	 * Small method which pads an int with zeros so that the 'width' of the int is 2
	 * @param num		the number to pad
	 * @return 			the string to be printed
	 */
	public static String pad(int num){
		return String.format("%02d", num);
	}
}

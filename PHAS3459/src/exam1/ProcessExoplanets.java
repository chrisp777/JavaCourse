package exam1;

// Import some useful classes
import java.util.*;
import java.io.*;
import java.net.URL;


public class ProcessExoplanets {

	public static void main(String[] args) {
		// Set up empty arraylist to be filled with all the exoplanets
		ArrayList<Exoplanet> planets = new ArrayList<Exoplanet>();
		// try and load Planets from the url using the method loadPlanets.
		// Url is hard coded into this method and so the only reason for an IO exception is a connection issue
		try {
			planets = loadPlanets();
		}
		catch (IOException e) 
		{
			// Inform the user of the error and stop the program from running any further as there is nothing to do
			// if there is no planet data to process!
			System.out.println("ERROR: IO Problem loading the planetary data. Check your internet connection.");
			System.exit(1);
		}
		
		// Try and find and print the closest exoplanet to Earth
		try {
			System.out.println("The closest exoplanet to Earth is: \n"+findClosestPlanet(planets)+"\n");
		} catch (Exception e) {
			// No exceptions are expected here as the method has few ways it could throw one, included for completeness
			System.out.println("ERROR: There was a problem when finding the closest exoplanet to earth.");
		}
		
		// Find all the methods used in the data and then for each print the number of planets discovered 
		// using that method the earliest year that a planet was discovered using that method and the full details of
		// the lightest planet discovered with that method.
		try {
			// empty array list of string for the list of methods used
			ArrayList<String> methods = new ArrayList<String>();
			// Find all the methods in the data file and tell the user what they are
			System.out.println("The planets associated with each method will now be investigated.\nThe methods used are: ");
			for(Exoplanet planet : planets) {
				// If the method has not been added to the methods list before add it
				if (!methods.contains(planet.getMethod())) {
					methods.add(planet.getMethod());
					System.out.println("\t"+planet.getMethod());
				}
			}
			// Give the stats on each method in the methods list
			for(String method : methods) {
				System.out.println("\nFor the method: "+method);
				System.out.println("There are "+methodCount(planets,method)+" planets discovered.");
				System.out.println("The ealiest planet discovered using this method is in "+earliestYear(planets,method));
				System.out.println("The lighest planet using this method is \n"+lightestPlanet(planets,method));
			}
			
		}
		catch (Exception e) {
			// Again no exceptions are likely to be found this is included for completeness.
			System.out.println("ERROR: There was a problem while finding the planets assosicated with the different methods.");
		}		
	}
	
	
	// Method which loads all the planet data into the array list of planets
	private static ArrayList<Exoplanet> loadPlanets() throws IOException {
		ArrayList<Exoplanet> planets = new ArrayList<Exoplanet>();
		
		// URL doesn't need to be user changable which means the exceptions are cut down.
		URL planetsFile = new URL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/exoplanets.txt");
		
		// Create new input stream, readers, buffers, and scanners for the data file
		InputStream is = planetsFile.openStream();			
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader reader = new BufferedReader(isr);
		Scanner lines = new Scanner(reader);
		
		// Skip the column headings
		lines.nextLine(); 
		
		// Loop through the file
		while(lines.hasNextLine()){
			// Split each line into parts delaminated by a comma
			String[] parts = lines.nextLine().split(",");
			// Try and add a new planet to the arraylist with the data from the file
			try {
			Exoplanet planet = new Exoplanet(
					parts[0],//string
					Integer.parseInt(parts[1]),//int
					parts[2],//string
					Double.parseDouble(parts[3]),//double
					Double.parseDouble(parts[4]),//double
					Double.parseDouble(parts[5]));//double
			planets.add(planet);
			}
			catch (ArrayIndexOutOfBoundsException e) {
				// Catches when parts[5] doesn't exist as some data is missing therefore
				// the planet doesn't have complete data, assume this is the distance data
				// as format of data is known.
				Exoplanet planet = new Exoplanet(
						parts[0],//string
						Integer.parseInt(parts[1]),//int
						parts[2],//string
						Double.parseDouble(parts[3]),//double
						Double.parseDouble(parts[4]),//double
						0.0);
						//zero is clearly unreasonable and so is an easy way of showing that this data is unknown.
				planets.add(planet); // Add the modified planet data
			}
		}
		// Close the streams.
		lines.close();
		// Returns the list of planets from the data file.
		return planets;
	}
	
	// Method which returns the closest exoplanet to earth 
	private static Exoplanet findClosestPlanet(ArrayList<Exoplanet> planets) {
		Exoplanet closest = new Exoplanet(null, 0, null, 0, 0, 0); //null blank planet
		
		// Sort the planets by distance so the closest planet is closer to the start of the list
		Collections.sort(planets,new Comparator<Exoplanet>() {
			public int compare(Exoplanet p1, Exoplanet p2){
				Double dist1 = p1.getDist();
				Double dist2 = p2.getDist();
				return dist1.compareTo(dist2);
			}
		});
		
		// Remember that the planets which have no distance data have been given a distance of 0.0
		// so we find first non 0 distance in arraylist as this is the closest planet with distance data.
		// Loop through all planets
		for(Exoplanet planet : planets) {
			// If planets distance is NOT equal to 0
			if (planet.getDist()!=0.0) {closest = planet;
			// Once found the loop needs to stop so only the first is seen.
			break;
			}
		}
		return closest;	
	}
	
	// Method that counts the number of planets that have been discovered using each method in the methods list
	private static double methodCount(ArrayList<Exoplanet> planets, String method) {
		// initate a count variable and reset it if the method has been called before
		int count = 0;
		// Loop through all planets
		for(Exoplanet planet : planets) {
			// If the planets method is equal to the method which is being investigated
			if (planet.getMethod().equals(method)) {
				// Increment the count variable
				count +=1;
			}
		}
		return count;
	}
	
	// Method which returns the ealiest year when a planet was discovered using the method we are investigating
	private static int earliestYear(ArrayList<Exoplanet> planets, String method) {
		// Initate a blank ealiest int for the output
		int earliest = 0;
		// Sort the planets by year
		Collections.sort(planets,new Comparator<Exoplanet>() {
			public int compare(Exoplanet p1, Exoplanet p2){
				Integer year1 = p1.getYear();
				Integer year2 = p2.getYear();
				return year1.compareTo(year2);
			}
		});
		// Loop through the planets again
		for(Exoplanet planet : planets) {
			// If the planets method is equal to the method we are looking at set the earliest variable
			if (planet.getMethod().equals(method)) {earliest = planet.getYear();
			// Again we only want the first result from the loop and so we break
			break;
			}
		}
		return earliest;
	}
	
	// Method which returns the lightest planet found using the given method, all details returned
	private static Exoplanet lightestPlanet(ArrayList<Exoplanet> planets, String method) {
		// initate a null planet for the output
		Exoplanet lightest = new Exoplanet(null, 0, null, 0, 0, 0);
		// Sort the planets by mass
		Collections.sort(planets,new Comparator<Exoplanet>() {
			public int compare(Exoplanet p1, Exoplanet p2){
				Double mass1 = p1.getMass();
				Double mass2 = p2.getMass();
				return mass1.compareTo(mass2);
			}
		});
		// Loop through the planets and again only return the first planet from the sorted list as this is the lightest.
		for(Exoplanet planet : planets) {
			if (planet.getMethod().equals(method)) {lightest = planet;
			break;
			}
		}
		return lightest;
	}
}
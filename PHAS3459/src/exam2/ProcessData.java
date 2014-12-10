package exam2;

import java.io.*;
import java.net.URL;
import java.util.*;

public class ProcessData {
	static ArrayList<Object> data = new ArrayList<>();
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * Creates a buffered reader from a URL object which can then be used to load in data.
	 * 
	 * @param url			A URL object containing the web address from which the buffered reader can be created
	 * @return 			 	The buffered reader object that can be used in other methods to load in data
	 */	
	
	public static BufferedReader loadStreamUrl(URL url) throws IOException{
			InputStream is = url.openStream();			
			InputStreamReader isr = new InputStreamReader(is);
			return new BufferedReader(isr);
	}
	
	/**
	 * Loads in the data processing it into the containers that will be used through the processing.
	 * Note that this does not return a collection only fills one already in the class
	 */	
	
	public static void loadSpecies(String type){
		BufferedReader stream = null;
		try {
			 stream = loadStreamUrl(new URL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/species-animals.txt"));

		} catch (IOException e) {
			System.out.println("ERROR: Animal species file could not be found or connection issues.");
		}
		
		Scanner lines = new Scanner(stream);
		while(lines.hasNextLine()){
			String[] parts = lines.nextLine().split("\\s+");
			ASpecies.put(parts[0], parts[1]+" "+parts[2]);
			
		}
		lines.close();

	}
}

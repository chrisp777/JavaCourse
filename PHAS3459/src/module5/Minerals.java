package module5;

import java.io.*;
import java.net.*;
import java.util.*;

public class Minerals {
	
	public static void main(String[] args) throws Exception {
		processSampleFile(loadLocationsFromFile());
	}
	
	public static HashMap<Integer, String> loadLocationsFromFile() throws IOException {
		HashMap<Integer, String> locations =
				new HashMap<Integer, String>();
		
		URL originsFile = new URL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt");
		
		InputStream originsIs = originsFile.openStream();			
		InputStreamReader originsIsr = new InputStreamReader(originsIs);
		BufferedReader originsReader = new BufferedReader(originsIsr);
		Scanner lines = new Scanner(originsReader);
		
		while(lines.hasNextLine()){
			String[] parts = lines.nextLine().split("\\s+");
			locations.put(Integer.parseInt(parts[1]),parts[0]);			
		}	
			
		return locations;
	}
	
	public static void processSampleFile(HashMap<Integer, String> locations) throws IOException {
		String location;
		double highMass = 0;
		String highLocation = "";
		int highCode = 0; 
		double lowMass = 1000000000;
		String lowLocation = "";
		int lowCode = 0; 
	
		URL samplesFile = new URL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt");
		
		InputStream samplesIs = samplesFile.openStream();			
		InputStreamReader samplesIsr = new InputStreamReader(samplesIs);
		BufferedReader samplesReader = new BufferedReader(samplesIsr);
		Scanner lines = new Scanner(samplesReader);
		while(lines.hasNextLine()){
			String[] parts = lines.nextLine().split("\\s+");
			int codeNumber = Integer.parseInt(parts[0]);
			double mass = Double.parseDouble(parts[1]);
			if (locations.containsKey(Integer.parseInt(parts[0]))){
				location = (String) locations.get(Integer.parseInt(parts[0]));
			}
			else {
				location = "UNKOWN LOCATION";
			}
			//System.out.println("Sample number "+codeNumber+" of mass: "+mass+"g, was found at: "+location);
			if(highMass<mass){highMass = mass;highLocation=location;highCode=codeNumber;}
			if(lowMass>mass){lowMass = mass;lowLocation=location;lowCode=codeNumber;}
		}
		System.out.println("The heaviest sample was number "+highCode+" of mass: "+highMass+"g, was found at: "+highLocation);
		System.out.println("The lightest sample was number "+lowCode+" of mass: "+lowMass+"g, was found at: "+lowLocation);
	}

}

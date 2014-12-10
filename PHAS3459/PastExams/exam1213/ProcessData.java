package exam1213;

import java.io.*;
import java.net.URL;
import java.util.*;

public class ProcessData {
	
	static ArrayList<Event> background = new ArrayList<>();
	static ArrayList<Higgs> higgs = new ArrayList<>();
	
	public static void main(String[] args) {
		loadBackgroundEvents();
		System.out.println("Expected GG: "+expectedBackgroundEvents(120,140,"GG"));
		System.out.println("Expected ZZ: "+expectedBackgroundEvents(120,140,"ZZ"));
		loadHiggs();
		System.out.println("Actual GG: "+higgsCandidates(120,240,"GG"));
		System.out.println("Actual ZZ: "+higgsCandidates(120,240,"ZZ"));
		
		System.out.println("LL GG: "+logLikelihood("GG"));
		System.out.println("LL ZZ: "+logLikelihood("ZZ"));
		/*for(Higgs higg:higgs){
			System.out.println(higg.getChannel()+", "+higg.getEnergy());
		}*/
		
		
		
		
	}
	
	/**
	 * Creates a buffered reader from a url object which can then be used to load in data.
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
	
	public static void loadBackgroundEvents(){
		BufferedReader stream = null;
		try {
			 stream = loadStreamUrl(new URL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundGG.txt"));

		} catch (IOException e) {
			System.out.println("ERROR: Background GG file could not be found or connection issues.");
		}
		
		Scanner lines = new Scanner(stream);
		lines.nextLine();
		while(lines.hasNextLine()){
			String[] parts = lines.nextLine().split("\\s+");
			background.add(new Event("GG", Double.parseDouble(parts[0]),Double.parseDouble(parts[1]),Double.parseDouble(parts[2])));
			
		}
		lines.close();
		stream = null;
		try {
			 stream = loadStreamUrl(new URL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundZZ.txt"));

		} catch (IOException e) {
			System.out.println("ERROR: Background ZZ file could not be found or connection issues.");
		}
		
		lines = new Scanner(stream);
		lines.nextLine();
		while(lines.hasNextLine()){
			String[] parts = lines.nextLine().split("\\s+");
			background.add(new Event("ZZ", Double.parseDouble(parts[0]),Double.parseDouble(parts[1]),Double.parseDouble(parts[2])));
			
		}
		lines.close();
	}
	
	/**
	 * Loads in the higgs data processing it into the containers that will be used through the processing.
	 * Note that this does not return a collection only fills one already in the class
	 */	
	
	public static void loadHiggs(){
		BufferedReader stream = null;
		try {
			 stream = loadStreamUrl(new URL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/higgsData.txt"));

		} catch (IOException e) {
			System.out.println("ERROR: Higgs file could not be found or connection issues.");
		}
		
		Scanner lines = new Scanner(stream);
		lines.nextLine();
		while(lines.hasNextLine()){
			String[] parts = lines.nextLine().split("\\s+");
			higgs.add(new Higgs(parts[0], Double.parseDouble(parts[1])));
			
		}
		lines.close();
	}
	
	
	/** 
	 * 
	 */
	public static int expectedBackgroundEvents(double min, double max, String channel) {
		int count = 0;
		for(Event event:background){
			if(event.getChannel().equals(channel)&& event.getMin()>min && event.getMax()<max) {
				count += event.getExpected();
			}
		}
		return count;
	}
	
	/**
	 * 
	 */
	public static int higgsCandidates(double min, double max, String channel){
		int count = 0;
		for(Higgs higg:higgs){
			if(higg.getChannel().equals(channel)&&higg.getEnergy()>min&&higg.getEnergy()<max){
				count++;
			}
		}
		return count;		
	}
	
	/**
	 * 
	 */
	public static double logLikelihood(String channel) {
		double sum = 0.0;
		for(Event event:background){
			double expected = higgsCandidates(event.getMin(),event.getMax(),channel);
			if(expected!=0.0){
				sum += (event.getExpected()-expected)+expected*Math.log(expected/event.getExpected());
			}
		}
		return sum;
	}
}

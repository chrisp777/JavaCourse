package module5;
import module5.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class DataAnalysis {
	
	public static void main(String[] args) throws IOException {
		//System.out.println(dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt"));
		System.out.println("The X2 (chi squared) for y = x2 ");
		System.out.println(goodnessOfFit(new Theory(2),dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt")));
		System.out.println("The X2 (chi squared) for y = x4 ");
		System.out.println(goodnessOfFit(new Theory(4),dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt")));
		System.out.println("The x2 fit is therefore better!");
	}

	public static ArrayList<DataPoint> dataFromURL(String url) {
		// Try and form a URL object from a url 
		URL file = null;
		ArrayList<DataPoint> data = new ArrayList<DataPoint>();
		try {
			file = new URL(url);
			} 
		catch (MalformedURLException e) {
			// URL isn't in a valid format
			System.out.println("ERROR: The url isn't in a corect form.");
		}
		
		try {
			InputStream is = file.openStream();			
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			Scanner lines = new Scanner(reader);
			
			while(lines.hasNextLine()){
				String[] parts = lines.nextLine().split("\\s+");
				data.add(new DataPoint(
						Double.parseDouble(parts[0]),
						Double.parseDouble(parts[1]),
						Double.parseDouble(parts[2])));
				
			}			
		} 
		// Catch all the IOExceptions that can arise when reading and writing from and to the files.
		catch (IOException e) {
			System.out.println("ERROR:"+e.getMessage());
		}
		return data;
	}
	
	public static double goodnessOfFit(Theory theory, ArrayList<DataPoint> actual) {
		double chiSq = 0.0;
		Iterator<DataPoint> it = actual.iterator();
		while (it.hasNext()) {
			DataPoint line = it.next();
			chiSq += Math.pow(line.getY()-theory.y(line.getX()),2)/Math.pow(line.getEy(),2);
		}
		
		return chiSq;
	}

}

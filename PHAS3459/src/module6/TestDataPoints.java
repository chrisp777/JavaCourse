package module6;

import java.io.*;
import java.net.*;
import java.util.*;

import module6.DataPoint;

public class TestDataPoints {
		
		// Empty interface to allow us to use an ArrayList with both DataPoint and LabelledDataPoint (THESE IMPLEMENT POINT)
		// This could also be achieved with a arrayList of Object type, however with the interface the code is more expendable
		// I know this is the inheritance section not the Interface section but i believe this is the best solution.
		public interface Point {
			double getX();
			double getY();
			double getEy();
		}
	
		public static void main(String[] args) {
			ArrayList<Point> data = new ArrayList<Point>(dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt"));
			for (Point dataPoint : data ) {
				System.out.println(dataPoint);				
			}
		}
		
		// Method which loads the data from a URL
		public static ArrayList<Point> dataFromURL(String url) {
			// Try and form a URL object from a URL 
			URL file = null;
			ArrayList<Point> data = new ArrayList<Point>();
			// Catch any URL exceptions
			try {
				file = new URL(url);
				} 
			catch (MalformedURLException e) {
				// URL isn't in a valid format
				System.out.println("ERROR: The url isn't in a corect form.");
			}
			
			// Try and load the data and catch any IO exceptions
			try {
				InputStream is = file.openStream();			
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader reader = new BufferedReader(isr);
				Scanner lines = new Scanner(reader);
				
				// Loop through the data splitting the line to get each separate parts, use \\s+ as any length whitespace
				while(lines.hasNextLine()){
					String[] parts = lines.nextLine().split("\\s+");
					if (parts.length == 3) {
						data.add(new DataPoint(
								Double.parseDouble(parts[0]),
								Double.parseDouble(parts[1]),
								Double.parseDouble(parts[2])));
					}
					else {
						data.add(new LabelledDataPoint(
								Double.parseDouble(parts[0]),
								Double.parseDouble(parts[1]),
								Double.parseDouble(parts[2]),
								parts[3]));
					}
				}
				//Close streams
				lines.close();
			} 
			// Catch all the IOExceptions that can arise when reading and writing from and to the files.
			catch (IOException e) {
				System.out.println("ERROR:"+e.getMessage());
			}
			return data;
		}
}

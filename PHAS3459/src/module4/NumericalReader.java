package module4;
import java.io.*;
import java.net.*;

public class NumericalReader {
	// Initalize the variables that will hold the calculated number
	private double minValue;
	private double maxValue;
	private int nValues;
	private double sumOfValues;
	private PrintWriter pw;
	
	// Change this variable to relocate the output file. NB the escape slashes
	File outputfile = new File("N:\\Eclipse\\Files\\numbers.txt");

	public static void main(String[] args) {
		// Initalize a few more variables that dont need global scope
		NumericalReader nr = new NumericalReader();
		BufferedReader reader;
		URL url = null;
		String line = "";
		
		// Try and form a URL object from a url (Not strictly nessecary as a correct url is supplied)
		try {
			// Two test URLs
			url = new URL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
			//url = new URL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
		} 
		catch (MalformedURLException e) {
			// URL isn't in a valid format
			System.out.println("ERROR: The url isn't in a corect form.");
		}
		
		// Try and read in the file from the URL or from a local location and start the analysis
		try {
			reader = brFromURL(url);
			//BufferedReader reader = brFromFile("N:\\Eclipse\\Files\\numbers.txt");
			nr.analysisStart(); // Initialise minValue etc.
			
			// While there is lines left in the file, run the analysis
			while ((line = reader.readLine()) != null) { 
				nr.analyseData(line); // Analyse lines, check for comments etc.
			}
		} 
		// Catch all the IOExceptions that can arise when reading and writing from and to the files.
		catch (IOException e) {
			System.out.println("ERROR:"+e.getMessage());
		}
		
		nr.analysisEnd(); // print min, max, etc. and close the file stream
		
	}
	
	// Method to open a new buffered reader object from a URL, returns a buffered reader from an input stream
	static private BufferedReader brFromURL(URL webAddress) throws IOException {
		InputStream is = webAddress.openStream();			
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);
	}
	
	// Method to open a new buffered reader object from a file, returns a buffered reader
	static private BufferedReader brFromFile(String path) throws IOException { 
		FileReader fr = new FileReader(path);
		return new BufferedReader(fr);
	}
	
	// Function that prepares to analyse the file supplied
	private void analysisStart() throws IOException {
		// An random large value is supplied for the minValue so that the file will almost certainly contain a lower value
		// Similarly the maxValue is started at 0 which assumes all values aren't -ve
		minValue = 1000000;
		maxValue = 0;
		nValues = 0;
		sumOfValues = 0;
		
		// Prepare the file that will be written out to
		FileWriter fw = new FileWriter(outputfile);
		BufferedWriter b = new BufferedWriter(fw);
		pw = new PrintWriter(b);
	}
	
	// Method that is run on each line of the data file dealing with them if they aren't blank and arn't a comment
	private void analyseData(String s) {
		if(s == null || s.trim().equals("")) {
			// String is blank
		}
		else if(s.trim().indexOf("c")==0||s.trim().indexOf("x")==0){
			// String is comment
		}
		else {
			// Deal with line
			// Splits the line into each whitespaced chunk
			String[] parts = s.split("\\s+");
			// Loops through the chunks
			for(int i=0; i<parts.length;i++) {
				// For each part check if number
				double d = 0.0;
				  try  
				  {  
					// If the 'word' is a number then we print it to file and update the running variables
				    d = Double.parseDouble(parts[i]);
				    
				    // String part is number
				    pw.println(d);
				    if (d < minValue) {minValue = d;}
				    if (d > maxValue) {maxValue = d;}
				    nValues++;
				    sumOfValues += d;
				    System.out.println(d);
				    
				  }  
				  catch(NumberFormatException nfe) {
					  // Go to the next loop if the word isn't a number
					  continue;
				  }
			}
			
		}
		
	}
	
	// Finish the file off with the calculated variables as well as print out some useful 
	// information for the users. 
	private void analysisEnd() {
		// Output the min max average and the number of values to the console as well as the location of the output file.
		System.out.println("\n"+"Min value: "+minValue);
		System.out.println("Max value: "+maxValue);
		System.out.println("Average value: "+sumOfValues/nValues);
		System.out.println("Number of values: "+nValues);
		System.out.println("\n"+"File written to "+outputfile);
		
		// Print out the variables that were calculated to file as comments so they can be read back in 
		// using the same methods that originally calculated them.
		pw.println("");
		pw.println("\n"+"c Min value: "+minValue);
		pw.println("c Max value: "+maxValue);
		pw.println("c Average value: "+sumOfValues/nValues);
		pw.println("c Number of values: "+nValues);
		pw.close();
	}
	
	
	
}

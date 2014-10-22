package module4;
import java.io.*;
import java.net.*;
import java.util.*;

public class NumericalReader {
	private double minValue;
	private double maxValue;
	private int nValues;
	private double sumOfValues;
	private PrintWriter pw;

	public static void main(String[] args) throws IOException {
		NumericalReader nr = new NumericalReader();
		URL url = new URL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
		BufferedReader reader = brFromURL(url);
		//BufferedReader reader = brFromFile("N:\\Eclipse\\Files\\numbers.txt");
		String line = "";
		nr.analysisStart(); // initialize minValue etc.
		while ((line = reader.readLine()) != null) { 
			nr.analyseData(line); // analyze lines, check for comments etc.
			
		}
		nr.analysisEnd(); // print min, max, etc.
		
	}
	
	static private BufferedReader brFromURL(URL webAddress) throws IOException {
		InputStream is = webAddress.openStream();			
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);
	}
	
	static private BufferedReader brFromFile(String path) throws IOException { 
		FileReader fr = new FileReader(path);
		return new BufferedReader(fr);
	}
	
	private void analysisStart() throws IOException {
		minValue = 1000000;
		maxValue = 0;
		nValues = 0;
		sumOfValues = 0;
		
		File outputfile = new File("N:\\Eclipse\\Files\\numbers.txt");
		FileWriter fw = new FileWriter(outputfile);
		BufferedWriter b = new BufferedWriter(fw);
		pw = new PrintWriter(b);
	}
	
	private void analyseData(String s) {
		if(s == null || s.trim().equals("")) {
			// String is blank
		}
		else if(s.trim().indexOf("c")==0||s.trim().indexOf("x")==0){
			// String is comment
		}
		else {
			// Deal with line
			String[] parts = s.split("\\s+");
			for(int i=0; i<parts.length;i++) {
				// For each part check if number
				double d = 0.0;
				  try  
				  {  
				    d = Double.parseDouble(parts[i]);
				    
				    // String part is number
				    pw.println(d);
				    if (d < minValue) {minValue = d;}
				    if (d > maxValue) {maxValue = d;}
				    nValues++;
				    sumOfValues += d;
				    
				  }  
				  catch(NumberFormatException nfe) {
					  continue;
				  }
				  System.out.println(d);  
			}
			
		}
		
	}
	
	private void analysisEnd() {
		System.out.println("\n"+"Min value: "+minValue);
		System.out.println("Max value: "+maxValue);
		System.out.println("Average value: "+sumOfValues/nValues);
		System.out.println("number of values: "+nValues);
		pw.close();
	}
	
	
	
}

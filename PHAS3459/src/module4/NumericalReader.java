package module4;
import java.io.*;
import java.net.*;
import java.util.*;

public class NumericalReader {
	private int minValue;
	private int maxValue;
	private int nValues;
	private int sumOfValues;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumericalReader nr = new NumericalReader();
		
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
		minValue = 0;
		maxValue = 100;
		nValues = 50;
		sumOfValues = 0;
		
		File outputfile = new File("N:\\mywork\\numbers.txt");
		FileWriter f = new FileWriter(outputfile);
		BufferedWriter b = new BufferedWriter(f);
		PrintWriter pw = new PrintWriter(b);
	}
	
	private void analysisEnd() {
		System.out.println(minValue);
		System.out.println(maxValue);
		System.out.println(sumOfValues/nValues);
		System.out.println(nValues);
	}
	
	
	
}

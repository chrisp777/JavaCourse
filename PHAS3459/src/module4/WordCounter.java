package module4;
import java.io.*;
import java.net.*;
import java.util.*;

public class WordCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countWordsInResource(getStringFromKeyboard()));
	}
	
	public static String getStringFromKeyboard() {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(r);
		System.out.println("Please enter the URL at which a file can be counted!");
		try {
			String s = b.readLine();
			return s;
		}
		catch (IOException e) {
			System.out.println("ERROR: "+e.getMessage());
			return null;
		}
		
	}
	
	public static int countWordsInResource(String urlName) {
		int sum = 0;	
		try {
			URL u = new URL(urlName);	
			InputStream is = u.openStream();			
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader b = new BufferedReader(isr);
			Scanner s = new Scanner(b);
			
			while (s.hasNext()) {
				String wordToken = s.next();
				if (wordToken instanceof String) {
					sum++;
				}
			}
			s.close();
			
		}
		catch (FileNotFoundException e1) {
			System.out.println("ERROR: File not found:"+e1.getMessage());
		} 
		catch (IOException e2) {
			System.out.println("ERROR: "+e2.getMessage());
		}
		return sum;
			
	}

}

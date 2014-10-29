package module4;
import java.io.*;
import java.net.*;
import java.util.*;

public class WordCounter {

	public static void main(String[] args) {
		// Call the countWordsInResource method with a string from the keyboard
		System.out.println(countWordsInResource(getStringFromKeyboard()));
	}
	
	// Method to get a string from the user and open the URL that they supplied
	public static String getStringFromKeyboard() {
		// Start the reader and the buffers through which the keyboard input will be accessed
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(r);
		// Ask the user for a URL
		System.out.println("Please enter the URL at which a file can be counted!");
		try {
			// Get the string inputed by the user and return it
			String s = b.readLine();
			return s;
		}
		catch (IOException e) {
			// Catches any exceptions arising from the user input
			System.out.println("ERROR: "+e.getMessage());
			return null;
		}
		
	}
	
	// Method to count the number of words in a given URL/file
	public static int countWordsInResource(String urlName) {
		// Init the sum variable which holds the number of wors
		int sum = 0;	
		try {
			// Open the URL supplied in the arguments in a buffered stream reader
			URL u = new URL(urlName);	
			InputStream is = u.openStream();			
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader b = new BufferedReader(isr);
			// init a new scanner to go through the file one work at a time
			Scanner s = new Scanner(b);
			
			// Loop through all the words checking to see if they are a valid string and add one to the sum
			while (s.hasNext()) {
				String wordToken = s.next();
				if (wordToken instanceof String) {
					sum++;
				}
			}
			// Close the URL file
			s.close();
			
		}
		// Catches and displays and errors that happen.
		// There this a specific file not found catch statment to better inform the user as to the error.
		catch (FileNotFoundException e1) {
			System.out.println("ERROR: File not found:"+e1.getMessage());
		} 
		catch (IOException e2) {
			System.out.println("ERROR: "+e2.getMessage());
		}
		// Return the number of words
		return sum;
			
	}

}

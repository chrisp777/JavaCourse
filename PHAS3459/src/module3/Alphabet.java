package module3;
// Import the relevant classes
import java.util.Random;
import java.lang.*;


public class Alphabet {
	public static void main(String[] args) {
		// Sets up the variable where the string will be built up
		StringBuilder outputString = new StringBuilder();
		int exception = 0; // Variable to count the exceptions
		int runningTotal = 0; // Variable to coun the running int total
		
		// For loop starting at 0 ad running until 1000 in steps of one
		for (int i=0;i<=1000;i++){
			// Gets a new random character from the random character method
			char rando = randomCharacter();
			// if character is a number or a letter
			if (Character.isLetter(rando)||Character.isDigit(rando)){
				// Catches the exception when trying to convert a letter to a number
				try {
					// Adds the number to a running total
					runningTotal = runningTotal + Integer.parseInt(Character.toString(rando));
				}
				catch (Exception e) {
					// Increments the exception variable
					exception = exception + 1;
				}
				// Build up the output string
				outputString.append(rando);	
				
			}
		}
		System.out.println("The string is: "+outputString.toString());
		System.out.println("The number of exceptions is: "+exception);
		System.out.println("The running total of all numbers is: "+runningTotal);
	}
	
	// Method which makes a new random character
	static char randomCharacter() {
		// Make a number Random object
		Random randomObject = new Random();
		// Get an integer 0-127 from the Random
		int randomNumber = randomObject.nextInt(128);
		// Convert the integer to a char
		char myChar = (char) randomNumber;
		// Return the char
		return myChar;		
	}
}

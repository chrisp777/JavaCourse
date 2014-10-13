package module3;
import java.util.Random;
import java.lang.*;


public class Alphabet {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder outputString = new StringBuilder();
		int exception = 0;
		int runningTotal = 0;
		
		for (int i=0;i<=1000;i++){
			char rando = randomCharacter();
			if (Character.isLetter(rando)||Character.isDigit(rando)){
				try {
					runningTotal = runningTotal + Integer.parseInt(Character.toString(rando));
				}
				catch (Exception e) {
					exception = exception + 1;
				}
				outputString.append(rando);	
				
			}
		}
		System.out.println("The string is: "+outputString.toString());
		System.out.println("The number of exceptions is: "+exception);
		System.out.println("The running total of all numbers is: "+runningTotal);
	}
	
	static char randomCharacter() {
		Random randomObject = new Random();
		int randomNumber = randomObject.nextInt(128);
		
		char myChar = (char) randomNumber;
		return myChar;		
	}
}

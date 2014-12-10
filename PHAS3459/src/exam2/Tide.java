package exam2;
/**
 * Object class and constructor which is used to hold the tidal data
 * 
 * @author Chris Davenport
 *
 */
public class Tide {
	// Set up the constructor variables
	// Note that a data and a time object could be used to store the date and time
	// however this has not been done to limit conversions between the data types and 
	// simplicity. If data/time related calculations needed to be done the data and time object would
	// be implemented to allow the use of more java api tools to handle such calculations
	private String id;
	private int year;
	private int month;
	private int day;
	private int hours;
	private int minutes;
	private double level;
	private double predictedLevel;

	// Tide constructor
	public Tide(String id, int year, int month, int day, int hours, int minutes, double level, double predictedLevel) {
		// Align variables
		this.id = id;
		this.year = year;
		this.month = month;
		this.day = day;
		this.hours = hours;
		this.minutes = minutes;
		this.level = level;
		this.predictedLevel = predictedLevel;
	}
	
	//Getters for the private variables
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * @return the level
	 */
	public double getLevel() {
		return level;
	}

	/**
	 * @return the predictedLevel
	 */
	public double getPredictedLevel() {
		return predictedLevel;
	}
	
	/**
	 * @return the string to be output
	 */
	// Note that this isn't used, it is just as a quick test to see if data has loaded correctly
	public String toString() {
		return id+" "+year+" "+day+" "+hours+" "+level+" "+predictedLevel;
	}
}

package exam1;

public class Exoplanet {
		// Set up the variables for the construct exoplanet
		private String name;
		private int year;
		private String method;
		private double mass;
		private double starSep;
		private double dist;
		
		// Exoplanet construct assigning the variables above. 
		// N.B. that the parameter name starts with capital
		// where as the variables above all start with a lowercase letter
		public Exoplanet(String Name, int Year, String Method, double Mass, double StarSep, double Dist) {
			name = Name;
			year = Year;
			method = Method;
			mass = Mass;
			starSep = StarSep;
			dist = Dist;
		}
		
		// Getters for values within the constructor
		// Distance getter
		public double getDist() {
			return dist;
		}
		
		// Method getter
		public String getMethod() {
			return method;
		}
		
		// Year getter
		public int getYear() {
			return year;
		}
		
		// Mass getter
		public double getMass() {
			return mass;
		}
		
		// To string method to instruct java on how to display the data available for each exoplanet so they can be clearly read
		public String toString() {
			// If the distance data is missing then the display needs to reflect this non phyical data
			String distString = "";
			if (dist == 0.0) {
				distString = "NO-DATA";
			}
			else {
				distString = Double.toString(dist);
			}
			
			// Return the constructed string with all the data from the exoplanet constructor
			return "\tName: "+name+"\n\tYear: "+year+"\n\tMethod: "+method+"\n\tMass: "+mass+
					"  (in Jupiter Masses)\n\tDistance from star: "+starSep+" (a.u.)\n\tDistance from Earth: "+distString+" (parsecs)\n";
		}
}

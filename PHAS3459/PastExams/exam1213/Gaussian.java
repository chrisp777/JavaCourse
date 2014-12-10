package exam1213;

import java.util.ArrayList;

public class Gaussian implements PredictHiggs{
	double normalisation;
	double mass;
	double width;
	
	public Gaussian(double normalisation, double mass, double width) {
		this.normalisation = normalisation;
		this.mass = mass;
		this.width = width;
		
	}
	
	public ArrayList<Higgs> predict(double mhStart, double mhEnd) {
		ArrayList<Event> output = new ArrayList<>();
		int i = start;
		while(i!=end) {
			double mhCurrent = mhStart;
			while(mhCurrent != mhEnd) {
				double expected = (normalisation/width*Math.sqrt(2*Math.PI))*Math.pow(Math.E, -(Math.pow((bin-mass),2)/(2*Math.pow(width,2))));
				output.add(new Event("PP", energy, energy, expected))
				mhCurrent++;
			}
		i++;
		}
		return null;
	}
	

}

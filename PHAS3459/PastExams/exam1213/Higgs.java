package exam1213;

public class Higgs {
	private String channel;
	private double energy;
	
	public Higgs(String channel, double energy) {
		this.channel = channel;
		this.energy = energy;
	}
	
	public String getChannel() {
		return channel;
	}
	
	public double getEnergy() {
		return energy;
	}
	public String toString() {
		return channel+": "+energy;
	}
}

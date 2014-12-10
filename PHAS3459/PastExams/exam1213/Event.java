package exam1213;

public class Event {
	private String channel;
	private double min;
	private double max;
	private double expected;
	
	public Event(String channel, double min, double max, double expected) {
		this.channel = channel;
		this.min = min;
		this.max = max;
		this.expected = expected;
	}
	
	public String getChannel() {
		return channel;
	}
	
	public double getMin() {
		return min;
	}
	
	public double getMax() {
		return max;
	}
	
	public double getExpected() {
		return expected;
	}
	public String toString() {
		return channel+": "+min+", "+max+", "+expected;
	}
}

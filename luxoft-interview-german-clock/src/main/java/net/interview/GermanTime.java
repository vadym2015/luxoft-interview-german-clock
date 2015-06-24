package net.interview;

public class GermanTime {
	private int fiveHours;
	private int singleHours;
	private int fiveMinutes;
	private int singleMinutes;
	private int seconds;
	private String time;

	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getFiveHours() {
		return fiveHours;
	}
	public void setFiveHours(int fiveHours) {
		this.fiveHours = fiveHours;
	}
	public int getSingleHours() {
		return singleHours;
	}
	public void setSingleHours(int singleHours) {
		this.singleHours = singleHours;
	}
	public int getFiveMinutes() {
		return fiveMinutes;
	}
	public void setFiveMinutes(int fiveMinutes) {
		this.fiveMinutes = fiveMinutes;
	}
	public int getSingleMinutes() {
		return singleMinutes;
	}
	public void setSingleMinutes(int singleMinutes) {
		this.singleMinutes = singleMinutes;
	}
	
	@Override
	public boolean equals(Object obj) {
		GermanTime germanTime = (GermanTime) obj;
		
		return (germanTime.getFiveHours() == getFiveHours() 
				&& germanTime.getSingleHours() == getSingleHours()
				&& germanTime.getFiveMinutes() == getFiveMinutes()
				&& germanTime.getSingleMinutes() == getSingleMinutes());
	}
}

package net.interview;

import org.joda.time.LocalTime;

/**
 * Utility class for german time sample
 * @author vadim
 *
 */
public final class GermanTimeUtil {

	/**
	 * First row
	 * @param hours
	 * @return	  
	 */
	protected static int getFiveHoursRow(int hours) {
		return hours / 5;
	}

	/**
	 * Second row
	 * @param hours
	 * @return	  
	 */
	protected static int getOneHoursRow(int hours) {
		return hours % 5;
	}

	/**
	 * Third row
	 * @param minutes
	 * @return	  
	 */
	protected static int getFiveMinutesRow(int minutes) {
		return minutes / 5;
	}

	/**
	 * Four row
	 * @param minutes
	 * @return	  
	 */
	protected static int getOneMinutesRow(int minutes) {
		return minutes % 5;
	}

	/**
	 * Assembled object
	 * @param time
	 * @return	  
	 */
	public static GermanTime getGermanTime(LocalTime time) {
		GermanTime germanTime = new GermanTime();
		germanTime.setFiveHours(getFiveHoursRow(time.getHourOfDay()));
		germanTime.setSingleHours(getOneHoursRow(time.getHourOfDay()));
		germanTime.setFiveMinutes(getFiveMinutesRow(time.getMinuteOfHour()));
		germanTime.setSingleMinutes(getOneMinutesRow(time.getMinuteOfHour()));
		germanTime.setSeconds(time.getSecondOfMinute());
		germanTime.setTime(time.toString());
		return germanTime;
	}
}

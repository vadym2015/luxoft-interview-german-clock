package net.interview;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;

public class TestData {

	public static void main(String[] args) {
		String time = LocalTime.now(DateTimeZone.forID("Europe/Kiev")).toString();
		System.out.println(time);
		}

}

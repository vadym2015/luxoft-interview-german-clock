package net.interview;

import static org.junit.Assert.*;

import org.joda.time.LocalTime;
import org.junit.Test;

public class GermanTimeUtilTest {

	//First row
	@Test
	public void getFiveHoursRow() {
		assertEquals(0, GermanTimeUtil.getFiveHoursRow(3));
		assertEquals(1, GermanTimeUtil.getFiveHoursRow(5));
		assertEquals(2, GermanTimeUtil.getFiveHoursRow(13));
		assertEquals(4, GermanTimeUtil.getFiveHoursRow(20));
	}

	//Second row
	@Test
	public void getOneHoursRow() {
		assertEquals(3, GermanTimeUtil.getOneHoursRow(3));
		assertEquals(0, GermanTimeUtil.getOneHoursRow(10));
		assertEquals(2, GermanTimeUtil.getOneHoursRow(12));
		assertEquals(4, GermanTimeUtil.getOneHoursRow(24));
	}

	//Third row
	@Test
	public void getFiveMinutesRow() {
		assertEquals(0, GermanTimeUtil.getFiveMinutesRow(3));
		assertEquals(2, GermanTimeUtil.getFiveMinutesRow(10));
		assertEquals(3, GermanTimeUtil.getFiveMinutesRow(16));
		assertEquals(11, GermanTimeUtil.getFiveMinutesRow(55));
	}

	//Four row
	@Test
	public void getOneMinutesRow() {
		assertEquals(3, GermanTimeUtil.getOneMinutesRow(3));
		assertEquals(0, GermanTimeUtil.getOneMinutesRow(10));
		assertEquals(1, GermanTimeUtil.getOneMinutesRow(16));
		assertEquals(0, GermanTimeUtil.getOneMinutesRow(55));
	}
	
	//Assembled object
	@Test
	public void getGermanTime() {
		LocalTime testTime =  new LocalTime(3, 3, 3);
		GermanTime testGermanTime = new GermanTime();
		testGermanTime.setFiveHours(0);
		testGermanTime.setSingleHours(3);
		testGermanTime.setFiveMinutes(0);
		testGermanTime.setSingleMinutes(3);
		testGermanTime.setSeconds(3);
		GermanTime germanTime = GermanTimeUtil.getGermanTime(testTime);
		assertEquals(testGermanTime, germanTime);

		testTime =  new LocalTime(23, 57, 33);
		testGermanTime = new GermanTime();
		testGermanTime.setFiveHours(4);
		testGermanTime.setSingleHours(3);
		testGermanTime.setFiveMinutes(11);
		testGermanTime.setSingleMinutes(2);
		testGermanTime.setSeconds(33);
		germanTime = GermanTimeUtil.getGermanTime(testTime);
		assertEquals(testGermanTime, germanTime);
}
}

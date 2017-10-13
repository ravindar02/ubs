package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestBerlinTimeConvertor {

	BerlinTimeConvertor berlinTimeConvertor = null;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void startClock() {
		berlinTimeConvertor = new BerlinTimeConvertor();
	}

	@Test
	public void testHour() {
		StringBuffer hoursString = new StringBuffer();
		berlinTimeConvertor.appendHoursRepresentation(hoursString, 23);
		assertEquals("RRRR\r\n" + "RRRO\r\n", hoursString.toString());
	}

	@Test
	public void testHourException() {
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Invalid Time");
		StringBuffer hoursString = new StringBuffer();
		berlinTimeConvertor.appendHoursRepresentation(hoursString, 29);

	}

}

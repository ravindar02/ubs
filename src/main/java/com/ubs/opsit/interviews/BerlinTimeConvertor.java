package com.ubs.opsit.interviews;

public class BerlinTimeConvertor implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		
/*		return "Y\r\n" + 
				"OOOO\r\n" + 
				"OOOO\r\n" + 
				"OOOOOOOOOOO\r\n" + 
				"OOOO"*/
		String[] times = aTime.split(":");
		int hours = Integer.parseInt(times[0]);
		int mins = Integer.parseInt(times[1]);
		int seconds = Integer.parseInt(times[2]);

		StringBuffer timeinBerlinClock = new StringBuffer();
		appendSecondsRepresentation(timeinBerlinClock, seconds);
		appendHoursRepresentation(timeinBerlinClock, hours);
		appendMinutesRepresentation(timeinBerlinClock, mins);

		return timeinBerlinClock.toString();
	}

	private void appendHoursRepresentation(StringBuffer timeinBerlinClock, int hours) {
		int remHour = hours % 5;
		int modHour = hours/5;
		
		for (int i = 0; i < 4; i++) {
			if(i < modHour) {
				timeinBerlinClock.append("R");
			}else {
				timeinBerlinClock.append("O");
			}
		}
		
		timeinBerlinClock.append("\r\n");
		
		for (int i = 0; i < 4; i++) {
			if(i < remHour) {
				timeinBerlinClock.append("R");
			}else {
				timeinBerlinClock.append("O");
			}
		}
		
		timeinBerlinClock.append("\r\n");
	}

	private void appendMinutesRepresentation(StringBuffer timeinBerlinClock, int mins) {
		int remMin = mins % 5;
		int modMin = mins/5;

		for (int i = 0; i < 11; i++) {
			if(i < modMin) {
				if(i==2 || i == 5 || i == 8) {
					timeinBerlinClock.append("R");
				}else {
					timeinBerlinClock.append("Y");
				}
			}else {
				timeinBerlinClock.append("O");
			}
		}
		timeinBerlinClock.append("\r\n");
		
		for (int i = 0; i < 4; i++) {
			if(i < remMin) {
				timeinBerlinClock.append("Y");
			}else {
				timeinBerlinClock.append("O");
			}
		}
		timeinBerlinClock.append("");
	}

	private void appendSecondsRepresentation(StringBuffer timeinBerlinClock, int seconds) {
		int mod = seconds % 2;
		timeinBerlinClock.append((mod > 0) ? "O\r\n" : "Y\r\n");
	}
}

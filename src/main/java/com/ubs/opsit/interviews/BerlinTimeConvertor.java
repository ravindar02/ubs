package com.ubs.opsit.interviews;

public class BerlinTimeConvertor implements TimeConverter {

	@Override
	public String convertTime(String aTime) {

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

	public void appendHoursRepresentation(StringBuffer timeinBerlinClock, int hours) {
		if(hours < 0 || hours > 24) {
			throw new RuntimeException("Invalid Time");
		}
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

	public void appendMinutesRepresentation(StringBuffer timeinBerlinClock, int mins) {
		if(mins < 0 || mins > 60) {
			throw new RuntimeException("Invalid Time");
		}
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

	public void appendSecondsRepresentation(StringBuffer timeinBerlinClock, int seconds) {
		if(seconds < 0 || seconds > 60) {
			throw new RuntimeException("Invalid Time");
		}
		int mod = seconds % 2;
		timeinBerlinClock.append((mod > 0) ? "O\r\n" : "Y\r\n");
	}
}

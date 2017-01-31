package com.tratif.ddd.domain.classes.timetable;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class ScheduledDate {

	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	
	@Deprecated // for jpa only
	ScheduledDate() {
	}
	
	public ScheduledDate(DayOfWeek dayOfWeek, LocalTime startTime) {
		this.dayOfWeek = dayOfWeek;
		this.startTime =startTime;
	}
	
	public DayOfWeek dayOfWeek() {
		return dayOfWeek;
	}
	
	public LocalTime startTime() {
		return startTime;
	}
}

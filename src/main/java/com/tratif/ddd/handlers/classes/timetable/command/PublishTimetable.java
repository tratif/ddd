package com.tratif.ddd.handlers.classes.timetable.command;

import java.time.LocalDate;


public class PublishTimetable {

	private Long timetableId;
	private LocalDate validFrom;
	private LocalDate validTo;
	
	public PublishTimetable(Long timetableId, LocalDate validFrom, LocalDate validTo) {
		this.timetableId = timetableId;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}
	
	public Long timetableId() {
		return timetableId;
	}
	
	public LocalDate validFrom() {
		return validFrom;
	}
	
	public LocalDate validTo() {
		return validTo;
	}
}

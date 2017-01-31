package com.tratif.ddd.handlers.classes.timetable.command;

import java.time.LocalDate;
import java.util.UUID;


public class PublishTimetable {

	private UUID timetableId;
	private LocalDate validFrom;
	private LocalDate validTo;
	
	public PublishTimetable(UUID timetableId, LocalDate validFrom, LocalDate validTo) {
		this.timetableId = timetableId;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}
	
	public UUID timetableId() {
		return timetableId;
	}
	
	public LocalDate validFrom() {
		return validFrom;
	}
	
	public LocalDate validTo() {
		return validTo;
	}
}

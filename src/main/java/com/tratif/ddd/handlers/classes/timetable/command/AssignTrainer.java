package com.tratif.ddd.handlers.classes.timetable.command;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

public class AssignTrainer {

	private UUID timetableId;
	private DayOfWeek dayOfWeek;
	private LocalTime classTime;
	private UUID trainerId;
	
	public AssignTrainer(UUID timetableId, DayOfWeek dayOfWeek, LocalTime classTime, UUID trainerId) {
		this.timetableId = timetableId;
		this.dayOfWeek = dayOfWeek;
		this.classTime = classTime;
		this.trainerId = trainerId;
	}
	
	public LocalTime classTime() {
		return classTime;
	}
	
	public DayOfWeek dayOfWeek() {
		return dayOfWeek;
	}
	
	public UUID timetableId() {
		return timetableId;
	}
	
	public UUID trainerId() {
		return trainerId;
	}
}

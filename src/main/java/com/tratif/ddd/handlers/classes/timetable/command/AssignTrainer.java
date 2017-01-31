package com.tratif.ddd.handlers.classes.timetable.command;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class AssignTrainer {

	private Long timetableId;
	private DayOfWeek dayOfWeek;
	private LocalTime classTime;
	private Long trainerId;
	
	public AssignTrainer(Long timetableId, DayOfWeek dayOfWeek, LocalTime classTime, Long trainerId) {
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
	
	public Long timetableId() {
		return timetableId;
	}
	
	public Long trainerId() {
		return trainerId;
	}
}

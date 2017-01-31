package com.tratif.ddd.handlers.classes.enrollment.command;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

import com.tratif.ddd.domain.classes.ClassType;


public class ScheduleClass {

	private ClassType classType;
	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	private Duration duration;

	
	public ScheduleClass(ClassType classType, DayOfWeek dayOfWeek, LocalTime startTime, Duration duration) {
		this.classType = classType;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.duration = duration;
	}
	
	public ClassType getClassType() {
		return classType;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}

	public Duration getDuration() {
		return duration;
	}

	public LocalTime getEndTime() {
		return startTime.plus(duration);
	}

	@Override
	public String toString() {
		return "ScheduleClass [classType=" + classType + ", dayOfWeek=" + dayOfWeek + ", startTime=" + startTime
				+ ", duration=" + duration + "]";
	}
}

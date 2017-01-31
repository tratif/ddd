package com.tratif.ddd.handlers.classes.timetable.events;

import java.time.LocalDateTime;

import com.tratif.ddd.DomainEvent;
import com.tratif.ddd.domain.classes.ClassType;

public class EnrollmentOpened extends DomainEvent {

	private ClassType classType;
	private LocalDateTime startTime;
	private Long trainerId;
	private int maxNumParticipants;
	
	public EnrollmentOpened(
			ClassType classType, LocalDateTime startTime, Long trainerId, int maxNumParticipants) {
		
		this.classType = classType;
		this.startTime = startTime;
		this.trainerId = trainerId;
		this.maxNumParticipants = maxNumParticipants;
	}
	
	public ClassType classType() {
		return classType;
	}
	
	public int maxNumParticipants() {
		return maxNumParticipants;
	}
	
	public LocalDateTime startTime() {
		return startTime;
	}
	
	public Long trainerId() {
		return trainerId;
	}
}

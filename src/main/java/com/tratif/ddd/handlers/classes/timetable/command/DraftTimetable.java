package com.tratif.ddd.handlers.classes.timetable.command;

import java.util.UUID;

import com.tratif.ddd.domain.classes.ClassType;

public class DraftTimetable {

	private UUID id;
	private ClassType classType;
	
	
	public DraftTimetable(UUID id, ClassType classType) {
		this.id = id;
		this.classType = classType;
	}
	
	public UUID id() {
		return id;
	}

	public ClassType classType() {
		return classType;
	}
}

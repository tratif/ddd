package com.tratif.ddd.handlers.classes.timetable.command;

import com.tratif.ddd.domain.classes.ClassType;

public class DraftTimetable {

	private ClassType classType;
	
	
	public DraftTimetable(ClassType classType) {
		this.classType = classType;
	}
	
	public ClassType classType() {
		return classType;
	}
}

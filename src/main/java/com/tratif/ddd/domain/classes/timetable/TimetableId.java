package com.tratif.ddd.domain.classes.timetable;

public class TimetableId {

	private Long value;
	
	@Deprecated
	TimetableId() {
	}
	
	public TimetableId(Long value) {
		this.value = value;
	}

	public Long value() {
		return value;
	}
}

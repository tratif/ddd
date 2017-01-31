package com.tratif.ddd.domain.classes.timetable;

public interface TimetableRepository {

	Timetable findById(Long timetableId);

	void save(Timetable timetable);

}

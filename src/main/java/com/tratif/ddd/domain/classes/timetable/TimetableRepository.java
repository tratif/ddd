package com.tratif.ddd.domain.classes.timetable;

import java.util.UUID;

public interface TimetableRepository {

	Timetable findById(UUID timetableId);

	void save(Timetable timetable);

}

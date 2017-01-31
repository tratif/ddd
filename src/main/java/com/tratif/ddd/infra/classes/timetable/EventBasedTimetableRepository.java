package com.tratif.ddd.infra.classes.timetable;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.tratif.ddd.domain.BasicRepository;
import com.tratif.ddd.domain.EventsStorage;
import com.tratif.ddd.domain.classes.timetable.Timetable;
import com.tratif.ddd.domain.classes.timetable.TimetableRepository;

@Component
@Profile("events")
public class EventBasedTimetableRepository extends BasicRepository<Timetable> implements TimetableRepository {

	@Autowired
	public EventBasedTimetableRepository(EventsStorage eventsStorage) {
		super(eventsStorage);
	}
	
	public Timetable findById(UUID id) {
		return getById(id, Timetable.class);
	}
	
}

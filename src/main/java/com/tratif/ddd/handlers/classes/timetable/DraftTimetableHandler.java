package com.tratif.ddd.handlers.classes.timetable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tratif.ddd.domain.classes.ClassType;
import com.tratif.ddd.domain.classes.timetable.Timetable;
import com.tratif.ddd.domain.classes.timetable.TimetableRepository;
import com.tratif.ddd.handlers.classes.timetable.command.DraftTimetable;

@Component
@Transactional
public class DraftTimetableHandler {

	private TimetableRepository repository;
	
	@Autowired
	public DraftTimetableHandler(TimetableRepository repo) {
		this.repository = repo;
	}
	
	public void handle(DraftTimetable command) {
		ClassType classType = command.classType();
		repository.save(new Timetable(command.id(), classType));
	}
}

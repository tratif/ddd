package com.tratif.ddd.handlers.classes.timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tratif.ddd.domain.classes.timetable.ScheduledDate;
import com.tratif.ddd.domain.classes.timetable.Timetable;
import com.tratif.ddd.domain.classes.timetable.TimetableRepository;
import com.tratif.ddd.handlers.classes.timetable.command.AddDate;

@Component
@Transactional
public class AddDateHandler {

	private TimetableRepository repository;
	
	@Autowired
	public AddDateHandler(TimetableRepository repository) {
		this.repository = repository;
	}
	
	public void handle(AddDate command) {
		Timetable timetable = repository.findById(command.timetableId());
		ScheduledDate date = new ScheduledDate(command.dayOfWeek(), command.classTime());
		timetable.addDate(date);
		repository.save(timetable);
	}
}

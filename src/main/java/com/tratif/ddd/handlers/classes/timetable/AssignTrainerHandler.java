package com.tratif.ddd.handlers.classes.timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tratif.ddd.domain.classes.timetable.ScheduledDate;
import com.tratif.ddd.domain.classes.timetable.Timetable;
import com.tratif.ddd.domain.classes.timetable.TimetableRepository;
import com.tratif.ddd.handlers.classes.timetable.command.AssignTrainer;

@Component
@Transactional
public class AssignTrainerHandler {

	private TimetableRepository repository;
	
	@Autowired
	public AssignTrainerHandler(TimetableRepository repository) {
		this.repository = repository;
	}
	
	public void handle(AssignTrainer command) {
		Timetable timetable = repository.findById(command.timetableId());
		ScheduledDate date = new ScheduledDate(command.dayOfWeek(), command.classTime());
		timetable.addDate(date);
	}
}

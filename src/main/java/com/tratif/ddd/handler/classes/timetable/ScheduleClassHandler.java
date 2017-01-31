package com.tratif.ddd.handler.classes.timetable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tratif.ddd.domain.classes.timetable.ScheduledDate;
import com.tratif.ddd.domain.classes.timetable.Timetable;
import com.tratif.ddd.domain.classes.timetable.TimetableRepository;
import com.tratif.ddd.handler.classes.timetable.command.ScheduleClass;

@Component
@Transactional
public class ScheduleClassHandler {

	private TimetableRepository timetableRepository;
	
	@Autowired
	private ScheduleClassHandler(TimetableRepository repo) {
		this.timetableRepository = repo;
	}
	
	public void handle(ScheduleClass command) {
		Timetable timetable = timetableRepository.findById(command.timetableId().value());
		
		timetable.scheduleClass(command.classType(),
				new ScheduledDate(command.dayOfWeek(), command.startTime()));
	}
}

package com.tratif.ddd.handlers.classes.timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tratif.ddd.domain.classes.timetable.Period;
import com.tratif.ddd.domain.classes.timetable.PublishTimetableService;
import com.tratif.ddd.handlers.classes.timetable.command.PublishTimetable;

@Component
@Transactional
public class PublishTimetableHandler {

	private PublishTimetableService service;
	
	@Autowired
	public PublishTimetableHandler(PublishTimetableService service) {
		this.service = service;
	}
	
	public void handle(PublishTimetable command) {
		Period validityPeriod = Period.between(command.validFrom(), command.validTo());
		service.publishTimetable(command.timetableId(), validityPeriod);
	}
}

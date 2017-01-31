package com.tratif.web.handler.classes.timetable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tratif.ddd.domain.classes.timetable.TimetableId;
import com.tratif.ddd.handler.classes.timetable.ScheduleClassHandler;
import com.tratif.ddd.handler.classes.timetable.command.ScheduleClass;

@Controller
@ResponseBody
public class TimetableController {

	@Autowired
	private ScheduleClassHandler handler;
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public void scheduleClass(@Valid @RequestBody ScheduledClassDto dto) {
		
		ScheduleClass command = new ScheduleClass(new TimetableId(dto.timetableId));
		
		handler.handle(command);
	}
	
	public static class ScheduledClassDto {
		
		@NotNull
		private Long timetableId;
	}
	
}

package com.tratif.ddd.web.classes.timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tratif.ddd.domain.classes.ClassType;
import com.tratif.ddd.handlers.classes.timetable.DraftTimetableHandler;
import com.tratif.ddd.handlers.classes.timetable.command.DraftTimetable;

@Controller
@ResponseBody
public class DraftScheduleController {

	@Autowired
	private DraftTimetableHandler handler;
	
	@RequestMapping(path = "/timetables", method = RequestMethod.POST)
	public void draftSchedule(@RequestBody ScheduleDto scheduleDto) {
		DraftTimetable command = new DraftTimetable(scheduleDto.getClassType());
		handler.handle(command);
	}
	
	public static class ScheduleDto {
		private ClassType classType;
		
		public ClassType getClassType() {
			return classType;
		}
	}
}

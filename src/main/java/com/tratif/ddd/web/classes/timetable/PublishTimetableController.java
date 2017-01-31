package com.tratif.ddd.web.classes.timetable;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tratif.ddd.handlers.classes.timetable.PublishTimetableHandler;
import com.tratif.ddd.handlers.classes.timetable.command.PublishTimetable;

@Controller
@ResponseBody
public class PublishTimetableController {

	@Autowired
	private PublishTimetableHandler handler;
	
	@RequestMapping(path = "/timetables/{timetableId}/publish", method = RequestMethod.POST)
	public void publishTimetable(@RequestBody TimetablePublicationDto publicationDto) {
		PublishTimetable command = new PublishTimetable(
				publicationDto.getTimetableId(),
				publicationDto.getValidFrom(),
				publicationDto.getValidTo());
		
		handler.handle(command);
	}
	
	public static class TimetablePublicationDto {
		private UUID timetableId;
		private LocalDate validFrom;
		private LocalDate validTo;
		
		public UUID getTimetableId() {
			return timetableId;
		}
		public LocalDate getValidFrom() {
			return validFrom;
		}
		public LocalDate getValidTo() {
			return validTo;
		}
	}
}

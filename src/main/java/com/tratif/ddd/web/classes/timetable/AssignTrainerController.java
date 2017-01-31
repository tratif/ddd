package com.tratif.ddd.web.classes.timetable;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tratif.ddd.domain.classes.ClassType;
import com.tratif.ddd.handlers.classes.timetable.AssignTrainerHandler;
import com.tratif.ddd.handlers.classes.timetable.command.AssignTrainer;

@Controller
@ResponseBody
public class AssignTrainerController {

	@Autowired
	private AssignTrainerHandler handler;
	
	@RequestMapping(value = "/timetables/{timetableId}/trainer-assignments", method = RequestMethod.POST)
	public void assignTrainer(@RequestBody TrainerAssignmentDto assignment) {
		AssignTrainer command = new AssignTrainer(
				assignment.getTimetableId(),
				assignment.getDayOfWeek(),
				LocalTime.of(assignment.getHour(), assignment.getMinute()),
				assignment.getTrainerId());
		handler.handle(command);
	}
	
	public static class TrainerAssignmentDto {
		private UUID trainerId;
		private UUID timetableId;
		private ClassType classType;
		private DayOfWeek dayOfWeek;
		private int hour;
		private int minute;
		
		public ClassType getClassType() {
			return classType;
		}
		public DayOfWeek getDayOfWeek() {
			return dayOfWeek;
		}
		public int getHour() {
			return hour;
		}
		public int getMinute() {
			return minute;
		}
		public UUID getTimetableId() {
			return timetableId;
		}
		public UUID getTrainerId() {
			return trainerId;
		}
	}
	
}

package com.tratif.ddd;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tratif.ddd.domain.Event;
import com.tratif.ddd.domain.EventsStorage;
import com.tratif.ddd.domain.classes.ClassType;
import com.tratif.ddd.domain.classes.timetable.ScheduledDate;
import com.tratif.ddd.domain.classes.timetable.events.DateAdded;
import com.tratif.ddd.handlers.classes.timetable.AddDateHandler;
import com.tratif.ddd.handlers.classes.timetable.AssignTrainerHandler;
import com.tratif.ddd.handlers.classes.timetable.DraftTimetableHandler;
import com.tratif.ddd.handlers.classes.timetable.command.AddDate;
import com.tratif.ddd.handlers.classes.timetable.command.AssignTrainer;
import com.tratif.ddd.handlers.classes.timetable.command.DraftTimetable;
import com.tratif.ddd.handlers.classes.timetable.events.TimetableDrafted;
import com.tratif.ddd.handlers.classes.timetable.events.TrainerAssigned;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DddDemoApplication.class })
@Transactional
@ActiveProfiles("events")
public class SaveAndLoadAggreateTest {

	@Autowired
	DraftTimetableHandler handler;
	
	@Autowired
	AssignTrainerHandler assignTrainerHandler;
	
	@Autowired
	AddDateHandler addDateHandler;
	
	@Autowired
	EventsStorage storage;
	
	@Test
	public void createEventsWhenCreatesClassScheduleWithEntry() {
		UUID id = UUID.randomUUID();
		UUID trainerId = UUID.randomUUID();
		
		handler.handle(new DraftTimetable(id, ClassType.GYMNASTICS));
		addDateHandler.handle(new AddDate(id, DayOfWeek.WEDNESDAY, LocalTime.of(16,0)));
		assignTrainerHandler.handle(new AssignTrainer(id, DayOfWeek.WEDNESDAY, LocalTime.of(16,0), trainerId));
		
		List<Event> events = storage.loadEvents(id);
		
		assertThat(events.get(0)).isEqualToIgnoringGivenFields(
				new TimetableDrafted(id, ClassType.GYMNASTICS), "dateOccured");
		
		assertThat(events.get(1)).isEqualToIgnoringGivenFields(
				new DateAdded(id, new ScheduledDate(DayOfWeek.WEDNESDAY, LocalTime.of(16, 0))), "dateOccured");
		
		assertThat(events.get(2)).isEqualToIgnoringGivenFields(
				new TrainerAssigned(id, new ScheduledDate(DayOfWeek.WEDNESDAY, LocalTime.of(16, 0)), trainerId), "dateOccured");
	}
}

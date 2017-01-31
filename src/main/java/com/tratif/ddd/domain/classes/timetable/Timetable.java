package com.tratif.ddd.domain.classes.timetable;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tratif.ddd.domain.AggregateRoot;
import com.tratif.ddd.domain.classes.ClassType;
import com.tratif.ddd.domain.classes.enrollment.Class;
import com.tratif.ddd.domain.classes.enrollment.exception.OverlappingDateException;
import com.tratif.ddd.domain.classes.enrollment.exception.ScheduleEntryNotFoundException;
import com.tratif.ddd.domain.classes.timetable.events.DateAdded;
import com.tratif.ddd.handlers.classes.timetable.events.TimetableDrafted;
import com.tratif.ddd.handlers.classes.timetable.events.TrainerAssigned;

@Entity
@Table(name = "class_schedules")
public class Timetable extends AggregateRoot {

	@Id
	private UUID id;
	
	private ClassType classType;
	
	@Embedded
	private Period validityPeriod;
	
	@OneToMany
	private Collection<ScheduledClass> scheduledClasses = new HashSet<>();
	
	public Timetable() {
		registerEventHandler(TimetableDrafted.class, e -> handle((TimetableDrafted) e));
		registerEventHandler(TrainerAssigned.class, e -> handle((TrainerAssigned) e));
		registerEventHandler(DateAdded.class, e -> handle((DateAdded) e));
	}
	
	public Timetable(UUID id, ClassType classType) {
		this();
		applyEvent(new TimetableDrafted(id, classType));
	}
	
	private void handle(TimetableDrafted event) {
		this.id = event.getId();
		this.classType = event.getType();
	}
	
	public void addDate(ScheduledDate date) {
		Optional<ScheduledClass> overlappingClass = scheduledClasses.stream()
			.filter(entry -> date.overlaps(entry.getDate()))
			.findAny();
		if(overlappingClass.isPresent()) {
			throw new OverlappingDateException();
		}
		applyEvent(new DateAdded(id, date));
	}
	
	public void handle(DateAdded event) {
		scheduledClasses.add(new ScheduledClass(event.getDate()));
	}
	
	public void assignTrainer(ScheduledDate date, UUID trainerId) {
		
		scheduledClasses.stream()
			.filter(entry -> date.equals(entry.getDate()))
			.findFirst()
			.orElseThrow(() -> new ScheduleEntryNotFoundException());
		applyEvent(new TrainerAssigned(this.id, date, trainerId));
	}
	
	private void handle(TrainerAssigned event) {
		scheduledClasses.stream()
			.filter(entry -> event.getDate().equals(entry.getDate()))
			.findFirst()
			.get()
			.assignTrainer(event.getTrainerId());
	}
	
	public List<Class> publish(Period validityPeriod) {
		this.validityPeriod = validityPeriod;
		
		return scheduledClasses.stream()
				.flatMap(scheduledClass -> scheduledClass.datesFor(validityPeriod).stream())
				.map(date -> new Class(UUID.randomUUID(), classType, date))
				.collect(toList());
				
	}

	@Override
	public UUID getId() {
		return id;
	}
}

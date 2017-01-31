package com.tratif.ddd.domain.classes.timetable;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tratif.ddd.domain.AggregateRoot;
import com.tratif.ddd.domain.classes.ClassType;
import com.tratif.ddd.domain.classes.enrollment.Class;
import com.tratif.ddd.domain.classes.enrollment.exception.ScheduleEntryNotFoundException;

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
	
	@Deprecated // for hibernate only
	Timetable() {
	}
	
	public Timetable(UUID id, ClassType classType) {
		this.id = id;
		this.classType = classType;
	}
	
	public void addDate(ScheduledDate date) {
		scheduledClasses.add(new ScheduledClass(date));
	}
	
	public void assignTrainer(ScheduledDate term, Long trainerId) {
		scheduledClasses.stream()
			.filter(entry -> term.equals(entry.getDate()))
			.findFirst()
			.orElseThrow(() -> new ScheduleEntryNotFoundException())
			.assignTrainer(trainerId);
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

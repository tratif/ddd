package com.tratif.ddd.domain.classes.timetable;

import java.util.Collection;
import java.util.List;
import static java.util.stream.Collectors.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tratif.ddd.domain.classes.ClassType;
import com.tratif.ddd.domain.classes.enrollment.Class;
import com.tratif.ddd.domain.classes.enrollment.exception.ScheduleEntryNotFoundException;

@Entity
@Table(name = "class_schedules")
public class Timetable {

	@Id @GeneratedValue
	private Long id;
	
	private ClassType classType;
	
	@Embedded
	private Period validityPeriod;
	
	@OneToMany
	private Collection<ScheduledClass> scheduledClasses;
	
	@Deprecated // for hibernate only
	Timetable() {
	}
	
	public Timetable(ClassType classType) {
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
				.map(date -> new Class(classType, date))
				.collect(toList());
				
	}
}

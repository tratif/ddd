package com.tratif.ddd.domain.classes.timetable;

import java.sql.Time;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tratif.ddd.domain.classes.ClassType;

@Entity
@Table(name = "timetables")
public class Timetable {
	
	@Id @GeneratedValue
	private Long id;
	
	@ElementCollection
	private Collection<ScheduledClass> scheduledClasses;

	public Timetable() {
	}
	
	public void scheduleClass(ClassType classType, ScheduledDate date) {
		assertDoesNotOverlap(date);
		scheduledClasses.add(new ScheduledClass(classType, date));
	}

	private void assertDoesNotOverlap(ScheduledDate date) {
		// TODO Auto-generated method stub
		
	}
}

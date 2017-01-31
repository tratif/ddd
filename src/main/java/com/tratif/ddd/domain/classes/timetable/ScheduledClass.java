package com.tratif.ddd.domain.classes.timetable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tratif.ddd.domain.classes.ClassType;

@Entity
@Table(name = "scheduled_classes")
public class ScheduledClass {
	
	@Id @GeneratedValue
	private Long id;
	
	private ClassType type;
	
	@Embedded
	private ScheduledDate date;
	
	private TrainerId trainerId;

	@Deprecated
	ScheduledClass() {
	}
	
	public ScheduledClass(ClassType classType, ScheduledDate date) {
		this.date = date;
		this.type = classType;
	}
}

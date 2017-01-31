package com.tratif.ddd.domain.classes.timetable;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "scheduled_classes")
public class ScheduledClass {

	@Id @GeneratedValue
	private Long id;

	@Embedded
	private ScheduledDate date;
	
	private Long trainerId;
	
	@Deprecated // for hibernate only
	ScheduledClass() {
	}
	
	public ScheduledClass(ScheduledDate term) {
		this.date = term;
	}
	
	public void assignTrainer(Long trainerId) {
		this.trainerId = trainerId;
	}

	ScheduledDate getDate() {
		return date;
	}

	public List<LocalDateTime> datesFor(Period validityPeriod) {
		// TODO Auto-generated method stub
		return null;
	}
}

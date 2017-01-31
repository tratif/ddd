package com.tratif.ddd.domain.classes.timetable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
	
	private UUID trainerId;
	
	@Deprecated // for hibernate only
	ScheduledClass() {
	}
	
	public ScheduledClass(ScheduledDate term) {
		this.date = term;
	}
	
	public void assignTrainer(UUID trainerId) {
		this.trainerId = trainerId;
	}

	ScheduledDate getDate() {
		return date;
	}

	public List<LocalDateTime> datesFor(Period validityPeriod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((trainerId == null) ? 0 : trainerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScheduledClass other = (ScheduledClass) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (trainerId == null) {
			if (other.trainerId != null)
				return false;
		} else if (!trainerId.equals(other.trainerId))
			return false;
		return true;
	}
	
}

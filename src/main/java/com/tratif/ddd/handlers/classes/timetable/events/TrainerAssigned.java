package com.tratif.ddd.handlers.classes.timetable.events;

import java.util.UUID;

import com.tratif.ddd.DomainEvent;
import com.tratif.ddd.domain.classes.timetable.ScheduledDate;

@SuppressWarnings("serial")
public class TrainerAssigned extends DomainEvent {

	private UUID timetableId;
	private ScheduledDate date;
	private UUID trainerId;
	
	public TrainerAssigned(UUID timetableId, ScheduledDate date, UUID trainerId) {
		super();
		this.timetableId = timetableId;
		this.date = date;
		this.trainerId = trainerId;
	}

	public UUID getId() {
		return timetableId;
	}

	public ScheduledDate getDate() {
		return date;
	}

	public UUID getTrainerId() {
		return trainerId;
	}

	public UUID getTimetableId() {
		return timetableId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((timetableId == null) ? 0 : timetableId.hashCode());
		result = prime * result + ((trainerId == null) ? 0 : trainerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainerAssigned other = (TrainerAssigned) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (timetableId == null) {
			if (other.timetableId != null)
				return false;
		} else if (!timetableId.equals(other.timetableId))
			return false;
		if (trainerId == null) {
			if (other.trainerId != null)
				return false;
		} else if (!trainerId.equals(other.trainerId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrainerAssigned [timetableId=" + timetableId + ", date=" + date + ", trainerId=" + trainerId + "]";
	}
}

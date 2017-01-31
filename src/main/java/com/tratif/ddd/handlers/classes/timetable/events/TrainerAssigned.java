package com.tratif.ddd.handlers.classes.timetable.events;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

import com.tratif.ddd.DomainEvent;

@SuppressWarnings("serial")
public class TrainerAssigned extends DomainEvent {

	private UUID id;
	private DayOfWeek dayOfWeek;
	private LocalTime time;
	
	public TrainerAssigned(UUID id, DayOfWeek dayOfWeek, LocalTime time) {
		super();
		this.id = id;
		this.dayOfWeek = dayOfWeek;
		this.time = time;
	}

	public UUID getId() {
		return id;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public LocalTime getTime() {
		return time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dayOfWeek == null) ? 0 : dayOfWeek.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		if (dayOfWeek != other.dayOfWeek)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrainerAssigned [id=" + id + ", dayOfWeek=" + dayOfWeek + ", time=" + time + "]";
	}
	
}

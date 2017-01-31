package com.tratif.ddd.domain.classes.timetable.events;

import java.util.UUID;

import com.tratif.ddd.DomainEvent;
import com.tratif.ddd.domain.classes.timetable.ScheduledDate;

@SuppressWarnings("serial")
public class DateAdded extends DomainEvent {

	private UUID id;
	private ScheduledDate date;
	
	public DateAdded(UUID id, ScheduledDate date) {
		super();
		this.id = id;
		this.date = date;
	}

	@Override
	public UUID getId() {
		return id;
	}

	public ScheduledDate getDate() {
		return date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DateAdded other = (DateAdded) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "DateAdded [id=" + id + ", date=" + date + "]";
	}

}

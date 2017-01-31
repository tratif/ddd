package com.tratif.ddd.domain.classes.timetable;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.persistence.Embeddable;


@SuppressWarnings("serial")
@Embeddable
public class ScheduledDate implements Serializable {

	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	
	@Deprecated // for hibernate only
	ScheduledDate() {
	}
	
	public ScheduledDate(DayOfWeek dayOfWeek, LocalTime startTime) {
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dayOfWeek == null) ? 0 : dayOfWeek.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		ScheduledDate other = (ScheduledDate) obj;
		if (dayOfWeek != other.dayOfWeek)
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ScheduledDate [dayOfWeek=" + dayOfWeek + ", startTime=" + startTime + "]";
	}

	public boolean overlaps(ScheduledDate date) {
		//TODO: implement
		return false;
	}
	
}

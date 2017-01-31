package com.tratif.ddd.handlers.classes.timetable.command;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

public class AddDate {

	private UUID timetableId;
	private DayOfWeek dayOfWeek;
	private LocalTime classTime;
	
	public AddDate(UUID timetableId, DayOfWeek dayOfWeek, LocalTime classTime) {
		this.timetableId = timetableId;
		this.dayOfWeek = dayOfWeek;
		this.classTime = classTime;
	}
	
	public LocalTime classTime() {
		return classTime;
	}
	
	public DayOfWeek dayOfWeek() {
		return dayOfWeek;
	}
	
	public UUID timetableId() {
		return timetableId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classTime == null) ? 0 : classTime.hashCode());
		result = prime * result + ((dayOfWeek == null) ? 0 : dayOfWeek.hashCode());
		result = prime * result + ((timetableId == null) ? 0 : timetableId.hashCode());
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
		AddDate other = (AddDate) obj;
		if (classTime == null) {
			if (other.classTime != null)
				return false;
		} else if (!classTime.equals(other.classTime))
			return false;
		if (dayOfWeek != other.dayOfWeek)
			return false;
		if (timetableId == null) {
			if (other.timetableId != null)
				return false;
		} else if (!timetableId.equals(other.timetableId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddDate [timetableId=" + timetableId + ", dayOfWeek=" + dayOfWeek + ", classTime=" + classTime + "]";
	}
	
}

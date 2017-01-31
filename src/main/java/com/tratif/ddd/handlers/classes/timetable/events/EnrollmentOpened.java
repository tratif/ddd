package com.tratif.ddd.handlers.classes.timetable.events;

import java.time.LocalDateTime;
import java.util.UUID;

import com.tratif.ddd.DomainEvent;
import com.tratif.ddd.domain.classes.ClassType;

@SuppressWarnings("serial")
public class EnrollmentOpened extends DomainEvent {

	private ClassType classType;
	private LocalDateTime startTime;
	private Long trainerId;
	private int maxNumParticipants;
	private UUID timetableId;
	
	public EnrollmentOpened(UUID timetableId,
			ClassType classType, LocalDateTime startTime, Long trainerId, int maxNumParticipants) {
		
		this.classType = classType;
		this.startTime = startTime;
		this.trainerId = trainerId;
		this.maxNumParticipants = maxNumParticipants;
	}
	
	public ClassType classType() {
		return classType;
	}
	
	public int maxNumParticipants() {
		return maxNumParticipants;
	}
	
	public LocalDateTime startTime() {
		return startTime;
	}
	
	public Long trainerId() {
		return trainerId;
	}

	@Override
	public UUID getId() {
		return timetableId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((classType == null) ? 0 : classType.hashCode());
		result = prime * result + maxNumParticipants;
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		EnrollmentOpened other = (EnrollmentOpened) obj;
		if (classType != other.classType)
			return false;
		if (maxNumParticipants != other.maxNumParticipants)
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
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
		return "EnrollmentOpened [classType=" + classType + ", startTime=" + startTime + ", trainerId=" + trainerId
				+ ", maxNumParticipants=" + maxNumParticipants + ", timetableId=" + timetableId + "]";
	}
}
package com.tratif.ddd;

import java.time.LocalDateTime;

import com.tratif.ddd.domain.Event;

@SuppressWarnings("serial")
public abstract class DomainEvent implements Event {

	private LocalDateTime dateOccured;
	
	protected DomainEvent() {
		dateOccured = LocalDateTime.now();
	}
	
	public LocalDateTime dateOccured() {
		return dateOccured;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOccured == null) ? 0 : dateOccured.hashCode());
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
		DomainEvent other = (DomainEvent) obj;
		if (dateOccured == null) {
			if (other.dateOccured != null)
				return false;
		} else if (!dateOccured.equals(other.dateOccured))
			return false;
		return true;
	}
	
}

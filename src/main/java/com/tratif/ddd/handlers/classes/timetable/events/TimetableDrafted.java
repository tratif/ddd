package com.tratif.ddd.handlers.classes.timetable.events;

import java.util.UUID;

import com.tratif.ddd.DomainEvent;
import com.tratif.ddd.domain.classes.ClassType;

@SuppressWarnings("serial")
public class TimetableDrafted extends DomainEvent {

	private UUID id;
	private ClassType type;
	
	public TimetableDrafted(UUID id, ClassType type) {
		super();
		this.id = id;
		this.type = type;
	}

	public UUID getId() {
		return id;
	}

	public ClassType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		TimetableDrafted other = (TimetableDrafted) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TimetableDrafted [id=" + id + ", type=" + type + "]";
	}

}

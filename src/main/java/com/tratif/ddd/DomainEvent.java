package com.tratif.ddd;

import java.time.LocalDateTime;

public abstract class DomainEvent {

	private LocalDateTime dateOccured;
	
	protected DomainEvent() {
		dateOccured = LocalDateTime.now();
	}
	
	public LocalDateTime dateOccured() {
		return dateOccured;
	}
}

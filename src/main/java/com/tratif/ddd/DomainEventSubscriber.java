package com.tratif.ddd;

public interface DomainEventSubscriber<T extends DomainEvent> {

	void handle(T event);
	
	Class<T> supportedEventType();
}

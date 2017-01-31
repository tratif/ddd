package com.tratif.ddd;

import java.util.ArrayList;
import java.util.List;

public class DomainEventPublisher {

	@SuppressWarnings("rawtypes")
	private static final ThreadLocal<List> subscribers = new ThreadLocal<>();
	private static final ThreadLocal<Boolean> publishing = new ThreadLocal<Boolean>() {
		protected Boolean initialValue() {
			return Boolean.FALSE;
		}
	};
	
	public static DomainEventPublisher instance() {
		return new DomainEventPublisher();
	}
	
	@SuppressWarnings("unchecked")
	public <T extends DomainEvent> void publish(T domainEvent) {
		if (publishing.get()) {
			return;
		}
		try {
			publishing.set(true);
			List<DomainEventSubscriber<?>> registeredSubscribers = subscribers.get();
			if (registeredSubscribers != null) {
				Class<?> eventType = domainEvent.getClass();
				registeredSubscribers.stream()
					.filter(subscriber -> subscriber.supportedEventType() == eventType || subscriber.supportedEventType() == DomainEvent.class)
					.map(subscriber -> (DomainEventSubscriber<T>) subscriber)
					.forEach(subscriber -> subscriber.handle(domainEvent));
			}
		} finally {
			publishing.set(false);
		}
	}
	
	public void reset() {
		if (!publishing.get()) {
			subscribers.set(null);
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T extends DomainEvent> void subscribe(DomainEventSubscriber<T> subscriber) {
		if (publishing.get()) {
			return;
		}
		List<DomainEventSubscriber<T>> registeredSubscribers = subscribers.get();
		
		if (registeredSubscribers == null) {
			registeredSubscribers = new ArrayList<>();
			registeredSubscribers.add(subscriber);
		};
		registeredSubscribers.add(subscriber);
	}
}

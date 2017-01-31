package com.tratif.ddd.domain;

import java.util.List;
import java.util.UUID;

public class BasicRepository<T extends AggregateRoot> implements Repository<T> {

	private EventsStorage eventsStorage;
	
	public BasicRepository(EventsStorage eventsStorage) {
		this.eventsStorage = eventsStorage;
	}
	
	@Override
	public void save(T aggregate) {
		this.eventsStorage.save(aggregate.getUncommitedChanges());
		aggregate.commitChanges();
	}

	@Override
	public T getById(UUID id, Class<T> clazz) {
		T aggregate;
		try {
			aggregate = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		List<Event> events = eventsStorage.loadEvents(id);
		aggregate.loadFromHistory(events);
		return aggregate;
	}

}

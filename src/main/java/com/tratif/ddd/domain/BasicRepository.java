package com.tratif.ddd.domain;

import java.util.List;

public abstract class BasicRepository<T extends AggregateRoot> implements Repository<T> {

	private Class<T> clazz;
	private EventsStorage<T> eventsStorage;
	
	public BasicRepository(Class<T> clazz, EventsStorage<T> eventsStorage) {
		this.clazz = clazz;
		this.eventsStorage = eventsStorage;
	}
	
	@Override
	public void save(T aggregate) {
		this.eventsStorage.save(aggregate.getUncommitedChanges());
		aggregate.commitChanges();
	}

	@Override
	public T getById(Long id) {
		T aggregate;
		try {
			aggregate = this.clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		List<Event> events = eventsStorage.getEventsForAggregate(clazz, id);
		aggregate.loadFromHistory(events);
		return aggregate;
	}

}

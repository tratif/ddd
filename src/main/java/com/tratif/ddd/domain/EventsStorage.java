package com.tratif.ddd.domain;

import java.util.List;

public interface EventsStorage<T extends AggregateRoot> {

	List<Event> getEventsForAggregate(Class<T> clazz, Long id);

	void save(List<Event> uncommitedChanges);

}

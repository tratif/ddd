package com.tratif.ddd.infra;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import com.tratif.ddd.domain.Event;
import com.tratif.ddd.domain.EventsStorage;

@Component
public class JpaEventsStorage implements EventsStorage {

	private final SpringDataEventRepository repo;

	@Autowired
	public JpaEventsStorage(SpringDataEventRepository repo) {
		this.repo = repo;
	}

	@Override
	public void save(List<Event> uncommitedChanges) {
		uncommitedChanges.stream()
			.map(event -> transform(event))
			.forEach(eventModel -> repo.save(eventModel));
	}

	private EventModel transform(Event event) {
		return new EventModel(event.getId(), event.getClass(), SerializationUtils.serialize(event));
	}

	private Event transform(EventModel eventModel) {
		return (Event) SerializationUtils.deserialize(eventModel.getSerializedContent());
	}

	@Override
	public List<Event> loadEvents(UUID id) {
		return repo.findByAggregateId(id)
				.stream()
				.map(eventModel -> transform(eventModel))
				.collect(Collectors.toList());
	}

}

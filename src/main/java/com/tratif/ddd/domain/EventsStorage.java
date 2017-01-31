package com.tratif.ddd.domain;

import java.util.List;
import java.util.UUID;

public interface EventsStorage {

	void save(List<Event> uncommitedChanges);

	List<Event> loadEvents(UUID id);

}

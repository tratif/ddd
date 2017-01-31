package com.tratif.ddd.domain;

import java.util.UUID;

public interface Repository<T extends AggregateRoot> {

	void save(T aggregate);
	
	T getById(UUID id, Class<T> clazz);
	
}

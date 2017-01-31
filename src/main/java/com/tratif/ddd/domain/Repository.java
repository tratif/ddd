package com.tratif.ddd.domain;

public interface Repository<T extends AggregateRoot> {

	void save(T aggregate);
	
	T getById(Long id);
	
}

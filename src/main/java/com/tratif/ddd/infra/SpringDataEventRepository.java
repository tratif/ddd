package com.tratif.ddd.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataEventRepository extends JpaRepository<EventModel, UUID> {

	List<EventModel> findByAggregateId(UUID id);
}

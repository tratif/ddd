package com.tratif.ddd.infra.classes.timetable;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.tratif.ddd.domain.BasicRepository;
import com.tratif.ddd.domain.EventsStorage;
import com.tratif.ddd.domain.classes.timetable.Trainer;
import com.tratif.ddd.domain.classes.timetable.TrainerRepository;

@Component
@Profile("events")
public class EventBasedTrainerRepository extends BasicRepository<Trainer> implements TrainerRepository {

	@Autowired
	public EventBasedTrainerRepository(EventsStorage eventsStorage) {
		super(eventsStorage);
	}

	@Override
	public Trainer findById(UUID id) {
		return getById(id, Trainer.class);
	}
}

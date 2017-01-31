package com.tratif.ddd.domain.classes.timetable;

import java.util.UUID;

public interface TrainerRepository {

	Trainer findById(UUID id);
}

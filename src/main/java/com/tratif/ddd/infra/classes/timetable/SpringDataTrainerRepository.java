package com.tratif.ddd.infra.classes.timetable;

import java.util.UUID;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tratif.ddd.domain.classes.timetable.Trainer;
import com.tratif.ddd.domain.classes.timetable.TrainerRepository;

@Profile("!events")
public interface SpringDataTrainerRepository extends TrainerRepository, JpaRepository<Trainer, UUID> {

}

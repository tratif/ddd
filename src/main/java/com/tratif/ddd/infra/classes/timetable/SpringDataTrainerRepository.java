package com.tratif.ddd.infra.classes.timetable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tratif.ddd.domain.classes.timetable.Trainer;
import com.tratif.ddd.domain.classes.timetable.TrainerRepository;

public interface SpringDataTrainerRepository extends TrainerRepository, JpaRepository<Trainer, Long> {

}

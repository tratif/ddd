package com.tratif.ddd.infra.classes.timetable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tratif.ddd.domain.classes.timetable.Timetable;
import com.tratif.ddd.domain.classes.timetable.TimetableRepository;

public interface SpringDataTimetableRepository extends TimetableRepository, JpaRepository<Timetable, Long> {

}

package com.tratif.ddd.handlers.classes.enrollment;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tratif.ddd.domain.classes.enrollment.Class;
import com.tratif.ddd.domain.classes.enrollment.ClassRepository;
import com.tratif.ddd.handlers.classes.enrollment.command.ClockIn;

@Component
@Transactional
public class ClockInHandler {

	private final ClassRepository classRepository;

	@Autowired
	public ClockInHandler(ClassRepository classRepository) {
		this.classRepository = classRepository;
	}
	
	public void handle(ClockIn command) {
		Class clazz = classRepository.findNearestForMember(command.getMemberId(), LocalDateTime.now());
		
		clazz.confirmReservation(command.getMemberId());
	}
}

package com.tratif.ddd.handlers.classes.enrollment;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tratif.ddd.domain.classes.enrollment.ReservationService;
import com.tratif.ddd.handlers.classes.enrollment.command.MakeReservation;

@Component
@Transactional
public class MakeReservationHandler {

	private final ReservationService reservationService;
	
	@Autowired
	public MakeReservationHandler(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	public void handle(MakeReservation command) {
		reservationService.makeReservation(command.getMemberId(), command.getClassId());
	}
}

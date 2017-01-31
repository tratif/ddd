package com.tratif.ddd.domain.classes.enrollment;

import java.util.List;

public interface ReservationRepository {
	
	Reservation save(Reservation reservation);
	
	List<Reservation> findOpenReservations(Long memberId);
}

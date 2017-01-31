package com.tratif.ddd.domain.classes.enrollment;

import java.util.List;
import java.util.UUID;

public interface ReservationRepository {
	
	Reservation save(Reservation reservation);
	
	List<Reservation> findOpenReservations(UUID memberId);
}

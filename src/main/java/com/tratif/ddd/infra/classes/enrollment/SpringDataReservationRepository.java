package com.tratif.ddd.infra.classes.enrollment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tratif.ddd.domain.classes.enrollment.Reservation;
import com.tratif.ddd.domain.classes.enrollment.ReservationRepository;


public interface SpringDataReservationRepository extends ReservationRepository, JpaRepository<Reservation, Long> {
	
	@Query("select r from Reservation r where r.confirmed = false and r.memberId = :memberId")
	List<Reservation> findOpenReservations(@Param("memberId") Long memberId);
}

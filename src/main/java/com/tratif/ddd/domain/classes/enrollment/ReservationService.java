package com.tratif.ddd.domain.classes.enrollment;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ReservationService {

	private final MemberRepository memberRepo;
	private final ClassRepository classRepo;
	private final ReservationRepository reservationRepo;

	@Autowired
	public ReservationService(MemberRepository memberRepo, ClassRepository classRepo, ReservationRepository reservationRepo) {
		this.memberRepo = memberRepo;
		this.classRepo = classRepo;
		this.reservationRepo = reservationRepo;
	}
	
	public void makeReservation(Long memberId, Long classId) {
		Member member = memberRepo.findById(memberId);
		Class clazz = classRepo.findById(classId);
		
		member.tryEnrollIn(clazz, reservationRepo);
		clazz.enroll(member);
		
		memberRepo.save(member);
		classRepo.save(clazz);
	}
}

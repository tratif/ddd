package com.tratif.ddd.domain.classes.enrollment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tratif.ddd.DomainEventPublisher;
import com.tratif.ddd.domain.classes.enrollment.events.MemberBanned;
import com.tratif.ddd.domain.classes.enrollment.exception.ClassTypeAlreadyScheduledException;
import com.tratif.ddd.domain.classes.enrollment.exception.MemberIsBannedException;
import com.tratif.ddd.domain.classes.enrollment.exception.TooManyReservationsException;
import com.tratif.ddd.handlers.classes.enrollment.OverlappingClassException;


@Entity
@Table(name = "members")
public class Member {

	private static final Duration DEFAULT_BAN_DURATION = Duration.ofDays(4);

	@Id @GeneratedValue
	private Long id;

	private String name;
	
	private LocalDateTime bannedTo;
	private int missedClasses;
	
	@Deprecated // for hibernate only
	Member() {
	}
	
	public Member(String name) {
		this.name = name;
	}
	
	public void tryEnrollIn(Class clazz, ReservationRepository reservationRepo) {
		List<Reservation> schedule = reservationRepo.findOpenReservations(id);
		
		if (isBanned()) {
			throw new MemberIsBannedException();
		}
		if (clazz.overlapsWith(schedule)) {
			throw new OverlappingClassException();
		}
		if (clazz.typeAlreadyScheduledIn(schedule)) {
			throw new ClassTypeAlreadyScheduledException();
		}
		if (schedule.size() >= 5) {
			throw new TooManyReservationsException();
		}
	}

	public Long getId() {
		return id;
	}
	
	private boolean isBanned() {
		return bannedTo == null || LocalDateTime.now().isAfter(bannedTo);
	}

	public void ban(Duration banDuration) {
		this.bannedTo = LocalDateTime.now().plus(banDuration);
		DomainEventPublisher.instance()
			.publish(new MemberBanned(id, banDuration));
	}

	public void classMissed() {
		missedClasses++;
		if (missedClasses == 3) {
			ban(DEFAULT_BAN_DURATION);
		}
	}
	
}

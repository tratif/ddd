package com.tratif.ddd.domain.classes.enrollment;

import java.time.LocalDateTime;
import static java.util.stream.Collectors.*;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import com.tratif.ddd.domain.classes.ClassType;

@Entity
@Table(name = "classes")
public class Class {

	@Id @GeneratedValue
	private Long id;
	
	private ClassType classType;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	private boolean finished = false;
	
	private int maxParticipants = 6; // TODO

	@OneToMany(cascade = CascadeType.PERSIST)
	private Collection<Reservation> reservations;
	
	@ElementCollection
	@OrderColumn
	private List<Long> waitingMembers;
	
	@Deprecated // for hibernate only
	Class() {
	}

	public Class(ClassType classType, LocalDateTime startTime) {
		this.startTime = startTime;
		this.endTime = startTime.plus(classType.duration());
		this.classType = classType;
	}
	
	public void enroll(Member member) {
		
		if (reservations.size() >= maxParticipants) {
			waitingMembers.add(member.getId());
		} else {
			reservations.add(new Reservation(member.getId()));
		}
	}
	
	public void leaveWaitingList(Member member) {
		waitingMembers.remove(member.getId());
	}
	
	public void cancelReservation(Member member) {
		reservations.removeIf(reservation -> reservation.isMadeBy(member));
		if (!waitingMembers.isEmpty()) {
			reservations.add(new Reservation(waitingMembers.remove(0)));
		}
	}

	public boolean overlapsWith(List<Reservation> schedule) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean typeAlreadyScheduledIn(List<Reservation> schedule) {
		// TODO Auto-generated method stub
		return false;
	}

	public void confirmReservation(Long memberId) {
		reservations.stream()
			.filter(reservation -> memberId.equals(reservation.getMemberId()))
			.findFirst()
			.ifPresent(reservation -> reservation.confirm());
	}
	
	public void finish() {
		finished = true;
		List<Long> membersWhoNotAttended = reservations.stream()
				.filter(reservation -> !reservation.isConfirmed())
				.map(reservation -> reservation.getMemberId())
				.collect(toList());
		
		// TODO event for each member 
	}
}

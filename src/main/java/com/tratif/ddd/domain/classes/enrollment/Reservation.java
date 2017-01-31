package com.tratif.ddd.domain.classes.enrollment;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tratif.ddd.domain.AggregateRoot;

@Entity
@Table(name = "reservations")
public class Reservation extends AggregateRoot {

	@Id
	private UUID id;
	
	private UUID memberId;
	
	private boolean confirmed;
	
	@Deprecated // for hibernate only
	Reservation() {
	}
	
	public Reservation(UUID memberId) {
		this.memberId = memberId;
	}
	
	UUID getMemberId() {
		return memberId;
	}

	void confirm() {
		confirmed = true; // we're loosing information about when confirmation was done
						// event sourcing can solve this naturally
						// alternatively boolean can be changed to conrimationDate here
	}

	boolean isMadeBy(Member member) {
		return isMadeBy(member.getId());
	}
	
	boolean isMadeBy(UUID memberId) {
		return Objects.equals(memberId, memberId);
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	@Override
	public UUID getId() {
		return id;
	}
}

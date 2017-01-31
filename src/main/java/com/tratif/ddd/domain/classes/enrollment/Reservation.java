package com.tratif.ddd.domain.classes.enrollment;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation {

	@Id @GeneratedValue
	private Long id;
	
	private Long memberId;
	
	private boolean confirmed;
	
	@Deprecated // for hibernate only
	Reservation() {
	}
	
	public Reservation(Long memberId) {
		this.memberId = memberId;
	}
	
	Long getMemberId() {
		return memberId;
	}

	void confirm() {
		confirmed = true; // we're loosing information about when confirmation was done
						// event sourcing can solve this naturally
						// alternatively boolean can be changed to conrimationDate here
	}

	boolean isMadeBy(Member member) {
		return Objects.equals(member.getId(), memberId);
	}

	public boolean isConfirmed() {
		return confirmed;
	}
}

package com.tratif.ddd.domain.classes.enrollment.events;

import java.time.Duration;

import com.tratif.ddd.DomainEvent;

public class MemberBanned extends DomainEvent {

	private Long memberId;
	private Duration bannedTo;
	
	public MemberBanned(Long memberId, Duration bannedTo) {
		this.memberId = memberId;
		this.bannedTo = bannedTo;
	}
	
	public Duration bannedTo() {
		return bannedTo;
	}
	
	public Long memberId() {
		return memberId;
	}
}

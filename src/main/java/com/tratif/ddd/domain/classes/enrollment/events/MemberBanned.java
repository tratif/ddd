package com.tratif.ddd.domain.classes.enrollment.events;

import java.time.Duration;
import java.util.UUID;

import com.tratif.ddd.DomainEvent;

@SuppressWarnings("serial")
public class MemberBanned extends DomainEvent {

	private UUID memberId;
	private Duration bannedTo;
	
	public MemberBanned(UUID memberId, Duration bannedTo) {
		this.memberId = memberId;
		this.bannedTo = bannedTo;
	}
	
	public Duration bannedTo() {
		return bannedTo;
	}
	
	@Override
	public UUID getId() {
		return memberId;
	}

}

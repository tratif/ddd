package com.tratif.ddd.handlers.classes.enrollment.command;

import java.time.Duration;
import java.util.UUID;

public class ImposeBan {

	private UUID memberId;
	private Duration banDuration;
	
	public ImposeBan(UUID memberId, Duration duration) {
		this.memberId = memberId;
		this.banDuration = duration;
	}
	
	public Duration getBanDuration() {
		return banDuration;
	}
	
	public UUID getMemberId() {
		return memberId;
	}
}

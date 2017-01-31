package com.tratif.ddd.handlers.classes.enrollment.command;

import java.time.Duration;

public class ImposeBan {

	private Long memberId;
	private Duration banDuration;
	
	public ImposeBan(Long memberId, Duration duration) {
		this.memberId = memberId;
		this.banDuration = duration;
	}
	
	public Duration getBanDuration() {
		return banDuration;
	}
	
	public Long getMemberId() {
		return memberId;
	}
}

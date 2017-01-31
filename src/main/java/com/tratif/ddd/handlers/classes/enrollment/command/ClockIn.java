package com.tratif.ddd.handlers.classes.enrollment.command;

public class ClockIn {

	private Long memberId;
	
	public ClockIn(Long memberId) {
		this.memberId = memberId;
	}
	
	public Long getMemberId() {
		return memberId;
	}
}

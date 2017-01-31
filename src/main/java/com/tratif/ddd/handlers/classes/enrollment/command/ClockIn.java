package com.tratif.ddd.handlers.classes.enrollment.command;

import java.util.UUID;

public class ClockIn {

	private UUID memberId;
	
	public ClockIn(UUID memberId) {
		this.memberId = memberId;
	}
	
	public UUID getMemberId() {
		return memberId;
	}
}

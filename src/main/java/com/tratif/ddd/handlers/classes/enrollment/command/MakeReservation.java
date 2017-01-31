package com.tratif.ddd.handlers.classes.enrollment.command;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MakeReservation {

	private final UUID memberId;
	private final UUID classId;
	
	
	@JsonCreator
	public MakeReservation(@JsonProperty("memberId") UUID memberId, @JsonProperty("classId") UUID classId) { // warning: domain model polluted with infracturcutre annotations
		this.memberId = memberId;
		this.classId = classId;
	}
	
	public UUID getClassId() {
		return classId;
	}
	
	public UUID getMemberId() {
		return memberId;
	}
}

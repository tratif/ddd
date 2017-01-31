package com.tratif.ddd.handlers.classes.enrollment.command;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MakeReservation {

	private final Long memberId;
	private final Long classId;
	
	
	@JsonCreator
	public MakeReservation(@JsonProperty("memberId") Long memberId, @JsonProperty("classId") Long classId) { // warning: domain model polluted with infracturcutre annotations
		this.memberId = memberId;
		this.classId = classId;
	}
	
	public Long getClassId() {
		return classId;
	}
	
	public Long getMemberId() {
		return memberId;
	}
}

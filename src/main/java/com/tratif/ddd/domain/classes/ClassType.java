package com.tratif.ddd.domain.classes;

import java.time.Duration;

public enum ClassType {

	YOGA(Duration.ofMinutes(120)),
	GYMNASTICS(Duration.ofMinutes(60)),
	WEIGHT_LIFTING(Duration.ofMinutes(60));
	
	private Duration duration;
	
	private ClassType(Duration duration) {
		this.duration = duration;
	}
	
	public Duration duration() {
		return duration;
	}
}

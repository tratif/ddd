package com.tratif.ddd.domain.classes;

import java.time.Duration;

public enum ClassType {

	GYMNASTICS(Duration.ofMinutes(60)),
	WEIGHT_LIFTING(Duration.ofMinutes(60)),
	MOBILITY(Duration.ofMinutes(60)),
	YOGA(Duration.ofMinutes(120));
	
	private Duration duration;
	
	private ClassType(Duration duration) {
		this.duration = duration;
	}
	
	public Duration duration() {
		return duration;
	}
}

package com.tratif.ddd.domain.classes.timetable;

import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class Period {

	private LocalDate start;
	private LocalDate end;
	
	private Period(LocalDate start, LocalDate end) {
		this.start = start;
		this.end = end;
	}

	public LocalDate end() {
		return end;
	}
	
	public LocalDate start() {
		return start;
	}
	
	public static Period between(LocalDate from, LocalDate to) {
		return new Period(from, to);
	}
}

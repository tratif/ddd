package com.tratif.ddd.domain.classes.timetable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trainers")
public class Trainer {

	@Id @GeneratedValue
	private Long id;
	
	private int numParticipants;
	
	public Trainer(int numParticipants) {
		this.numParticipants = numParticipants;
	}
	
	public int numParticipants() {
		return numParticipants;
	}
}

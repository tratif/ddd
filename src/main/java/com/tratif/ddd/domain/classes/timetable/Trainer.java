package com.tratif.ddd.domain.classes.timetable;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tratif.ddd.domain.AggregateRoot;

@Entity
@Table(name = "trainers")
public class Trainer extends AggregateRoot {

	@Id
	private UUID id;
	
	private int numParticipants;
	
	public Trainer(int numParticipants) {
		this.numParticipants = numParticipants;
	}
	
	public int numParticipants() {
		return numParticipants;
	}

	@Override
	public UUID getId() {
		return id;
	}
}

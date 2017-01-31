package com.tratif.ddd.infra;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class EventModel {

	@Id
	@GeneratedValue
	private Long id;
	
	private UUID aggregateId;
	
	private Class<?> type;
	
	@Lob
	private byte[] serializedContent;
	
	EventModel(){}
	
	public EventModel(UUID aggregateId, Class<?> type, byte[] content) {
		this.aggregateId = aggregateId;
		this.type = type;
		this.serializedContent = content;
	}

	public Long getId() {
		return id;
	}
	
	public UUID getAggregateId() {
		return aggregateId;
	}

	public Class<?> getType() {
		return type;
	}

	public byte[] getSerializedContent() {
		return serializedContent;
	}
	
}

package com.tratif.ddd.domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public abstract class AggregateRoot {

	private List<Event> uncommitedChanges = new LinkedList<>();
	
	private Map<Class<? extends Event>, Consumer<Event>> eventHandlers = new HashMap<>();
	
	public abstract UUID getId();
	
	public List<Event> getUncommitedChanges() {
		return uncommitedChanges;
	}
	
	public void commitChanges() {
		uncommitedChanges.clear();
	}
	
	public void loadFromHistory(List<Event> history) {
		history.forEach(event -> applyEvent(event, false));
	}
	
	public void applyEvent(Event event) {
		applyEvent(event, true);
	}
	
	private void applyEvent(Event event, boolean notCommited) {
		eventHandlers.get(event.getClass()).accept(event);
		if(notCommited) {
			uncommitedChanges.add(event);
		}
	}
	
	protected void registerEventHandler(Class<? extends Event> clazz, Consumer<Event> eventHandler) {
		eventHandlers.put(clazz, eventHandler);
	}
	
}

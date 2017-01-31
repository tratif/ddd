package com.tratif.ddd;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tratif.ddd.domain.Event;
import com.tratif.ddd.domain.classes.ClassType;
import com.tratif.ddd.handlers.classes.timetable.events.TimetableDrafted;
import com.tratif.ddd.infra.JpaEventsStorage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DddDemoApplication.class })
@Transactional
public class SerializationTest {

	@Autowired
	private JpaEventsStorage eventStorage;
	
	@Test
	public void test() {
		UUID id = UUID.randomUUID();
		Event event = new TimetableDrafted(id, ClassType.MOBILITY);
		eventStorage.save(Arrays.asList(event));
		List<Event> events = eventStorage.loadEvents(id);
		Assertions.assertThat(events).contains(event);
	}
}

package de.ct.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.Module;
import de.ct.shared.Event;

public class UserServiceImplTest {

	EventService eventService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new Module());
		eventService = injector.getInstance(EventService.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateNewMessage() {
		assertNotNull(eventService.createNewEvent());
	}

	@Test
	public void testDeleteEvent() {
		Event event = eventService.createNewEvent();
		eventService.deleteEvent(event.getEventId());
		Event e1 = null;

		e1 = eventService.findEventById(event.getEventId());
		assertNull(e1);
	}

	@Test
	public void testFindEventById() {
		Event event = eventService.createNewEvent();
		boolean eventFound = false;

		if (eventService.findEventById(event.getEventId()) != null) {
			eventFound = true;
		}
		assertTrue(eventFound);
	}

	@Test
	public void testGetEvents() {
		assertNotNull(eventService.getEvents());
	}

	@Test
	public void testSaveEvent() {
		Event e = eventService.createNewEvent();
		e.setEventname("Hallo");
		eventService.saveEvent(e);
		Event eventFound = null;
		eventFound = eventService.findEventById(e.getEventId());
		assertTrue(eventFound.getEventname().equalsIgnoreCase("Hallo"));
	}

}

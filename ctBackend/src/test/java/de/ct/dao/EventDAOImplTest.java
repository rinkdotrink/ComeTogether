package de.ct.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.Module;
import de.ct.shared.Event;

public class EventDAOImplTest {
	
	EventDAO eventDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new Module());
		eventDAO = injector.getInstance(EventDAO.class);
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testCreate() {
		Event e = eventDAO.create();
		assertNotNull(e);
	}

	@Test
	public void testRead() {
		Event e = eventDAO.create();
		e.setEventId(1);
		Event e2 = null;

		e2 = eventDAO.read(1);

		assertNotNull(e2);
	}

	@Test
	public void testUpdate() {
		Event event = eventDAO.create();
		event.setEventname("Name1");
		long eventId = event.getEventId();
		eventDAO.update(event);
		boolean eventUpdated = false;

		eventUpdated = eventDAO.read(eventId).getEventname()
				.equalsIgnoreCase("Name1");

		assertTrue(eventUpdated);
	}

	@Test
	public void testDelete() {
		Event event = eventDAO.create();
		long eventId = event.getEventId();
		eventDAO.delete(event);
		Event e2 = null;
		e2 = eventDAO.read(eventId);

		assertNull(e2);
	}

	@Test
	public void testFindAll() {
		List<Event> events = eventDAO.findAll();
		assertNotNull(events);
	}
}

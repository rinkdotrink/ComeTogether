package de.ct.datamodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.Module;
import de.ct.shared.Participation;

public class ParticipationUnittest {

	Participation participation;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new Module());
		participation = injector.getInstance(Participation.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetParticipationId() {
		participation.setParticipationId(1);
		assertEquals(1, participation.getParticipationId());
	}

	@Test
	public void testSetParticipationId() {
		participation.setParticipationId(1);
		assertEquals(1, participation.getParticipationId());
	}

	@Test
	public void testGetEventId() {
		participation.setEventId(1);
		assertEquals(1, participation.getEventId());
	}

	@Test
	public void testSetEventId() {
		participation.setEventId(1);
		assertEquals(1, participation.getEventId());
	}

	@Test
	public void testGetUserId() {
		participation.setUserId(1);
		assertEquals(1, participation.getUserId());
	}

	@Test
	public void testSetUserId() {
		participation.setUserId(1);
		assertEquals(1, participation.getUserId());
	}

	@Test
	public void testHashCode() {
		participation.setParticipationId(1);
		assertEquals(1, participation.hashCode());
	}

	@Test
	public void testEquals() {
		Participation participationTemp = new Participation();
		participationTemp.setParticipationId(1);
		participation.setParticipationId(1);
		assertTrue(participation.equals(participationTemp));
	}

}

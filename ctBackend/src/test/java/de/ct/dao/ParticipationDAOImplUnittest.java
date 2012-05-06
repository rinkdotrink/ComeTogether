package de.ct.dao;

import static org.easymock.EasyMock.createControl;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.ct.db.ParticipationPersistence;
import de.ct.shared.Participation;

public class ParticipationDAOImplUnittest {

	private ParticipationDAO classUnderTest;
	private ParticipationPersistence mock;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		IMocksControl mockControl = createControl();
		mock = mockControl.createMock(ParticipationPersistence.class);
		classUnderTest = new ParticipationDAOImpl(mock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		Participation participation = new Participation();
		participation.setParticipationId(0);
		Participation p2 = classUnderTest.create();
		assertEquals(participation, p2);
	}

	@Test
	public void testParticipationsForEventId() {
		List<Participation> participations = new ArrayList<Participation>();
		Participation participation = new Participation();
		participation.setParticipationId(0);
		participations.add(participation);
		EasyMock.expect(classUnderTest.getParticipationsForEventId(0)).andReturn(participations).times(1);
		EasyMock.replay(mock);
		List<Participation> p2 = classUnderTest.getParticipationsForEventId(0);
		assertEquals(participations, p2);
		verify(mock);
	}
	
	@Test
	public void testParticipationsForUserId() {
		List<Participation> participations = new ArrayList<Participation>();
		Participation participation = new Participation();
		participation.setParticipationId(0);
		participations.add(participation);
		EasyMock.expect(classUnderTest.getParticipationsForUserId(0)).andReturn(participations).times(1);
		EasyMock.replay(mock);
		List<Participation> p2 = classUnderTest.getParticipationsForUserId(0);
		assertEquals(participations, p2);
		verify(mock);
	}


	@Test
	public void testUpdate() {
		Participation participation = new Participation();
		EasyMock.expect(classUnderTest.update(participation)).times(1);
		EasyMock.replay(mock);
		Participation p2 = classUnderTest.update(participation);
		assertEquals(participation, p2);
		verify(mock);
	}

	@Test
	public void testDelete() {
		Participation participation = new Participation();
		participation.setParticipationId(0);
		mock.delete(participation);
		EasyMock.replay(mock);		
		classUnderTest.delete(participation);		
		verify(mock);
	}

}

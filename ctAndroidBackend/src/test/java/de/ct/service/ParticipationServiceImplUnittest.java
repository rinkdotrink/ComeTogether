package de.ct.service;

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

import de.ct.dao.ParticipationDAO;
import de.ct.shared.Participation;

public class ParticipationServiceImplUnittest {

	private ParticipationService classUnderTest;
	private ParticipationDAO mock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		IMocksControl mockControl = createControl();
		mock = mockControl.createMock(ParticipationDAO.class);
		classUnderTest = new ParticipationServiceImpl(mock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateNewParticipation() {
		Participation participation = new Participation();
		participation.setUserId(0);		
		EasyMock.expect(classUnderTest.createNewParticipation()).andReturn(participation).times(1);
		EasyMock.replay(mock);
		Participation p = classUnderTest.createNewParticipation();
		assertEquals(participation, p);
		verify(mock);
	}

	@Test
	public void testDeleteParticipation() {
		Participation participation = new Participation();
		participation.setParticipationId(0);		
		mock.delete(participation);
		EasyMock.replay(mock);		
		classUnderTest.deleteParticipation(0);		
		verify(mock);
	}

	@Test
	public void testGetParticipationsForEventId() {
		List<Participation> participations = new ArrayList<Participation>();
		Participation participation = new Participation();
		participation.setParticipationId(0);
		participations.add(participation);
		EasyMock.expect(mock.getParticipationsForEventId(0)).andReturn(participations).times(1);
		EasyMock.replay(mock);
		List<Participation> p2 = classUnderTest.getParticipationsForEventId(0);
		assertEquals(participations, p2);
		verify(mock);
	}
	
	@Test
	public void testGetParticipationsForUserId() {
		List<Participation> participations = new ArrayList<Participation>();
		Participation participation = new Participation();
		participation.setParticipationId(0);
		participations.add(participation);
		EasyMock.expect(mock.getParticipationsForUserId(0)).andReturn(participations).times(1);
		EasyMock.replay(mock);
		List<Participation> p2 = classUnderTest.getParticipationsForUserId(0);
		assertEquals(participations, p2);
		verify(mock);
	}
	
	
	@Test
	public void testSaveEvent() {
		Participation participation = new Participation();
		participation.setParticipationId(0);
		EasyMock.expect(mock.update(participation)).andReturn(participation).times(1);
		EasyMock.replay(mock);		
		Participation p2 = classUnderTest.saveParticipation(participation);		
		verify(mock);
		assertEquals(participation, p2);
	}

}

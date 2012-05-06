package de.ct.service;

import static org.easymock.EasyMock.createControl;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.ct.dao.EventDAO;
import de.ct.shared.Event;

public class EventServiceImplUnittest {

	private EventService classUnderTest;
	private EventDAO mock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		IMocksControl mockControl = createControl();
		mock = mockControl.createMock(EventDAO.class);
		classUnderTest = new EventServiceImpl(mock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateNewEvent() {
		Event event = new Event();
		event.setEventId(0);		
		EasyMock.expect(classUnderTest.createNewEvent()).andReturn(event).times(1);
		EasyMock.replay(mock);		
		Event e = classUnderTest.createNewEvent();
		assertEquals(event, e);
		verify(mock);
	}

	@Test
	public void testDeleteEvent() {
		Event event = new Event();
		event.setEventId(0);
		EasyMock.expect(mock.read(0)).andReturn(event);
		mock.delete(event);
		EasyMock.replay(mock);		
		classUnderTest.deleteEvent(0);		
		verify(mock);
	}

	@Test
	public void testFindEventById() {
		Event event = new Event();
		event.setEventId(0);
		EasyMock.expect(mock.read(0)).andReturn(event).times(1);
		EasyMock.replay(mock);		
		classUnderTest.findEventById(0);		
		verify(mock);		
	}

	@Test
	public void testSaveEvent() {
		Event event = new Event();
		event.setEventId(0);
		EasyMock.expect(mock.update(event)).andReturn(event).times(1);
		EasyMock.replay(mock);		
		Event e2 = classUnderTest.saveEvent(event);		
		verify(mock);
		assertEquals(event, e2);
	}

}

package de.ct.dao;

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

import de.ct.db.EventPersistence;
import de.ct.shared.Event;

public class EventDAOImplUnittest {

	private EventDAO classUnderTest;
	private EventPersistence mock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		IMocksControl mockControl = createControl();
		mock = mockControl.createMock(EventPersistence.class);
		classUnderTest = new EventDAOImpl(mock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		Event event = new Event();
		event.setEventId(0);
		Event e = classUnderTest.create();
		assertEquals(event, e);
	}

	@Test
	public void testRead() {
		Event event = new Event();
		event.setEventId(0);
		EasyMock.expect(classUnderTest.read(0)).andReturn(event).times(1);
		EasyMock.replay(mock);
		Event e2 = classUnderTest.read(0);
		assertEquals(event, e2);
		verify(mock);
	}

	@Test
	public void testUpdate() {
		Event event = new Event();
		EasyMock.expect(classUnderTest.update(event)).times(1);
		EasyMock.replay(mock);
		Event e2 = classUnderTest.update(event);
		assertEquals(event, e2);
		verify(mock);
	}

	@Test
	public void testDelete() {
		Event event = new Event();
		event.setEventId(0);
		mock.delete(event);
		EasyMock.replay(mock);		
		classUnderTest.delete(event);		
		verify(mock);
	}
}

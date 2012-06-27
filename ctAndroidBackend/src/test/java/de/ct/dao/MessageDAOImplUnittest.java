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

import de.ct.db.MessagePersistence;
import de.ct.shared.Message;

public class MessageDAOImplUnittest {

	private MessageDAO classUnderTest;
	private MessagePersistence mock;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		IMocksControl mockControl = createControl();
		mock = mockControl.createMock(MessagePersistence.class);
		classUnderTest = new MessageDAOImpl(mock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		Message message = new Message();
		message.setMessageId(0);
		Message m = classUnderTest.create();
		assertEquals(message.getMessageId(), m.getMessageId());
	}

	@Test
	public void testRead() {
		Message message = new Message();
		message.setEventId(0);
		EasyMock.expect(classUnderTest.read(0)).andReturn(message).times(1);
		EasyMock.replay(mock);
		Message m2 = classUnderTest.read(0);
		assertEquals(message, m2);
		verify(mock);
	}

	@Test
	public void testUpdate() {
		Message message = new Message();
		EasyMock.expect(classUnderTest.update(message)).times(1);
		EasyMock.replay(mock);
		Message m2 = classUnderTest.update(message);
		assertEquals(message, m2);
		verify(mock);
	}

	@Test
	public void testDelete() {
		Message message = new Message();
		message.setEventId(0);
		mock.delete(message);
		EasyMock.replay(mock);		
		classUnderTest.delete(message);		
		verify(mock);
	}

}

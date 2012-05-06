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

import de.ct.dao.MessageDAO;
import de.ct.shared.Message;

public class MessageServiceImplUnittest {

	private MessageService classUnderTest;	
	private MessageDAO mock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		IMocksControl mockControl = createControl();
		mock = mockControl.createMock(MessageDAO.class);
		classUnderTest = new MessageServiceImpl(mock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateNewMessage() {
		Message message = new Message();
		message.setMessageId(0);		
		EasyMock.expect(classUnderTest.createNewMessage()).andReturn(message).times(1);
		EasyMock.replay(mock);
		Message m = classUnderTest.createNewMessage();
		assertEquals(message, m);
		verify(mock);
	}

	@Test
	public void testDeleteMessage() {
		Message message = new Message();
		message.setMessageId(0);
		EasyMock.expect(mock.read(0)).andReturn(message);
		mock.delete(message);
		EasyMock.replay(mock);		
		classUnderTest.deleteMessage(0);		
		verify(mock);
	}

	@Test
	public void testFindMessageById() {
		Message message = new Message();
		message.setMessageId(0);
		EasyMock.expect(mock.read(0)).andReturn(message).times(1);
		EasyMock.replay(mock);		
		classUnderTest.findMessageById(0);		
		verify(mock);
	}

	@Test
	public void testSaveMessage() {
		Message message = new Message();
		message.setMessageId(0);
		EasyMock.expect(mock.update(message)).andReturn(message).times(1);
		EasyMock.replay(mock);		
		Message m2 = classUnderTest.saveMessage(message);		
		verify(mock);
		assertEquals(message, m2);
	}

}

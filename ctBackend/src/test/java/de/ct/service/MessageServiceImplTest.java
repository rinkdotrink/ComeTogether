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
import de.ct.shared.Message;

public class MessageServiceImplTest {

	MessageService messageService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new Module());
		messageService = injector.getInstance(MessageService.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateNewMessage() {
		assertNotNull(messageService.createNewMessage());
	}

	@Test
	public void testDeleteMessage() {
		Message message = messageService.createNewMessage();
		messageService.saveMessage(message);
		messageService.deleteMessage(message.getMessageId());
		Message m1 = null;

		m1 = messageService.findMessageById(message.getMessageId());
		assertNull(m1);
	}

	@Test
	public void testFindMessageById() {
		Message message = messageService.createNewMessage();
		messageService.saveMessage(message);
		boolean messageFound = false;

		if (messageService.findMessageById(message.getMessageId()) != null) {
			messageFound = true;
		}
		assertTrue(messageFound);
	}

	@Test
	public void testSaveMessage() {
		Message m = messageService.createNewMessage();
		m.setTextmessage("Hallo");
		messageService.saveMessage(m);
		Message messageFound = null;
		messageFound = messageService.findMessageById(m.getMessageId());
		assertTrue(messageFound.getTextmessage().equalsIgnoreCase("Hallo"));
	}

}

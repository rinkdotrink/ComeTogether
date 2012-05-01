package de.ct.dao;

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

public class MessageDAOImplTest {

	MessageDAO messageDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new Module());
		messageDAO = injector.getInstance(MessageDAO.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		Message m = messageDAO.create();
		assertNotNull(m);
	}

	@Test
	public void testRead() {
		Message m = messageDAO.create();
		m.setMessageId(1);
		messageDAO.update(m);
		Message m2 = null;

		m2 = messageDAO.read(1);

		assertNotNull(m2);
	}

	@Test
	public void testUpdate() {
		Message message = messageDAO.create();
		message.setTextmessage("Hallo");
		long messageId = message.getMessageId();
		messageDAO.update(message);
		boolean messageUpdated = false;

		messageUpdated = messageDAO.read(messageId).getTextmessage()
				.equalsIgnoreCase("Hallo");

		assertTrue(messageUpdated);
	}

	@Test
	public void testDelete() {
		Message message = messageDAO.create();
		long messageId = message.getMessageId();
		messageDAO.delete(message);
		Message m2 = null;
		m2 = messageDAO.read(messageId);

		assertNull(m2);
	}

}

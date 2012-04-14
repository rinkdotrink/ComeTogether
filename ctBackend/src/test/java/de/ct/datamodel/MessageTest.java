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

public class MessageTest {
	Message m;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new Module());
		m = injector.getInstance(Message.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMessageId() {
		m.setMessageId(1);
		assertEquals(1, m.getMessageId());
	}

	@Test
	public void testSetMessageId() {
		m.setMessageId(1);
		assertEquals(1, m.getMessageId());
	}

	@Test
	public void testGetEventId() {
		m.setEventId(1);
		assertEquals(1, m.getEventId());
	}

	@Test
	public void testSetEventId() {
		m.setEventId(1);
		assertEquals(1, m.getEventId());
	}

	@Test
	public void testGetSenderId() {
		m.setSenderId(1);
		assertEquals(1, m.getSenderId());
	}

	@Test
	public void testSetSenderId() {
		m.setSenderId(1);
		assertEquals(1, m.getSenderId());
	}

	@Test
	public void testGetRecipientId() {
		m.setRecipientId(1);
		assertEquals(1, m.getRecipientId());
	}

	@Test
	public void testSetRecipientId() {
		m.setRecipientId(1);
		assertEquals(1, m.getRecipientId());
	}

	@Test
	public void testGetTextmessage() {
		m.setTextmessage("1");
		assertTrue(m.getTextmessage().equalsIgnoreCase("1"));
	}

	@Test
	public void testSetTextmessage() {
		m.setTextmessage("1");
		assertTrue(m.getTextmessage().equalsIgnoreCase("1"));
	}

	@Test
	public void testHashCode() {
		m.setMessageId(1);
		assertEquals(1, m.hashCode());
	}

	@Test
	public void testEquals() {
		m.setMessageId(1);
		Message m2 = new Message();
		m2.setMessageId(1);
		assertTrue(m.equals(m2));
	}

}

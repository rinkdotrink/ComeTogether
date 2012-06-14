package de.datagenerator.generator.unittest;

import static org.easymock.EasyMock.createControl;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.GregorianCalendar;

import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.shared.Message;
import de.ct.shared.Product;
import de.datagenerator.DBModule;
import de.datagenerator.creator.Creator;
import de.datagenerator.generator.MessageGenerator;
import de.datagenerator.writer.IWriter;
import de.datagenerator.writer.MessageWriter;

public class MessageGeneratorTest {

	private MessageGenerator classUnderTest;
	private IWriter mock;
	private Injector injector = Guice.createInjector(new DBModule());

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		IMocksControl mockControl = createControl();
		mock = mockControl.createMock(MessageWriter.class);
		Creator creator = injector.getInstance(Creator.class);
		classUnderTest = new MessageGenerator(creator, mock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGenerateMessage_0() {
		long aUser = 0;
		long aMessagePerUser = 0;
		long aEventPerUser = 0;

		mock.close();
		replay(mock);
		classUnderTest.generateMessage(aMessagePerUser, aEventPerUser, aUser);
		verify(mock);
	}

	@Test
	public final void testGenerateMessage_1() {
		long aUser = 1;
		long aMessagePerUser = 1;
		long aEventPerUser = 1;

		Product message0 = new Message(0, 0, 0, 0, "textmessage0",
				new GregorianCalendar(1990, 1, 1));
		mock.write(message0);
		mock.close();
		replay(mock);
		classUnderTest.generateMessage(aMessagePerUser, aEventPerUser, aUser);
		verify(mock);
	}

	@Test
	public final void testGenerateMessages_2() {
		long aUser = 5;
		long aMessagePerUser = 1;
		long aEventPerUser = 1;

		Product message0 = new Message(0, 0, 0, 1, "textmessage0",
				new GregorianCalendar(1990, 1, 1));

		Product message1 = new Message(1, 1, 1, 2, "textmessage1",
				new GregorianCalendar(1990, 1, 1));

		Product message2 = new Message(2, 2, 2, 3, "textmessage2",
				new GregorianCalendar(1990, 1, 1));

		Product message3 = new Message(3, 3, 3, 4, "textmessage3",
				new GregorianCalendar(1990, 1, 1));

		Product message4 = new Message(4, 4, 4, 0, "textmessage4",
				new GregorianCalendar(1990, 1, 1));

		mock.write(message0);
		mock.write(message1);
		mock.write(message2);
		mock.write(message3);
		mock.write(message4);
		mock.close();

		replay(mock);
		classUnderTest.generateMessage(aMessagePerUser, aEventPerUser, aUser);
		verify(mock);
	}


	@Test
	public final void testGenerateMessages_3() {
		long aUser = 5;
		long aMessagePerUser = 2;
		long aEventPerUser = 1;

		Product message0 = new Message(0, 0, 0, 1, "textmessage0",
				new GregorianCalendar(1990, 1, 1));

		Product message1 = new Message(1, 1, 1, 2, "textmessage1",
				new GregorianCalendar(1990, 1, 1));

		Product message2 = new Message(2, 2, 2, 3, "textmessage2",
				new GregorianCalendar(1990, 1, 1));

		Product message3 = new Message(3, 3, 3, 4, "textmessage3",
				new GregorianCalendar(1990, 1, 1));

		Product message4 = new Message(4, 4, 4, 0, "textmessage4",
				new GregorianCalendar(1990, 1, 1));		
		
		Product message5 = new Message(5, 0, 0, 1, "textmessage5",
				new GregorianCalendar(1990, 1, 1));

		Product message6 = new Message(6, 1, 1, 2, "textmessage6",
				new GregorianCalendar(1990, 1, 1));

		Product message7 = new Message(7, 2, 2, 3, "textmessage7",
				new GregorianCalendar(1990, 1, 1));

		Product message8 = new Message(8, 3, 3, 4, "textmessage8",
				new GregorianCalendar(1990, 1, 1));

		Product message9 = new Message(9, 4, 4, 0, "textmessage9",
				new GregorianCalendar(1990, 1, 1));

		
		mock.write(message0);
		mock.write(message1);
		mock.write(message2);
		mock.write(message3);
		mock.write(message4);
		mock.write(message5);
		mock.write(message6);
		mock.write(message7);
		mock.write(message8);
		mock.write(message9);
		mock.close();

		replay(mock);
		classUnderTest.generateMessage(aMessagePerUser, aEventPerUser, aUser);
		verify(mock);
	}
	
	@Test
	public final void testGenerateMessages_4() {
		long aUser = 5;
		long aMessagePerUser = 2;
		long aEventPerUser = 2;

		Product message0 = new Message(0, 0, 0, 1, "textmessage0",
				new GregorianCalendar(1990, 1, 1));

		Product message1 = new Message(1, 1, 1, 2, "textmessage1",
				new GregorianCalendar(1990, 1, 1));

		Product message2 = new Message(2, 2, 2, 3, "textmessage2",
				new GregorianCalendar(1990, 1, 1));

		Product message3 = new Message(3, 3, 3, 4, "textmessage3",
				new GregorianCalendar(1990, 1, 1));

		Product message4 = new Message(4, 4, 4, 0, "textmessage4",
				new GregorianCalendar(1990, 1, 1));		
		
		Product message5 = new Message(5, 5, 0, 1, "textmessage5",
				new GregorianCalendar(1990, 1, 1));

		Product message6 = new Message(6, 6, 1, 2, "textmessage6",
				new GregorianCalendar(1990, 1, 1));

		Product message7 = new Message(7, 7, 2, 3, "textmessage7",
				new GregorianCalendar(1990, 1, 1));

		Product message8 = new Message(8, 8, 3, 4, "textmessage8",
				new GregorianCalendar(1990, 1, 1));

		Product message9 = new Message(9, 9, 4, 0, "textmessage9",
				new GregorianCalendar(1990, 1, 1));

		
		mock.write(message0);
		mock.write(message1);
		mock.write(message2);
		mock.write(message3);
		mock.write(message4);
		mock.write(message5);
		mock.write(message6);
		mock.write(message7);
		mock.write(message8);
		mock.write(message9);
		mock.close();

		replay(mock);
		classUnderTest.generateMessage(aMessagePerUser, aEventPerUser, aUser);
		verify(mock);
	}

}

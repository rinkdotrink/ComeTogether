package de.datagenerator.generator.unittest;

import static org.easymock.EasyMock.createControl;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

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
	private Random random;

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

		random = new Random(0);
		String textmessage = "textmessage " + randomSalsa();			
		int year = computeIntBetween0and4();
		int month = computeIntBetween1and12();
		Calendar date = new GregorianCalendar(2009 + year, month, 1);
		
		Product message0 = new Message(0, 0, 0, 0, textmessage,
				date);
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

		random = new Random(0);
		String textmessage = "textmessage " + randomSalsa();			
		int year = computeIntBetween0and4();
		int month = computeIntBetween1and12();
		Calendar date = new GregorianCalendar(2009 + year, month, 1);
		
		Product message0 = new Message(0, 0, 0, 1, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message1 = new Message(1, 1, 1, 2, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message2 = new Message(2, 2, 2, 3, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message3 = new Message(3, 3, 3, 4, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message4 = new Message(4, 4, 4, 0, textmessage,
				date);

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

		random = new Random(0);
		String textmessage = "textmessage " + randomSalsa();			
		int year = computeIntBetween0and4();
		int month = computeIntBetween1and12();
		Calendar date = new GregorianCalendar(2009 + year, month, 1);
		
		Product message0 = new Message(0, 0, 0, 1, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message1 = new Message(1, 1, 1, 2, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message2 = new Message(2, 2, 2, 3, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message3 = new Message(3, 3, 3, 4, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message4 = new Message(4, 4, 4, 0, textmessage,
				date);		
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);
		
		Product message5 = new Message(5, 0, 0, 1, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message6 = new Message(6, 1, 1, 2, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message7 = new Message(7, 2, 2, 3, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message8 = new Message(8, 3, 3, 4, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message9 = new Message(9, 4, 4, 0, textmessage,
				date);

		
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

		random = new Random(0);
		String textmessage = "textmessage " + randomSalsa();			
		int year = computeIntBetween0and4();
		int month = computeIntBetween1and12();
		Calendar date = new GregorianCalendar(2009 + year, month, 1);
		
		Product message0 = new Message(0, 0, 0, 1, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message1 = new Message(1, 1, 1, 2, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message2 = new Message(2, 2, 2, 3, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message3 = new Message(3, 3, 3, 4, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message4 = new Message(4, 4, 4, 0, textmessage,
				date);		
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);
		
		Product message5 = new Message(5, 5, 0, 1, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message6 = new Message(6, 6, 1, 2, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message7 = new Message(7, 7, 2, 3, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message8 = new Message(8, 8, 3, 4, textmessage,
				date);
		
		textmessage = "textmessage " + randomSalsa();			
		year = computeIntBetween0and4();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2009 + year, month, 1);

		Product message9 = new Message(9, 9, 4, 0, textmessage,
				date);
		
		
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
	

	private int computeIntBetween0and4() {
		double randomDouble = random.nextDouble();
		int int0_100 = (int) Math.ceil(randomDouble * 100);
		int int0_4 = int0_100 % 4;
		return int0_4;
	}
	
	private int computeIntBetween1and12() {
		double randomDouble = random.nextDouble();
		int int0_100 = (int) Math.ceil(randomDouble * 100);
		int int1_12 = int0_100 % 12 + 1;
		return int1_12;
	}
	
	private String randomSalsa() {
		String salsa = "";
		if (random.nextDouble() < 0.02) {
			salsa = "Salsa";
		}
		return salsa;
	}


}

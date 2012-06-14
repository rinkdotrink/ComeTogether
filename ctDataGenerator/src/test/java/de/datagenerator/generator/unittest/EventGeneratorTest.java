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

import de.ct.shared.Event;
import de.ct.shared.Product;
import de.datagenerator.DBModule;
import de.datagenerator.creator.Creator;
import de.datagenerator.generator.EventGenerator;
import de.datagenerator.writer.EventWriter;
import de.datagenerator.writer.IWriter;

public class EventGeneratorTest {

	private EventGenerator classUnderTest;
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
		mock = mockControl.createMock(EventWriter.class);
		Creator creator = injector.getInstance(Creator.class);
		classUnderTest = new EventGenerator(creator, mock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGenerateEvent_0() {
		long user = 0;
		long eventsPerUser = 0;

		mock.close();
		replay(mock);
		classUnderTest.generateEvent(user, eventsPerUser);
		verify(mock);
	}

	@Test
	public final void testGenerateEvent_1() {
		long user = 1;
		long eventsPerUser = 1;
		Product event0 = new Event(0,0,new GregorianCalendar(1990, 0, 1), "event0", "occasion0", "location0", "description0",2,2, 0,0);
		mock.write(event0);
		mock.close();
		replay(mock);
		classUnderTest.generateEvent(user, eventsPerUser);
		verify(mock);
	}

	@Test
	public final void testGenerateEvent_2() {
		long user = 2;
		long eventsPerUser = 2;
		Product event0 = new Event(0,0,new GregorianCalendar(1990, 0, 1), "event0", "occasion0", "location0", "description0",2,2,0,0);
		Product event1 = new Event(1,1,new GregorianCalendar(1990, 0, 1), "event1", "occasion1", "location1", "description1",2,2,0,0);
		Product event2 = new Event(2,0,new GregorianCalendar(1990, 0, 1), "event2", "occasion2", "location2", "description2",2,2,0,0);
		Product event3 = new Event(3,1,new GregorianCalendar(1990, 0, 1), "event3", "occasion3", "location3", "description3",2,2,0,0);
		mock.write(event0);
		mock.write(event1);
		mock.write(event2);
		mock.write(event3);
		mock.close();
		replay(mock);
		classUnderTest.generateEvent(user, eventsPerUser);
		verify(mock);
	}
}

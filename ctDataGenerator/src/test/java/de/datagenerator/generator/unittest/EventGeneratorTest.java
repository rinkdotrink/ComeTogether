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
		
		random = new Random(0);
		int year = computeIntBetween0and2();
		int month = computeIntBetween1and12();
		Calendar date = new GregorianCalendar(2011 + year, month, 1);
		int numberMaleConfirmed = 3 * computeIntBetween1and12();
		int numberFemaleConfirmed = 6 * computeIntBetween1and12();
		double lon = computeDoubleBetween0and360() + random.nextDouble();
		double lat = computedDoubleBetween0and180() + random.nextDouble();
		
		Product event0 = new Event(0,0, date, "event0", "occasion0", "location0", "description0",numberMaleConfirmed ,numberFemaleConfirmed , lon, lat);
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

		random = new Random(0);
		int year = computeIntBetween0and2();
		int month = computeIntBetween1and12();
		Calendar date = new GregorianCalendar(2011 + year, month, 1);
		int numberMaleConfirmed = 3 * computeIntBetween1and12();
		int numberFemaleConfirmed = 6 * computeIntBetween1and12();
		double lon = computeDoubleBetween0and360() + random.nextDouble();
		double lat = computedDoubleBetween0and180() + random.nextDouble();

		Product event0 = new Event(0,0, date, "event0", "occasion0", "location0", "description0",numberMaleConfirmed ,numberFemaleConfirmed , lon,lat);
		
		year = computeIntBetween0and2();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2011 + year, month, 1);
		numberMaleConfirmed = 3 * computeIntBetween1and12();
		numberFemaleConfirmed = 6 * computeIntBetween1and12();
		lon = computeDoubleBetween0and360() + random.nextDouble();
		lat = computedDoubleBetween0and180() + random.nextDouble();
		
		Product event1 = new Event(1,1, date, "event1", "occasion1", "location1", "description1",numberMaleConfirmed ,numberFemaleConfirmed , lon,lat);

		year = computeIntBetween0and2();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2011 + year, month, 1);
		numberMaleConfirmed = 3 * computeIntBetween1and12();
		numberFemaleConfirmed = 6 * computeIntBetween1and12();
		lon = computeDoubleBetween0and360() + random.nextDouble();
		lat = computedDoubleBetween0and180() + random.nextDouble();
		
		Product event2 = new Event(2,0, date, "event2", "occasion2", "location2", "description2",numberMaleConfirmed ,numberFemaleConfirmed , lon,lat);

		year = computeIntBetween0and2();
		month = computeIntBetween1and12();
		date = new GregorianCalendar(2011 + year, month, 1);
		numberMaleConfirmed = 3 * computeIntBetween1and12();
		numberFemaleConfirmed = 6 * computeIntBetween1and12();
		lon = computeDoubleBetween0and360() + random.nextDouble();
		lat = computedDoubleBetween0and180() + random.nextDouble();
		
		Product event3 = new Event(3,1, date, "event3", "occasion3", "location3", "description3",numberMaleConfirmed ,numberFemaleConfirmed , lon,lat);

		mock.write(event0);
		mock.write(event1);
		mock.write(event2);
		mock.write(event3);
		mock.close();
		replay(mock);
		classUnderTest.generateEvent(user, eventsPerUser);
		verify(mock);
	}
	
	private int computeIntBetween0and2() {
		double randomDouble = random.nextDouble();
		int int0_100 = (int) Math.ceil(randomDouble * 100);
		int int0_2 = int0_100 % 3;
		return int0_2;
	}
	
	private int computeIntBetween1and12() {
		double randomDouble = random.nextDouble();
		int int0_100 = (int) Math.ceil(randomDouble * 100);
		int int1_12 = int0_100 % 12 + 1;
		return int1_12;
	}
	
	private double computedDoubleBetween0and180() {
		double randomDouble = random.nextDouble();
		int int0_1000 = (int) Math.ceil(randomDouble * 1000);
		int int0_180 = int0_1000 % 181;
		double double0_180 = int0_180;
		return double0_180;
	}
	
	private double computeDoubleBetween0and360() {
		double randomDouble = random.nextDouble();
		int int0_1000 = (int) Math.ceil(randomDouble * 1000);
		int int0_360 = int0_1000 % 361;
		double double0_360 = int0_360;
		return double0_360;
	}
}

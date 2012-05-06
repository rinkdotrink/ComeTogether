package de.ct.datamodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.Module;
import de.ct.shared.Event;

public class EventUnittest {

	Event event;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new Module());
		event = injector.getInstance(Event.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetEventId() {
		event.setEventId(1);
		assertEquals(1, event.getEventId());
	}

	@Test
	public void testSetEventId() {
		event.setEventId(1);
		assertEquals(1, event.getEventId());
	}

	@Test
	public void testGetDate() {
		GregorianCalendar calendar = new GregorianCalendar(2000, 7, 1);
		event.setDate(calendar);
		assertEquals(calendar, event.getDate());		
	}

	@Test
	public void testSetDate() {
		GregorianCalendar calendar = new GregorianCalendar(2000, 7, 1);
		event.setDate(calendar);
		assertEquals(calendar, event.getDate());
	}

	@Test
	public void testGetEventname() {
		event.setEventname("name1");
		assertTrue(event.getEventname().equalsIgnoreCase("name1"));
	}

	@Test
	public void testSetEventname() {
		event.setEventname("name1");
		assertTrue(event.getEventname().equalsIgnoreCase("name1"));
	}

	@Test
	public void testGetOccasion() {
		event.setOccasion("occasion");
		assertTrue(event.getOccasion().equalsIgnoreCase("occasion"));
	}

	@Test
	public void testSetOccasion() {
		event.setOccasion("occasion");
		assertTrue(event.getOccasion().equalsIgnoreCase("occasion"));
	}

	@Test
	public void testGetLocation() {
		event.setLocation("location1");
		assertTrue(event.getLocation().equalsIgnoreCase("location1"));
	}

	@Test
	public void testSetLocation() {
		event.setLocation("location1");
		assertTrue(event.getLocation().equalsIgnoreCase("location1"));
	}

	@Test
	public void testGetGps() {
		List<String> gpsArray = new ArrayList<String>();
		gpsArray.add("1");
		gpsArray.add("2");
		gpsArray.add("3");
		event.setGps(gpsArray);
		assertEquals(gpsArray, event.getGps());
	}

	@Test
	public void testSetGps() {
		List<String> gpsArray = new ArrayList<String>();
		gpsArray.add("1");
		gpsArray.add("2");
		gpsArray.add("3");
		event.setGps(gpsArray);
		assertEquals(gpsArray, event.getGps());
	}

	@Test
	public void testGetDescription() {
		event.setDescription("description");
		assertTrue(event.getDescription().equalsIgnoreCase("description"));
	}

	@Test
	public void testSetDescription() {
		event.setDescription("description");
		assertTrue(event.getDescription().equalsIgnoreCase("description"));
	}

	@Test
	public void testGetNumberMaleConfirmed() {
		event.setNumberMaleConfirmed(2);
		assertTrue(event.getNumberMaleConfirmed() == 2);
	}

	@Test
	public void testSetNumberMaleConfirmed() {
		event.setNumberMaleConfirmed(2);
		assertTrue(event.getNumberMaleConfirmed() == 2);
	}

	@Test
	public void testGetNumberFemaleConfirmed() {
		event.setNumberFemaleConfirmed(2);
		assertTrue(event.getNumberFemaleConfirmed() == 2);
	}

	@Test
	public void testSetNumberFemaleConfirmed() {
		event.setNumberFemaleConfirmed(2);
		assertTrue(event.getNumberFemaleConfirmed() == 2);
	}

	@Test
	public void testHashCode() {
		event.setEventId(1);
		assertTrue(event.hashCode() == 1);
	}

	@Test
	public void testEquals() {
		Event event2 = new Event();
		event2.setEventId(1);
		event.setEventId(1);
		assertTrue(event.equals(event2));
	}

}

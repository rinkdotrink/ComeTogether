package de.datagenerator.generator;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import de.datagenerator.creator.Creator;
import de.datagenerator.writer.IWriter;

public class EventGenerator extends Generator {

	private Random random = new Random(0);
	
	@Inject
	public EventGenerator(final Creator aCreator,
			@Named("Event") final IWriter aDbWriter) {
		setCreator(aCreator);
		setDBWriter(aDbWriter);
	}

	@Override
	public final void generateEvent(final long aUser, final long aEventPerUser) {
		long aEvents = aUser * aEventPerUser;
		long eventId = 0;		
		long creatorId = 0;
		Calendar date;
		String eventname = "";
		String occasion = "";
		String location = "";
		String description = "";
		Integer numberMaleConfirmed = 0;
		Integer numberFemaleConfirmed = 0;
		double lon = 0;
		double lat = 0;
		for (long i = 0; i < aEvents; i++) {
			eventId = i;
			creatorId = i % aUser;
			int year = computeIntBetween0and2();
			int month = computeIntBetween1and12();
			date = new GregorianCalendar(2011 + year, month, 1);
			eventname = "event" + i;
			occasion = "occasion" + i;
			location = "location" + i;
			description = "description" + i;
			numberMaleConfirmed = 3 * computeIntBetween1and12();
			numberFemaleConfirmed = 6 * computeIntBetween1and12();
			lon = computeDoubleBetween0and360() + random.nextDouble();
			lat = computedDoubleBetween0and180() + random.nextDouble();			
			setProduct(getCreator().createEvent(eventId, creatorId, date,
					eventname, occasion, location, description,
					numberMaleConfirmed, numberFemaleConfirmed, lon, lat));
			getDBWriter().write(getProduct());
		}
		getDBWriter().close();
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
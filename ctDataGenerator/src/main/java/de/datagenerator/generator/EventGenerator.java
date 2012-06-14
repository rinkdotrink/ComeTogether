package de.datagenerator.generator;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import de.datagenerator.creator.Creator;
import de.datagenerator.writer.IWriter;

public class EventGenerator extends Generator {

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
		Calendar date = new GregorianCalendar(1990, 0, 1);
		String eventname = "";
		String occasion = "";
		String location = "";
		String description = "";
		Integer numberMaleConfirmed = 0;
		Integer numberFemaleConfirmed = 0;
		double lonRad = 0;
		double latRad = 0;
		for (long i = 0; i < aEvents; i++) {
			eventId = i;
			creatorId = i % aUser;
			eventname = "event" + i;
			occasion = "occasion" + i;
			location = "location" + i;
			description = "description" + i;
			numberMaleConfirmed = 2;
			numberFemaleConfirmed = 2;
			setProduct(getCreator().createEvent(eventId, creatorId, date,
					eventname, occasion, location, description,
					numberMaleConfirmed, numberFemaleConfirmed, lonRad, latRad));
			getDBWriter().write(getProduct());
		}
		getDBWriter().close();
	}
}
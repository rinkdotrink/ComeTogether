package de.ct.dao;

import java.util.ArrayList;
import java.util.List;

import de.ct.shared.Event;

public class EventDAOImpl implements EventDAO {

	private List<Event> events = new ArrayList<Event>();
	private static long eventId = 0;

	@Override
	public Event create() {
		Event e = new Event();
		eventId++;
		e.setEventId(eventId);
		events.add(e);
		return e;
	}

	@Override
	public Event read(final long aEventId) {
		Event temp = findEvent(aEventId);
		return temp;
	}

	@Override
	public Event update(final Event aEvent) {
		Event temp = findEvent(aEvent.getEventId());
		copyAttributes(temp, aEvent);
		return temp;
	}

	@Override
	public void delete(final Event aEvent) {
		events.remove(aEvent);
	}

	@Override
	public List<Event> findAll() {
		return events;
	}

	private void copyAttributes(final Event aTemp, final Event aEvent) {
		aTemp.setDate(aEvent.getDate());
		aTemp.setDescription(aEvent.getDescription());
		aTemp.setEventname(aEvent.getEventname());
		aTemp.setGps(aEvent.getGps());
		aTemp.setLocation(aEvent.getLocation());
		aTemp.setNumberFemaleConfirmed(aEvent.getNumberFemaleConfirmed());
		aTemp.setNumberMaleConfirmed(aEvent.getNumberMaleConfirmed());		
	}

	private Event findEvent(final long aEventId) {
		Event temp = null;
		for (Event e : events) {
			if (e.getEventId() == aEventId) {
				temp = e;
			}
		}
		return temp;
	}

}

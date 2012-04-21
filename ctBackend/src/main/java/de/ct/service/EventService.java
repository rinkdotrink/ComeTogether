package de.ct.service;

import java.util.List;

import de.ct.shared.Event;

public interface EventService {

	public Event createNewEvent();

	public void deleteEvent(final long aEventId);

	public Event findEventById(final long aEventId);

	public List<Event> getEvents();

	public Event saveEvent(final Event aEvent);
}

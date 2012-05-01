package de.ct.service;

import de.ct.shared.Event;

public interface EventService {

	public Event createNewEvent();

	public void deleteEvent(final long aEventId);

	public Event findEventById(final long aEventId);

	public Event saveEvent(final Event aEvent);
}

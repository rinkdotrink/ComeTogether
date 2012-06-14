package de.ct.service;

import com.google.inject.Inject;

import de.ct.dao.EventDAO;
import de.ct.shared.Event;

public class EventServiceImpl implements EventService {

	private EventDAO eventDAO;

	@Inject
	public EventServiceImpl(final EventDAO aEventDAO) {
		this.eventDAO = aEventDAO;
	}

	@Override
	public Event createNewEvent() {
		return eventDAO.create();
	}

	@Override
	public void deleteEvent(final long aEventId) {
		Event event = eventDAO.read(aEventId);
		eventDAO.delete(event);
	}

	@Override
	public Event findEventById(final long aEventId) {
		return eventDAO.read(aEventId);
	}

	@Override
	public Event saveEvent(final Event aEvent) {
		return eventDAO.update(aEvent);
	}

}

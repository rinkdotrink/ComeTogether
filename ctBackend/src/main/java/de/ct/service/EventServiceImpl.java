package de.ct.service;

import java.util.List;

import com.google.inject.Inject;

import de.ct.dao.EventDAO;
import de.ct.shared.Event;

public class EventServiceImpl implements EventService {

	EventDAO eventDAO;

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
		Event event;
		event = eventDAO.read(aEventId);
		eventDAO.delete(event);
	}

	@Override
	public Event findEventById(final long aEventId) {
		return eventDAO.read(aEventId);
	}

	@Override
	public List<Event> getEvents() {
		return eventDAO.findAll();
	}

	@Override
	public Event saveEvent(final Event aEvent) {
		return eventDAO.update(aEvent);
	}

}

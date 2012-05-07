package de.ct.dao;

import com.google.inject.Inject;

import de.ct.db.EventPersistence;
import de.ct.shared.Event;

public class EventDAOImpl implements EventDAO {

	private static long eventId = 0;
	
	private EventPersistence db;
	
	@Inject
	public EventDAOImpl(EventPersistence eventPersistence){
		this.db = eventPersistence;
	}
	
	public EventDAOImpl() {
		
	}

	@Override
	public Event create() {
		Event e = new Event();		
		e.setEventId(eventId);
		eventId++;
		return e;
	}

	@Override
	public Event read(final long aEventId) {
		Event event = db.read(aEventId);
		return event;
	}

	@Override
	public Event update(final Event aEvent) {
		db.update(aEvent);
		return aEvent;
	}

	@Override
	public void delete(final Event aEvent) {
		db.delete(aEvent);
	}
}

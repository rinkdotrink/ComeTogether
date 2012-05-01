package de.ct.dao;

import de.ct.db.EventPersistence;
import de.ct.db.EventPersistenceImpl;
import de.ct.shared.Event;

public class EventDAOImpl implements EventDAO {

	private static long eventId = 0;
	
	private EventPersistence db = new EventPersistenceImpl();

	@Override
	public Event create() {
		Event e = new Event();
		eventId++;
		e.setEventId(eventId);
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

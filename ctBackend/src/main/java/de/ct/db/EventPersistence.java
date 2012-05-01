package de.ct.db;

import de.ct.shared.Event;

public interface EventPersistence {

	public Event read(final long aEventId);
	
	public void update(final Event aEvent);

	public void delete(final Event aEvent);

}

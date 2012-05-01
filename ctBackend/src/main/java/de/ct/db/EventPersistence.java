package de.ct.db;

import de.ct.shared.Event;

public interface EventPersistence {

	public abstract Event read(final long aEventId);
	
	public abstract void update(final Event aEvent);

	public abstract void delete(final Event aEvent);

}

package de.ct.dao;

import java.util.List;

import de.ct.shared.Event;

public interface EventDAO {

	public Event create();

	public Event read(final long aEventId);

	public Event update(final Event aEvent);

	public void delete(final Event aEvent);

	public List<Event> findAll();
}

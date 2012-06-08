package de.ct.client.clients;

import de.ct.client.creator.EventCreator;
import de.ct.client.deleter.EventDeleter;
import de.ct.client.reader.EventReader;
import de.ct.shared.Event;

public class EventClient {

	private EventCreator eventCreator;
	private EventDeleter eventDeleter;
	private EventReader eventReader;

	public EventClient() {
		eventCreator = new EventCreator();
		eventDeleter = new EventDeleter();
		eventReader = new EventReader();
	}

	public Event createEvent(final Event aEvent) {
		Event event = eventCreator.createEvent(aEvent);
		return event;
	}

	public Event readEvent(final long aEventId) {
		Event event = eventReader.readEvent(aEventId);
		return event;
	}

	 public void deleteEvent(final long aEventId) {	 
		 eventDeleter.deleteEvent(aEventId);
	 }

}

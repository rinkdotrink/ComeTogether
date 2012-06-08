package de.ct.client.creator;

import de.ct.shared.Event;

public class EventCreator extends Creator {	

	public Event createEvent(final Event aEvent) {
		initConnection("http://10.0.2.2:8080/ctBackend/ctEvent/createEvent");
		Event event = (Event) writeProduct(aEvent);
		return event;
	}
}

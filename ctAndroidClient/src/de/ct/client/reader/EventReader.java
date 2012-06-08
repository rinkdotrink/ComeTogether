package de.ct.client.reader;

import de.ct.shared.Event;

public class EventReader extends Reader {

	public Event readEvent(final long aId) {
		initConnection("http://10.0.2.2:8080/ctBackend/ctEvent/readEvent");
		Event event = (Event) getProduct(aId, new Event());
		return event;
	}
	
}

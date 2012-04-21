package de.ct.webservice;

import de.ct.shared.Event;


public interface EventServerREST {

	public void Event(Event aEvent);
	
	public Event Event(String aEventId);
	
	public void deleteEvent(String aEventId);

}

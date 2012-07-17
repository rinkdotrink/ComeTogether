package de.ct.webservice;

import de.ct.shared.Event;


public interface EventServerREST {

	public Event createEvent(String aEvent);
	
	public Event readEvent(String aEventId);
	
	public String deleteEvent(String aEventId);

}

package de.ct.webservice;

import de.ct.shared.Event;


public interface EventServerREST {

	public Event Event1(String aEvent);
	
	public Event Event2(String aEventId);
	
	public String deleteEvent(String aEventId);

}

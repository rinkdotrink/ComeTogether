package de.ct.webservice;

import javax.ws.rs.core.Response;

import de.ct.shared.Event;


public interface EventServerREST {

	public Event Event(Event aEvent);
	
	public Event Event(String aEventId);
	
	public Response deleteEvent(String aEventId);

}

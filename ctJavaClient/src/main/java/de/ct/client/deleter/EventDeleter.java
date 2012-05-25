package de.ct.client.deleter;



public class EventDeleter extends Deleter {
	

	public void deleteEvent(final long aId) {
		initConnection("http://localhost:8080/ctBackend/ctEvent/deleteEvent");
		write(aId);
		evaluateServerResponse();		
	}

}

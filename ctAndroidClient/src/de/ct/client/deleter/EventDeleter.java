package de.ct.client.deleter;

public class EventDeleter extends Deleter {

	public void deleteEvent(final long aId) {
		initConnection("http://10.0.2.2:8080/ctBackend/ctEvent/deleteEvent");
		writeProduct(aId);
	}

}

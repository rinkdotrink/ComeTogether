package de.ct.client;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import de.ct.shared.Event;

public class MyEventClient {

	WebResource service;

	public MyEventClient() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		service = client.resource(getBaseURI());
	}

	public void createEvent(Event aEvent) {
		service.path("rest").path("ctEvent").path("createEvent").type("text/xml; charset=utf-8")
				.accept("text/xml; charset=utf-8")
				.post(ClientResponse.class, aEvent);
	}

	public Event readEvent(long aEventId) {
		Event event= service.path("rest").path("ctEvent").path("readEvent")
				.type("text/xml; charset=utf-8")
				.accept("text/xml; charset=utf-8")
				.post(Event.class, String.valueOf(aEventId));
		return event;
	}
	
//	public List<Message> getMessages() {
//		List<Message> list = service.path("rest").path("ctEvent")
//				.type("text/xml; charset=utf-8")
//				.get((new GenericType<List<Message>>() {
//				}));
//		return list;
//	}

	public void deleteEvent(int eventId) {
		service.path("rest").path("ctEvent").path("deleteEvent")
				.type("text/xml; charset=utf-8")
				.accept("text/xml; charset=utf-8")
				.post(ClientResponse.class, String.valueOf(eventId));
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/ctBackend").build();
	}
}

package de.ct.client;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import de.ct.shared.Participation;

public class MyParticipationClient {

	WebResource service;

	public MyParticipationClient() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		service = client.resource(getBaseURI());
	}

	public void createParticipation(Participation aParticipation) {
		service.path("rest").path("ctParticipation").path("createParticipation").type("text/xml; charset=utf-8")
				.accept("text/xml; charset=utf-8")
				.post(ClientResponse.class, aParticipation);
	}

	public List<Participation> ParticipationsForEventId(final long aEventId) {
		List<Participation> participations = service.path("rest").path("ctParticipation").path("ParticipationsForEventId")
				.type("text/xml; charset=utf-8")
				.accept("text/xml; charset=utf-8")
				.post(new GenericType<List<Participation>>() {}, String.valueOf(aEventId));
		return participations;
	}
	
	public List<Participation> ParticipationsForUserId(final long aUserId) {
		List<Participation> participations = service.path("rest").path("ctParticipation").path("ParticipationsForUserId")
				.type("text/xml; charset=utf-8")
				.accept("text/xml; charset=utf-8")
				.post(new GenericType<List<Participation>>() {}, String.valueOf(aUserId));
		return participations;
	}
	
//	public List<Message> getUsers() {
//		List<User> list = service.path("rest").path("ctUser")
//				.type("text/xml; charset=utf-8")
//				.get((new GenericType<List<User>>() {
//				}));
//		return list;
//	}

	public void deleteParticipation(int participationId) {
		service.path("rest").path("ctParticipation").path("deleteParticipation")
				.type("text/xml; charset=utf-8")
				.accept("text/xml; charset=utf-8")
				.post(ClientResponse.class, String.valueOf(participationId));
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/ctBackend").build();
	}
}

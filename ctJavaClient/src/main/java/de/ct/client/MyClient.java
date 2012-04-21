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

import de.ct.shared.Message;

public class MyClient {

	WebResource service;

	public MyClient() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		service = client.resource(getBaseURI());
	}

	public void createMessage(Message aMessage) {
		service.path("rest").path("ct").path("createMessage").type("text/xml; charset=utf-8")
				.accept("text/xml; charset=utf-8")
				.post(ClientResponse.class, aMessage);
	}

	public Message readMessage(long aMessageId) {
		Message message = service.path("rest").path("ct").path("readMessage")
				.type("text/xml; charset=utf-8")
				.accept("text/xml; charset=utf-8")
				.post(Message.class, String.valueOf(aMessageId));
		return message;
	}
	
//	public List<Message> getMessages() {
//		List<Message> list = service.path("rest").path("ct")
//				.type("text/xml; charset=utf-8")
//				.get((new GenericType<List<Message>>() {
//				}));
//		return list;
//	}

	public void deleteMessage(int messageId) {
		service.path("rest").path("ct").path("deleteMessage")
				.type("text/xml; charset=utf-8")
				.accept("text/xml; charset=utf-8")
				.post(ClientResponse.class, String.valueOf(messageId));
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/ctBackend").build();
	}
}

package de.ct.client;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import de.ct.shared.User;

public class MyUserClient {

	WebResource service;

	public MyUserClient() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		service = client.resource(getBaseURI());
	}

	public void createUser(User aUser) {
		service.path("rest").path("ctUser").path("createUser").type("text/xml; charset=utf-8")
				.accept("text/xml; charset=utf-8")
				.post(ClientResponse.class, aUser);
	}

	public User readUser(long aUserId) {
		User user = service.path("rest").path("ctUser").path("readUser")
				.type("text/xml; charset=utf-8")
				.accept("text/xml; charset=utf-8")
				.post(User.class, String.valueOf(aUserId));
		return user;
	}
	
//	public List<Message> getUsers() {
//		List<User> list = service.path("rest").path("ctUser")
//				.type("text/xml; charset=utf-8")
//				.get((new GenericType<List<User>>() {
//				}));
//		return list;
//	}

	public void deleteUser(int userId) {
		service.path("rest").path("ctUser").path("deleteUser")
				.type("text/xml; charset=utf-8")
				.accept("text/xml; charset=utf-8")
				.post(ClientResponse.class, String.valueOf(userId));
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/ctBackend").build();
	}
}

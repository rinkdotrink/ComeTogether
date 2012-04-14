package de.ct.client;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import de.ct.shared.Message;

public class MyClient {
	
	WebResource service;
	
	public MyClient(){
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		service = client.resource(getBaseURI());		
	}
	
	public String sayHelloWorld(){
		String helloWorld;
		helloWorld = service.path("rest").path("ct")
				.type("text/xml; charset=utf-8")
				.get(String.class);
		return helloWorld;
	}
	
	public void postMessage(Message aMessage){
		
		
service.path("rest").path("ct")
				.type("text/xml; charset=utf-8")
				.accept("text/xml; charset=utf-8")
				.post(ClientResponse.class, aMessage);

	}
		
	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"http://localhost:8080/ctBackend").build();
	}	

}

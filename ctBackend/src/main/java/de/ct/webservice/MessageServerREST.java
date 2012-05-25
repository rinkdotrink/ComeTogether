package de.ct.webservice;

import javax.ws.rs.core.Response;

import de.ct.shared.Message;


public interface MessageServerREST {

	public Message Message(Message aMessage);
	
	public Message Message(String aMessageId);
	
	public Response deleteMessage(String aMessageId);
	
	

}

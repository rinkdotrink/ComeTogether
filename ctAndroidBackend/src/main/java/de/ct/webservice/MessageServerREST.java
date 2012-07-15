package de.ct.webservice;

import de.ct.shared.Message;


public interface MessageServerREST {

	public Message createMessage(String aMessage);
	
	public Message readMessage(String aMessageId);
	
	public String deleteMessage(String aMessageId);
	
	

}

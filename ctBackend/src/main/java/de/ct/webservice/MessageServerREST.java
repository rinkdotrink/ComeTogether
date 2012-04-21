package de.ct.webservice;

import de.ct.shared.Message;


public interface MessageServerREST {

	public void Message(Message aMessage);
	
	public Message Message(String aMessageId);
	
	public void deleteMessage(String aMessageId);
	
	

}

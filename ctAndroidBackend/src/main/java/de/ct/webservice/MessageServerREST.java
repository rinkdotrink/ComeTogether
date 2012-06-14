package de.ct.webservice;

import de.ct.shared.Message;


public interface MessageServerREST {

	public Message Message1(String aMessage);
	
	public Message Message2(String aMessageId);
	
	public String deleteMessage(String aMessageId);
	
	

}

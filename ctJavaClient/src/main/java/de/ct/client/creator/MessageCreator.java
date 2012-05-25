package de.ct.client.creator;

import de.ct.shared.Message;

public class MessageCreator extends Creator{
	
	public Message createMessage(final Message aMessage) {
		initConnection("http://localhost:8080/ctBackend/ctMessage/createMessage");
		Message message = (Message) writeProduct(aMessage);
		return message;
	}
}

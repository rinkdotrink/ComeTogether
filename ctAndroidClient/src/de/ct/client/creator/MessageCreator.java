package de.ct.client.creator;

import de.ct.shared.Message;

public class MessageCreator extends Creator{
	
	public Message createMessage(final Message aMessage) {
		initConnection("http://10.0.2.2:8080/ctBackend/ctMessage/createMessage");
		Message message = (Message) writeProduct(aMessage);
		return message;
	}
}

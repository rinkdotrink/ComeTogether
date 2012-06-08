package de.ct.client.reader;

import de.ct.shared.Message;

public class MessageReader extends Reader {
	
	public Message readMessage(final long aId) {
		initConnection("http://10.0.2.2:8080/ctBackend/ctMessage/readMessage");
		Message message = (Message) getProduct(aId, new Message());
		return message;
	}	
}

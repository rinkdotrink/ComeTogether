package de.ct.client.clients;

import de.ct.client.creator.MessageCreator;
import de.ct.client.deleter.MessageDeleter;
import de.ct.client.reader.MessageReader;
import de.ct.shared.Message;

public class MessageClient {

	private MessageCreator messageCreator;
	private MessageReader messageReader;
	private MessageDeleter messageDeleter;

	public MessageClient() {
		messageCreator = new MessageCreator();
		messageReader = new MessageReader();
		messageDeleter = new MessageDeleter();
	}

	public Message createMessage(final Message aMessage) {
		Message message = messageCreator.createMessage(aMessage);
		return message;
	}

	public Message readMessage(final long aMessageId) {	
		Message message = messageReader.readMessage(aMessageId);
		return message;
	}	

	public void deleteMessage(final long aMessageId) {
		messageDeleter.deleteMessage(aMessageId);
	}

}

package de.ct.service;

import de.ct.shared.Message;

public interface MessageService {

	public Message createNewMessage();

	public void deleteMessage(final long aMessageId);

	public Message findMessageById(final long aMessageId);

	public Message saveMessage(final Message aMessage);
}

package de.ct.service;

import java.util.List;

import de.ct.shared.Message;

public interface MessageService {

	public Message createNewMessage();

	public void deleteMessage(final long aMessageId);

	public Message findMessageById(final long aMessageId);

	public List<Message> getMessages();

	public Message saveMessage(final Message aMessage);
}

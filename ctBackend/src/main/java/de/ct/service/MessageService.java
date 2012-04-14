package de.ct.service;

import java.util.List;

import de.ct.datamodel.Message;

public interface MessageService {

	public Message createNewMessage();

	public void deleteMessage(long messageId);

	public Message findMessageById(long messageId);

	public List<Message> getMessages();

	public Message saveMessage(Message message);
}

package de.ct.service;

import com.google.inject.Inject;

import de.ct.dao.MessageDAO;
import de.ct.shared.Message;

public class MessageServiceImpl implements MessageService {

	MessageDAO messageDAO;

	@Inject
	public MessageServiceImpl(final MessageDAO aMessageDAO) {
		this.messageDAO = aMessageDAO;
	}

	@Override
	public Message createNewMessage() {
		return messageDAO.create();
	}

	@Override
	public void deleteMessage(final long aMessageId) {
		Message message;
		message = messageDAO.read(aMessageId);
		messageDAO.delete(message);
	}

	@Override
	public Message findMessageById(final long aMessageId) {
		return messageDAO.read(aMessageId);
	}

	@Override
	public Message saveMessage(final Message aMessage) {
		return messageDAO.update(aMessage);
	}

}

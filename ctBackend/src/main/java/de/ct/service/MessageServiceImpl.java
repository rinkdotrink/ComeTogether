package de.ct.service;

import java.util.List;

import com.google.inject.Inject;

import de.ct.dao.MessageDAO;
import de.ct.datamodel.Message;

public class MessageServiceImpl implements MessageService {

	MessageDAO messageDAO;

	@Inject
	public MessageServiceImpl(MessageDAO aMessageDAO) {
		this.messageDAO = aMessageDAO;
	}

	@Override
	public Message createNewMessage() {
		return messageDAO.create();
	}

	@Override
	public void deleteMessage(long messageId) {
		Message message;
		message = messageDAO.read(messageId);
		messageDAO.delete(message);
	}

	@Override
	public Message findMessageById(long messageId) {
		return messageDAO.read(messageId);
	}

	@Override
	public List<Message> getMessages() {
		return messageDAO.findAll();
	}

	@Override
	public Message saveMessage(Message message) {
		return messageDAO.update(message);
	}

}

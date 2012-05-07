package de.ct.dao;

import com.google.inject.Inject;

import de.ct.db.MessagePersistence;
import de.ct.shared.Message;

public class MessageDAOImpl implements MessageDAO {

	private MessagePersistence db;

	private static long messageId = 0;

	@Inject
	public MessageDAOImpl(MessagePersistence messagePersistence) {
		this.db = messagePersistence;
	}

	public MessageDAOImpl() {

	}

	@Override
	public Message create() {
		Message m = new Message();
		m.setMessageId(messageId);
		messageId++;
		return m;
	}

	@Override
	public Message read(final long aMessageId) {
		Message message = db.read(aMessageId);
		return message;
	}

	@Override
	public Message update(final Message aMessage) {
		db.update(aMessage);
		return aMessage;
	}

	@Override
	public void delete(final Message aMessage) {
		db.delete(aMessage);
	}
}

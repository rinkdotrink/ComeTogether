package de.ct.dao;

import de.ct.db.MessagePersistence;
import de.ct.db.MessagePersistenceImpl;
import de.ct.shared.Message;

public class MessageDAOImpl implements MessageDAO {

	private MessagePersistence db = new MessagePersistenceImpl();
	
	private static long messageId = 0;

	@Override
	public Message create() {
		Message m = new Message();
		messageId++;
		m.setMessageId(messageId);
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

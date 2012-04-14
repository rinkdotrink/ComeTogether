package de.ct.dao;

import java.util.ArrayList;
import java.util.List;

import de.ct.datamodel.Message;

public class MessageDAOImpl implements MessageDAO {

	private List<Message> messages = new ArrayList<Message>();
	private static long messageId = 0;

	@Override
	public Message create() {
		Message m = new Message();
		messageId++;
		m.setMessageId(messageId);
		messages.add(m);
		return m;
	}

	@Override
	public Message read(final long aMessageId) {
		Message temp = findMessage(aMessageId);
		return temp;
	}

	@Override
	public Message update(final Message aMessage) {
		Message temp = findMessage(aMessage.getMessageId());
		copyAttributes(temp, aMessage);
		return temp;
	}

	@Override
	public void delete(final Message aMessage) {
		messages.remove(aMessage);
	}

	@Override
	public List<Message> findAll() {
		return messages;
	}

	private void copyAttributes(final Message aTemp, final Message aMessage) {
		aTemp.setEventId(aMessage.getEventId());
		aTemp.setRecipientId(aMessage.getRecipientId());
		aTemp.setSenderId(aMessage.getSenderId());
		aTemp.setTextmessage(aMessage.getTextmessage());
	}

	private Message findMessage(final long aMessageId) {
		Message temp = null;
		for (Message m : messages) {
			if (m.getMessageId() == aMessageId) {
				temp = m;
			}
		}
		return temp;
	}

}

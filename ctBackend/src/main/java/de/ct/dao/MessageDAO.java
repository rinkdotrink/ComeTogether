package de.ct.dao;

import java.util.List;

import de.ct.shared.Message;

public interface MessageDAO {

	public Message create();

	public Message read(final long aMessageId);

	public Message update(final Message aMessage);

	public void delete(final Message aMessage);

	public List<Message> findAll();
}

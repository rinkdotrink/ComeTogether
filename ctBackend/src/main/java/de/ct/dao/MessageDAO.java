package de.ct.dao;

import java.util.List;

import de.ct.datamodel.Message;

public interface MessageDAO {

	public Message create();

	public Message read(long messageId);

	public Message update(Message message);

	public void delete(Message message);

	public List<Message> findAll();
}

package de.ct.db;

import de.ct.shared.Message;

public interface MessagePersistence {

	public Message read(final long aMessageId);
	
	public void update(final Message aMessage);

	public void delete(final Message aMessage);

}

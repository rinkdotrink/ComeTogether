package de.ct.db;

import de.ct.shared.Message;

public interface MessagePersistence {

	public abstract Message read(final long aMessageId);
	
	public abstract void update(final Message aMessage);

	public abstract void delete(final Message aMessage);

}

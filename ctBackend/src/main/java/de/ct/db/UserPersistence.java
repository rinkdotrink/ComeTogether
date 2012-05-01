package de.ct.db;

import de.ct.shared.User;

public interface UserPersistence {

	public abstract User read(final long aUserId);
	
	public abstract void update(final User aUser);

	public abstract void delete(final User aUser);

}

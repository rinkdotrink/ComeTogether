package de.ct.db;

import de.ct.shared.User;

public interface UserPersistence {

	public User read(final long aUserId);
	
	public void update(final User aUser);

	public void delete(final User aUser);

}

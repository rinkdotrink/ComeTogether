package de.ct.db;

import de.ct.shared.User;

public interface UserPersistence {

	public User read(final long aUserId);
	
	public User read(final String aUsername);
	
	public User update(final User aUser);

	public void delete(final User aUser);

}

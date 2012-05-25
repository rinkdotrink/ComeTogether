package de.ct.client.clients;

import de.ct.client.creator.UserCreator;
import de.ct.client.deleter.UserDeleter;
import de.ct.client.reader.UserReader;
import de.ct.shared.User;

public class UserClient {

	private UserCreator userCreator;
	private UserReader userReader;
	private UserDeleter userDeleter;

	public UserClient() {
		userCreator = new UserCreator();
		userReader = new UserReader();
		userDeleter = new UserDeleter();
	}

	public User createUser(final User aUser) {
		User user = userCreator.createUser(aUser);
		return user;
	}

	public User readUser(final long aUserId) {
		User user = userReader.readUser(aUserId);
		return user;
	}

	public void deleteUser(final long aUserId) {
		userDeleter.deleteUser(aUserId);
	}

}

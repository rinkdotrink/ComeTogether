package de.ct.client.clients;

import de.ct.client.creator.UserCreator;
import de.ct.client.deleter.UserDeleter;
import de.ct.client.login.UserLogin;
import de.ct.client.reader.UserReader;
import de.ct.shared.User;

public class UserClient {

	private UserCreator userCreator;
	private UserReader userReader;
	private UserDeleter userDeleter;
	private UserLogin userLogin;

	public UserClient() {
		userCreator = new UserCreator();
		userReader = new UserReader();
		userDeleter = new UserDeleter();
		userLogin = new UserLogin();
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
	
	public User login(final User aUser) {
		User user = userLogin.login(aUser);
		return user;
	}

}

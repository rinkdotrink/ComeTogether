package de.ct.client.creator;

import de.ct.shared.User;

public class UserCreator extends Creator{
	
	public User createUser(final User aUser) {
		initConnection("http://localhost:8080/ctBackend/ctUser/createUser");
		User user = (User) writeProduct(aUser);
		return user;
	}
}

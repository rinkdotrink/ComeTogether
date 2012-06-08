package de.ct.client.creator;

import de.ct.shared.User;

public class UserCreator extends Creator{
	
	public User createUser(final User aUser) {
		initConnection("http://10.0.2.2:8080/ctBackend/ctUser/createUser");
		User user = (User) writeProduct(aUser);
		return user;
	}
}

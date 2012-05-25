package de.ct.client.reader;

import de.ct.shared.User;

public class UserReader extends Reader {
	
	public User readUser(final long aId) {
		initConnection("http://localhost:8080/ctBackend/ctUser/readUser");
		User user = (User) getProduct(aId, new User());
		return user;
	}	
}

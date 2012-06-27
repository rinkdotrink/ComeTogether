package de.ct.client.login;

import de.ct.shared.User;

public class UserLogin extends Login {

	public User login(final User aUser) {
		initConnection("http://10.0.2.2:8080/ctBackend/ctUser/login");
		User user = (User) getProduct(aUser, new User());
		return user;
	}
	
}

package de.ct.webservice;

import de.ct.shared.User;


public interface UserServerREST {

	public void User(User aUser);
	
	public User User(String aUserId);
	
	public void deleteUser(String aUserId);

}

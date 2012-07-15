package de.ct.webservice;

import de.ct.shared.User;


public interface UserServerREST {

	public User createUser(String aUserStr);
	
	public User readUser(String aUserId);
	
	public User loginUser(String aUserStr);
	
	public String deleteUser(String aUserId);

}

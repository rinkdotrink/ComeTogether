package de.ct.webservice;

import de.ct.shared.User;


public interface UserServerREST {

	public User User1(String aUser);
	
	public User User2(String aUserId);
	
	public User User3(String aUserStr);
	
	public String deleteUser(String aUserId);

}

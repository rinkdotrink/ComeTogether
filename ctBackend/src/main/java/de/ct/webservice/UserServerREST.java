package de.ct.webservice;

import javax.ws.rs.core.Response;

import de.ct.shared.User;


public interface UserServerREST {

	public User User(User aUser);
	
	public User User(String aUserId);
	
	public Response deleteUser(String aUserId);

}

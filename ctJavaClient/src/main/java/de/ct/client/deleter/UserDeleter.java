package de.ct.client.deleter;


public class UserDeleter extends Deleter{
	
	public void deleteUser(final long aId) {
		initConnection("http://localhost:8080/ctBackend/ctUser/deleteUser");
		write(aId);
		evaluateServerResponse();		
	}
}

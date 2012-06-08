package de.ct.client.deleter;


public class UserDeleter extends Deleter{
	
	public void deleteUser(final long aId) {
		initConnection("http://10.0.2.2:8080/ctBackend/ctUser/deleteUser");
		writeProduct(aId);				
	}
}

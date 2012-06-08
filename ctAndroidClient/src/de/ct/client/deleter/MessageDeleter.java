package de.ct.client.deleter;


public class MessageDeleter extends Deleter{
	
	public void deleteMessage(final long aId) {
		initConnection("http://10.0.2.2:8080/ctBackend/ctMessage/deleteMessage");
		writeProduct(aId);				
	}
}

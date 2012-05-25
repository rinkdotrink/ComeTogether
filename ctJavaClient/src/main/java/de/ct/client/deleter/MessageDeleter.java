package de.ct.client.deleter;


public class MessageDeleter extends Deleter{
	
	public void deleteMessage(final long aId) {
		initConnection("http://localhost:8080/ctBackend/ctMessage/deleteMessage");
		write(aId);
		evaluateServerResponse();		
	}
}

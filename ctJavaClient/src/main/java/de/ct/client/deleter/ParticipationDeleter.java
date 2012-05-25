package de.ct.client.deleter;


public class ParticipationDeleter extends Deleter{
	
	public void deleteParticipation(final long aId) {
		initConnection("http://localhost:8080/ctBackend/ctParticipation/deleteParticipation");
		write(aId);
		evaluateServerResponse();		
	}
}

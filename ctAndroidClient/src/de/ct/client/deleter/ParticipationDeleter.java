package de.ct.client.deleter;


public class ParticipationDeleter extends Deleter{
	
	public void deleteParticipation(final long aId) {
		initConnection("http://10.0.2.2:8080/ctBackend/ctParticipation/deleteParticipation");
		writeProduct(aId);				
	}
}

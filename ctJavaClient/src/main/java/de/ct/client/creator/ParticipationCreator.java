package de.ct.client.creator;

import de.ct.shared.Participation;

public class ParticipationCreator extends Creator{
	
	public Participation createParticipation(final Participation aParticipation) {
		initConnection("http://localhost:8080/ctBackend/ctParticipation/createParticipation");
		Participation participation = (Participation) writeProduct(aParticipation);
		return participation;
	}
}

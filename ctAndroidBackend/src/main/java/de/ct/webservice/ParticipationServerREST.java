package de.ct.webservice;

import java.util.List;

import de.ct.shared.Participation;

public interface ParticipationServerREST {

	public Participation createParticipation(String aParticipation);

	public String deleteParticipation(String aParticipationId);

	public List<Participation> readParticipationsForEventId(final String aEventId);

	public List<Participation> readParticipationsForUserId(final String aUserId);

}

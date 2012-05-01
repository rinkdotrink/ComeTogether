package de.ct.webservice;

import java.util.List;

import de.ct.shared.Participation;

public interface ParticipationServerREST {

	public void Participation(Participation aParticipation);

	public void deleteParticipation(String aParticipationId);

	public List<Participation> ParticipationsForEventId(final String aEventId);

	public List<Participation> ParticipationsForUserId(final String aUserId);

}

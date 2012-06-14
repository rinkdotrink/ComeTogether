package de.ct.service;

import java.util.List;

import de.ct.shared.Participation;

public interface ParticipationService {

	public Participation createNewParticipation();

	public void deleteParticipation(final long aParticipationId);

	public List<Participation> getParticipationsForEventId(final long aEventId);
	
	public List<Participation> getParticipationsForUserId(final long aUserId);

	public Participation saveParticipation(final Participation aParticipation);
}

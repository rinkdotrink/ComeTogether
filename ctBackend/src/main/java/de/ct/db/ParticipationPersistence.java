package de.ct.db;

import java.util.List;

import de.ct.shared.Participation;

public interface ParticipationPersistence {

	public List<Participation> getParticipationsForEventId(final long aEventId);
	
	public List<Participation> getParticipationsForUserId(final long aUserId);
	
	public void update(final Participation aParticipation);

	public void delete(final Participation aParticipation);

}

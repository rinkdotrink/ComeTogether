package de.ct.dao;

import java.util.List;

import de.ct.shared.Participation;

public interface ParticipationDAO {

	public Participation create();

	public List<Participation> getParticipationsForEventId(final long aEventId);
	
	public List<Participation> getParticipationsForUserId(final long aUserId);

	public Participation update(final Participation aParticipation);

	public void delete(final Participation aParticipation);

}

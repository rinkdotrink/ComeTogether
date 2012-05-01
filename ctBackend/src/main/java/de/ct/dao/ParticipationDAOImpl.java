package de.ct.dao;

import java.util.List;

import de.ct.db.ParticipationPersistence;
import de.ct.db.ParticipationPersistenceImpl;
import de.ct.shared.Participation;

public class ParticipationDAOImpl implements ParticipationDAO {

	private static long participationId = 0;

	private ParticipationPersistence db = new ParticipationPersistenceImpl();

	@Override
	public Participation create() {
		Participation p = new Participation();
		participationId++;
		p.setParticipationId(participationId);
		return p;
	}

	@Override
	public List<Participation> getParticipationsForEventId(final long aEventId) {
		List<Participation> participations = db.getParticipationsForEventId(aEventId);
		return participations;
	}
	
	@Override
	public List<Participation> getParticipationsForUserId(final long aUserId) {
		List<Participation> participations = db.getParticipationsForUserId(aUserId);
		return participations;
	}

	@Override
	public Participation update(final Participation aParticipation) {
		db.update(aParticipation);
		return aParticipation;
	}

	@Override
	public void delete(final Participation aParticipation) {
		db.delete(aParticipation);
	}

}

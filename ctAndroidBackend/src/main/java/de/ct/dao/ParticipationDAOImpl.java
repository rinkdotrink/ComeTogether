package de.ct.dao;

import java.util.List;

import com.google.inject.Inject;

import de.ct.db.ParticipationPersistence;
import de.ct.shared.Participation;

public class ParticipationDAOImpl implements ParticipationDAO {

	private static long participationId = 0;

	private ParticipationPersistence db;

	public ParticipationDAOImpl() {
	}

	@Inject
	public ParticipationDAOImpl(ParticipationPersistence participationPersistence) {
		this.db = participationPersistence;
	}

	@Override
	public Participation create() {
		Participation p = new Participation();
		p.setParticipationId(participationId);
		participationId++;
		return p;
	}

	@Override
	public List<Participation> getParticipationsForEventId(final long aEventId) {
		List<Participation> participations = db
				.getParticipationsForEventId(aEventId);
		return participations;
	}

	@Override
	public List<Participation> getParticipationsForUserId(final long aUserId) {
		List<Participation> participations = db
				.getParticipationsForUserId(aUserId);
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

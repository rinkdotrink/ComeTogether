package de.ct.service;

import java.util.List;

import com.google.inject.Inject;

import de.ct.dao.ParticipationDAO;
import de.ct.shared.Participation;

public class ParticipationServiceImpl implements ParticipationService {

	ParticipationDAO participationDAO;

	@Inject
	public ParticipationServiceImpl(final ParticipationDAO aParticipationDAO) {
		this.participationDAO = aParticipationDAO;
	}

	@Override
	public Participation createNewParticipation() {
		return participationDAO.create();
	}

	@Override
	public void deleteParticipation(final long aParticipationId) {
		Participation participation = new Participation();
		participation.setParticipationId(aParticipationId);
		participationDAO.delete(participation);		
	}

	@Override
	public List<Participation> getParticipationsForEventId(final long aEventId){
		return participationDAO.getParticipationsForEventId(aEventId);
	}
	
	@Override
	public List<Participation> getParticipationsForUserId(final long aUserId){
		return participationDAO.getParticipationsForUserId(aUserId);
	}

	@Override
	public Participation saveParticipation(final Participation aParticipation) {
		return participationDAO.update(aParticipation);
	}

}

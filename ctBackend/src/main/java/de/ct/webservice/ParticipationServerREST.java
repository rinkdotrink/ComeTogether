package de.ct.webservice;

import java.util.List;

import javax.ws.rs.core.Response;

import de.ct.shared.Participation;

public interface ParticipationServerREST {

	public Participation Participation(Participation aParticipation);

	public Response deleteParticipation(String aParticipationId);

	public List<Participation> ParticipationsForEventId(final String aEventId);

	public List<Participation> ParticipationsForUserId(final String aUserId);

}

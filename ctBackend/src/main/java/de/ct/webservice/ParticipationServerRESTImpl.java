package de.ct.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sun.jersey.spi.resource.Singleton;

import de.ct.Module;
import de.ct.service.ParticipationService;
import de.ct.shared.Participation;

@Singleton
@Path("/ctParticipation")
public class ParticipationServerRESTImpl  implements ParticipationServerREST {

	ParticipationService participationService;

	public ParticipationServerRESTImpl() {
		Injector injector = Guice.createInjector(new Module());
		participationService = injector.getInstance(ParticipationService.class);
	}

	@POST
	@Path("/createParticipation")
	@Consumes("text/xml")
	public void Participation(Participation aParticipation) {
		Participation participation = participationService.createNewParticipation();
		participation.setEventId(aParticipation.getEventId());
		participation.setUserId(aParticipation.getUserId());	
		participationService.saveParticipation(participation);
	}

	@POST
	@Path("/ParticipationsForEventId")
	@Produces("text/xml")
	@Consumes("text/xml")
	public List<Participation> ParticipationsForEventId(final String aEventId) {
		Long eventId = Long.valueOf(aEventId);
		List<Participation> participations = participationService.getParticipationsForEventId(eventId);
		return participations;
	}
	
	@POST
	@Path("/ParticipationsForUserId")
	@Produces("text/xml")
	@Consumes("text/xml")
	public List<Participation> ParticipationsForUserId(final String aUserId) {
		Long userId = Long.valueOf(aUserId);
		List<Participation> participations = participationService.getParticipationsForUserId(userId);
		return participations;
	}

	@POST
	@Path("/deleteParticipation")
	@Consumes("text/xml")
	public void deleteParticipation(String aParticipationId) {
		long participationId = Long.parseLong(aParticipationId);
		participationService.deleteParticipation(participationId);
	}

//	@GET
//	@Produces("text/xml")
//	public List<Message> Messages() {
//		List<Message> messages = messageService.getMessages();
//		return messages;
//	}

}

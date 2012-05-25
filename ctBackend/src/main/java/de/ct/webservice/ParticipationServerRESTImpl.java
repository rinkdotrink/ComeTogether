package de.ct.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.Module;
import de.ct.service.ParticipationService;
import de.ct.shared.Participation;

@Path("/ctParticipation")
public class ParticipationServerRESTImpl  implements ParticipationServerREST {

	ParticipationService participationService;

	public ParticipationServerRESTImpl() {
		Injector injector = Guice.createInjector(new Module());
		participationService = injector.getInstance(ParticipationService.class);
	}

	@POST
	@Path("/createParticipation")
	@Consumes("application/json")
	@Produces("application/json")
	public Participation Participation(Participation aParticipation) {
		Participation participation = participationService.createNewParticipation();
		participation.setEventId(aParticipation.getEventId());
		participation.setUserId(aParticipation.getUserId());	
		Participation participation2 = participationService.saveParticipation(participation);
		return participation2;
	}

	@POST
	@Path("/readParticipationsForEventId")
	@Produces("application/json")
	@Consumes("application/x-www-form-urlencoded")
	public List<Participation> ParticipationsForEventId(final String aEventId) {
		String id = aEventId.substring(7, 8);
		Long eventId = Long.valueOf(id);
		List<Participation> participations = participationService.getParticipationsForEventId(eventId);
		return participations;
	}
	
	@POST
	@Path("/readParticipationsForUserId")
	@Produces("application/json")
	@Consumes("application/x-www-form-urlencoded")
	public List<Participation> ParticipationsForUserId(final String aUserId) {
		String id = aUserId.substring(7, 8);
		Long userId = Long.valueOf(id);
		List<Participation> participations = participationService.getParticipationsForUserId(userId);
		return participations;
	}

	@POST
	@Path("/deleteParticipation")
	@Consumes("application/x-www-form-urlencoded")
	public Response deleteParticipation(String aParticipationId) {
		String id = aParticipationId.substring(7, 8);
		long participationId = Long.parseLong(id);
		participationService.deleteParticipation(participationId);
		String result = "Participation deleted: " + id;
		return Response.status(201).entity(result).build();
	}

//	@GET
//	@Produces("text/xml")
//	public List<Message> Messages() {
//		List<Message> messages = messageService.getMessages();
//		return messages;
//	}

}

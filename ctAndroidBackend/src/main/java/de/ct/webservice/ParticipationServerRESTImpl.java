package de.ct.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.Module;
import de.ct.helper.Marshaller;
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
	@Consumes("text/plain")
	@Produces("application/json")
	public Participation createParticipation(String aParticipationStr) {
		Marshaller marshaller = new Marshaller();
		Participation aParticipation = (Participation) marshaller.unmarshall(aParticipationStr, new Participation());
		Participation participation = participationService.createNewParticipation();
		participation.setEventId(aParticipation.getEventId());
		participation.setUserId(aParticipation.getUserId());	
		Participation participation2 = participationService.saveParticipation(participation);
		return participation2;
	}

	@POST
	@Path("/readParticipationsForEventId")
	@Consumes("text/plain")
	@Produces("application/json")	
	public List<Participation> readParticipationsForEventId(final String aEventId) {
		Long eventId = Long.valueOf(aEventId);
		List<Participation> participations = participationService.getParticipationsForEventId(eventId);
		return participations;
	}
	
	@POST
	@Path("/readParticipationsForUserId")
	@Consumes("text/plain")
	@Produces("application/json")
	public List<Participation> readParticipationsForUserId(final String aUserId) {
		Long userId = Long.valueOf(aUserId);
		List<Participation> participations = participationService.getParticipationsForUserId(userId);
		return participations;
	}

	@POST
	@Path("/deleteParticipation")
	@Consumes("text/plain")
	@Produces("text/plain")
	public String deleteParticipation(String aParticipationId) {
		long participationId = Long.parseLong(aParticipationId);
		participationService.deleteParticipation(participationId);
		String result = "Participation deleted: " + participationId;
		return result;
	}

//	@GET
//	@Produces("text/xml")
//	public List<Message> Messages() {
//		List<Message> messages = messageService.getMessages();
//		return messages;
//	}

}

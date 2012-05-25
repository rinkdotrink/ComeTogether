package de.ct.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.inject.Guice;
import com.google.inject.Injector;
//import com.sun.jersey.spi.resource.Singleton;

import de.ct.Module;
import de.ct.service.EventService;
import de.ct.shared.Event;

@Path("/ctEvent")
public class EventServerRESTImpl  implements EventServerREST {

	EventService eventService;

	public EventServerRESTImpl() {
		Injector injector = Guice.createInjector(new Module());
		eventService = injector.getInstance(EventService.class);
	}

	@POST
	@Path("/createEvent")
	@Consumes("application/json")
	@Produces("application/json")
	public Event Event(Event aEvent) {
		Event event = eventService.createNewEvent();
		event.setDate(aEvent.getDate());
		event.setDescription(aEvent.getDescription());
		event.setEventname(aEvent.getEventname());
		event.setGps(aEvent.getGps());
		event.setLocation(aEvent.getLocation());
		event.setNumberFemaleConfirmed(aEvent.getNumberFemaleConfirmed());
		event.setNumberMaleConfirmed(aEvent.getNumberMaleConfirmed());
		event.setOccasion(aEvent.getOccasion());	
		
		Event event2 = eventService.saveEvent(event);
		return event2;
	}

	@POST
	@Path("/readEvent")
	@Produces("application/json")
	@Consumes("application/x-www-form-urlencoded")
	public Event Event(String aEventId) {
		String id = aEventId.substring(7, 8);
		long eventId = Long.parseLong(id);
		Event event = eventService.findEventById(eventId);
		return event;
	}

	@POST
	@Path("/deleteEvent")
	@Consumes("application/x-www-form-urlencoded")
	public Response deleteEvent(String aEventId) {
		String id = aEventId.substring(7, 8);
		long eventId = Long.parseLong(id);
		eventService.deleteEvent(eventId);
		String result = "Event deleted: " + eventId;
		return Response.status(201).entity(result).build();
	}

//	@GET
//	@Produces("text/xml")
//	public List<Message> Messages() {
//		List<Message> messages = messageService.getMessages();
//		return messages;
//	}

}

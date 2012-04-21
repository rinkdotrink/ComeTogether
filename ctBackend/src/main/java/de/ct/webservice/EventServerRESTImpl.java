package de.ct.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sun.jersey.spi.resource.Singleton;

import de.ct.Module;
import de.ct.service.EventService;
import de.ct.shared.Event;

@Singleton
@Path("/ct")
public class EventServerRESTImpl  implements EventServerREST {

	EventService eventService;

	public EventServerRESTImpl() {
		Injector injector = Guice.createInjector(new Module());
		eventService = injector.getInstance(EventService.class);
	}

	@POST
	@Path("/createEvent")
	@Consumes("text/xml")
	public void Event(Event aEvent) {
		Event event = eventService.createNewEvent();
		event.setDate(aEvent.getDate());
		event.setDescription(aEvent.getDescription());
		event.setEventId(aEvent.getEventId());
		event.setEventname(aEvent.getEventname());
		event.setGps(aEvent.getGps());
		event.setLocation(aEvent.getLocation());
		event.setNumberFemaleConfirmed(aEvent.getNumberFemaleConfirmed());
		event.setNumberMaleConfirmed(aEvent.getNumberMaleConfirmed());
		event.setOccasion(aEvent.getOccasion());
		
		
		eventService.saveEvent(event);
	}

	@POST
	@Path("/readEvent")
	@Produces("text/xml")
	@Consumes("text/xml")
	public Event Event(String aEventId) {
		long eventId = Long.parseLong(aEventId);
		Event event = eventService.findEventById(eventId);
		return event;
	}

	@POST
	@Path("/deleteEvent")
	@Consumes("text/xml")
	public void deleteEvent(String aEventId) {
		long eventId = Long.parseLong(aEventId);
		eventService.deleteEvent(eventId);
	}

//	@GET
//	@Produces("text/xml")
//	public List<Message> Messages() {
//		List<Message> messages = messageService.getMessages();
//		return messages;
//	}

}

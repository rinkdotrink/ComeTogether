package de.ct.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.Module;
import de.ct.helper.Marshaller;
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
	@Consumes("text/plain")
	@Produces("application/json")
	public Event createEvent(String aEventStr) {
		Marshaller marshaller = new Marshaller();
		Event aEvent = (Event) marshaller.unmarshall(aEventStr, new Event());		
		Event event = eventService.createNewEvent();
		event.setDate(aEvent.getDate());
		event.setDescription(aEvent.getDescription());
		event.setEventname(aEvent.getEventname());
		event.setLonRad(aEvent.getLon());
		event.setLatRad(aEvent.getLat());
		event.setLocation(aEvent.getLocation());
		event.setNumberFemaleConfirmed(aEvent.getNumberFemaleConfirmed());
		event.setNumberMaleConfirmed(aEvent.getNumberMaleConfirmed());
		event.setOccasion(aEvent.getOccasion());	
		
		Event event2 = eventService.saveEvent(event);
		return event2;
	}

	@POST
	@Path("/readEvent")
	@Consumes("text/plain")
	@Produces("application/json")	
	public Event readEvent(String aEventId) {
		long eventId = Long.parseLong(aEventId);
		Event event = eventService.findEventById(eventId);
		return event;
	}

	@POST
	@Path("/deleteEvent")
	@Consumes("text/plain")
	@Produces("text/plain")
	public String deleteEvent(String aEventId) {
		long eventId = Long.parseLong(aEventId);
		eventService.deleteEvent(eventId);
		String result = "Event deleted: " + eventId;
		return result;
	}

//	@GET
//	@Produces("text/xml")
//	public List<Message> Messages() {
//		List<Message> messages = messageService.getMessages();
//		return messages;
//	}

}

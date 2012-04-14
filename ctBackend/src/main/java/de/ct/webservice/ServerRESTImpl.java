package de.ct.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.Module;
import de.ct.service.MessageService;
import de.ct.shared.Message;

@Path("/ct")
public class ServerRESTImpl  implements ServerREST {

	MessageService messageService;

	public ServerRESTImpl() {
		Injector injector = Guice.createInjector(new Module());
		messageService = injector.getInstance(MessageService.class);
	}

//	@GET
//	@Produces("text/xml")
//	public List<Message> Messages() {
//		List<Message> messages = messageService.getMessages();
//		return messages;
//	}
//
//	@GET
//	@Produces("text/xml")
//	@Consumes("text/xml")
//	public Message Message(final long aMessageId) {
//		Message message = messageService.findMessageById(aMessageId);
//		return message;
//	}
//
	@POST
	@Consumes("text/xml")
	public void Message(Message aMessage) {

		//final String aTextMessage, final long aEventId, final long aSenderId,
		//final long aRecipientId
		Message message = messageService.createNewMessage();
		message.setTextmessage(aMessage.getTextmessage());
		message.setSenderId(aMessage.getSenderId());
		message.setRecipientId(aMessage.getRecipientId());
		message.setEventId(aMessage.getEventId());
		messageService.saveMessage(message);
		System.out.println("Message added");
	}
//
//	@DELETE
//	public void DELETEMessage(final long aMessageId) {
//		messageService.deleteMessage(aMessageId);
//	}

	@GET
	@Produces("text/xml")
	public String halloWelt() {
		return "Hallo Welt!!";
	}

}

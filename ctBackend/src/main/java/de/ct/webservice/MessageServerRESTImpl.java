package de.ct.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.Module;
import de.ct.service.MessageService;
import de.ct.shared.Message;

@Path("/ctMessage")
public class MessageServerRESTImpl  implements MessageServerREST {

	MessageService messageService;

	public MessageServerRESTImpl() {
		Injector injector = Guice.createInjector(new Module());
		messageService = injector.getInstance(MessageService.class);
	}

	@POST
	@Path("/createMessage")
	@Consumes("application/json")
	@Produces("application/json")
	public Message Message(Message aMessage) {
		Message message = messageService.createNewMessage();
		message.setTextmessage(aMessage.getTextmessage());
		message.setSenderId(aMessage.getSenderId());
		message.setRecipientId(aMessage.getRecipientId());
		message.setEventId(aMessage.getEventId());
		Message message2 = messageService.saveMessage(message);
		return message2;
	}

	@POST
	@Path("/readMessage")
	@Produces("application/json")
	@Consumes("application/x-www-form-urlencoded")
	public Message Message(String aMessageId) {
		String id = aMessageId.substring(7, 8);
		long messageId = Long.parseLong(id);
		Message message = messageService.findMessageById(messageId);
		return message;
	}

	@POST
	@Path("/deleteMessage")
	@Consumes("application/x-www-form-urlencoded")
	public Response deleteMessage(String aMessageId) {
		String id = aMessageId.substring(7, 8);
		long messageId = Long.parseLong(id);		
		messageService.deleteMessage(messageId);
		String result = "Message deleted: " + messageId;
		return Response.status(201).entity(result).build();
	}

//	@GET
//	@Produces("text/xml")
//	public List<Message> Messages() {
//		List<Message> messages = messageService.getMessages();
//		return messages;
//	}

}

package de.ct.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sun.jersey.spi.resource.Singleton;

import de.ct.Module;
import de.ct.service.MessageService;
import de.ct.shared.Message;

@Singleton
@Path("/ct")
public class MessageServerRESTImpl  implements MessageServerREST {

	MessageService messageService;

	public MessageServerRESTImpl() {
		Injector injector = Guice.createInjector(new Module());
		messageService = injector.getInstance(MessageService.class);
	}

	@POST
	@Path("/createMessage")
	@Consumes("text/xml")
	public void Message(Message aMessage) {
		Message message = messageService.createNewMessage();
		message.setTextmessage(aMessage.getTextmessage());
		message.setSenderId(aMessage.getSenderId());
		message.setRecipientId(aMessage.getRecipientId());
		message.setEventId(aMessage.getEventId());
		messageService.saveMessage(message);
	}

	@POST
	@Path("/readMessage")
	@Produces("text/xml")
	@Consumes("text/xml")
	public Message Message(String aMessageId) {
		long messageId = Long.parseLong(aMessageId);
		Message message = messageService.findMessageById(messageId);
		return message;
	}

	@POST
	@Path("/deleteMessage")
	@Consumes("text/xml")
	public void deleteMessage(String aMessageId) {
		long messageId = Long.parseLong(aMessageId);
		messageService.deleteMessage(messageId);
	}

//	@GET
//	@Produces("text/xml")
//	public List<Message> Messages() {
//		List<Message> messages = messageService.getMessages();
//		return messages;
//	}

}

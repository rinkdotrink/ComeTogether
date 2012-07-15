package de.ct.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.Module;
import de.ct.helper.Marshaller;
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
	@Consumes("text/plain")
	@Produces("application/json")
	public Message createMessage(String aMessageStr) {
		Marshaller marshaller = new Marshaller();
		Message aMessage = (Message) marshaller.unmarshall(aMessageStr, new Message());
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
	@Consumes("text/plain")
	@Produces("application/json")	
	public Message readMessage(String aMessageId) {
		long messageId = Long.parseLong(aMessageId);
		Message message = messageService.findMessageById(messageId);
		return message;
	}

	@POST
	@Path("/deleteMessage")
	@Consumes("text/plain")
	@Produces("text/plain")
	public String deleteMessage(String aMessageId) {
		long messageId = Long.parseLong(aMessageId);		
		messageService.deleteMessage(messageId);
		String result = "Message deleted: " + messageId;
		return result;
	}

//	@GET
//	@Produces("text/xml")
//	public List<Message> Messages() {
//		List<Message> messages = messageService.getMessages();
//		return messages;
//	}

}

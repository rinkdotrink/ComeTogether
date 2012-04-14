package de.ct.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.inject.Inject;

import de.ct.datamodel.Message;
import de.ct.service.MessageService;

@Path("/ct")
public class ServerRESTImpl  implements ServerREST {

	MessageService messageService;

	@Inject
	public ServerRESTImpl(MessageService aMessageService) {
		this.messageService = aMessageService;
	}

	@GET
	@Produces("text/xml")
	public List<Message> Messages() {
		List<Message> messages = messageService.getMessages();
		return messages;
	}

	@GET
	@Produces("text/xml")
	@Consumes("text/xml")
	public Message Message(long messageId) {
		Message message = messageService.findMessageById(messageId);
		return message;
	}

	@POST
	@Produces("text/xml")
	@Consumes("text/xml")
	public void Message(String aTextMessage, long aEventId, long aSenderId,
			long aRecipientId) {

		Message message = messageService.createNewMessage();
		message.setTextmessage(aTextMessage);
		message.setSenderId(aSenderId);
		message.setRecipientId(aRecipientId);
		message.setEventId(aEventId);
		messageService.saveMessage(message);
	}

	@DELETE
	public void DELETEMessage(long messageId) {
		messageService.deleteMessage(messageId);
	}

	@GET
	@Produces("text/xml")
	public String halloWelt() {
		return "Hallo Welt!!";
	}

}

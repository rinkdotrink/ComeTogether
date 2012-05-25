package de.ct.shared;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message implements Product, Serializable {

	private static final long serialVersionUID = 1L;
	private long messageId;
	private long eventId;
	private long senderId;
	private long recipientId;
	private String textmessage;
	private Calendar date = new GregorianCalendar(1900, 0, 1);

	public Message(final long aMessageId, final long aEventId,
			final long aSenderId, final long aRecipientId,
			final String aTextMessage, final Calendar aDate) {
		this.messageId = aMessageId;
		this.eventId = aEventId;
		this.senderId = aSenderId;
		this.recipientId = aRecipientId;
		this.textmessage = aTextMessage;
		this.date = aDate;
	}

	public Message() {

	}

	public boolean equals(final Object aObject) {
		boolean isEqual = false;
		if ((aObject != null) && (aObject.getClass() == this.getClass())) {
			Message message = (Message) aObject;
			if ((this.eventId == message.getEventId() 
					&&	(this.date.equals(message.getDate())
					&& (this.messageId == message.getMessageId())
					&& (this.recipientId == message.getRecipientId())
					&& (this.senderId == message.getSenderId()) 
					&& (this.textmessage.equalsIgnoreCase(message.getTextmessage()))

			))) {
				isEqual = true;
			}
		}
		return isEqual;
	}

	public int hashCode() {
		return (int) this.messageId % 1000;
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(final long aMessageId) {
		this.messageId = aMessageId;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(final long aEventId) {
		this.eventId = aEventId;
	}

	public long getSenderId() {
		return senderId;
	}

	public void setSenderId(final long aSenderId) {
		this.senderId = aSenderId;
	}

	public long getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(final long aRecipientId) {
		this.recipientId = aRecipientId;
	}

	public String getTextmessage() {
		return textmessage;
	}

	public void setTextmessage(final String aTextmessage) {
		this.textmessage = aTextmessage;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(final Calendar aDate) {
		this.date = aDate;
	}

}

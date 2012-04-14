package de.ct.shared;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long messageId;
	private long eventId;
	private long senderId;
	private long recipientId;
	private String textmessage;

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

	@Override
	public int hashCode() {
		int hash = (int) messageId;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		boolean equals;
		if (object == null) {
			equals = false;
		} else {
			Message m = (Message) object;
			equals = messageId == m.getMessageId();
		}

		return equals;
	}

}

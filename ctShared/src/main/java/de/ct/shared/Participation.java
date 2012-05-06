package de.ct.shared;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Participation {

	private long participationId = 0;
	private long userId = 0;
	private long eventId = 0;

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public long getParticipationId() {
		return participationId;
	}

	public void setParticipationId(long participationId) {
		this.participationId = participationId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public boolean equals(Object object) {
		Participation participation = (Participation) object;
		return this.participationId == participation.getParticipationId();
	}

	public int hashCode() {
		return (int) this.participationId % 1000;
	}

}

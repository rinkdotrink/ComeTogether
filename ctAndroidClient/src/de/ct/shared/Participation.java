package de.ct.shared;


//@XmlRootElement
public class Participation implements Product {

	private long participationId = 0;
	private long userId = 0;
	private long eventId = 0;

	public Participation() {

	}

	public Participation(final long aParticipationId, final long aUserId,
			final long aEventId) {
		this.participationId = aParticipationId;
		this.userId = aUserId;
		this.eventId = aEventId;
	}

	public boolean equals(final Object aObject) {
		boolean isEqual = false;
		if ((aObject != null) && (aObject.getClass() == this.getClass())) {
			Participation participation = (Participation) aObject;
			if ((this.participationId == participation.getParticipationId())
					&& (this.eventId == participation.getEventId())
					&& (this.userId == participation.getUserId())
			) {
				isEqual = true;
			}
		}
		return isEqual;
	}

	public int hashCode() {
		return (int) this.eventId % 1000;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(final long aEventId) {
		this.eventId = aEventId;
	}

	public long getParticipationId() {
		return participationId;
	}

	public void setParticipationId(final long aParticipationId) {
		this.participationId = aParticipationId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(final long aUserId) {
		this.userId = aUserId;
	}

}

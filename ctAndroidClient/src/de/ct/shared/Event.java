package de.ct.shared;

import java.util.Calendar;
import java.util.GregorianCalendar;

//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class Event implements Product {

	private long eventId = 0;
	private long eventUserId = 0;
	private long creatorId = 0;
	private Calendar date = new GregorianCalendar(1900, 0, 1);
	private String eventname = "";
	private String occasion = "";
	private String location = "";
	private String description = "";
	private Integer numberMaleConfirmed = 0;
	private Integer numberFemaleConfirmed = 0;
	private double lon = 0;
	private double lat = 0;

	public Event() {

	}

	public Event(final long aEventId, final long aCreatorId,
			final Calendar aDate, final String aEventname,
			final String aOccasion, final String aLocation,
			final String aDescription,
			final Integer aNumberOfMaleConfirmed,
			final Integer aNumberOfFemaleConfirmed, final double aLon,
			final double aLat) {

		this.eventId = aEventId;
		this.creatorId = aCreatorId;
		this.date = aDate;
		this.eventname = aEventname;
		this.occasion = aOccasion;
		this.location = aLocation;
		this.description = aDescription;
		this.numberMaleConfirmed = aNumberOfMaleConfirmed;
		this.numberFemaleConfirmed = aNumberOfFemaleConfirmed;
		this.lon = aLon;
		this.lat = aLat;
	}

	public boolean equals(final Object aObject) {
		boolean isEqual = false;
		if ((aObject != null) && (aObject.getClass() == this.getClass())) {
			Event event = (Event) aObject;
			if (

			(this.eventId == event.getEventId())
					&& (this.creatorId == event.getCreatorId())
					&& (this.date.equals(event.getDate()))
					&& (this.description.equalsIgnoreCase(event
							.getDescription()))
					&& (this.eventname.equalsIgnoreCase(event.getEventname()))
					&& (this.eventUserId == event.getEventUserId())
					&& (this.lon == event.getLonRad())
					&& (this.lat == event.getLatRad())
					&& (this.location.equalsIgnoreCase(event.getLocation()))
					&& (this.numberFemaleConfirmed == event
							.getNumberFemaleConfirmed())
					&& (this.numberMaleConfirmed == event
							.getNumberMaleConfirmed())
					&& (this.occasion.equalsIgnoreCase(event.getOccasion()))

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

	public Calendar getDate() {
		return date;
	}

	public void setDate(final Calendar aDate) {
		this.date = aDate;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(final String aEventname) {
		this.eventname = aEventname;
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(final String aOccasion) {
		this.occasion = aOccasion;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(final String aLocation) {
		this.location = aLocation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String aDescription) {
		this.description = aDescription;
	}

	public Integer getNumberMaleConfirmed() {
		return numberMaleConfirmed;
	}

	public void setNumberMaleConfirmed(final Integer aNumberMaleConfirmed) {
		this.numberMaleConfirmed = aNumberMaleConfirmed;
	}

	public Integer getNumberFemaleConfirmed() {
		return numberFemaleConfirmed;
	}

	public void setNumberFemaleConfirmed(final Integer aNumberFemaleConfirmed) {
		this.numberFemaleConfirmed = aNumberFemaleConfirmed;
	}

	public long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(final long aCreatorId) {
		this.creatorId = aCreatorId;
	}

	public long getEventUserId() {
		return eventUserId;
	}

	public void setEventUserId(final long aEventUserId) {
		this.eventUserId = aEventUserId;
	}

	public double getLonRad() {
		return lon;
	}

	public void setLonRad(double aLon) {
		this.lon = aLon;
	}

	public double getLatRad() {
		return lat;
	}

	public void setLatRad(double aLat) {
		this.lat = aLat;
	}

}

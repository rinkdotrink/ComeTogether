package de.ct.shared;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Event {

	private long eventId = 0;
	private long creatorId = 0;
	
	private Calendar date = new GregorianCalendar(1900, 0, 1);
	private String eventname = "";
	private String occasion = "";
	private String location = "";
	private List<String> gps = new ArrayList<String>();
	private String description = "";
	private Integer numberMaleConfirmed = 0;
	private Integer numberFemaleConfirmed = 0;

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getGps() {
		return gps;
	}

	public void setGps(List<String> gps) {
		this.gps = gps;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNumberMaleConfirmed() {
		return numberMaleConfirmed;
	}

	public void setNumberMaleConfirmed(Integer numberMaleConfirmed) {
		this.numberMaleConfirmed = numberMaleConfirmed;
	}

	public Integer getNumberFemaleConfirmed() {
		return numberFemaleConfirmed;
	}

	public void setNumberFemaleConfirmed(Integer numberFemaleConfirmed) {
		this.numberFemaleConfirmed = numberFemaleConfirmed;
	}
	
	public boolean equals(Object object){
		Event event = (Event) object;
		return this.eventId == event.getEventId();
	}
	
	public int hashCode(){
		return (int) this.eventId % 1000;
	}

	public long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(long creatorId) {
		this.creatorId = creatorId;
	}

}
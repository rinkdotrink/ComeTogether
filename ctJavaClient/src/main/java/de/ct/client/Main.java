package de.ct.client;

import java.util.GregorianCalendar;

import de.ct.shared.Event;
import de.ct.shared.Message;
import de.ct.shared.Participation;
import de.ct.shared.User;

public class Main {

	public static void main(String[] args) {
		MyMessageClient messageClient = new MyMessageClient();
		messageClient.createMessage(new Message());
		messageClient.createMessage(new Message());
		messageClient.createMessage(new Message());
		messageClient.deleteMessage(2);
		System.out.println("Message mit ID 1 gelesen: "
				+ messageClient.readMessage(1).getMessageId());

		MyEventClient eventClient = new MyEventClient();
		eventClient.createEvent(new Event());
		eventClient.createEvent(new Event());
		eventClient.createEvent(new Event());
		eventClient.deleteEvent(2);
		System.out.println("Event mit ID 1 gelesen: "
				+ eventClient.readEvent(1).getEventId());

		MyUserClient userClient = new MyUserClient();
		User user = new User();
		user.setEmail("myMail");
		user.setBirthday(new GregorianCalendar(2000, 01, 01));
		user.setGender("weiblich");
		user.setImage("Pfad");
		user.setName("Name");
		user.setPassword("Password");
		userClient.createUser(user);
		userClient.createUser(user);
		userClient.createUser(user);

		userClient.deleteUser(2);
		System.out.println("user mit ID 1 gelesen: "
				+ userClient.readUser(1).getUserId());
		
		
		MyParticipationClient participationClient = new MyParticipationClient();
		participationClient.createParticipation(new Participation());
		participationClient.createParticipation(new Participation());
		participationClient.createParticipation(new Participation());
		participationClient.deleteParticipation(2);
		System.out.println("Participation mit ID 1 gelesen: "
				+ participationClient.ParticipationsForEventId(0).get(0).getParticipationId());

	}

}

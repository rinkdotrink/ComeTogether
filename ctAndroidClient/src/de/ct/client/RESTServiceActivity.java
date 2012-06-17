package de.ct.client;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import de.ct.client.clients.EventClient;
import de.ct.client.clients.MessageClient;
import de.ct.client.clients.ParticipationClient;
import de.ct.client.clients.UserClient;
import de.ct.shared.Event;
import de.ct.shared.Message;
import de.ct.shared.Participation;
import de.ct.shared.User;

public class RESTServiceActivity extends FragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rest_service);

		performUser();
		performEvent();
		performMessage();
		performParticipation();
	}

	private static void performUser() {
		UserClient userClient = new UserClient();
		User user = new User();
		User user3 = userClient.createUser(user);
		Log.d("RESTServiceActivity", "User erstellt mit id: " + user3);
		User user2 = userClient.readUser(user3.getUserId());
		Log.d("RESTServiceActivity",
				"User gelesen mit id: " + user2.getUserId());
		userClient.deleteUser(user3.getUserId());
	}

	private static void performEvent() {
		EventClient eventClient = new EventClient();
		Event event = eventClient.createEvent(new Event());
		Log.d("RESTServiceActivity",
				"Event erstellt mit id: " + event.getEventId());
		Log.d("RESTServiceActivity",
				"Event gelesen mit id: "
						+ eventClient.readEvent(event.getEventId()));
		eventClient.deleteEvent(event.getEventId());
	}

	private static void performMessage() {
		MessageClient messageClient = new MessageClient();
		Message message = messageClient.createMessage(new Message());
		Log.d("RESTServiceActivity",
				"Message erstellt mit id: " + message.getMessageId());
		Log.d("RESTServiceActivity", "Message gelesen mit ID : "
				+ messageClient.readMessage(message.getMessageId()));
		messageClient.deleteMessage(message.getMessageId());
	}

	private static void performParticipation() {
		ParticipationClient participationClient = new ParticipationClient();
		Participation participation = participationClient
				.createParticipation(new Participation());
		Log.d("RESTServiceActivity", "Participation erstellt mit id: "
				+ participation.getParticipationId());
		Log.d("RESTServiceActivity",
				"Participation gelesen mit event id: "
						+ participationClient
								.ParticipationsForEventId(
										participation.getEventId()).get(0)
								.getParticipationId());
		Log.d("RESTServiceActivity",
				"Participation gelesen mit user id: "
						+ participationClient
								.ParticipationsForUserId(
										participation.getUserId()).get(0)
								.getParticipationId());
		participationClient.deleteParticipation(participation
				.getParticipationId());
	}

}

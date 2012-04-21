package de.ct.client;

import de.ct.shared.Event;
import de.ct.shared.Message;
import de.ct.shared.User;


public class Main {

	public static void main(String[] args) {
		MyMessageClient client = new MyMessageClient();
		client.createMessage(new Message());
		client.createMessage(new Message());
		client.createMessage(new Message());
		client.deleteMessage(2);
		client.readMessage(1);
		
		
		MyEventClient eventClient = new MyEventClient();
		eventClient.createEvent(new Event());
		eventClient.createEvent(new Event());
		eventClient.createEvent(new Event());
		eventClient.deleteEvent(2);
		eventClient.readEvent(1);
		
		
		MyUserClient userClient = new MyUserClient();
		userClient.createUser(new User());
		userClient.createUser(new User());
		userClient.createUser(new User());
		userClient.deleteUser(2);
		userClient.readUser(1);
	}

}

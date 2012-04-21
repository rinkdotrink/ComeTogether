package de.ct.client;

import de.ct.shared.Message;


public class Main {

	public static void main(String[] args) {
		MyClient client = new MyClient();
		client.createMessage(new Message());
		client.createMessage(new Message());
		client.createMessage(new Message());
//		client.getMessages();
		client.deleteMessage(2);
		client.readMessage(1);
	}

}

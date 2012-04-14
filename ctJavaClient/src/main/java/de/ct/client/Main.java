package de.ct.client;

import de.ct.shared.Message;

public class Main {

	public static void main(String[] args) {
		MyClient client = new MyClient();
		System.out.println(client.sayHelloWorld());
		client.postMessage(new Message());
	}

}

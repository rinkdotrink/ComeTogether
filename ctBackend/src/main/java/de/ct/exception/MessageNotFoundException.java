package de.ct.exception;

public class MessageNotFoundException extends Exception {

	private static final long serialVersionUID = -955459730173382815L;

	public MessageNotFoundException() {
	}

	public MessageNotFoundException(String s) {
		super(s);
	}

}

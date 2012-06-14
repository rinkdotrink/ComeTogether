package de.datagenerator.writer;

import java.io.IOException;

import de.ct.shared.Message;
import de.ct.shared.Product;
import de.datagenerator.LogUtil;

public class MessageWriter extends Writer {

	public MessageWriter() {
		try {
			initWriter("Files/Message.txt");
		} catch (Exception e) {
			LogUtil.getLogger().error(e);
		}
	}

	public void write(final Product aProduct) {
		if (aProduct instanceof Message) {
			writeMessage((Message) aProduct);
		}
	}

	private void writeMessage(final Message aMessage) {
		String date = df.format(aMessage.getDate().getTime());
		String s = "" + aMessage.getMessageId() + ";" + aMessage.getEventId()
				+ ";" + aMessage.getSenderId() + ";"
				+ aMessage.getRecipientId() + ";" + aMessage.getTextmessage()
				+ ";" + date + "\n";
		try {
			writer.write(s);
		} catch (IOException e) {
			LogUtil.getLogger().error(e);
		}
	}

}

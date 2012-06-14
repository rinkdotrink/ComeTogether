package de.datagenerator.generator;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import de.datagenerator.creator.Creator;
import de.datagenerator.writer.IWriter;

public class MessageGenerator extends Generator {

	@Inject
	public MessageGenerator(final Creator aCreator,
			@Named("Message") final IWriter aDbWriter) {
		setCreator(aCreator);
		setDBWriter(aDbWriter);
	}

	@Override
	public final void generateMessage(final long aMessagePerUser,
			final long aEventPerUser, final long aUser) {

		long messages = aMessagePerUser * aUser;
		long events = aEventPerUser * aUser;
		long messageId = 0;
		long eventId = 0;
		long senderId = 0;
		long recipientId = 0;
		String textmessage = "";
		Calendar date;

		for (long i = 0; i < messages; i++) {
			messageId = i;
			eventId = i % events;
			senderId = i % aUser;
			recipientId = (i + 1) % aUser;
			textmessage = "textmessage" + i;
			date = new GregorianCalendar(1990, 1, 1);

			setProduct(getCreator().createMessage(messageId, eventId, senderId,
					recipientId, textmessage, date));
			getDBWriter().write(getProduct());
		}
		getDBWriter().close();
	}

}

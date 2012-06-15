package de.datagenerator.generator;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import de.datagenerator.creator.Creator;
import de.datagenerator.writer.IWriter;

public class MessageGenerator extends Generator {

	private Random random;
	
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

		random = new Random(0);
		
		for (long i = 0; i < messages; i++) {
			messageId = i;
			eventId = i % events;
			senderId = i % aUser;
			recipientId = (i + 1) % aUser;
			textmessage = "textmessage " + randomSalsa();			
			int year = computeIntBetween0and4();
			int month = computeIntBetween1and12();
			date = new GregorianCalendar(2009 + year, month, 1);
			setProduct(getCreator().createMessage(messageId, eventId, senderId,
					recipientId, textmessage, date));
			getDBWriter().write(getProduct());
		}
		getDBWriter().close();
	}
	
	private int computeIntBetween0and4() {
		double randomDouble = random.nextDouble();
		int int0_100 = (int) Math.ceil(randomDouble * 100);
		int int0_4 = int0_100 % 4;
		return int0_4;
	}
	
	private int computeIntBetween1and12() {
		double randomDouble = random.nextDouble();
		int int0_100 = (int) Math.ceil(randomDouble * 100);
		int int1_12 = int0_100 % 12 + 1;
		return int1_12;
	}
	
	private String randomSalsa() {
		String salsa = "";
		if (random.nextDouble() < 0.2) {
			salsa = "Salsa";
		}
		return salsa;
	}


}

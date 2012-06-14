package de.datagenerator.creator;

import java.util.Calendar;

import de.ct.shared.Event;
import de.ct.shared.Message;
import de.ct.shared.Participation;
import de.ct.shared.Product;
import de.ct.shared.User;

public class Creator {

	public final Product createUser(final long aUserId, final String aName,
			final String aEmail, final String aGender,
			final Calendar aBirthday, final String aPassword,
			final String aImage) {
		return new User(aUserId, aName, aEmail, aGender, aBirthday, aPassword,
				aImage);
	}

	public final Product createEvent(final long aEventId,
			final long aCreatorId, final Calendar aDate,
			final String aEventname, final String aOccasion,
			final String aLocation, final String aDescription, final Integer aNumberOfMaleConfirmed,
			final Integer aNumberOfFemaleConfirmed, final double aLonRad, final double aLatRad) {
		return new Event(aEventId, aCreatorId, aDate, aEventname, aOccasion,
				aLocation, aDescription, aNumberOfMaleConfirmed,
				aNumberOfFemaleConfirmed, aLonRad, aLatRad);
	}

	public final Product createMessage(final long aMessageId, final long aEventId,
			final long aSenderId, final long aRecipientId, final String aTextMessage,
			final Calendar aDate) {
		return new Message(aMessageId, aEventId, aSenderId, aRecipientId,
				aTextMessage, aDate);
	}

	public final Product createParticipation(final long aParticipationId, final long aUserId,
			final long aEventId) {
		return new Participation(aParticipationId, aUserId, aEventId);
	}
}

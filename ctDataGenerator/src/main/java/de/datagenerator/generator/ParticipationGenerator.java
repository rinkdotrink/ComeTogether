package de.datagenerator.generator;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import de.datagenerator.creator.Creator;
import de.datagenerator.writer.IWriter;

public class ParticipationGenerator extends Generator {

	@Inject
	public ParticipationGenerator(final Creator aCreator,
			@Named("Participation") final IWriter aDbWriter) {
		setCreator(aCreator);
		setDBWriter(aDbWriter);
	}

	@Override
	public final void generateParticipation(final long aParticipationPerUser,
			long aUser, long aEventPerUser) {

		long participtions = aParticipationPerUser * aUser;
		long events = aEventPerUser * aUser;
		long participationId = 0;
		long userId = 0;
		long eventId = 0;

		for (long i = 0; i < participtions; i++) {
			participationId = i;
			userId = i % aUser;
			eventId = i % events;
			setProduct(getCreator().createParticipation(participationId,
					userId, eventId));
			getDBWriter().write(getProduct());
		}
		getDBWriter().close();
	}

}

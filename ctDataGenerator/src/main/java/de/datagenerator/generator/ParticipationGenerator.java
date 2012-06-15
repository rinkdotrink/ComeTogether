package de.datagenerator.generator;

import java.util.Random;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import de.datagenerator.creator.Creator;
import de.datagenerator.writer.IWriter;

public class ParticipationGenerator extends Generator {

	private Random random = new Random(0);
	
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
			userId = computeIntBetween0andUser(aUser);
			eventId = i % events;
			setProduct(getCreator().createParticipation(participationId,
					userId, eventId));
			getDBWriter().write(getProduct());
		}
		getDBWriter().close();
	}
	
	private long computeIntBetween0andUser(long aUser) {
		double randomDouble = random.nextDouble();
		int int0_100 = (int) Math.ceil(randomDouble * aUser);
		long int0_User = int0_100 % aUser;
		return int0_User;
	}
}

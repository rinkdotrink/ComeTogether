package de.datagenerator.generator;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.shared.Product;
import de.datagenerator.DBModule;
import de.datagenerator.creator.Creator;
import de.datagenerator.timekeeper.EventTimeKeeper;
import de.datagenerator.timekeeper.MessageTimeKeeper;
import de.datagenerator.timekeeper.ParticipationTimeKeeper;
import de.datagenerator.timekeeper.TimeKeeper;
import de.datagenerator.timekeeper.UserTimeKeeper;
import de.datagenerator.writer.IWriter;

public class Generator {

	private Creator creator;
	private Product product;
	private IWriter writer;
	private Generator strategy;
	private Injector injector = Guice.createInjector(new DBModule());

	public void generate(final long aUser, final long aEventsPerUser, final long aMessagesPerUser, final long aParticipationsPerUser) {
		System.out.println(aUser + " User | "
				+ aEventsPerUser + " Events pro User | "
				+ aMessagesPerUser + " Messages pro User | "
				+ aParticipationsPerUser + " Participations pro User");

		TimeKeeper.setParameter(aUser, aEventsPerUser, aMessagesPerUser,
				aParticipationsPerUser);

		generateProducts(aUser, aEventsPerUser, aMessagesPerUser, aParticipationsPerUser);
	}

	private void generateProducts(final long aUser, final long aEventPerUser, final long aMessagesPerUser, final long aParticipationsPerUser) {
		generateUser(aUser);
		generateEvent(aUser, aEventPerUser);
		generateMessage(aMessagesPerUser, aEventPerUser, aUser);
		generateParticipation(aParticipationsPerUser, aUser, aEventPerUser);
	}

	protected void generateUser(final long aUser) {
		UserTimeKeeper.startTimeUser();
		strategy = injector.getInstance(UserGenerator.class);
		strategy.generateUser(aUser);
		UserTimeKeeper.endTime();
	};

	protected void generateEvent(final long aUser, final long aEventPerUser) {
		EventTimeKeeper.startTimeEvent();
		strategy = injector.getInstance(EventGenerator.class);
		strategy.generateEvent(aUser, aEventPerUser);
		EventTimeKeeper.endTime();
	}
	
	protected void generateMessage(final long aMessage, final long aEvent, final long aUser) {
		MessageTimeKeeper.startTimeMessage();
		strategy = injector.getInstance(MessageGenerator.class);
		strategy.generateMessage(aMessage, aEvent, aUser);
		MessageTimeKeeper.endTime();
	}
	
	protected void generateParticipation(final long aParticipation, long aUser, long aEvent) {
		ParticipationTimeKeeper.startTimeParticipation();
		strategy = injector.getInstance(ParticipationGenerator.class);
		strategy.generateParticipation(aParticipation, aUser, aEvent);
		ParticipationTimeKeeper.endTime();
	}

	protected final Creator getCreator() {
		return creator;
	}

	protected final void setCreator(final Creator aCreator) {
		this.creator = aCreator;
	}

	protected final Product getProduct() {
		return product;
	}

	protected final void setProduct(final Product aProduct) {
		this.product = aProduct;
	}

	protected final void setDBWriter(final IWriter aDBWriter) {
		this.writer = aDBWriter;
	}

	protected final IWriter getDBWriter() {
		return writer;
	}
}

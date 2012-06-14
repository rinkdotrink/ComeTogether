package de.datagenerator.timekeeper;

import java.util.Date;

public abstract class TimeKeeper {

	static long start = 0;

	static long user;
	static long eventsPerUser;
	static long messagesPerUser;
	static long participationsPerUser;
	static long allTime = 0;

	public static void setParameter(final long aUser,
			final long aEventsPerUser, final long aMessagesPerUser,
			final long aParticipationsPerUser) {
		user = aUser;
		eventsPerUser = aEventsPerUser;
		messagesPerUser = aMessagesPerUser;
		participationsPerUser = aParticipationsPerUser;

	}

	protected static long getRunningTimeKundeInSeconds() {
		long runningTime = new Date().getTime() - start;
		return runningTime / 1000;
	}

}

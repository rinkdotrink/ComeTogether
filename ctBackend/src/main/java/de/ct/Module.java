package de.ct;

import com.google.inject.AbstractModule;

import de.ct.dao.EventDAO;
import de.ct.dao.EventDAOImpl;
import de.ct.dao.MessageDAO;
import de.ct.dao.MessageDAOImpl;
import de.ct.dao.ParticipationDAO;
import de.ct.dao.ParticipationDAOImpl;
import de.ct.dao.UserDAO;
import de.ct.dao.UserDAOImpl;
import de.ct.service.EventService;
import de.ct.service.EventServiceImpl;
import de.ct.service.MessageService;
import de.ct.service.MessageServiceImpl;
import de.ct.service.ParticipationService;
import de.ct.service.ParticipationServiceImpl;
import de.ct.service.UserService;
import de.ct.service.UserServiceImpl;
import de.ct.shared.Event;
import de.ct.shared.Message;
import de.ct.shared.Participation;
import de.ct.shared.User;

public class Module extends AbstractModule {

	@Override
	protected void configure() {
		bind(Message.class);
		bind(User.class);
		bind(Participation.class);
		bind(Event.class);
		bind(MessageDAO.class).to(MessageDAOImpl.class);
		bind(UserDAO.class).to(UserDAOImpl.class);
		bind(EventDAO.class).to(EventDAOImpl.class);
		bind(ParticipationDAO.class).to(ParticipationDAOImpl.class);
		bind(MessageService.class).to(MessageServiceImpl.class);		
		bind(UserService.class).to(UserServiceImpl.class);
		bind(EventService.class).to(EventServiceImpl.class);
		bind(ParticipationService.class).to(ParticipationServiceImpl.class);
	}
}

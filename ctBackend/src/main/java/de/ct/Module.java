package de.ct;

import com.google.inject.AbstractModule;

import de.ct.dao.MessageDAO;
import de.ct.dao.MessageDAOImpl;
import de.ct.dao.UserDAO;
import de.ct.dao.UserDAOImpl;
import de.ct.service.MessageService;
import de.ct.service.MessageServiceImpl;
import de.ct.service.UserService;
import de.ct.service.UserServiceImpl;
import de.ct.shared.Message;
import de.ct.shared.User;

public class Module extends AbstractModule {

	@Override
	protected void configure() {
		bind(Message.class);
		bind(User.class);
		bind(MessageDAO.class).to(MessageDAOImpl.class);
		bind(UserDAO.class).to(UserDAOImpl.class);
		bind(MessageService.class).to(MessageServiceImpl.class);
		bind(UserService.class).to(UserServiceImpl.class);
	}
}

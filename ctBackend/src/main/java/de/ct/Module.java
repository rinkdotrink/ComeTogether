package de.ct;

import com.google.inject.AbstractModule;

import de.ct.dao.MessageDAO;
import de.ct.dao.MessageDAOImpl;
import de.ct.datamodel.Message;
import de.ct.service.MessageService;
import de.ct.service.MessageServiceImpl;

public class Module extends AbstractModule {

	@Override
	protected void configure() {
		bind(Message.class);
		bind(MessageDAO.class).to(MessageDAOImpl.class);
		bind(MessageService.class).to(MessageServiceImpl.class);
	}
}

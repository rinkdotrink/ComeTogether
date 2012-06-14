package de.ct;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.ct.dao.EventDAOImplUnittest;
import de.ct.dao.MessageDAOImplUnittest;
import de.ct.dao.ParticipationDAOImplUnittest;
import de.ct.dao.UserDAOImplUnittest;
import de.ct.datamodel.EventUnittest;
import de.ct.datamodel.MessageUnittest;
import de.ct.datamodel.ParticipationUnittest;
import de.ct.datamodel.UserUnittest;
import de.ct.service.EventServiceImplUnittest;
import de.ct.service.MessageServiceImplUnittest;
import de.ct.service.ParticipationServiceImplUnittest;
import de.ct.service.UserServiceImplUnittest;

@RunWith(Suite.class)
@SuiteClasses({ 
	MessageUnittest.class,	
	ParticipationUnittest.class,
	UserUnittest.class,
	EventUnittest.class,
	
		MessageDAOImplUnittest.class,
		EventDAOImplUnittest.class,
		UserDAOImplUnittest.class,
		ParticipationDAOImplUnittest.class,
		
		MessageServiceImplUnittest.class,
		UserServiceImplUnittest.class, 
		EventServiceImplUnittest.class,
		ParticipationServiceImplUnittest.class})
public class AllUnittests {

}

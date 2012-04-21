package de.ct;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.ct.dao.MessageDAOImplTest;
import de.ct.dao.UserDAOImplTest;
import de.ct.datamodel.MessageTest;
import de.ct.datamodel.UserTest;
import de.ct.service.MessageServiceImplTest;
import de.ct.service.UserServiceImplTest;

@RunWith(Suite.class)
@SuiteClasses({ MessageTest.class, MessageDAOImplTest.class, MessageServiceImplTest.class,
				UserTest.class, UserDAOImplTest.class, UserServiceImplTest.class
})
public class AllTests {

}

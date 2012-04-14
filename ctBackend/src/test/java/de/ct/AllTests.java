package de.ct;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.ct.dao.MessageDAOImplTest;
import de.ct.datamodel.MessageTest;
import de.ct.service.MessageServiceImplTest;

@RunWith(Suite.class)
@SuiteClasses({ MessageDAOImplTest.class, MessageTest.class, MessageServiceImplTest.class})
public class AllTests {

}
